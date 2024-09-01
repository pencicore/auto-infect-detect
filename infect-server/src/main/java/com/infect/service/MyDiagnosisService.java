package com.infect.service;

import com.infect.dto.AllDiagnosisAndResultDTO;
import com.infect.dto.DiagnosisReportsDTO;

public interface MyDiagnosisService {

    void saveDiagnosis(Integer currentId, AllDiagnosisAndResultDTO allDiagnosisAndResultDTO);

    Integer uploadReportFile(DiagnosisReportsDTO diagnosisReportsDTO);
}
