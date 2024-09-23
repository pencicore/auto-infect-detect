package com.infect.service;

import cn.hutool.core.lang.Pair;
import com.infect.dto.AllDiagnosisAndResultDTO;
import com.infect.dto.DiagnosisReportsDTO;
import com.infect.dto.system.DiseaseStatisticsDTO;
import com.infect.entity.armorFusion.AllDiagnosis;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface MyDiagnosisService {

    void saveDiagnosis(Integer userId, AllDiagnosisAndResultDTO allDiagnosisAndResultDTO, String userType);

    Integer uploadReportFile(DiagnosisReportsDTO diagnosisReportsDTO);

    List<String> getDiseaseList();

    Map<String, List<Pair<LocalDate, Integer>>> getDiseaseStatisticsListInfo(DiseaseStatisticsDTO diseaseStatisticsDTO);

    AllDiagnosis getAllDiagnosis(Integer diagnosisResultsID);

    void updateDiagnosis(AllDiagnosis allDiagnosis);

    void getExcelClinicalInformationExportForm(HttpServletResponse response);
}
