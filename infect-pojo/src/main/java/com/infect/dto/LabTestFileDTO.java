package com.infect.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@ApiModel(value = "实验报告文件")
public class LabTestFileDTO {

    private MultipartFile file;

    private String LabTestType;
}
