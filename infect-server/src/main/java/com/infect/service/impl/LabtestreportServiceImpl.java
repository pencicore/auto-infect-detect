package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.infect.dto.system.DiagnosisPageDTO;
import com.infect.entity.Labtestfiles;
import com.infect.entity.Labtestreport;
import com.infect.entity.User;
import com.infect.entity.armorFusion.LabtestreportWirhFileList;
import com.infect.mapper.LabtestfilesMapper;
import com.infect.mapper.LabtestreportMapper;
import com.infect.mapper.UserMapper;
import com.infect.result.PageResult;
import com.infect.service.ILabtestreportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.vo.system.LabTestPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-09-23
 */
@Service
public class LabtestreportServiceImpl extends ServiceImpl<LabtestreportMapper, Labtestreport> implements ILabtestreportService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LabtestreportMapper labtestreportMapper;

    @Autowired
    private LabtestfilesMapper labtestfilesMapper;

    /**
     * 根据用户名，电话，部门，时间分页查询用户检查信息
     * @param labTestPageDTO
     * @return
     */
    @Override
    public PageResult<LabTestPageVO> pageSelectLabTest(DiagnosisPageDTO labTestPageDTO) {
        String name = labTestPageDTO.getName();
        String phoneNumber = labTestPageDTO.getPhoneNumber();
        String department = labTestPageDTO.getDepartment();
        LocalDate beginDate = labTestPageDTO.getBeginDate();
        LocalDate endDate = labTestPageDTO.getEndDate();
        boolean flag = beginDate!=null && endDate!=null;

        //构造分页条件
        Page<Labtestreport> page = Page.of(labTestPageDTO.getPageNo(),labTestPageDTO.getPageSize());
        page.addOrder(new OrderItem("UploadDate",false));

        //根据用户名，电话，部门获取用户id
        List<Integer> userIds = userMapper.selectIdsByWrapper(
                new LambdaQueryWrapper<User>()
                        .like(name!=null, User::getName, name)
                        .like(phoneNumber!=null, User::getPhoneNumber, phoneNumber)
                        .like(department!=null, User::getDepartment, department)
        );

        //分页查询
        Page<Labtestreport> p = lambdaQuery()
                .in(Labtestreport::getUserId, userIds)
                .ge(flag,Labtestreport::getUploadDate,beginDate)
                .le(flag,Labtestreport::getUploadDate,endDate)
                .page(page);

        //封装VO结果
        PageResult<LabTestPageVO> pageResult = new PageResult<>();

        List<LabTestPageVO> list = new ArrayList<>();
        for(Labtestreport labtestreport:p.getRecords()){
            //TODO 这里可以用算法优化，现在暴力处理，后期优化
            LabTestPageVO labTestPageVO = new LabTestPageVO();
            User user = userMapper.selectById(labtestreport.getUserId());

            BeanUtil.copyProperties(user,labTestPageVO);
            BeanUtil.copyProperties(labtestreport,labTestPageVO);

            list.add(labTestPageVO);
        }

        pageResult.setRecords(list);
        pageResult.setTotal(p.getTotal());

        //返回
        return pageResult;
    }

    /**
     * 根据诊断id查询检查信息
     * @param labTestReportID
     * @return
     */
    @Override
    public LabtestreportWirhFileList selectLabTest(Integer labTestReportID) {
        LabtestreportWirhFileList labtestreportWirhFileList = new LabtestreportWirhFileList();
        Labtestreport labtestreport = labtestreportMapper.selectById(labTestReportID);
        BeanUtil.copyProperties(labtestreport,labtestreportWirhFileList);
        labtestreportWirhFileList.setFileIds(
                labtestreportMapper.selectIdsByLabTestReportID(labTestReportID)
        );
        return labtestreportWirhFileList;
    }

    /**
     * 根据id更新检查信息
     * 重点是文件更新
     * @param labtestreportWirhFileList
     */
    @Override
    public void updateLabTest(LabtestreportWirhFileList labtestreportWirhFileList) {
        Integer labTestReportId = labtestreportWirhFileList.getLabTestReportId();
        List<Integer> fileIds = labtestreportWirhFileList.getFileIds();

        //更新实验室检测报告表
        Labtestreport labtestreport = BeanUtil.copyProperties(labtestreportWirhFileList,Labtestreport.class);
        labtestreport.setUploadDate(LocalDate.now());
        labtestreportMapper.updateById(labtestreport);

        //将id为labTestReportId且id不在fileIds中的数据的labTestReportId设置为0
        labtestfilesMapper.updateLabTestReportIdByFileIds(0,labTestReportId,fileIds);

        //将id为labTestReportId且id不在fileIds中的数据的labTestReportId设置为labTestReportId
        for (Integer fileId:labtestreportWirhFileList.getFileIds()) {
            labtestfilesMapper.updateLabTestReportIdByFileId(fileId,labTestReportId);
        }
    }
}
