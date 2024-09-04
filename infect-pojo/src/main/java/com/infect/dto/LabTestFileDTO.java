package com.infect.dto;

import io.swagger.annotations.ApiModel;

import org.springframework.web.multipart.MultipartFile;

@ApiModel(value = "实验报告文件")
public class LabTestFileDTO {

    private MultipartFile file;

    private String LabTestType;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getLabTestType() {
        return LabTestType;
    }

    public void setLabTestType(String labTestType) {
        LabTestType = labTestType;
    }
}
