package com.infect.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
@ApiModel(value = "铁路工人诊断结果数据传输实体")
public class DiagnosisResultsEmpDTO {
    @ApiModelProperty(value = "诊断的疾病类型", required = true, example = "新型冠状病毒感染")
    private String diseaseType;

    @ApiModelProperty(value = "其他疾病名称", required = true, example = "未知疾病")
    private String otherDiseaseName;

    @ApiModelProperty(value = "鼠疫子类", example = "腺鼠疫")
    private String plagueSubtype;

    @ApiModelProperty(value = "炭疽子类", example = "皮肤炭疽")
    private String anthraxSubtype;

    @ApiModelProperty(value = "病例发现途径", required = true, example = "主动就诊")
    private String discoveryMethod;

    @ApiModelProperty(value = "其他途径名称", required = true, example = "社区筛查")
    private String otherDiscoveryMethodName;

    @ApiModelProperty(value = "疾病转归", required = true, example = "治愈")
    private String diseaseOutcome;

    @ApiModelProperty(value = "确诊医院名称", required = true, example = "北京市医院")
    private String hospitalName;

    @ApiModelProperty(value = "就诊/入院日期", example = "2024-08-20")
    private LocalDate admissionDate;

    @ApiModelProperty(value = "出院日期", example = "2024-08-27")
    private LocalDate dischargeDate;

    @ApiModelProperty(value = "死亡日期", example = "2024-08-28")
    private LocalDate deathDate;

    @ApiModelProperty(value = "就诊/入院时症状和体征", example = "高热、咳嗽、呼吸困难")
    private String admissionSymptomsAndSigns;

    @ApiModelProperty(value = "登记分类", example = "新患者")
    private String registrationClassification;

    @ApiModelProperty(value = "登记分类其他详情", example = "复发病例")
    private String otherRegistrationDetails;

}
