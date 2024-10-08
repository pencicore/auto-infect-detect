package com.infect.service;

import com.infect.dto.AllSymptomsDTO;
import com.infect.dto.RailwayEmployeeCheckInDTO;
import com.infect.dto.system.CheckinPageDTO;
import com.infect.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;
import com.infect.result.PageResult;
import com.infect.temporary.DiseaseNameNumberPairTemp;
import com.infect.temporary.StationTemp;
import com.infect.vo.DailyhealthstatusGetVO;
import com.infect.vo.system.CheckinDailyNumberSumVO;
import com.infect.vo.system.CheckinDailyNumberVO;
import com.infect.vo.system.CheckinInfoStatisticsVO;
import com.infect.vo.system.CheckinInfoVO;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

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

    PageResult<CheckinInfoVO> pageSelectCheckin(CheckinPageDTO checkinPageDTO);

    void getEmployeeCheckInExcel(HttpServletResponse response);

    void getEmployeeCheckInExcelAI(HttpServletResponse response);

    List<DiseaseNameNumberPairTemp> getDiseaseDataToday();

    List<StationTemp> getUserStation();

    List<CheckinInfoStatisticsVO> getChickInInfoByText(String phoneNumber, Integer infoNumber);

    List<CheckinDailyNumberSumVO> getCheckInDailyNumber(List<LocalDate> dateList);
}
