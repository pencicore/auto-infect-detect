package com.infect.service;

import cn.hutool.core.lang.Pair;
import com.infect.dto.AllDiagnosisAndResultDTO;
import com.infect.dto.DiagnosisReportsDTO;
import com.infect.dto.system.DiseaseStatisticsDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface MyDiagnosisService {

    void saveDiagnosis(Integer currentId, AllDiagnosisAndResultDTO allDiagnosisAndResultDTO);

    Integer uploadReportFile(DiagnosisReportsDTO diagnosisReportsDTO);

    List<String> getDiseaseList();

    Map<String, List<Pair<LocalDate, Integer>>> getDiseaseStatisticsListInfo(DiseaseStatisticsDTO diseaseStatisticsDTO);

}
