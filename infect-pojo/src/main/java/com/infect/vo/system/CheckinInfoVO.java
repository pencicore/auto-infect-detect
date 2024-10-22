package com.infect.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@ApiModel(value = "用户签到信息VO")
public class CheckinInfoVO {

    private Integer statusId;

    private Integer userId;

    @ApiModelProperty(value = "用户类型", required = true, example = "铁路职工")
    private String userType;

    @ApiModelProperty(value = "用户姓名", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value = "电话号码", required = true, example = "13812345678")
    private String phoneNumber;

    @ApiModelProperty(value = "性别", example = "男")
    private String gender;

    @ApiModelProperty(value = "年龄", example = "30")
    private Integer age;

    @ApiModelProperty(value = "部门", example = "工程技术部")
    private String department;

    @ApiModelProperty(value = "健康状态，true 表示健康，false 表示不健康", required = true, example = "true")
    private Boolean isHealth;

    @ApiModelProperty(value = "省", required = true, example = "北京市")
    private String province;

    @ApiModelProperty(value = "市", required = true, example = "北京市")
    private String city;

    @ApiModelProperty(value = "县", required = true, example = "东城区")
    private String county;

    @ApiModelProperty(value = "位置名称，如详细地址信息或地标", required = true, example = "天安门广场")
    private String locationName;

    @ApiModelProperty(value = "签到日期，格式为 yyyy-MM-dd", required = true, example = "2024-10-08")
    private LocalDate checkInDate;

    @ApiModelProperty(value = "最可能疾病类型名称", example = "感冒")
    private String diseaseTypeName;

    public CheckinInfoVO() {
    }

    public CheckinInfoVO(String userType, String name, String phoneNumber, String gender, Integer age, String department, Boolean isHealth, String province, String city, String county, String locationName, LocalDate checkInDate, String diseaseTypeName) {
        this.userType = userType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.department = department;
        this.isHealth = isHealth;
        this.province = province;
        this.city = city;
        this.county = county;
        this.locationName = locationName;
        this.checkInDate = checkInDate;
        this.diseaseTypeName = diseaseTypeName;
    }

    public CheckinInfoVO(Integer statusId, Integer userId, String userType, String name, String phoneNumber, String gender, Integer age, String department, Boolean isHealth, String province, String city, String county, String locationName, LocalDate checkInDate, String diseaseTypeName) {
        this.statusId = statusId;
        this.userId = userId;
        this.userType = userType;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
        this.department = department;
        this.isHealth = isHealth;
        this.province = province;
        this.city = city;
        this.county = county;
        this.locationName = locationName;
        this.checkInDate = checkInDate;
        this.diseaseTypeName = diseaseTypeName;
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
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
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
     * @return isHealth
     */
    public Boolean getIsHealth() {
        return isHealth;
    }

    /**
     * 设置
     * @param isHealth
     */
    public void setIsHealth(Boolean isHealth) {
        this.isHealth = isHealth;
    }

    /**
     * 获取
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取
     * @return county
     */
    public String getCounty() {
        return county;
    }

    /**
     * 设置
     * @param county
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * 获取
     * @return locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * 设置
     * @param locationName
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * 获取
     * @return checkInDate
     */
    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    /**
     * 设置
     * @param checkInDate
     */
    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * 获取
     * @return diseaseTypeName
     */
    public String getDiseaseTypeName() {
        return diseaseTypeName;
    }

    /**
     * 设置
     * @param diseaseTypeName
     */
    public void setDiseaseTypeName(String diseaseTypeName) {
        this.diseaseTypeName = diseaseTypeName;
    }

    public String toString() {
        return "CheckinInfoVO{userType = " + userType + ", name = " + name + ", phoneNumber = " + phoneNumber + ", gender = " + gender + ", age = " + age + ", department = " + department + ", isHealth = " + isHealth + ", province = " + province + ", city = " + city + ", county = " + county + ", locationName = " + locationName + ", checkInDate = " + checkInDate + ", diseaseTypeName = " + diseaseTypeName + "}";
    }

    /**
     * 获取
     * @return statusId
     */
    public Integer getStatusId() {
        return statusId;
    }

    /**
     * 设置
     * @param statusId
     */
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
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
