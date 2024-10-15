package com.infect.vo.system;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class LabTestPageVO {

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

    //LabTest表信息
    private Integer labTestReportId;

    private LocalDate uploadDate;

    private Boolean isVirusAntigenTestDone;

    private Boolean isVirusNucleicAcidTestDone;

    private Boolean isVirusCultureIsolationDone;

    private Boolean isSerologicalTestDone;

    public LabTestPageVO() {
    }

    public LabTestPageVO(Integer userId, String userType, String name, String phoneNumber, String gender, LocalDate birthDate, String department, Integer labTestReportId, LocalDate uploadDate, Boolean isVirusAntigenTestDone, Boolean isVirusNucleicAcidTestDone, Boolean isVirusCultureIsolationDone, Boolean isSerologicalTestDone) {
        this.userId = userId;
        this.userType = userType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthDate = birthDate;
        this.department = department;
        this.labTestReportId = labTestReportId;
        this.uploadDate = uploadDate;
        this.isVirusAntigenTestDone = isVirusAntigenTestDone;
        this.isVirusNucleicAcidTestDone = isVirusNucleicAcidTestDone;
        this.isVirusCultureIsolationDone = isVirusCultureIsolationDone;
        this.isSerologicalTestDone = isSerologicalTestDone;
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
     * @return labTestReportId
     */
    public Integer getLabTestReportId() {
        return labTestReportId;
    }

    /**
     * 设置
     * @param labTestReportId
     */
    public void setLabTestReportId(Integer labTestReportId) {
        this.labTestReportId = labTestReportId;
    }

    /**
     * 获取
     * @return uploadDate
     */
    public LocalDate getUploadDate() {
        return uploadDate;
    }

    /**
     * 设置
     * @param uploadDate
     */
    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    /**
     * 获取
     * @return isVirusAntigenTestDone
     */
    public Boolean getIsVirusAntigenTestDone() {
        return isVirusAntigenTestDone;
    }

    /**
     * 设置
     * @param isVirusAntigenTestDone
     */
    public void setIsVirusAntigenTestDone(Boolean isVirusAntigenTestDone) {
        this.isVirusAntigenTestDone = isVirusAntigenTestDone;
    }

    /**
     * 获取
     * @return isVirusNucleicAcidTestDone
     */
    public Boolean getIsVirusNucleicAcidTestDone() {
        return isVirusNucleicAcidTestDone;
    }

    /**
     * 设置
     * @param isVirusNucleicAcidTestDone
     */
    public void setIsVirusNucleicAcidTestDone(Boolean isVirusNucleicAcidTestDone) {
        this.isVirusNucleicAcidTestDone = isVirusNucleicAcidTestDone;
    }

    /**
     * 获取
     * @return isVirusCultureIsolationDone
     */
    public Boolean getIsVirusCultureIsolationDone() {
        return isVirusCultureIsolationDone;
    }

    /**
     * 设置
     * @param isVirusCultureIsolationDone
     */
    public void setIsVirusCultureIsolationDone(Boolean isVirusCultureIsolationDone) {
        this.isVirusCultureIsolationDone = isVirusCultureIsolationDone;
    }

    /**
     * 获取
     * @return isSerologicalTestDone
     */
    public Boolean getIsSerologicalTestDone() {
        return isSerologicalTestDone;
    }

    /**
     * 设置
     * @param isSerologicalTestDone
     */
    public void setIsSerologicalTestDone(Boolean isSerologicalTestDone) {
        this.isSerologicalTestDone = isSerologicalTestDone;
    }

    public String toString() {
        return "LabTestPageVO{userId = " + userId + ", userType = " + userType + ", name = " + name + ", phoneNumber = " + phoneNumber + ", gender = " + gender + ", birthDate = " + birthDate + ", department = " + department + ", labTestReportId = " + labTestReportId + ", uploadDate = " + uploadDate + ", isVirusAntigenTestDone = " + isVirusAntigenTestDone + ", isVirusNucleicAcidTestDone = " + isVirusNucleicAcidTestDone + ", isVirusCultureIsolationDone = " + isVirusCultureIsolationDone + ", isSerologicalTestDone = " + isSerologicalTestDone + "}";
    }
}
