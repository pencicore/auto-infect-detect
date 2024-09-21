package com.infect.service;

import com.infect.dto.LabTestFileDTO;
import com.infect.dto.LabTestReportDTO;
import com.infect.result.Result;

public interface MyLabTestService {
    Integer uploadLabTestFile(LabTestFileDTO labTestFileDTO);

    Result saveLabTest(LabTestReportDTO labTestReportDTO, Integer userId);

    LabTestReportDTO getReportFile(String date, Integer currentId);
}
