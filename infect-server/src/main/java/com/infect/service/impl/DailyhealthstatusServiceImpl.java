package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.infect.dto.AllSymptomsDTO;
import com.infect.dto.RailwayEmployeeCheckInDTO;
import com.infect.dto.system.CheckinPageDTO;
import com.infect.entity.*;
import com.infect.mapper.*;
import com.infect.result.PageResult;
import com.infect.service.IDailyhealthstatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.utils.BaseContext;
import com.infect.utils.ExcelPencilUtil;
import com.infect.utils.ExcelUtil;
import com.infect.vo.DailyhealthstatusGetVO;
import com.infect.vo.system.CheckinInfoVO;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Service
public class DailyhealthstatusServiceImpl extends ServiceImpl<DailyhealthstatusMapper, Dailyhealthstatus> implements IDailyhealthstatusService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DailyhealthstatusMapper dailyhealthstatusMapper;

    @Autowired
    private GeneralsymptomsMapper generalsymptomsMapper;

    @Autowired
    private RespiratorysymptomsMapper respiratorysymptomsMapper;

    @Autowired
    private DigestivesymptomsMapper digestivesymptomsMapper;

    @Autowired
    private CirculatorysymptomsMapper circulatorysymptomsMapper;

    @Autowired
    private NeurologicalsymptomsMapper neurologicalsymptomsMapper;

    @Autowired
    private LocalsymptomsMapper localsymptomsMapper;

    @Autowired
    private OthersymptomsMapper othersymptomsMapper;

    @Autowired
    private RiskfactorsandexposureMapper riskfactorsandexposureMapper;

    @Override
    public DailyhealthstatusGetVO getDailyCheckIn(LocalDate date) {
        //根据用户id和日期查询每日健康签到记录
        LambdaQueryWrapper<Dailyhealthstatus> wrapper = new LambdaQueryWrapper<Dailyhealthstatus>()
                .eq(Dailyhealthstatus::getUserId, BaseContext.getCurrentId())
                .eq(Dailyhealthstatus::getCheckInDate, date);
        Dailyhealthstatus dailyhealthstatus = dailyhealthstatusMapper.selectOne(wrapper);

        //构造VO对象
        DailyhealthstatusGetVO dailyhealthstatusGetVO = new DailyhealthstatusGetVO();
        if(dailyhealthstatus == null) {
            dailyhealthstatusGetVO.setHasSignedToday(false);
        }
        else {
            dailyhealthstatusGetVO.setDailyhealthstatus(dailyhealthstatus);
            dailyhealthstatusGetVO.setHasSignedToday(true);
        }

        return dailyhealthstatusGetVO;
    }

    @Override
    public void userCheckIn(RailwayEmployeeCheckInDTO railwayEmployeeCheckInDTO) {
        Dailyhealthstatus dailyhealthstatus = BeanUtil.copyProperties(railwayEmployeeCheckInDTO, Dailyhealthstatus.class);
        dailyhealthstatus.setIsHealth(railwayEmployeeCheckInDTO.getHealth());
        dailyhealthstatus.setUserId(BaseContext.getCurrentId());
        dailyhealthstatus.setCheckInTime(LocalTime.now());
        dailyhealthstatus.setCheckInDate(LocalDate.now());
        dailyhealthstatusMapper.insert(dailyhealthstatus);
    }

    /*提交所有症状信息*/
    @Transactional
    @Override
    public void saveAllSymptoms(AllSymptomsDTO allSymptomsDTO) {
        //TODO 这里先暂时暴力处理，后期优化
        // 提交全身症状信息
        saveGeneralSymptoms(allSymptomsDTO.getGeneralsymptoms());
        // 提交呼吸系统症状信息
        saveRespiratorysymptoms(allSymptomsDTO.getRespiratorysymptoms());
        // 提交消化系统症状信息
        saveDigestiveSymptoms(allSymptomsDTO.getDigestivesymptoms());
        // 提交循环系统症状信息
        saveCirculatorySymptoms(allSymptomsDTO.getCirculatorysymptoms());
        // 提交神经系统症状信息
        saveNeurologicalSymptoms(allSymptomsDTO.getNeurologicalSymptoms());
        // 提交局部症状信息
        saveLocalSymptoms(allSymptomsDTO.getLocalSymptoms());
        // 提交其他症状信息
        saveOtherSymptoms(allSymptomsDTO.getOtherSymptoms());
        // 提交风险因素和暴露信息
        saveRiskFactorsAndExposure(allSymptomsDTO.getRiskFactorsAndExposure());
    }

    /**
     * 分页查询用户签到信息
     * @param checkinPageDTO
     * @return
     */
    @Override
    public PageResult<CheckinInfoVO> pageSelectCheckin(CheckinPageDTO checkinPageDTO) {
        Boolean isHealth = checkinPageDTO.getIsHealth();
        LocalDate checkInDateBegin = checkinPageDTO.getCheckInDateBegin();
        LocalDate checkInDateEnd = checkinPageDTO.getCheckInDateEnd();
        boolean dateFlag = checkInDateBegin!=null && checkInDateEnd!=null;

        System.out.println(checkinPageDTO);

        //根据查询条件，获取用户id列表
        List<Integer> listUserId=null;

        if(checkinPageDTO.getName()!=null
        || checkinPageDTO.getPhoneNumber()!=null
        || checkinPageDTO.getDepartment()!=null
        || checkinPageDTO.getSpecificOccupation()!=null) {

            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                    .like(checkinPageDTO.getName()!=null, User::getName, checkinPageDTO.getName())
                    .like(checkinPageDTO.getPhoneNumber()!=null, User::getPhoneNumber, checkinPageDTO.getPhoneNumber())
                    .like(checkinPageDTO.getDepartment()!=null, User::getDepartment, checkinPageDTO.getDepartment())
                    .like(checkinPageDTO.getSpecificOccupation()!=null, User::getSpecificOccupation, checkinPageDTO.getSpecificOccupation());
            listUserId = userMapper.selectIdsByWrapper(wrapper);
        }

        //构建分页条件
        Page<Dailyhealthstatus> page = Page.of(checkinPageDTO.getPageNo(), checkinPageDTO.getPageSize());

        //分页条件查询
        Page<Dailyhealthstatus> p = lambdaQuery()
                .in(listUserId!=null,Dailyhealthstatus::getUserId,listUserId)
                .gt(dateFlag,Dailyhealthstatus::getCheckInDate,checkInDateBegin)
                .lt(dateFlag,Dailyhealthstatus::getCheckInDate,checkInDateEnd)
                .eq(isHealth!=null,Dailyhealthstatus::getIsHealth,isHealth)
                .page(page);

        //封装VO
        PageResult<CheckinInfoVO> pageResult=new PageResult<>();

        List<CheckinInfoVO> list = new ArrayList<>();
        for (Dailyhealthstatus dailyhealthstatus:p.getRecords()) {
            //TODO 这里可以用算法优化，现在暴力处理，后期优化
            CheckinInfoVO checkinInfoVO = new CheckinInfoVO();
            User user = userMapper.selectById(dailyhealthstatus.getUserId());

            BeanUtil.copyProperties(user, checkinInfoVO);
            BeanUtil.copyProperties(dailyhealthstatus, checkinInfoVO);

            list.add(checkinInfoVO);
        }

        pageResult.setRecords(list);
        pageResult.setTotal(p.getTotal());

        //返回
        return pageResult;
    }

    /**
     * 导出职工打卡信息表
     * @param response
     */
    @Override
    public void getEmployeeCheckInExcel(HttpServletResponse response) {

        //获取文件绝对路径
        String projectDir = System.getProperty("user.dir");
        String fileName = projectDir + "\\infect-server\\src\\main\\resources\\templates\\职工打卡信息导出表.xlsx";

        //查询打卡信息
        List<Dailyhealthstatus> dailyhealthstatusList = dailyhealthstatusMapper.selectList(null);
        List<List<Object>> listList = new ArrayList<>();

        //生成二维数组
        for (Dailyhealthstatus obj:
                dailyhealthstatusList) {
            List<Object> temp = new ArrayList<>();

            temp.add(obj);

            temp.add(userMapper.selectById(obj.getUserId()));

            Integer statusId=obj.getStatusId();

            temp.add(generalsymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Generalsymptoms>()
                            .eq(Generalsymptoms::getStatusId,statusId)
            ));
            temp.add(respiratorysymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Respiratorysymptoms>()
                            .eq(Respiratorysymptoms::getStatusId,statusId)
            ));
            temp.add(digestivesymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Digestivesymptoms>()
                            .eq(Digestivesymptoms::getStatusId,statusId)
            ));
            temp.add(circulatorysymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Circulatorysymptoms>()
                            .eq(Circulatorysymptoms::getStatusId,statusId)
            ));
            temp.add(neurologicalsymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Neurologicalsymptoms>()
                            .eq(Neurologicalsymptoms::getStatusId,statusId)
            ));
            temp.add(localsymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Localsymptoms>()
                            .eq(Localsymptoms::getStatusId, statusId)
            ));
            temp.add(othersymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Othersymptoms>()
                            .eq(Othersymptoms::getStatusId,statusId)
            ));
            temp.add(riskfactorsandexposureMapper.selectOne(
                    new LambdaQueryWrapper<Riskfactorsandexposure>()
                            .eq(Riskfactorsandexposure::getStatusId, statusId)
            ));

            listList.add(temp);
        }

        XSSFWorkbook excel = ExcelUtil.getExcelFile(response, "职工打卡信息导出表.xlsx", fileName
                , 2, 1, 185
                , 2, 1
                , listList);

        try {
            ServletOutputStream out = response.getOutputStream();
            excel.write(out);

            excel.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 导出职工打卡信息导出表（含AI预测数据
     * @param response
     */
    @Override
    public void getEmployeeCheckInExcelAI(HttpServletResponse response) {

        //获取文件绝对路径
        String projectDir = System.getProperty("user.dir");
        String fileName = projectDir + "\\infect-server\\src\\main\\resources\\templates\\职工打卡信息导出表(含AI预测数据）.xlsx";

        //查询打卡信息
        List<Dailyhealthstatus> dailyhealthstatusList = dailyhealthstatusMapper.selectList(null);
        List<List<Object>> listList = new ArrayList<>();

        //生成二维数组
        for (Dailyhealthstatus obj:
                dailyhealthstatusList) {
            List<Object> temp = new ArrayList<>();

            temp.add(obj);

            temp.add(userMapper.selectById(obj.getUserId()));

            Integer statusId=obj.getStatusId();

            temp.add(generalsymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Generalsymptoms>()
                            .eq(Generalsymptoms::getStatusId,statusId)
            ));
            temp.add(respiratorysymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Respiratorysymptoms>()
                            .eq(Respiratorysymptoms::getStatusId,statusId)
            ));
            temp.add(digestivesymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Digestivesymptoms>()
                            .eq(Digestivesymptoms::getStatusId,statusId)
            ));
            temp.add(circulatorysymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Circulatorysymptoms>()
                            .eq(Circulatorysymptoms::getStatusId,statusId)
            ));
            temp.add(neurologicalsymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Neurologicalsymptoms>()
                            .eq(Neurologicalsymptoms::getStatusId,statusId)
            ));
            temp.add(localsymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Localsymptoms>()
                            .eq(Localsymptoms::getStatusId, statusId)
            ));
            temp.add(othersymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Othersymptoms>()
                            .eq(Othersymptoms::getStatusId,statusId)
            ));
            temp.add(riskfactorsandexposureMapper.selectOne(
                    new LambdaQueryWrapper<Riskfactorsandexposure>()
                            .eq(Riskfactorsandexposure::getStatusId, statusId)
            ));

            listList.add(temp);
        }

        XSSFWorkbook excel = ExcelUtil.getExcelFile(response, "职工打卡信息导出表(含AI预测数据）.xlsx", fileName
                , 2, 1, 185
                , 2, 1
                , listList);

        try {
            ServletOutputStream out = response.getOutputStream();
            excel.write(out);

            excel.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /*提交全身症状信息*/
    @Override
    public void saveGeneralSymptoms(Generalsymptoms generalsymptoms) {
        //通过用户id和今天的日期获取健康签到表的id
        Dailyhealthstatus dailyhealthstatus = getDailyhealthstatus(BaseContext.getCurrentId());
        //添加签到表id字段
        generalsymptoms.setStatusId(dailyhealthstatus.getStatusId());
        //查询今日是否已经填写了信息，如果已填，直接退出不能修改
        Generalsymptoms generalsymptoms1 = generalsymptomsMapper.selectById(dailyhealthstatus.getStatusId());
        if(generalsymptoms1!=null) {
            return;
        }
        //向全身症状表中添加数据
        generalsymptomsMapper.insert(generalsymptoms);
    }

    /*提交呼吸系统症状信息*/
    @Override
    public void saveRespiratorysymptoms(Respiratorysymptoms respiratorysymptoms) {
        //通过用户id和今天的日期获取健康签到表的id
        Dailyhealthstatus dailyhealthstatus = getDailyhealthstatus(BaseContext.getCurrentId());
        //添加签到表id字段
        respiratorysymptoms.setStatusId(dailyhealthstatus.getStatusId());
        //查询今日是否已经填写了信息，如果已填，直接退出不能修改
        Respiratorysymptoms respiratorysymptoms1 = respiratorysymptomsMapper.selectById(respiratorysymptoms.getStatusId());
        if(respiratorysymptoms1!=null) {
            return;
        }
        //向全身症状表中添加数据
        respiratorysymptomsMapper.insert(respiratorysymptoms);
    }

    /* 提交消化系统症状信息 */
    @Override
    public void saveDigestiveSymptoms(Digestivesymptoms digestivesymptoms) {
        // 通过用户id和今天的日期获取健康签到表的id
        Dailyhealthstatus dailyhealthstatus = getDailyhealthstatus(BaseContext.getCurrentId());
        // 添加签到表id字段
        digestivesymptoms.setStatusId(dailyhealthstatus.getStatusId());
        // 查询今日是否已经填写了信息，如果已填，直接退出不能修改
        Digestivesymptoms existingDigestiveSymptoms = digestivesymptomsMapper.selectById(digestivesymptoms.getStatusId());
        if (existingDigestiveSymptoms != null) {
            return;
        }
        // 向消化系统症状表中添加数据
        digestivesymptomsMapper.insert(digestivesymptoms);
    }

    /* 提交循环系统症状信息 */
    @Override
    public void saveCirculatorySymptoms(Circulatorysymptoms circulatorysymptoms) {
        // 通过用户id和今天的日期获取健康签到表的id
        Dailyhealthstatus dailyhealthstatus = getDailyhealthstatus(BaseContext.getCurrentId());
        // 添加签到表id字段
        circulatorysymptoms.setStatusId(dailyhealthstatus.getStatusId());
        // 查询今日是否已经填写了信息，如果已填，直接退出不能修改
        Circulatorysymptoms existingCirculatorySymptoms = circulatorysymptomsMapper.selectById(circulatorysymptoms.getStatusId());
        if (existingCirculatorySymptoms != null) {
            return;
        }
        // 向循环系统症状表中添加数据
        circulatorysymptomsMapper.insert(circulatorysymptoms);
    }

    /* 提交神经系统症状信息 */
    @Override
    public void saveNeurologicalSymptoms(Neurologicalsymptoms neurologicalSymptoms) {
        // 通过用户id和今天的日期获取健康签到表的id
        Dailyhealthstatus dailyhealthstatus = getDailyhealthstatus(BaseContext.getCurrentId());
        // 添加签到表id字段
        neurologicalSymptoms.setStatusId(dailyhealthstatus.getStatusId());
        // 查询今日是否已经填写了信息，如果已填，直接退出不能修改
        Neurologicalsymptoms existingNeurologicalSymptoms = neurologicalsymptomsMapper.selectById(neurologicalSymptoms.getStatusId());
        if (existingNeurologicalSymptoms != null) {
            return;
        }
        // 向神经系统症状表中添加数据
        neurologicalsymptomsMapper.insert(neurologicalSymptoms);
    }

    /* 提交局部症状信息 */
    @Override
    public void saveLocalSymptoms(Localsymptoms localSymptoms) {
        // 通过用户id和今天的日期获取健康签到表的id
        Dailyhealthstatus dailyhealthstatus = getDailyhealthstatus(BaseContext.getCurrentId());
        // 添加签到表id字段
        localSymptoms.setStatusId(dailyhealthstatus.getStatusId());
        // 查询今日是否已经填写了信息，如果已填，直接退出不能修改
        Localsymptoms existingLocalSymptoms = localsymptomsMapper.selectById(localSymptoms.getStatusId());
        if (existingLocalSymptoms != null) {
            return;
        }
        // 向局部症状表中添加数据
        localsymptomsMapper.insert(localSymptoms);
    }

    /* 提交其他症状信息 */
    @Override
    public void saveOtherSymptoms(Othersymptoms otherSymptoms) {
        // 通过用户id和今天的日期获取健康签到表的id
        Dailyhealthstatus dailyhealthstatus = getDailyhealthstatus(BaseContext.getCurrentId());
        // 添加签到表id字段
        otherSymptoms.setStatusId(dailyhealthstatus.getStatusId());
        // 查询今日是否已经填写了信息，如果已填，直接退出不能修改
        Othersymptoms existingOtherSymptoms = othersymptomsMapper.selectById(otherSymptoms.getStatusId());
        if (existingOtherSymptoms != null) {
            return;
        }
        // 向其他症状表中添加数据
        othersymptomsMapper.insert(otherSymptoms);
    }

    /* 提交风险因素和暴露信息 */
    @Override
    public void saveRiskFactorsAndExposure(Riskfactorsandexposure riskFactorsAndExposure) {
        // 通过用户id和今天的日期获取健康签到表的id
        Dailyhealthstatus dailyhealthstatus = getDailyhealthstatus(BaseContext.getCurrentId());
        // 添加签到表id字段
        riskFactorsAndExposure.setStatusId(dailyhealthstatus.getStatusId());
        // 查询今日是否已经填写了信息，如果已填，直接退出不能修改
        Riskfactorsandexposure existingRiskFactorsAndExposure = riskfactorsandexposureMapper.selectById(riskFactorsAndExposure.getStatusId());
        if (existingRiskFactorsAndExposure != null) {
            return;
        }
        // 向风险因素和暴露表中添加数据
        riskfactorsandexposureMapper.insert(riskFactorsAndExposure);
    }


    /*根据时间和用户id查询健康签到表信息*/
    private Dailyhealthstatus getDailyhealthstatus(Integer userId){
        LambdaQueryWrapper<Dailyhealthstatus> wrapper = new LambdaQueryWrapper<Dailyhealthstatus>()
                .eq(Dailyhealthstatus::getUserId, userId)
                .eq(Dailyhealthstatus::getCheckInDate, LocalDate.now());
        return dailyhealthstatusMapper.selectOne(wrapper);
    }
}
