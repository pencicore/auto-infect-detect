package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.infect.dto.AllSymptomsDTO;
import com.infect.dto.RailwayEmployeeCheckInDTO;
import com.infect.dto.system.CheckinPageDTO;
import com.infect.entity.*;
import com.infect.mapper.*;
import com.infect.result.PageResult;
import com.infect.service.IDailyhealthstatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.temporary.DiseaseNameNumberPairTemp;
import com.infect.temporary.StationTemp;
import com.infect.utils.BaseContext;
import com.infect.utils.ExcelUtil;
import com.infect.utils.ExcelUtil;
import com.infect.vo.DailyhealthstatusGetVO;
import com.infect.vo.system.CheckinDailyNumberSumVO;
import com.infect.vo.system.CheckinDailyNumberVO;
import com.infect.vo.system.CheckinInfoStatisticsVO;
import com.infect.vo.system.CheckinInfoVO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.infect.vo.MonthlyHealthStatusVO;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;
import java.util.stream.Collectors;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16

import static com.infect.utils.ExcelUtil.readExcelFile;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Service
public class DailyhealthstatusServiceImpl extends ServiceImpl<DailyhealthstatusMapper, Dailyhealthstatus>
        implements IDailyhealthstatusService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiagnosisresultsMapper diagnosisresultsMapper;

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

    @Autowired
    private LabtestreportMapper labtestreportMapper;

    @Autowired
    private DiseasescoringMapper diseasescoringMapper;

    @Autowired
    private SymptomweightingMapper symptomweightingMapper;

    @Override
    public DailyhealthstatusGetVO getDailyCheckIn(LocalDate date) {
        // 根据用户id和日期查询每日健康签到记录
        LambdaQueryWrapper<Dailyhealthstatus> wrapper = new LambdaQueryWrapper<Dailyhealthstatus>()
                .eq(Dailyhealthstatus::getUserId, BaseContext.getCurrentId())
                .eq(Dailyhealthstatus::getCheckInDate, date);
        Dailyhealthstatus dailyhealthstatus = dailyhealthstatusMapper.selectOne(wrapper);

        // 构造VO对象
        DailyhealthstatusGetVO dailyhealthstatusGetVO = new DailyhealthstatusGetVO();
        if (dailyhealthstatus == null) {
            dailyhealthstatusGetVO.setHasSignedToday(false);
        } else {
            dailyhealthstatusGetVO.setDailyhealthstatus(dailyhealthstatus);
            dailyhealthstatusGetVO.setHasSignedToday(true);
        }

        LambdaQueryWrapper<Diseasescoring> wrapper1 = null;
        if (dailyhealthstatus != null && dailyhealthstatus.getStatusId() != null && date != null) {
            wrapper1 = new LambdaQueryWrapper<Diseasescoring>()
                    .eq(Diseasescoring::getStatusId, dailyhealthstatus.getStatusId())
                    .eq(Diseasescoring::getSymptomTime, date);
            List<Diseasescoring> diseasescorings = diseasescoringMapper.selectList(wrapper1);
            dailyhealthstatusGetVO.setDiseasescoringList(diseasescorings);
        }
        return dailyhealthstatusGetVO;
    }

    @Override
    public void userCheckIn(RailwayEmployeeCheckInDTO railwayEmployeeCheckInDTO) {
        Dailyhealthstatus dailyhealthstatus = BeanUtil.copyProperties(railwayEmployeeCheckInDTO,
                Dailyhealthstatus.class);
        dailyhealthstatus.setIsHealth(railwayEmployeeCheckInDTO.getHealth());
        dailyhealthstatus.setUserId(BaseContext.getCurrentId());
        dailyhealthstatus.setCheckInTime(LocalTime.now());
        dailyhealthstatus.setCheckInDate(LocalDate.now());
        dailyhealthstatusMapper.insert(dailyhealthstatus);
    }

    /* 提交所有症状信息 */
    @Transactional
    @Override
    public List<Diseasescoring> saveAllSymptoms(AllSymptomsDTO allSymptomsDTO) {
        // TODO 这里先暂时暴力处理，后期优化
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

        List<Symptomweighting> generatedSymptoms = symptomweightingMapper.selectAll();
        List<Diseasescoring> diseaseScorings = new ArrayList<>();
        Diseasescoring infectiousDiarrhea = inputDiseaseScoring("感染性腹泻", generatedSymptoms.stream()
                .filter(symptom -> "感染性腹泻".equals(symptom.getDiseaseTypeName()))
                .collect(Collectors.toList()), allSymptomsDTO);
        diseasescoringMapper.insert(infectiousDiarrhea);
        diseaseScorings.add(infectiousDiarrhea);
        Diseasescoring epidemicHaemorrhagic = inputDiseaseScoring("流行性出血热", generatedSymptoms.stream()
                .filter(symptom -> "流行性出血热".equals(symptom.getDiseaseTypeName()))
                .collect(Collectors.toList()), allSymptomsDTO);
        diseasescoringMapper.insert(epidemicHaemorrhagic);
        diseaseScorings.add(epidemicHaemorrhagic);
        Diseasescoring anthrax = inputDiseaseScoring("炭疽", generatedSymptoms.stream()
                .filter(symptom -> "炭疽".equals(symptom.getDiseaseTypeName()))
                .collect(Collectors.toList()), allSymptomsDTO);
        diseasescoringMapper.insert(anthrax);
        diseaseScorings.add(anthrax);
        Diseasescoring thrombocytopenia = inputDiseaseScoring("发热伴血小板减少综合征（蜱媒传染病）", generatedSymptoms.stream()
                .filter(symptom -> "发热伴血小板减少综合征（蜱媒传染病）".equals(symptom.getDiseaseTypeName()))
                .collect(Collectors.toList()), allSymptomsDTO);
        diseasescoringMapper.insert(thrombocytopenia);
        diseaseScorings.add(thrombocytopenia);
        Diseasescoring dengue = inputDiseaseScoring("登革热（蚊媒传染病）", generatedSymptoms.stream()
                .filter(symptom -> "登革热（蚊媒传染病）".equals(symptom.getDiseaseTypeName()))
                .collect(Collectors.toList()), allSymptomsDTO);
        diseasescoringMapper.insert(dengue);
        diseaseScorings.add(dengue);
        Diseasescoring malaria = inputDiseaseScoring("疟疾（蚊媒传染病）", generatedSymptoms.stream()
                .filter(symptom -> "疟疾（蚊媒传染病）".equals(symptom.getDiseaseTypeName()))
                .collect(Collectors.toList()), allSymptomsDTO);
        diseasescoringMapper.insert(malaria);
        diseaseScorings.add(malaria);
        Diseasescoring cholera = inputDiseaseScoring("森林脑炎（蜱媒传染病）", generatedSymptoms.stream()
                .filter(symptom -> "森林脑炎（蜱媒传染病）".equals(symptom.getDiseaseTypeName()))
                .collect(Collectors.toList()), allSymptomsDTO);
        diseasescoringMapper.insert(cholera);
        diseaseScorings.add(cholera);
        Diseasescoring diarrhea = inputDiseaseScoring("新型冠状病毒感染", generatedSymptoms.stream()
                .filter(symptom -> "新型冠状病毒感染".equals(symptom.getDiseaseTypeName()))
                .collect(Collectors.toList()), allSymptomsDTO);
        diseasescoringMapper.insert(diarrhea);
        diseaseScorings.add(diarrhea);
        Diseasescoring pestis = inputDiseaseScoring("鼠疫", generatedSymptoms.stream()
                .filter(symptom -> "鼠疫".equals(symptom.getDiseaseTypeName()))
                .collect(Collectors.toList()), allSymptomsDTO);
        diseasescoringMapper.insert(pestis);
        diseaseScorings.add(pestis);
        Diseasescoring typhus = inputDiseaseScoring("斑疹伤寒", generatedSymptoms.stream()
                .filter(symptom -> "斑疹伤寒".equals(symptom.getDiseaseTypeName()))
                .collect(Collectors.toList()), allSymptomsDTO);
        diseasescoringMapper.insert(typhus);
        diseaseScorings.add(typhus);
        Diseasescoring tuberculosis = inputDiseaseScoring("结核病", generatedSymptoms.stream()
                .filter(symptom -> "结核病".equals(symptom.getDiseaseTypeName()))
                .collect(Collectors.toList()), allSymptomsDTO);
        diseasescoringMapper.insert(tuberculosis);
        diseaseScorings.add(tuberculosis);
        Diseasescoring flu = inputDiseaseScoring("流感", generatedSymptoms.stream()
                .filter(symptom -> "流感".equals(symptom.getDiseaseTypeName()))
                .collect(Collectors.toList()), allSymptomsDTO);
        diseasescoringMapper.insert(flu);
        diseaseScorings.add(flu);
        return diseaseScorings;
    }

    private Diseasescoring inputDiseaseScoring(String diseaseName, List<Symptomweighting> collect, AllSymptomsDTO allSymptomsDTO) {
        Diseasescoring diseasescoring = new Diseasescoring();
        diseasescoring.setDiseaseTypeName(diseaseName);
        diseasescoring.setScore(calculateScore(collect, allSymptomsDTO));
        diseasescoring.setSymptomTime(LocalDate.now());
        Dailyhealthstatus dailyhealthstatus = getDailyhealthstatus(BaseContext.getCurrentId());
        diseasescoring.setStatusId(dailyhealthstatus.getStatusId());
        diseasescoring.setDiseaseTypeId(dailyhealthstatus.getStatusId());
        return diseasescoring;
    }
    // 通用的获取症状权重的方法
//    private BigDecimal getSymptomWeight(List<Symptomweighting> lists, String symptomFieldName) {
//        return lists.stream()
//                .filter(symptom -> symptomFieldName.equals(symptom.getSymptomFieldName()))
//                .findFirst()
//                .map(Symptomweighting::getWeightScore)
//                .orElse(BigDecimal.ZERO);
//    }

//    // 通用的处理症状的存在与权重累加
//    private BigDecimal processSymptom(List<Symptomweighting> lists, Object symptomObject, String symptomFieldName, boolean condition) {
//        if (condition) {
//            return getSymptomWeight(lists, symptomFieldName);
//        }
//        return BigDecimal.ZERO;
//    }
    private BigDecimal calculateScore(List<Symptomweighting> lists, AllSymptomsDTO results) {
        BigDecimal totalScore = BigDecimal.ZERO; // 使用 BigDecimal.ZERO 初始化
//        if (results.getGeneralsymptoms() != null) {
//            totalScore = totalScore
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasFever", results.getGeneralsymptoms().getHasFever()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasChills", results.getGeneralsymptoms().getHasChills()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasSweating", results.getGeneralsymptoms().getHasSweating()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasFatigue", results.getGeneralsymptoms().getHasFatigue()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasHeadache", results.getGeneralsymptoms().getHasHeadache()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasMusclePain", results.getGeneralsymptoms().getHasMusclePain()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasJointPain", results.getGeneralsymptoms().getHasJointPain()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasLymphNodeSwelling", results.getGeneralsymptoms().getHasLymphNodeSwelling()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasCyanosis", results.getGeneralsymptoms().getHasCyanosis()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasSubcutaneousAndMucosalBleedingSpots", results.getGeneralsymptoms().getHasSubcutaneousAndMucosalBleedingSpots()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasPainfulRedRash", results.getGeneralsymptoms().getHasPainfulRedRash()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasBloodBlisters", results.getGeneralsymptoms().getHasBloodBlisters()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasSkinUlcer", results.getGeneralsymptoms().getHasSkinUlcer()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasCongestiveOrPetechialRash", results.getGeneralsymptoms().getHasCongestiveOrPetechialRash()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasItchyRash", results.getGeneralsymptoms().getHasItchyRash()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasDehydration", results.getGeneralsymptoms().getHasDehydration()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasEdema", results.getGeneralsymptoms().getHasEdema()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasNightSweats", results.getGeneralsymptoms().getHasNightSweats()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasWeightLoss", results.getGeneralsymptoms().getHasWeightLoss()))
//                    .add(processSymptom(lists, results.getGeneralsymptoms(), "HasExhaustion", results.getGeneralsymptoms().getHasExhaustion()));
//        }
//        if (results.getRespiratorysymptoms() != null) {
//            totalScore = totalScore
//                    .add(processSymptom(lists, results.getRespiratorysymptoms(), "HasCough", results.getRespiratorysymptoms().getHasCough()))
//                    .add(processSymptom(lists, results.getRespiratorysymptoms(), "HasSputum", results.getRespiratorysymptoms().getHasSputum()))
//                    .add(processSymptom(lists, results.getRespiratorysymptoms(), "HasBloodySputum", results.getRespiratorysymptoms().getHasBloodySputum()))
//                    .add(processSymptom(lists, results.getRespiratorysymptoms(), "HasHemoptysis", results.getRespiratorysymptoms().getHasHemoptysis()))
//                    .add(processSymptom(lists, results.getRespiratorysymptoms(), "HasSoreThroat", results.getRespiratorysymptoms().getHasSoreThroat()))
//                    .add(processSymptom(lists, results.getRespiratorysymptoms(), "HasDryThroat", results.getRespiratorysymptoms().getHasDryThroat()))
//                    .add(processSymptom(lists, results.getRespiratorysymptoms(), "HasNasalCongestion", results.getRespiratorysymptoms().getHasNasalCongestion()))
//                    .add(processSymptom(lists, results.getRespiratorysymptoms(), "HasRunnyNose", results.getRespiratorysymptoms().getHasRunnyNose()))
//                    .add(processSymptom(lists, results.getRespiratorysymptoms(), "HasChestTightness", results.getRespiratorysymptoms().getHasChestTightness()))
//                    .add(processSymptom(lists, results.getRespiratorysymptoms(), "HasShortnessOfBreath", results.getRespiratorysymptoms().getHasShortnessOfBreath()))
//                    .add(processSymptom(lists, results.getRespiratorysymptoms(), "HasBreathingDifficulty", results.getRespiratorysymptoms().getHasBreathingDifficulty()))
//                    .add(processSymptom(lists, results.getRespiratorysymptoms(), "HasHoarseness", results.getRespiratorysymptoms().getHasHoarseness()))
//                    .add(processSymptom(lists, results.getRespiratorysymptoms(), "HasBronchitis", results.getRespiratorysymptoms().getHasBronchitis()));
//        }
//
//        if (results.getDigestivesymptoms() != null) {
//            totalScore = totalScore
//                    .add(processSymptom(lists, results.getDigestivesymptoms(), "HasVomiting", results.getDigestivesymptoms().getHasVomiting()))
//                    .add(processSymptom(lists, results.getDigestivesymptoms(), "HasNausea", results.getDigestivesymptoms().getHasNausea()))
//                    .add(processSymptom(lists, results.getDigestivesymptoms(), "HasAppetiteLoss", results.getDigestivesymptoms().getHasAppetiteLoss()))
//                    .add(processSymptom(lists, results.getDigestivesymptoms(), "HasAbdominalDistension", results.getDigestivesymptoms().getHasAbdominalDistension()))
//                    .add(processSymptom(lists, results.getDigestivesymptoms(), "HasAbdominalPain", results.getDigestivesymptoms().getHasAbdominalPain()));
//        }

        if (results.getGeneralsymptoms() != null) {
            if (results.getGeneralsymptoms().getHasFever()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasFever".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasChills()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasChills".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasSweating()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasSweating".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasFatigue()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasFatigue".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasHeadache()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasHeadache".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasMusclePain()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasMusclePain".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasJointPain()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasSweating".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasLymphNodeSwelling()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasLymphNodeSwelling".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasCyanosis()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasCyanosis".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasSubcutaneousAndMucosalBleedingSpots()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasSubcutaneousAndMucosalBleedingSpots".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasPainfulRedRash()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasPainfulRedRash".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasBloodBlisters()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasBloodBlisters".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasSkinUlcer()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasSkinUlcer".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasCongestiveOrPetechialRash()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasCongestiveOrPetechialRash".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getItchyRashOnBackOfHands() || results.getGeneralsymptoms().getItchyRashOnFace() || results.getGeneralsymptoms().getItchyRashOnFeet() || results.getGeneralsymptoms().getItchyRashOnFingers()
                    || results.getGeneralsymptoms().getItchyRashOnLowerLimbs() || results.getGeneralsymptoms().getItchyRashOnOther()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasPressureInsensitiveRash".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasDehydration()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasDehydration".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasItchyRash()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasItchyRash".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasEdema()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasEdema".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasNightSweats()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasNightSweats".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasWeightLoss()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasWeightLoss".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getGeneralsymptoms().getHasExhaustion()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasExhaustion".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
        }
<<<<<<< HEAD
        if (results.getRespiratorysymptoms() != null) {
            if (results.getRespiratorysymptoms().getHasCough()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasCough".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRespiratorysymptoms().getHasSputum()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasSputum".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRespiratorysymptoms().getHasBloodySputum()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasBloodySputum".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRespiratorysymptoms().getHasHemoptysis()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasHemoptysis".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRespiratorysymptoms().getHasSoreThroat()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasSoreThroat".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRespiratorysymptoms().getHasDryThroat()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasDryThroat".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRespiratorysymptoms().getHasNasalCongestion()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasNasalCongestion".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRespiratorysymptoms().getHasRunnyNose()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasRunnyNose".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRespiratorysymptoms().getHasChestTightness()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasChestTightness".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRespiratorysymptoms().getHasShortnessOfBreath()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasShortnessOfBreath".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRespiratorysymptoms().getHasBreathingDifficulty()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasBreathingDifficulty".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRespiratorysymptoms().getHasHoarseness()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasHoarseness".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRespiratorysymptoms().getHasBronchitis()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasBronchitis".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
=======
        try {
            // 将输入流转换为字节数组
            byte[] bytes = IOUtils.toByteArray(inputStream);

            // 创建一个 MultipartFile 对象
            MultipartFile multipartFile = new MockMultipartFile(fileName, fileName,
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                    new ByteArrayInputStream(bytes));

            // 调用 readExcelFile 方法
            List<List<String>> lists = readExcelFile(multipartFile, 0);
            List<Diseasescoring> diseaseScorings = new ArrayList<>();
            Diseasescoring infectiousDiarrhea = inputDiseaseScoring("感染性腹泻", lists.get(1), allSymptomsDTO);
            diseasescoringMapper.insert(infectiousDiarrhea);
            diseaseScorings.add(infectiousDiarrhea);
            Diseasescoring epidemicHaemorrhagic = inputDiseaseScoring("流行性出血热", lists.get(2), allSymptomsDTO);
            diseasescoringMapper.insert(epidemicHaemorrhagic);
            diseaseScorings.add(epidemicHaemorrhagic);
            Diseasescoring anthrax = inputDiseaseScoring("炭疽", lists.get(3), allSymptomsDTO);
            diseasescoringMapper.insert(anthrax);
            diseaseScorings.add(anthrax);
            Diseasescoring thrombocytopenia = inputDiseaseScoring("发热伴血小板减少综合征（蜱媒传染病）", lists.get(4), allSymptomsDTO);
            diseasescoringMapper.insert(thrombocytopenia);
            diseaseScorings.add(thrombocytopenia);
            Diseasescoring dengue = inputDiseaseScoring("登革热（蚊媒传染病）", lists.get(5), allSymptomsDTO);
            diseasescoringMapper.insert(dengue);
            diseaseScorings.add(dengue);
            Diseasescoring malaria = inputDiseaseScoring("疟疾（蚊媒传染病）", lists.get(6), allSymptomsDTO);
            diseasescoringMapper.insert(malaria);
            diseaseScorings.add(malaria);
            Diseasescoring cholera = inputDiseaseScoring("森林脑炎（蜱媒传染病）", lists.get(7), allSymptomsDTO);
            diseasescoringMapper.insert(cholera);
            diseaseScorings.add(cholera);
            Diseasescoring diarrhea = inputDiseaseScoring("新型冠状病毒感染", lists.get(8), allSymptomsDTO);
            diseasescoringMapper.insert(diarrhea);
            diseaseScorings.add(diarrhea);
            Diseasescoring pestis = inputDiseaseScoring("鼠疫", lists.get(9), allSymptomsDTO);
            diseasescoringMapper.insert(pestis);
            diseaseScorings.add(pestis);
            Diseasescoring typhus = inputDiseaseScoring("斑疹伤寒", lists.get(10), allSymptomsDTO);
            diseasescoringMapper.insert(typhus);
            diseaseScorings.add(typhus);
            Diseasescoring tuberculosis = inputDiseaseScoring("结核病", lists.get(11), allSymptomsDTO);
            diseasescoringMapper.insert(tuberculosis);
            diseaseScorings.add(tuberculosis);
            Diseasescoring flu = inputDiseaseScoring("流感", lists.get(12), allSymptomsDTO);
            diseasescoringMapper.insert(flu);
            diseaseScorings.add(flu);
            return diseaseScorings;
        } catch (Exception e) {
            e.printStackTrace();
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16
        }
        if (results.getDigestivesymptoms() != null) {
            if (results.getDigestivesymptoms().getArrheaFrequencyGEThreeTimesPerDay()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "IsDiarrheaFrequencyGEThreeTimesPerDay".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getDigestivesymptoms().getHasStoolType1()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasStoolType1".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getDigestivesymptoms().getHasStoolType2()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasStoolType2".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getDigestivesymptoms().getHasVomiting()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasVomiting".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getDigestivesymptoms().getHasNausea()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasNausea".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getDigestivesymptoms().getHasAppetiteLoss()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasAppetiteLoss".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getDigestivesymptoms().getHasAbdominalDistension()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasAbdominalDistension".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getDigestivesymptoms().getHasAbdominalPain()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasAbdominalPain".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getDigestivesymptoms().getHasBorborygmus()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasBorborygmus".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getDigestivesymptoms().getHasUpperAbdominalDiscomfort()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasUpperAbdominalDiscomfort".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getDigestivesymptoms().getHasConstipation()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasConstipation".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getDigestivesymptoms().getHasOliguriaOrAnuria()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasOliguriaOrAnuria".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
        }
        if (results.getCirculatorysymptoms() != null) {
            if (results.getCirculatorysymptoms().getHasArrhythmia()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasArrhythmia".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getCirculatorysymptoms().getHasChestPain()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasChestPain".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getCirculatorysymptoms().getHasRapidPulse()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasRapidPulse".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getCirculatorysymptoms().getHasPalpitation()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasPalpitation".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getCirculatorysymptoms().getHasLowBloodPressure()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasLowBloodPressure".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
        }
        if (results.getNeurologicalSymptoms() != null) {
            if (results.getNeurologicalSymptoms().getHasDelirium()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasDelirium".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getNeurologicalSymptoms().getHasConvulsion()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasConvulsion".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getNeurologicalSymptoms().getHasDrowsiness()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasDrowsiness".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getNeurologicalSymptoms().getHasComa()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasComa".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getNeurologicalSymptoms().getHasStiffNeck()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasStiffNeck".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getNeurologicalSymptoms().getHasRestlessness()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasRestlessness".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getNeurologicalSymptoms().getHasMuscleParalysisNeckShoulder()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasMuscleParalysisNeckShoulder".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getNeurologicalSymptoms().getHasMuscleParalysisLimbs()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasMuscleParalysisLimbs".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getNeurologicalSymptoms().getHasSwallowingDifficulty()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasSwallowingDifficulty".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getNeurologicalSymptoms().getHasSpeechDisorder()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasSpeechDisorder".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getNeurologicalSymptoms().getHasConsciousnessDisorder()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasConsciousnessDisorder".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getNeurologicalSymptoms().getHasDizziness()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasDizziness".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getNeurologicalSymptoms().getHasTinnitus()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasTinnitus".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getNeurologicalSymptoms().getHasHearingLoss()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasHearingLoss".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
        }
        if (results.getLocalSymptoms() != null) {
            if (results.getLocalSymptoms().getHasConjunctivitis()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasConjunctivitis".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getLocalSymptoms().getHasConjunctivalCongestion()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasConjunctivalCongestion".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getLocalSymptoms().getHasEyelidEdema()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasEyelidEdema".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getLocalSymptoms().getHasSmellTasteLoss()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasSmellTasteLoss".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getLocalSymptoms().getHasFacialRednessOrPallor()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasFacialRednessOrPallor".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getLocalSymptoms().getHasRednessNeckChest()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasRednessNeckChest".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getLocalSymptoms().getHasLipCyanosis()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasLipCyanosis".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getLocalSymptoms().getHasSkinPallorOrBruising()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasSkinPallorOrBruising".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getLocalSymptoms().getHasGumBleeding()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasGumBleeding".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getLocalSymptoms().getHasKidneyPain()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasKidneyPain".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getLocalSymptoms().getHasLowBackPain()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasLowBackPain".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getLocalSymptoms().getHasOrbitalPain()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasOrbitalPain".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getLocalSymptoms().getHasMucosalBleedingInOralOrNasal()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasMucosalBleedingInOralOrNasal".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getLocalSymptoms().getHasSkinBleedingPoints()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasSkinBleedingPoints".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
        }
        if (results.getOtherSymptoms() != null) {
            if (results.getOtherSymptoms().getHasSuddenOnset()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasSuddenOnset".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getOtherSymptoms().getHasRapidProgress()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasRapidProgress".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getOtherSymptoms().getHasPeriodicAttack()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasPeriodicAttack".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getOtherSymptoms().getHasForcedPosture()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasForcedPosture".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getOtherSymptoms().getHasCalfMusclePain()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasCalfMusclePain".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getOtherSymptoms().getSleepQuality().equals("差")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "SleepQuality".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getOtherSymptoms().getNutritionStatus().equals("差")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "NutritionStatus".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getOtherSymptoms().getWorkLifeStress().equals("大")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "WorkLifeStress".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getOtherSymptoms().getSymptomSeverity().equals("重")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "SymptomSeverity".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getOtherSymptoms().getHasOtherSymptoms()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasOtherSymptoms".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
        }
        if (results.getRiskFactorsAndExposure() != null) {
            if (results.getRiskFactorsAndExposure().getContactWithFeverPatient().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "ContactWithFeverPatient".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getContactWithDiarrheaPatient().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "ContactWithDiarrheaPatient".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getContactWithRashPatient().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "ContactWithRashPatient".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getContactWithTuberculosisPatient().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "ContactWithTuberculosisPatient".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getHasDrinkingRawWater()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasDrinkingRawWater".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getHasEatingRawFood()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasEatingRawFood".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getHasEatingColdCookedFood()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasEatingColdCookedFood".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getHasEatingSeafood()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasEatingSeafood".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getGroupOutbreak().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "GroupOutbreak".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getOutdoorStayOrWorkWithinMonth().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "OutdoorStayOrWorkWithinMonth".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getPlagueArea().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "PlagueArea".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getAnthraxArea().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "AnthraxArea".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getMalariaArea().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "MalariaArea".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getContactWithAnimalProducts().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "ContactWithAnimalProducts".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getHasContactWithWolf() || results.getRiskFactorsAndExposure().getHasContactWithTiger()
                    || results.getRiskFactorsAndExposure().getHasContactWithSheep() || results.getRiskFactorsAndExposure().getHasContactWithRat()
                    || results.getRiskFactorsAndExposure().getHasContactWithRabbit() || results.getRiskFactorsAndExposure().getHasContactWithPig()
                    || results.getRiskFactorsAndExposure().getHasContactWithOtherAnimal() || results.getRiskFactorsAndExposure().getHasContactWithMule()
                    || results.getRiskFactorsAndExposure().getHasContactWithMarmot() || results.getRiskFactorsAndExposure().getHasContactWithLice()
                    || results.getRiskFactorsAndExposure().getHasContactWithHorse() || results.getRiskFactorsAndExposure().getHasContactWithFlea()
                    || results.getRiskFactorsAndExposure().getHasContactWithDonkey() || results.getRiskFactorsAndExposure().getHasContactWithDog()
                    || results.getRiskFactorsAndExposure().getHasContactWithCow() || results.getRiskFactorsAndExposure().getHasContactWithCat()
                    || results.getRiskFactorsAndExposure().getHasContactWithBird()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "ContactWithAnimals".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getOutdoorStayOrWorkWithinMonth().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "IsHillyOrMountainous".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
                optionalSymptom = lists.stream()
                        .filter(symptom -> "IsPlain".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getHasMosquitoBite()) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "HasMosquitoBite".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getTickBite().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "TickBite".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getFleaBite().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "FleaBite".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getContactWithRatIn2Months().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "ContactWithRatIn2Months".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getEatenFoodContaminatedByRatFeces().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "EatenFoodContaminatedByRatFeces".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getDrunkWaterFromDitchesOrPonds().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "DrunkWaterFromDitchesOrPonds".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getRestedNearRatHoles().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "RestedNearRatHoles".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getRatOrRatDroppingsAtWorkplace().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "RatOrRatDroppingsAtWorkplace".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
            if (results.getRiskFactorsAndExposure().getContactWithPatientExcreta().equals("是")) {
                Optional<Symptomweighting> optionalSymptom = lists.stream()
                        .filter(symptom -> "ContactWithPatientExcreta".equals(symptom.getSymptomFieldName()))
                        .findFirst();
                totalScore = totalScore.add(optionalSymptom.map(Symptomweighting::getWeightScore)
                        .orElse(BigDecimal.valueOf(0)));
            }
        }
        return totalScore;
    }

    /**
     * 分页查询用户签到信息
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16
     * @param checkinPageDTO
     * @return
     */
    @Override
    public PageResult<CheckinInfoVO> pageSelectCheckin(CheckinPageDTO checkinPageDTO) {
        Boolean isHealth = checkinPageDTO.getIsHealth();
        LocalDate checkInDateBegin = checkinPageDTO.getCheckInDateBegin();
        LocalDate checkInDateEnd = checkinPageDTO.getCheckInDateEnd();
        boolean dateFlag = checkInDateBegin != null && checkInDateEnd != null;

        // 根据查询条件，获取用户id列表
        List<Integer> listUserId = null;

<<<<<<< HEAD
        //根据查询条件，获取用户id列表
        List<Integer> listUserId = null;

        if (checkinPageDTO.getName() != null
                || checkinPageDTO.getPhoneNumber() != null
                || checkinPageDTO.getDepartment() != null
                || checkinPageDTO.getSpecificOccupation() != null) {

            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                    .like(checkinPageDTO.getName() != null, User::getName, checkinPageDTO.getName())
                    .like(checkinPageDTO.getPhoneNumber() != null, User::getPhoneNumber, checkinPageDTO.getPhoneNumber())
                    .like(checkinPageDTO.getDepartment() != null, User::getDepartment, checkinPageDTO.getDepartment())
                    .like(checkinPageDTO.getSpecificOccupation() != null, User::getSpecificOccupation, checkinPageDTO.getSpecificOccupation());
=======
        String name = checkinPageDTO.getName();
        String phoneNumber = checkinPageDTO.getPhoneNumber();
        String department = checkinPageDTO.getDepartment();
        String specificOccupation = checkinPageDTO.getSpecificOccupation();

        if ((name != null && !name.isEmpty())
                || (phoneNumber != null && !phoneNumber.isEmpty())
                || (department != null && !department.isEmpty())
                || (specificOccupation != null && !specificOccupation.isEmpty())) {

            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                    .like(name != null && !name.isEmpty(), User::getName, name)
                    .like(phoneNumber != null && !phoneNumber.isEmpty(), User::getPhoneNumber, phoneNumber)
                    .like(department != null && !department.isEmpty(), User::getDepartment, department)
                    .like(specificOccupation != null && !specificOccupation.isEmpty(), User::getSpecificOccupation,
                            specificOccupation);

>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16
            listUserId = userMapper.selectIdsByWrapper(wrapper);
        }

        // 构建分页条件
        Page<Dailyhealthstatus> page = Page.of(checkinPageDTO.getPageNo(), checkinPageDTO.getPageSize());
        page.addOrder(new OrderItem("CheckInDate", false));
        page.addOrder(new OrderItem("CheckInTime", false));

        // 分页条件查询
        Page<Dailyhealthstatus> p = lambdaQuery()
                .in(listUserId != null, Dailyhealthstatus::getUserId, listUserId)
<<<<<<< HEAD
                .gt(dateFlag, Dailyhealthstatus::getCheckInDate, checkInDateBegin)
                .lt(dateFlag, Dailyhealthstatus::getCheckInDate, checkInDateEnd)
                .eq(isHealth != null, Dailyhealthstatus::getIsHealth, isHealth)
                .page(page);

        //封装VO
=======
                .ge(dateFlag, Dailyhealthstatus::getCheckInDate, checkInDateBegin)
                .le(dateFlag, Dailyhealthstatus::getCheckInDate, checkInDateEnd)
                .eq(isHealth != null, Dailyhealthstatus::getIsHealth, isHealth)
                .page(page);

        // 封装VO
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16
        PageResult<CheckinInfoVO> pageResult = new PageResult<>();

        List<CheckinInfoVO> list = new ArrayList<>();
        for (Dailyhealthstatus dailyhealthstatus : p.getRecords()) {
<<<<<<< HEAD
            //TODO 这里可以用算法优化，现在暴力处理，后期优化
=======
            // TODO 这里可以用算法优化，现在暴力处理，后期优化
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16
            CheckinInfoVO checkinInfoVO = new CheckinInfoVO();
            User user = userMapper.selectById(dailyhealthstatus.getUserId());

            BeanUtil.copyProperties(user, checkinInfoVO);
            BeanUtil.copyProperties(dailyhealthstatus, checkinInfoVO);

            list.add(checkinInfoVO);
        }

        pageResult.setRecords(list);
        pageResult.setTotal(p.getTotal());

        // 返回
        return pageResult;
    }

    /**
     * 导出职工打卡信息表
<<<<<<< HEAD
     *
=======
     * 
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16
     * @param response
     */
    @Override
    public void getEmployeeCheckInExcel(HttpServletResponse response) {

        // 获取文件绝对路径
        String projectDir = System.getProperty("user.dir");
        String fileName = projectDir + "/infect-server/src/main/resources/templates/职工打卡信息导出表.xlsx";

        // 查询打卡信息
        List<Dailyhealthstatus> dailyhealthstatusList = dailyhealthstatusMapper.selectList(null);
        List<List<Object>> listList = new ArrayList<>();

<<<<<<< HEAD
        for (Object obj :
                listUser) {
=======
        // 生成二维数组
        for (Dailyhealthstatus obj : dailyhealthstatusList) {
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16
            List<Object> temp = new ArrayList<>();

            temp.add(obj);

            temp.add(userMapper.selectById(obj.getUserId()));

            Integer statusId = obj.getStatusId();

            temp.add(generalsymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Generalsymptoms>()
                            .eq(Generalsymptoms::getStatusId, statusId)));
            temp.add(respiratorysymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Respiratorysymptoms>()
                            .eq(Respiratorysymptoms::getStatusId, statusId)));
            temp.add(digestivesymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Digestivesymptoms>()
                            .eq(Digestivesymptoms::getStatusId, statusId)));
            temp.add(circulatorysymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Circulatorysymptoms>()
                            .eq(Circulatorysymptoms::getStatusId, statusId)));
            temp.add(neurologicalsymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Neurologicalsymptoms>()
                            .eq(Neurologicalsymptoms::getStatusId, statusId)));
            temp.add(localsymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Localsymptoms>()
                            .eq(Localsymptoms::getStatusId, statusId)));
            temp.add(othersymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Othersymptoms>()
                            .eq(Othersymptoms::getStatusId, statusId)));
            temp.add(riskfactorsandexposureMapper.selectOne(
                    new LambdaQueryWrapper<Riskfactorsandexposure>()
                            .eq(Riskfactorsandexposure::getStatusId, statusId)));

            listList.add(temp);
        }

<<<<<<< HEAD
        ExcelPencilUtil.getExcel(response, "个人信息导出表.xlsx", fileName
                , 1, 1, 52
                , 1, 1
                , listList);
    }
=======
        XSSFWorkbook excel = ExcelUtil.getExcelFile(response, "职工打卡信息导出表.xlsx", fileName, 2, 1, 185, 2, 1, listList);
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16

        try {
            ServletOutputStream out = response.getOutputStream();
            excel.write(out);

<<<<<<< HEAD
    @Override
    public List<MonthlyHealthStatusVO> getWorkEnvironmentInfo(Integer currentId, String yearMonth) {


        List<Dailyhealthstatus> dailyhealthstatuses = dailyhealthstatusMapper.selectList(
                new QueryWrapper<Dailyhealthstatus>()
                        .eq("UserId", currentId)
                        .like("CheckInDate", yearMonth)
        );
        List<MonthlyHealthStatusVO> monthlyHealthStatusVOS = new ArrayList<>();
        for (Dailyhealthstatus dailyhealthstatus : dailyhealthstatuses) {
            MonthlyHealthStatusVO monthlyHealthStatusVO = new MonthlyHealthStatusVO();
            monthlyHealthStatusVO.setDate(dailyhealthstatus.getCheckInDate().toString());
            monthlyHealthStatusVO.setHealth(dailyhealthstatus.getIsHealth());
            monthlyHealthStatusVOS.add(monthlyHealthStatusVO);
=======
            excel.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16
        }
    }

    /**
     * 导出职工打卡信息导出表（含AI预测数据）
     * 
     * @param response
     */
    @Override
<<<<<<< HEAD
    public List<MonthlyHealthStatusVO> getDiagnoseInfo(String yearMonth, Integer currentId, List<MonthlyHealthStatusVO> clearHealthCostsGetVO) {
        List<Diagnosisresults> diagnosisresults = diagnosisresultsMapper.selectList(
                new QueryWrapper<Diagnosisresults>()
                        .eq("UserID", currentId)
                        .like("SubmissionTime", yearMonth)
        );
        // 遍历 diagnosisresults 并更新 clearHealthCostsGetVO
        for (MonthlyHealthStatusVO vo : clearHealthCostsGetVO) {
            for (Diagnosisresults result : diagnosisresults) {
                if (result.getSubmissionTime().toString().equals(vo.getDate())) {
                    vo.setDiagnose(true);
                    break; // 找到匹配项后跳出内层循环
                }
            }
=======
    public void getEmployeeCheckInExcelAI(HttpServletResponse response) {

        // 获取文件绝对路径
        String projectDir = System.getProperty("user.dir");
        String fileName = projectDir + "/infect-server/src/main/resources/templates/职工打卡信息导出表(含AI预测数据）.xlsx";

        // 查询打卡信息
        List<Dailyhealthstatus> dailyhealthstatusList = dailyhealthstatusMapper.selectList(null);
        List<List<Object>> listList = new ArrayList<>();

        // 生成二维数组
        for (Dailyhealthstatus obj : dailyhealthstatusList) {
            List<Object> temp = new ArrayList<>();

            temp.add(obj);

            temp.add(userMapper.selectById(obj.getUserId()));

            Integer statusId = obj.getStatusId();

            temp.add(generalsymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Generalsymptoms>()
                            .eq(Generalsymptoms::getStatusId, statusId)));
            temp.add(respiratorysymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Respiratorysymptoms>()
                            .eq(Respiratorysymptoms::getStatusId, statusId)));
            temp.add(digestivesymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Digestivesymptoms>()
                            .eq(Digestivesymptoms::getStatusId, statusId)));
            temp.add(circulatorysymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Circulatorysymptoms>()
                            .eq(Circulatorysymptoms::getStatusId, statusId)));
            temp.add(neurologicalsymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Neurologicalsymptoms>()
                            .eq(Neurologicalsymptoms::getStatusId, statusId)));
            temp.add(localsymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Localsymptoms>()
                            .eq(Localsymptoms::getStatusId, statusId)));
            temp.add(othersymptomsMapper.selectOne(
                    new LambdaQueryWrapper<Othersymptoms>()
                            .eq(Othersymptoms::getStatusId, statusId)));
            temp.add(riskfactorsandexposureMapper.selectOne(
                    new LambdaQueryWrapper<Riskfactorsandexposure>()
                            .eq(Riskfactorsandexposure::getStatusId, statusId)));

            listList.add(temp);
        }

        XSSFWorkbook excel = ExcelUtil.getExcelFile(response, "职工打卡信息导出表(含AI预测数据）.xlsx", fileName, 2, 1, 185, 2, 1,
                listList);

        try {
            ServletOutputStream out = response.getOutputStream();
            excel.write(out);

            excel.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16
        }
    }

    /**
     * 获取当日疾病分布
     *
     * @return
     */
    @Override
<<<<<<< HEAD
    public List<MonthlyHealthStatusVO> getExamineInfo(Integer currentId, String yearMonth, List<MonthlyHealthStatusVO> newClearHealthCostsGetVO) {
        List<Labtestreport> labtestreports = labtestreportMapper.selectList(
                new QueryWrapper<Labtestreport>()
                        .eq("UserID", currentId)
                        .like("UploadDate", yearMonth)
        );
        // 遍历 diagnosisresults 并更新 clearHealthCostsGetVO
        for (MonthlyHealthStatusVO vo : newClearHealthCostsGetVO) {
            for (Labtestreport result : labtestreports) {
                if (result.getUploadDate().toString().equals(vo.getDate())) {
                    vo.setExamine(true);
                    break; // 找到匹配项后跳出内层循环
                }
            }
        }
        return newClearHealthCostsGetVO;
=======
    public List<DiseaseNameNumberPairTemp> getDiseaseDataToday() {
        List<DiseaseNameNumberPairTemp> list = dailyhealthstatusMapper.selectDiseaseNumber(LocalDate.now());
        return list;
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16
    }

    /**
     * 获取全部用户地理位置信息
     * 
     * @return
     */
    @Override
    public List<StationTemp> getUserStation() {
        List<StationTemp> list = dailyhealthstatusMapper.selectStationListByTime(LocalDate.now());
        return list;
    }

    /**
     * 根据手机号筛选数据
     * 
     * @param phoneNumber
     * @param infoNumber
     * @return
     */
    @Override
    public List<CheckinInfoStatisticsVO> getChickInInfoByText(String phoneNumber, Integer infoNumber) {
        // 根据手机号模糊查询用户id列表
        List<Integer> idList = userMapper.selectIdsByWrapper(
                new LambdaQueryWrapper<User>()
                        .like(User::getPhoneNumber, phoneNumber));

        // 根据用户id列表查询查询签到信息
        List<CheckinInfoStatisticsVO> list = dailyhealthstatusMapper.selectChickInInfo(idList, infoNumber);

        // 根据用户名逐条查询用户id
        for (CheckinInfoStatisticsVO vo : list) {
            vo.setName(userMapper.selectNameById(vo.getUserId()));
        }

        return list;
    }

    /**
     * 获取一段时间的打卡时间分布
     * 
     * @param dateList
     * @return
     */
    @Override
    public List<CheckinDailyNumberSumVO> getCheckInDailyNumber(List<LocalDate> dateList) {
        int n = dateList.size();
        List<CheckinDailyNumberSumVO> voList = new ArrayList<>();

        for (int l = 0, r = 1; r < n; l++, r++) {
            LocalDate startDate = dateList.get(l);
            LocalDate endDate = dateList.get(r);

            List<CheckinDailyNumberVO> temp = dailyhealthstatusMapper.selectChickInDailyNumber(startDate, endDate);

            CheckinDailyNumberSumVO vo = new CheckinDailyNumberSumVO(startDate, endDate, temp);
            voList.add(vo);
        }
        return voList;
    }

    /* 提交全身症状信息 */
    @Override
    public void saveGeneralSymptoms(Generalsymptoms generalsymptoms) {
        // 通过用户id和今天的日期获取健康签到表的id
        Dailyhealthstatus dailyhealthstatus = getDailyhealthstatus(BaseContext.getCurrentId());
        // 添加签到表id字段
        generalsymptoms.setStatusId(dailyhealthstatus.getStatusId());
        // 查询今日是否已经填写了信息，如果已填，直接退出不能修改
        Generalsymptoms generalsymptoms1 = generalsymptomsMapper.selectById(dailyhealthstatus.getStatusId());
        if (generalsymptoms1 != null) {
            return;
        }
        // 向全身症状表中添加数据
        generalsymptomsMapper.insert(generalsymptoms);
    }

    /* 提交呼吸系统症状信息 */
    @Override
    public void saveRespiratorysymptoms(Respiratorysymptoms respiratorysymptoms) {
        // 通过用户id和今天的日期获取健康签到表的id
        Dailyhealthstatus dailyhealthstatus = getDailyhealthstatus(BaseContext.getCurrentId());
        // 添加签到表id字段
        respiratorysymptoms.setStatusId(dailyhealthstatus.getStatusId());
<<<<<<< HEAD
        //查询今日是否已经填写了信息，如果已填，直接退出不能修改
        Respiratorysymptoms respiratorysymptoms1 = respiratorysymptomsMapper.selectById(respiratorysymptoms.getStatusId());
=======
        // 查询今日是否已经填写了信息，如果已填，直接退出不能修改
        Respiratorysymptoms respiratorysymptoms1 = respiratorysymptomsMapper
                .selectById(respiratorysymptoms.getStatusId());
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16
        if (respiratorysymptoms1 != null) {
            return;
        }
        // 向全身症状表中添加数据
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
        Digestivesymptoms existingDigestiveSymptoms = digestivesymptomsMapper
                .selectById(digestivesymptoms.getStatusId());
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
        Circulatorysymptoms existingCirculatorySymptoms = circulatorysymptomsMapper
                .selectById(circulatorysymptoms.getStatusId());
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
        Neurologicalsymptoms existingNeurologicalSymptoms = neurologicalsymptomsMapper
                .selectById(neurologicalSymptoms.getStatusId());
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
        if (otherSymptoms.getWorkLifeStress().isEmpty()) {
            otherSymptoms.setWorkLifeStress("小");
        }
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
        Riskfactorsandexposure existingRiskFactorsAndExposure = riskfactorsandexposureMapper
                .selectById(riskFactorsAndExposure.getStatusId());
        if (existingRiskFactorsAndExposure != null) {
            return;
        }
        // 向风险因素和暴露表中添加数据
        riskfactorsandexposureMapper.insert(riskFactorsAndExposure);
    }

<<<<<<< HEAD

    /*根据时间和用户id查询健康签到表信息*/
=======
    /* 根据时间和用户id查询健康签到表信息 */
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16
    private Dailyhealthstatus getDailyhealthstatus(Integer userId) {
        LambdaQueryWrapper<Dailyhealthstatus> wrapper = new LambdaQueryWrapper<Dailyhealthstatus>()
                .eq(Dailyhealthstatus::getUserId, userId)
                .eq(Dailyhealthstatus::getCheckInDate, LocalDate.now());
        return dailyhealthstatusMapper.selectOne(wrapper);
    }
<<<<<<< HEAD
=======

    private Diseasescoring inputDiseaseScoring(String diseaseName, List<String> lists, AllSymptomsDTO allSymptomsDTO) {
        Diseasescoring diseasescoring = new Diseasescoring();
        diseasescoring.setDiseaseTypeName(diseaseName);
        diseasescoring.setScore(calculateScore(lists, allSymptomsDTO));
        diseasescoring.setSymptomTime(LocalDate.now());
        Dailyhealthstatus dailyhealthstatus = getDailyhealthstatus(BaseContext.getCurrentId());
        diseasescoring.setStatusId(dailyhealthstatus.getStatusId());
        diseasescoring.setDiseaseTypeId(dailyhealthstatus.getStatusId());
        return diseasescoring;
    }

    private BigDecimal calculateScore(List<String> lists, AllSymptomsDTO results) {
        int totalScore = 0;
        // 根据症状信息累加权重
        if (results.getGeneralsymptoms() != null) {
            if (results.getGeneralsymptoms().getHasFever()) {
                totalScore += Integer.parseInt(lists.get(3));
            }
            if (results.getGeneralsymptoms().getHasChills()) {
                totalScore += Integer.parseInt(lists.get(4));
            }
            if (results.getGeneralsymptoms().getHasSweating()) {
                totalScore += Integer.parseInt(lists.get(5));
            }
            if (results.getGeneralsymptoms().getHasFatigue()) {
                totalScore += Integer.parseInt(lists.get(6));
            }
            if (results.getGeneralsymptoms().getHasHeadache()) {
                totalScore += Integer.parseInt(lists.get(7));
            }
            if (results.getGeneralsymptoms().getHasMusclePain()) {
                totalScore += Integer.parseInt(lists.get(8));
            }
            if (results.getGeneralsymptoms().getHasJointPain()) {
                totalScore += Integer.parseInt(lists.get(9));
            }
            if (results.getGeneralsymptoms().getHasLymphNodeSwelling()) {
                totalScore += Integer.parseInt(lists.get(10));
            }
            if (results.getGeneralsymptoms().getHasCyanosis()) {
                totalScore += Integer.parseInt(lists.get(11));
            }
            if (results.getGeneralsymptoms().getHasSubcutaneousAndMucosalBleedingSpots()) {
                totalScore += Integer.parseInt(lists.get(12));
            }
            if (results.getGeneralsymptoms().getHasPainfulRedRash()) {
                totalScore += Integer.parseInt(lists.get(13));
            }
            if (results.getGeneralsymptoms().getHasBloodBlisters()) {
                totalScore += Integer.parseInt(lists.get(14));
            }
            if (results.getGeneralsymptoms().getHasSkinUlcer()) {
                totalScore += Integer.parseInt(lists.get(15));
            }
            if (results.getGeneralsymptoms().getHasCongestiveOrPetechialRash()) {
                totalScore += Integer.parseInt(lists.get(16));
            }
            if (results.getGeneralsymptoms().getItchyRashOnBackOfHands()
                    || results.getGeneralsymptoms().getItchyRashOnFace()
                    || results.getGeneralsymptoms().getItchyRashOnFeet()
                    || results.getGeneralsymptoms().getItchyRashOnFingers()
                    || results.getGeneralsymptoms().getItchyRashOnLowerLimbs()
                    || results.getGeneralsymptoms().getItchyRashOnOther()) {
                totalScore += Integer.parseInt(lists.get(17));
            }
            if (results.getGeneralsymptoms().getHasDehydration()) {
                totalScore += Integer.parseInt(lists.get(18));
            }
            if (results.getGeneralsymptoms().getHasItchyRash()) {
                totalScore += Integer.parseInt(lists.get(19));
            }
            if (results.getGeneralsymptoms().getHasEdema()) {
                totalScore += Integer.parseInt(lists.get(20));
            }
            if (results.getGeneralsymptoms().getHasNightSweats()) {
                totalScore += Integer.parseInt(lists.get(21));
            }
            if (results.getGeneralsymptoms().getHasWeightLoss()) {
                totalScore += Integer.parseInt(lists.get(22));
            }
            if (results.getGeneralsymptoms().getHasExhaustion()) {
                totalScore += Integer.parseInt(lists.get(23));
            }
        }
        if (results.getRespiratorysymptoms() != null) {
            if (results.getRespiratorysymptoms().getHasCough()) {
                totalScore += Integer.parseInt(lists.get(24));
            }
            if (results.getRespiratorysymptoms().getHasSputum()) {
                totalScore += Integer.parseInt(lists.get(25));
            }
            if (results.getRespiratorysymptoms().getHasBloodySputum()) {
                totalScore += Integer.parseInt(lists.get(26));
            }
            if (results.getRespiratorysymptoms().getHasHemoptysis()) {
                totalScore += Integer.parseInt(lists.get(27));
            }
            if (results.getRespiratorysymptoms().getHasSoreThroat()) {
                totalScore += Integer.parseInt(lists.get(28));
            }
            if (results.getRespiratorysymptoms().getHasDryThroat()) {
                totalScore += Integer.parseInt(lists.get(29));
            }
            if (results.getRespiratorysymptoms().getHasNasalCongestion()) {
                totalScore += Integer.parseInt(lists.get(30));
            }
            if (results.getRespiratorysymptoms().getHasRunnyNose()) {
                totalScore += Integer.parseInt(lists.get(31));
            }
            if (results.getRespiratorysymptoms().getHasChestTightness()) {
                totalScore += Integer.parseInt(lists.get(32));
            }
            if (results.getRespiratorysymptoms().getHasShortnessOfBreath()) {
                totalScore += Integer.parseInt(lists.get(33));
            }
            if (results.getRespiratorysymptoms().getHasBreathingDifficulty()) {
                totalScore += Integer.parseInt(lists.get(34));
            }
            if (results.getRespiratorysymptoms().getHasHoarseness()) {
                totalScore += Integer.parseInt(lists.get(35));
            }
            if (results.getRespiratorysymptoms().getHasBronchitis()) {
                totalScore += Integer.parseInt(lists.get(36));
            }
        }
        if (results.getDigestivesymptoms() != null) {
            if (results.getDigestivesymptoms().getArrheaFrequencyGEThreeTimesPerDay()) {
                totalScore += Integer.parseInt(lists.get(37));
            }
            if (results.getDigestivesymptoms().getHasStoolType1()) {
                totalScore += Integer.parseInt(lists.get(38));
            }
            if (results.getDigestivesymptoms().getHasStoolType2()) {
                totalScore += Integer.parseInt(lists.get(39));
            }
            if (results.getDigestivesymptoms().getHasVomiting()) {
                totalScore += Integer.parseInt(lists.get(40));
            }
            if (results.getDigestivesymptoms().getHasNausea()) {
                totalScore += Integer.parseInt(lists.get(41));
            }
            if (results.getDigestivesymptoms().getHasAppetiteLoss()) {
                totalScore += Integer.parseInt(lists.get(42));
            }
            if (results.getDigestivesymptoms().getHasAbdominalDistension()) {
                totalScore += Integer.parseInt(lists.get(43));
            }
            if (results.getDigestivesymptoms().getHasAbdominalPain()) {
                totalScore += Integer.parseInt(lists.get(44));
            }
            if (results.getDigestivesymptoms().getHasBorborygmus()) {
                totalScore += Integer.parseInt(lists.get(45));
            }
            if (results.getDigestivesymptoms().getHasUpperAbdominalDiscomfort()) {
                totalScore += Integer.parseInt(lists.get(46));
            }
            if (results.getDigestivesymptoms().getHasConstipation()) {
                totalScore += Integer.parseInt(lists.get(47));
            }
            if (results.getDigestivesymptoms().getHasOliguriaOrAnuria()) {
                totalScore += Integer.parseInt(lists.get(48));
            }
        }
        if (results.getCirculatorysymptoms() != null) {
            if (results.getCirculatorysymptoms().getHasArrhythmia()) {
                totalScore += Integer.parseInt(lists.get(49));
            }
            if (results.getCirculatorysymptoms().getHasChestPain()) {
                totalScore += Integer.parseInt(lists.get(50));
            }
            if (results.getCirculatorysymptoms().getHasRapidPulse()) {
                totalScore += Integer.parseInt(lists.get(51));
            }
            if (results.getCirculatorysymptoms().getHasPalpitation()) {
                totalScore += Integer.parseInt(lists.get(52));
            }
            if (results.getCirculatorysymptoms().getHasLowBloodPressure()) {
                totalScore += Integer.parseInt(lists.get(53));
            }
        }
        if (results.getNeurologicalSymptoms() != null) {
            if (results.getNeurologicalSymptoms().getHasDelirium()) {
                totalScore += Integer.parseInt(lists.get(54));
            }
            if (results.getNeurologicalSymptoms().getHasConvulsion()) {
                totalScore += Integer.parseInt(lists.get(55));
            }
            if (results.getNeurologicalSymptoms().getHasDrowsiness()) {
                totalScore += Integer.parseInt(lists.get(56));
            }
            if (results.getNeurologicalSymptoms().getHasComa()) {
                totalScore += Integer.parseInt(lists.get(57));
            }
            if (results.getNeurologicalSymptoms().getHasStiffNeck()) {
                totalScore += Integer.parseInt(lists.get(58));
            }
            if (results.getNeurologicalSymptoms().getHasRestlessness()) {
                totalScore += Integer.parseInt(lists.get(59));
            }
            if (results.getNeurologicalSymptoms().getHasMuscleParalysisNeckShoulder()) {
                totalScore += Integer.parseInt(lists.get(60));
            }
            if (results.getNeurologicalSymptoms().getHasMuscleParalysisLimbs()) {
                totalScore += Integer.parseInt(lists.get(61));
            }
            if (results.getNeurologicalSymptoms().getHasSwallowingDifficulty()) {
                totalScore += Integer.parseInt(lists.get(62));
            }
            if (results.getNeurologicalSymptoms().getHasSpeechDisorder()) {
                totalScore += Integer.parseInt(lists.get(63));
            }
            if (results.getNeurologicalSymptoms().getHasConsciousnessDisorder()) {
                totalScore += Integer.parseInt(lists.get(64));
            }
            if (results.getNeurologicalSymptoms().getHasDizziness()) {
                totalScore += Integer.parseInt(lists.get(65));
            }
            if (results.getNeurologicalSymptoms().getHasTinnitus()) {
                totalScore += Integer.parseInt(lists.get(66));
            }
            if (results.getNeurologicalSymptoms().getHasHearingLoss()) {
                totalScore += Integer.parseInt(lists.get(67));
            }
        }
        if (results.getLocalSymptoms() != null) {
            if (results.getLocalSymptoms().getHasConjunctivitis()) {
                totalScore += Integer.parseInt(lists.get(68));
            }
            if (results.getLocalSymptoms().getHasConjunctivalCongestion()) {
                totalScore += Integer.parseInt(lists.get(69));
            }
            if (results.getLocalSymptoms().getHasEyelidEdema()) {
                totalScore += Integer.parseInt(lists.get(70));
            }
            if (results.getLocalSymptoms().getHasSmellTasteLoss()) {
                totalScore += Integer.parseInt(lists.get(71));
            }
            if (results.getLocalSymptoms().getHasFacialRednessOrPallor()) {
                totalScore += Integer.parseInt(lists.get(72));
            }
            if (results.getLocalSymptoms().getHasRednessNeckChest()) {
                totalScore += Integer.parseInt(lists.get(73));
            }
            if (results.getLocalSymptoms().getHasLipCyanosis()) {
                totalScore += Integer.parseInt(lists.get(74));
            }
            if (results.getLocalSymptoms().getHasSkinPallorOrBruising()) {
                totalScore += Integer.parseInt(lists.get(75));
            }
            if (results.getLocalSymptoms().getHasGumBleeding()) {
                totalScore += Integer.parseInt(lists.get(76));
            }
            if (results.getLocalSymptoms().getHasKidneyPain()) {
                totalScore += Integer.parseInt(lists.get(77));
            }
            if (results.getLocalSymptoms().getHasLowBackPain()) {
                totalScore += Integer.parseInt(lists.get(78));
            }
            if (results.getLocalSymptoms().getHasOrbitalPain()) {
                totalScore += Integer.parseInt(lists.get(79));
            }
            if (results.getLocalSymptoms().getHasMucosalBleedingInOralOrNasal()) {
                totalScore += Integer.parseInt(lists.get(80));
            }
            if (results.getLocalSymptoms().getHasSkinBleedingPoints()) {
                totalScore += Integer.parseInt(lists.get(81));
            }
        }
        if (results.getOtherSymptoms() != null) {
            if (results.getOtherSymptoms().getHasSuddenOnset()) {
                totalScore += Integer.parseInt(lists.get(82));
            }
            if (results.getOtherSymptoms().getHasRapidProgress()) {
                totalScore += Integer.parseInt(lists.get(83));
            }
            if (results.getOtherSymptoms().getHasPeriodicAttack()) {
                totalScore += Integer.parseInt(lists.get(84));
            }
            if (results.getOtherSymptoms().getHasForcedPosture()) {
                totalScore += Integer.parseInt(lists.get(85));
            }
            if (results.getOtherSymptoms().getHasCalfMusclePain()) {
                totalScore += Integer.parseInt(lists.get(86));
            }
            if (results.getOtherSymptoms().getSleepQuality().equals("差")) {
                totalScore += Integer.parseInt(lists.get(87));
            }
            if (results.getOtherSymptoms().getNutritionStatus().equals("差")) {
                totalScore += Integer.parseInt(lists.get(88));
            }
            if (results.getOtherSymptoms().getWorkLifeStress().equals("大")) {
                totalScore += Integer.parseInt(lists.get(89));
            }
            if (results.getOtherSymptoms().getSymptomSeverity().equals("重")) {
                totalScore += Integer.parseInt(lists.get(90));
            }
            if (results.getOtherSymptoms().getHasOtherSymptoms()) {
                totalScore += Integer.parseInt(lists.get(91));
            }
        }
        if (results.getRiskFactorsAndExposure() != null) {
            if (results.getRiskFactorsAndExposure().getContactWithFeverPatient().equals("是")) {
                totalScore += Integer.parseInt(lists.get(92));
            }
            if (results.getRiskFactorsAndExposure().getContactWithDiarrheaPatient().equals("是")) {
                totalScore += Integer.parseInt(lists.get(93));
            }
            if (results.getRiskFactorsAndExposure().getContactWithRashPatient().equals("是")) {
                totalScore += Integer.parseInt(lists.get(94));
            }
            if (results.getRiskFactorsAndExposure().getContactWithTuberculosisPatient().equals("是")) {
                totalScore += Integer.parseInt(lists.get(95));
            }
            if (results.getRiskFactorsAndExposure().getHasDrinkingRawWater()) {
                totalScore += Integer.parseInt(lists.get(96));
            }
            if (results.getRiskFactorsAndExposure().getHasEatingRawFood()) {
                totalScore += Integer.parseInt(lists.get(97));
            }
            if (results.getRiskFactorsAndExposure().getHasEatingColdCookedFood()) {
                totalScore += Integer.parseInt(lists.get(98));
            }
            if (results.getRiskFactorsAndExposure().getHasEatingSeafood()) {
                totalScore += Integer.parseInt(lists.get(99));
            }
            if (results.getRiskFactorsAndExposure().getGroupOutbreak().equals("是")) {
                totalScore += Integer.parseInt(lists.get(100));
            }
            if (results.getRiskFactorsAndExposure().getOutdoorStayOrWorkWithinMonth().equals("是")) {
                totalScore += Integer.parseInt(lists.get(101));
            }
            if (results.getRiskFactorsAndExposure().getPlagueArea().equals("是")) {
                totalScore += Integer.parseInt(lists.get(102));
            }
            if (results.getRiskFactorsAndExposure().getAnthraxArea().equals("是")) {
                totalScore += Integer.parseInt(lists.get(103));
            }
            if (results.getRiskFactorsAndExposure().getMalariaArea().equals("是")) {
                totalScore += Integer.parseInt(lists.get(104));
            }
            if (results.getRiskFactorsAndExposure().getContactWithAnimalProducts().equals("是")) {
                totalScore += Integer.parseInt(lists.get(105));
            }
            if (results.getRiskFactorsAndExposure().getHasContactWithWolf()
                    || results.getRiskFactorsAndExposure().getHasContactWithTiger()
                    || results.getRiskFactorsAndExposure().getHasContactWithSheep()
                    || results.getRiskFactorsAndExposure().getHasContactWithRat()
                    || results.getRiskFactorsAndExposure().getHasContactWithRabbit()
                    || results.getRiskFactorsAndExposure().getHasContactWithPig()
                    || results.getRiskFactorsAndExposure().getHasContactWithOtherAnimal()
                    || results.getRiskFactorsAndExposure().getHasContactWithMule()
                    || results.getRiskFactorsAndExposure().getHasContactWithMarmot()
                    || results.getRiskFactorsAndExposure().getHasContactWithLice()
                    || results.getRiskFactorsAndExposure().getHasContactWithHorse()
                    || results.getRiskFactorsAndExposure().getHasContactWithFlea()
                    || results.getRiskFactorsAndExposure().getHasContactWithDonkey()
                    || results.getRiskFactorsAndExposure().getHasContactWithDog()
                    || results.getRiskFactorsAndExposure().getHasContactWithCow()
                    || results.getRiskFactorsAndExposure().getHasContactWithCat()
                    || results.getRiskFactorsAndExposure().getHasContactWithBird()) {
                totalScore += Integer.parseInt(lists.get(106));
            }
            if (results.getRiskFactorsAndExposure().getOutdoorStayOrWorkWithinMonth().equals("是")) {
                totalScore += Integer.parseInt(lists.get(107));
                totalScore += Integer.parseInt(lists.get(108));
            }
            if (results.getRiskFactorsAndExposure().getHasMosquitoBite()) {
                totalScore += Integer.parseInt(lists.get(109));
            }
            if (results.getRiskFactorsAndExposure().getTickBite().equals("是")) {
                totalScore += Integer.parseInt(lists.get(110));
            }
            if (results.getRiskFactorsAndExposure().getFleaBite().equals("是")) {
                totalScore += Integer.parseInt(lists.get(111));
            }
            if (results.getRiskFactorsAndExposure().getContactWithRatIn2Months().equals("是")) {
                totalScore += Integer.parseInt(lists.get(112));
            }
            if (results.getRiskFactorsAndExposure().getEatenFoodContaminatedByRatFeces().equals("是")) {
                totalScore += Integer.parseInt(lists.get(113));
            }
            if (results.getRiskFactorsAndExposure().getDrunkWaterFromDitchesOrPonds().equals("是")) {
                totalScore += Integer.parseInt(lists.get(114));
            }
            if (results.getRiskFactorsAndExposure().getRestedNearRatHoles().equals("是")) {
                totalScore += Integer.parseInt(lists.get(115));
            }
            if (results.getRiskFactorsAndExposure().getRatOrRatDroppingsAtWorkplace().equals("是")) {
                totalScore += Integer.parseInt(lists.get(116));
            }
            if (results.getRiskFactorsAndExposure().getContactWithPatientExcreta().equals("是")) {
                totalScore += Integer.parseInt(lists.get(117));
            }
        }
        return new BigDecimal(totalScore);
    }
>>>>>>> cc3e501b894742cfa1047ff571178e3e882ddd16
}
