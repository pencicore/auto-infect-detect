package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.infect.dto.DiagnosisResultsEmpDTO;
import com.infect.dto.system.DiagnosisPageDTO;
import com.infect.entity.Diagnosisresults;
import com.infect.entity.User;
import com.infect.mapper.DiagnosisresultsMapper;
import com.infect.mapper.UserMapper;
import com.infect.result.PageResult;
import com.infect.service.IDiagnosisresultsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.vo.system.DiagnosisPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Service
public class DiagnosisresultsServiceImpl extends ServiceImpl<DiagnosisresultsMapper, Diagnosisresults> implements IDiagnosisresultsService {

    @Autowired
    private DiagnosisresultsMapper diagnosisresultsMapper;

    @Autowired
    private UserMapper userMapper;

    //提交确诊疾病信息
    @Override
    public void saveDiagnosisResult(DiagnosisResultsEmpDTO diagnosisResultsEmpDTO, Integer userId, Integer submissionUserId) {
        //查询是否已有诊断结果数据,已有，则直接返回
        if (lambdaQuery()
                .eq(Diagnosisresults::getSubmissionTime, LocalDate.now())
                .eq(Diagnosisresults::getUserId, userId)
                .count() != 0) {
            return;
        }

        //将dto中的数据复制到entity实体类中
        Diagnosisresults diagnosisresults = BeanUtil.copyProperties(diagnosisResultsEmpDTO, Diagnosisresults.class);

        //设置用户id，提交时间，提交用户类型
        diagnosisresults.setUserId(userId);
        diagnosisresults.setSubmissionUserId(submissionUserId);
        diagnosisresults.setSubmissionTime(LocalDate.now());

        //通过用户id，获取提交用户姓名对象，并设置提交用户名，提交用户类型
        //TODO 后期想办法在这里只获取用户名
        User user = userMapper.selectById(submissionUserId);
        diagnosisresults.setSubmissionUserName(user.getName());
        diagnosisresults.setSubmissionUserType(user.getUserType());

        diagnosisresultsMapper.insert(diagnosisresults);
    }

    /**
     * 根据用户id和时间获取当天诊断结果
     * @param date
     * @param userId
     * @return
     */
    @Override
    public Diagnosisresults getDiagnosisResult(LocalDate date, Integer userId) {
        return lambdaQuery()
                .eq(Diagnosisresults::getSubmissionTime, date)
                .eq(Diagnosisresults::getSubmissionUserId, userId)
                .one();
    }

    /**
     * 根据用户名，电话，部门，时间分页查询用户诊断信息
     * @param diagnosisPageDTO
     * @return
     */
    @Override
    public PageResult<DiagnosisPageVO> pageSelectDiagnosis(DiagnosisPageDTO diagnosisPageDTO) {
        String name = diagnosisPageDTO.getName();
        String phoneNumber = diagnosisPageDTO.getPhoneNumber();
        String department = diagnosisPageDTO.getDepartment();
        LocalDate beginDate = diagnosisPageDTO.getBeginDate();
        LocalDate endDate = diagnosisPageDTO.getEndDate();
        boolean flag = beginDate!=null && endDate!=null;

        //构造分页条件
        Page<Diagnosisresults> page = Page.of(diagnosisPageDTO.getPageNo(),diagnosisPageDTO.getPageSize());
        page.addOrder(new OrderItem("SubmissionTime",false));

        //根据用户名，电话，部门获取用户id
        List<Integer> userIds = userMapper.selectIdsByWrapper(
                new LambdaQueryWrapper<User>()
                        .like(name!=null, User::getName, name)
                        .like(phoneNumber!=null, User::getPhoneNumber, phoneNumber)
                        .like(department!=null, User::getDepartment, department)
        );

        //分页查询
        Page<Diagnosisresults> p = lambdaQuery()
                .in(Diagnosisresults::getUserId,userIds)
                .ge(flag, Diagnosisresults::getSubmissionTime,beginDate)
                .le(flag, Diagnosisresults::getSubmissionTime,endDate)
                .page(page);

        //封装VO结果
        PageResult<DiagnosisPageVO> pageResult = new PageResult<>();

        List<DiagnosisPageVO> list = new ArrayList<>();
        for(Diagnosisresults diagnosisresults:p.getRecords()){
            //TODO 这里可以用算法优化，现在暴力处理，后期优化
            DiagnosisPageVO diagnosisPageVO = new DiagnosisPageVO();
            User user = userMapper.selectById(diagnosisresults.getUserId());

            BeanUtil.copyProperties(user, diagnosisPageVO);
            BeanUtil.copyProperties(diagnosisresults, diagnosisPageVO);

            list.add(diagnosisPageVO);
        }

        pageResult.setRecords(list);
        pageResult.setTotal(p.getTotal());

        //返回
        return pageResult;
    }
}
