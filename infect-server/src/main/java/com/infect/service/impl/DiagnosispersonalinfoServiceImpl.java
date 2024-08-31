package com.infect.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.infect.entity.*;
import com.infect.mapper.*;
import com.infect.service.IDiagnosispersonalinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Service
public class DiagnosispersonalinfoServiceImpl extends ServiceImpl<DiagnosispersonalinfoMapper, Diagnosispersonalinfo> implements IDiagnosispersonalinfoService {

    @Autowired
    private DiagnosisresultsMapper diagnosisresultsMapper;

    @Autowired
    private DiagnosisgeneralsymptomsMapper diagnosisGeneralSymptomsMapper;

    @Autowired
    private DiagnosispersonalinfoMapper diagnosispersonalinfoMapper;

    @Autowired
    private DiagnosisrespiratorysymptomsMapper diagnosisRespiratorySymptomsMapper;

    @Autowired
    private DiagnosisdigestivesymptomsMapper diagnosisDigestiveSymptomsMapper;

    @Autowired
    private DiagnosiscirculatorysymptomsMapper diagnosisCirculatorySymptomsMapper;

    @Autowired
    private DiagnosisneurologicalsymptomsMapper diagnosisNeurologicalSymptomsMapper;

    @Autowired
    private DiagnosislocalsymptomsMapper diagnosisLocalSymptomsMapper;

    @Autowired
    private DiagnosisothersymptomsMapper diagnosisOtherSymptomsMapper;

    @Autowired
    private DiagnosiscomplicationsMapper diagnosisComplicationsMapper;


    @Override
    public void saveDiagnosisPersonal(Integer userId, Diagnosispersonalinfo diagnosispersonalinfo) {
        Integer diagnosisResultsId = getDiagnosisresultId(userId);
        diagnosispersonalinfo.setDiagnosisResultsId(diagnosisResultsId);
        //TODO 判断是否已经存在
        diagnosispersonalinfoMapper.insert(diagnosispersonalinfo);
    }

    @Override
    public void saveDiagnosisGeneralSymptoms(Integer userId, Diagnosisgeneralsymptoms diagnosisGeneralSymptoms) {
        Integer diagnosisResultsId = getDiagnosisresultId(userId);
        diagnosisGeneralSymptoms.setDiagnosisResultsId(diagnosisResultsId);
        diagnosisGeneralSymptomsMapper.insert(diagnosisGeneralSymptoms);
    }

    @Override
    public void saveDiagnosisRespiratorySymptoms(Integer userId, Diagnosisrespiratorysymptoms diagnosisRespiratorySymptoms) {
        Integer diagnosisResultsId = getDiagnosisresultId(userId);
        diagnosisRespiratorySymptoms.setDiagnosisResultsId(diagnosisResultsId);
        diagnosisRespiratorySymptomsMapper.insert(diagnosisRespiratorySymptoms);
    }

    @Override
    public void saveDiagnosisDigestiveSymptoms(Integer userId, Diagnosisdigestivesymptoms diagnosisDigestiveSymptoms) {
        Integer diagnosisResultsId = getDiagnosisresultId(userId);
        diagnosisDigestiveSymptoms.setDiagnosisResultsId(diagnosisResultsId);
        diagnosisDigestiveSymptomsMapper.insert(diagnosisDigestiveSymptoms);
    }

    @Override
    public void saveDiagnosisCirculatorySymptoms(Integer userId, Diagnosiscirculatorysymptoms diagnosisCirculatorySymptoms) {
        Integer diagnosisResultsId = getDiagnosisresultId(userId);
        diagnosisCirculatorySymptoms.setDiagnosisResultsId(diagnosisResultsId);
        diagnosisCirculatorySymptomsMapper.insert(diagnosisCirculatorySymptoms);
    }

    @Override
    public void saveDiagnosisNeurologicalSymptoms(Integer userId, Diagnosisneurologicalsymptoms diagnosisNeurologicalSymptoms) {
        Integer diagnosisResultsId = getDiagnosisresultId(userId);
        diagnosisNeurologicalSymptoms.setDiagnosisResultsId(diagnosisResultsId);
        diagnosisNeurologicalSymptomsMapper.insert(diagnosisNeurologicalSymptoms);
    }

    @Override
    public void saveDiagnosisLocalSymptoms(Integer userId, Diagnosislocalsymptoms diagnosisLocalSymptoms) {
        Integer diagnosisResultsId = getDiagnosisresultId(userId);
        diagnosisLocalSymptoms.setDiagnosisResultsId(diagnosisResultsId);
        diagnosisLocalSymptomsMapper.insert(diagnosisLocalSymptoms);
    }

    @Override
    public void saveDiagnosisOtherSymptoms(Integer userId, Diagnosisothersymptoms diagnosisOtherSymptoms) {
        Integer diagnosisResultsId = getDiagnosisresultId(userId);
        diagnosisOtherSymptoms.setDiagnosisResultsId(diagnosisResultsId);
        diagnosisOtherSymptomsMapper.insert(diagnosisOtherSymptoms);
    }

    @Override
    public void saveDiagnosisComplications(Integer userId, Diagnosiscomplications diagnosisComplications) {
        Integer diagnosisResultsId = getDiagnosisresultId(userId);
        diagnosisComplications.setDiagnosisResultsId(diagnosisResultsId);
        diagnosisComplicationsMapper.insert(diagnosisComplications);
    }

    private Integer getDiagnosisresultId(Integer userId) {
        return diagnosisresultsMapper.selectOne(new LambdaQueryWrapper<Diagnosisresults>()
                .eq(Diagnosisresults::getUserId, userId)
                .eq(Diagnosisresults::getSubmissionTime, LocalDate.now())).getDiagnosisResultsId();
    }
}
