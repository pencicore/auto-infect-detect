package com.infect.service;

import com.infect.dto.LabTestFileDTO;
import com.infect.dto.LabTestReportDTO;

public interface MyLabTestService {
    Integer uploadLabTestFile(LabTestFileDTO labTestFileDTO);

    void saveLabTest(LabTestReportDTO labTestReportDTO, Integer userId);
}
