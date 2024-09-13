package com.infect.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

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

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public String getOtherDiseaseName() {
        return otherDiseaseName;
    }

    public void setOtherDiseaseName(String otherDiseaseName) {
        this.otherDiseaseName = otherDiseaseName;
    }

    public String getPlagueSubtype() {
        return plagueSubtype;
    }

    public void setPlagueSubtype(String plagueSubtype) {
        this.plagueSubtype = plagueSubtype;
    }

    public String getAnthraxSubtype() {
        return anthraxSubtype;
    }

    public void setAnthraxSubtype(String anthraxSubtype) {
        this.anthraxSubtype = anthraxSubtype;
    }

    public String getDiscoveryMethod() {
        return discoveryMethod;
    }

    public void setDiscoveryMethod(String discoveryMethod) {
        this.discoveryMethod = discoveryMethod;
    }

    public String getOtherDiscoveryMethodName() {
        return otherDiscoveryMethodName;
    }

    public void setOtherDiscoveryMethodName(String otherDiscoveryMethodName) {
        this.otherDiscoveryMethodName = otherDiscoveryMethodName;
    }

    public String getDiseaseOutcome() {
        return diseaseOutcome;
    }

    public void setDiseaseOutcome(String diseaseOutcome) {
        this.diseaseOutcome = diseaseOutcome;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public String getAdmissionSymptomsAndSigns() {
        return admissionSymptomsAndSigns;
    }

    public void setAdmissionSymptomsAndSigns(String admissionSymptomsAndSigns) {
        this.admissionSymptomsAndSigns = admissionSymptomsAndSigns;
    }

    public String getRegistrationClassification() {
        return registrationClassification;
    }

    public void setRegistrationClassification(String registrationClassification) {
        this.registrationClassification = registrationClassification;
    }

    public String getOtherRegistrationDetails() {
        return otherRegistrationDetails;
    }

    public void setOtherRegistrationDetails(String otherRegistrationDetails) {
        this.otherRegistrationDetails = otherRegistrationDetails;
    }

    @Override
    public String toString() {
        return "DiagnosisResultsEmpDTO{" +
                "diseaseType='" + diseaseType + '\'' +
                ", otherDiseaseName='" + otherDiseaseName + '\'' +
                ", plagueSubtype='" + plagueSubtype + '\'' +
                ", anthraxSubtype='" + anthraxSubtype + '\'' +
                ", discoveryMethod='" + discoveryMethod + '\'' +
                ", otherDiscoveryMethodName='" + otherDiscoveryMethodName + '\'' +
                ", diseaseOutcome='" + diseaseOutcome + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", admissionDate=" + admissionDate +
                ", dischargeDate=" + dischargeDate +
                ", deathDate=" + deathDate +
                ", admissionSymptomsAndSigns='" + admissionSymptomsAndSigns + '\'' +
                ", registrationClassification='" + registrationClassification + '\'' +
                ", otherRegistrationDetails='" + otherRegistrationDetails + '\'' +
                '}';
    }
}
