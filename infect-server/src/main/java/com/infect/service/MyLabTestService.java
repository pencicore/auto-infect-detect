package com.infect.service;

import com.infect.dto.LabTestFileDTO;
import com.infect.dto.LabTestReportDTO;
import com.infect.result.Result;

import javax.servlet.http.HttpServletResponse;

public interface MyLabTestService {
    Integer uploadLabTestFile(LabTestFileDTO labTestFileDTO);

    Result saveLabTest(LabTestReportDTO labTestReportDTO, Integer userId);

    void getDetectionInformationExportFormExcel(HttpServletResponse response);

    LabTestReportDTO getReportFile(String date, Integer currentId);
}
