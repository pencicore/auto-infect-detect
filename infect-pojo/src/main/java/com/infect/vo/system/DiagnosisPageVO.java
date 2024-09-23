package com.infect.vo.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class DiagnosisPageVO {

    //User表信息
    @ApiModelProperty(value = "用户ID", required = true, example = "123")
    private Integer userId;

    @ApiModelProperty(value = "用户类型", required = true, example = "铁路职工")
    private String userType;

    @ApiModelProperty(value = "用户姓名", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value = "电话号码", required = true, example = "13812345678")
    private String phoneNumber;

    @ApiModelProperty(value = "性别", example = "男")
    private String gender;

    @ApiModelProperty(value = "出生日期", example = "1990-01-01")
    private LocalDate birthDate;

    @ApiModelProperty(value = "部门", example = "工程技术部")
    private String department;

    //DiagnosisResult表信息
    @ApiModelProperty(value = "诊断结果ID，自增", hidden = true)
    private Integer diagnosisResultsId;

    @ApiModelProperty(value = "诊断的疾病类型", required = true, example = "新型冠状病毒感染")
    private String diseaseType;

    @ApiModelProperty(value = "病例发现途径", required = true, example = "主动就诊")
    private String discoveryMethod;

    @ApiModelProperty(value = "确诊医院名称", required = true, example = "北京市医院")
    private String hospitalName;

    @ApiModelProperty(value = "疾病转归", required = true, example = "治愈")
    private String diseaseOutcome;

    @ApiModelProperty(value = "就诊/入院日期", example = "2024-08-20")
    private LocalDate admissionDate;

    @ApiModelProperty(value = "出院日期", example = "2024-08-27")
    private LocalDate dischargeDate;

    @ApiModelProperty(value = "死亡日期", example = "2024-08-28")
    private LocalDate deathDate;

    public DiagnosisPageVO() {
    }

    public DiagnosisPageVO(Integer userId, String userType, String name, String phoneNumber, String gender, LocalDate birthDate, String department, String diseaseType, String discoveryMethod, String hospitalName, String diseaseOutcome, LocalDate admissionDate, LocalDate dischargeDate, LocalDate deathDate) {
        this.userId = userId;
        this.userType = userType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthDate = birthDate;
        this.department = department;
        this.diseaseType = diseaseType;
        this.discoveryMethod = discoveryMethod;
        this.hospitalName = hospitalName;
        this.diseaseOutcome = diseaseOutcome;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.deathDate = deathDate;
    }

    public DiagnosisPageVO(Integer userId, String userType, String name, String phoneNumber, String gender, LocalDate birthDate, String department, Integer diagnosisResultsId, String diseaseType, String discoveryMethod, String hospitalName, String diseaseOutcome, LocalDate admissionDate, LocalDate dischargeDate, LocalDate deathDate) {
        this.userId = userId;
        this.userType = userType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthDate = birthDate;
        this.department = department;
        this.diagnosisResultsId = diagnosisResultsId;
        this.diseaseType = diseaseType;
        this.discoveryMethod = discoveryMethod;
        this.hospitalName = hospitalName;
        this.diseaseOutcome = diseaseOutcome;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.deathDate = deathDate;
    }

    /**
     * 获取
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * 设置
     * @param birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 获取
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取
     * @return diseaseType
     */
    public String getDiseaseType() {
        return diseaseType;
    }

    /**
     * 设置
     * @param diseaseType
     */
    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    /**
     * 获取
     * @return discoveryMethod
     */
    public String getDiscoveryMethod() {
        return discoveryMethod;
    }

    /**
     * 设置
     * @param discoveryMethod
     */
    public void setDiscoveryMethod(String discoveryMethod) {
        this.discoveryMethod = discoveryMethod;
    }

    /**
     * 获取
     * @return hospitalName
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * 设置
     * @param hospitalName
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    /**
     * 获取
     * @return diseaseOutcome
     */
    public String getDiseaseOutcome() {
        return diseaseOutcome;
    }

    /**
     * 设置
     * @param diseaseOutcome
     */
    public void setDiseaseOutcome(String diseaseOutcome) {
        this.diseaseOutcome = diseaseOutcome;
    }

    /**
     * 获取
     * @return admissionDate
     */
    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    /**
     * 设置
     * @param admissionDate
     */
    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    /**
     * 获取
     * @return dischargeDate
     */
    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    /**
     * 设置
     * @param dischargeDate
     */
    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    /**
     * 获取
     * @return deathDate
     */
    public LocalDate getDeathDate() {
        return deathDate;
    }

    /**
     * 设置
     * @param deathDate
     */
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public String toString() {
        return "DiagnosisPageVO{userId = " + userId + ", userType = " + userType + ", name = " + name + ", phoneNumber = " + phoneNumber + ", gender = " + gender + ", birthDate = " + birthDate + ", department = " + department + ", diseaseType = " + diseaseType + ", discoveryMethod = " + discoveryMethod + ", hospitalName = " + hospitalName + ", diseaseOutcome = " + diseaseOutcome + ", admissionDate = " + admissionDate + ", dischargeDate = " + dischargeDate + ", deathDate = " + deathDate + "}";
    }

    /**
     * 获取
     * @return diagnosisResultsId
     */
    public Integer getDiagnosisResultsId() {
        return diagnosisResultsId;
    }

    /**
     * 设置
     * @param diagnosisResultsId
     */
    public void setDiagnosisResultsId(Integer diagnosisResultsId) {
        this.diagnosisResultsId = diagnosisResultsId;
    }
}
