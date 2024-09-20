package com.infect.vo.system;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class UserSystemInfoVO {

    private Integer userId;

    @ApiModelProperty(value = "用户类型", required = true, example = "铁路职工")
    private String userType;

    @ApiModelProperty(value = "用户姓名", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value = "电话号码", required = true, example = "13812345678")
    private String phoneNumber;

    @ApiModelProperty(value = "性别", example = "男")
    private String gender;

    @ApiModelProperty(value = "民族", example = "汉族")
    private String ethnicity;

    @ApiModelProperty(value = "教育水平", example = "大专/本科")
    private String educationLevel;

    @ApiModelProperty(value = "在高原工作的开始日期", example = "2022-05-01")
    private LocalDate workOnPlateauStartDate;

    @ApiModelProperty(value = "部门", example = "工程技术部")
    private String department;

    @ApiModelProperty(value = "特殊职业", example = "医务人员")
    private String specificOccupation;

    @ApiModelProperty(value = "是否激活", required = true, example = "true")
    private Boolean isActived;

    public UserSystemInfoVO() {
    }

    public UserSystemInfoVO(String userType, String name, String phoneNumber, String gender, String ethnicity, String educationLevel, LocalDate workOnPlateauStartDate, String department, String specificOccupation, Boolean isActived) {
        this.userType = userType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.ethnicity = ethnicity;
        this.educationLevel = educationLevel;
        this.workOnPlateauStartDate = workOnPlateauStartDate;
        this.department = department;
        this.specificOccupation = specificOccupation;
        this.isActived = isActived;
    }

    public UserSystemInfoVO(Integer userId, String userType, String name, String phoneNumber, String gender, String ethnicity, String educationLevel, LocalDate workOnPlateauStartDate, String department, String specificOccupation, Boolean isActived) {
        this.userId = userId;
        this.userType = userType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.ethnicity = ethnicity;
        this.educationLevel = educationLevel;
        this.workOnPlateauStartDate = workOnPlateauStartDate;
        this.department = department;
        this.specificOccupation = specificOccupation;
        this.isActived = isActived;
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
     * @return ethnicity
     */
    public String getEthnicity() {
        return ethnicity;
    }

    /**
     * 设置
     * @param ethnicity
     */
    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    /**
     * 获取
     * @return educationLevel
     */
    public String getEducationLevel() {
        return educationLevel;
    }

    /**
     * 设置
     * @param educationLevel
     */
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    /**
     * 获取
     * @return workOnPlateauStartDate
     */
    public LocalDate getWorkOnPlateauStartDate() {
        return workOnPlateauStartDate;
    }

    /**
     * 设置
     * @param workOnPlateauStartDate
     */
    public void setWorkOnPlateauStartDate(LocalDate workOnPlateauStartDate) {
        this.workOnPlateauStartDate = workOnPlateauStartDate;
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
     * @return specificOccupation
     */
    public String getSpecificOccupation() {
        return specificOccupation;
    }

    /**
     * 设置
     * @param specificOccupation
     */
    public void setSpecificOccupation(String specificOccupation) {
        this.specificOccupation = specificOccupation;
    }

    /**
     * 获取
     * @return isActived
     */
    public Boolean getIsActived() {
        return isActived;
    }

    /**
     * 设置
     * @param isActived
     */
    public void setIsActived(Boolean isActived) {
        this.isActived = isActived;
    }

    public String toString() {
        return "UserSystemInfoVO{userType = " + userType + ", name = " + name + ", phoneNumber = " + phoneNumber + ", gender = " + gender + ", ethnicity = " + ethnicity + ", educationLevel = " + educationLevel + ", workOnPlateauStartDate = " + workOnPlateauStartDate + ", department = " + department + ", specificOccupation = " + specificOccupation + ", isActived = " + isActived + "}";
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
}
