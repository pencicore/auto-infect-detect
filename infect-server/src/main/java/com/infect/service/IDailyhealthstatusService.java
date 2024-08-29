package com.infect.service;

import com.infect.dto.AllSymptomsDTO;
import com.infect.dto.RailwayEmployeeCheckInDTO;
import com.infect.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;
import com.infect.vo.DailyhealthstatusGetVO;

import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
public interface IDailyhealthstatusService extends IService<Dailyhealthstatus> {

    void userCheckIn(RailwayEmployeeCheckInDTO railwayEmployeeCheckInDTO);

    DailyhealthstatusGetVO getDailyCheckIn(LocalDate date);

    void saveGeneralSymptoms(Generalsymptoms generalsymptoms);

    void saveRespiratorysymptoms(Respiratorysymptoms respiratorysymptoms);

    void saveDigestiveSymptoms(Digestivesymptoms digestivesymptoms);

    void saveCirculatorySymptoms(Circulatorysymptoms circulatorysymptoms);

    void saveNeurologicalSymptoms(Neurologicalsymptoms neurologicalSymptoms);

    void saveLocalSymptoms(Localsymptoms localSymptoms);

    void saveOtherSymptoms(Othersymptoms otherSymptoms);

    void saveRiskFactorsAndExposure(Riskfactorsandexposure riskFactorsAndExposure);

    void saveAllSymptoms(AllSymptomsDTO allSymptomsDTO);
}
