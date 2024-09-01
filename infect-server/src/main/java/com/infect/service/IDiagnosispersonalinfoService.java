package com.infect.service;

import com.infect.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 诊断个人信息服务类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
public interface IDiagnosispersonalinfoService extends IService<Diagnosispersonalinfo> {

    void saveDiagnosisPersonal(Integer userId, Diagnosispersonalinfo diagnosispersonalinfo);

    void saveDiagnosisGeneralSymptoms(Integer userId, Diagnosisgeneralsymptoms diagnosisGeneralSymptoms);

    void saveDiagnosisRespiratorySymptoms(Integer userId, Diagnosisrespiratorysymptoms diagnosisRespiratorySymptoms);

    void saveDiagnosisDigestiveSymptoms(Integer userId, Diagnosisdigestivesymptoms diagnosisDigestiveSymptoms);

    void saveDiagnosisCirculatorySymptoms(Integer userId, Diagnosiscirculatorysymptoms diagnosisCirculatorySymptoms);

    void saveDiagnosisNeurologicalSymptoms(Integer userId, Diagnosisneurologicalsymptoms diagnosisNeurologicalSymptoms);

    void saveDiagnosisLocalSymptoms(Integer userId, Diagnosislocalsymptoms diagnosisLocalSymptoms);

    void saveDiagnosisOtherSymptoms(Integer userId, Diagnosisothersymptoms diagnosisOtherSymptoms);

    void saveDiagnosisComplications(Integer userId, Diagnosiscomplications diagnosisComplications);
}
