package com.infect.dto;

import io.swagger.annotations.ApiModel;
import org.springframework.web.multipart.MultipartFile;

@ApiModel("诊断报告文件")
public class DiagnosisReportsDTO {

    private MultipartFile file;

    private String ReportType;

    public String getReportType() {
        return ReportType;
    }

    public void setReportType(String reportType) {
        ReportType = reportType;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
