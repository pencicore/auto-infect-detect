package com.infect.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@ApiModel("诊断报告文件")
@Data
public class DiagnosisReportsDTO {

    private MultipartFile file;

    private String ReportType;

}
