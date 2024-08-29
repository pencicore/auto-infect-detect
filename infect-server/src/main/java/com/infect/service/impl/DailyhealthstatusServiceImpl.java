package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.infect.dto.AllSymptomsDTO;
import com.infect.dto.RailwayEmployeeCheckInDTO;
import com.infect.entity.*;
import com.infect.mapper.*;
import com.infect.service.IDailyhealthstatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.utils.BaseContext;
import com.infect.vo.DailyhealthstatusGetVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

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
        dailyhealthstatus.setUserId(BaseContext.getCurrentId());
        dailyhealthstatus.setCheckInTime(LocalTime.now());
        dailyhealthstatus.setCheckInDate(LocalDate.now());

        dailyhealthstatusMapper.insert(dailyhealthstatus);
    }

    /*提交所有症状信息*/
    @Transactional
    @Override
    public void saveAllSymptoms(AllSymptomsDTO allSymptomsDTO) {
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
