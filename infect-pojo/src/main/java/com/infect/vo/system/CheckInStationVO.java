package com.infect.vo.system;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CheckInStationVO {

    private Integer statusId;

    private Integer userId;

    private String name;

    private Integer age;

    private String gender;

    private String userType;

    private String ethnicity;

    private String department;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String province;

    private String city;

    private String county;

    private String locationName;

    private LocalDate checkInDate;

    public CheckInStationVO() {
    }

    public CheckInStationVO(String name, Integer age, String gender, String userType, String ethnicity, String department, BigDecimal longitude, BigDecimal latitude, String province, String city, String county, String locationName, LocalDate checkInDate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.userType = userType;
        this.ethnicity = ethnicity;
        this.department = department;
        this.longitude = longitude;
        this.latitude = latitude;
        this.province = province;
        this.city = city;
        this.county = county;
        this.locationName = locationName;
        this.checkInDate = checkInDate;
    }

    public CheckInStationVO(Integer statusId, Integer userId, String name, Integer age, String gender, String userType, String ethnicity, String department, BigDecimal longitude, BigDecimal latitude, String province, String city, String county, String locationName, LocalDate checkInDate) {
        this.statusId = statusId;
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.userType = userType;
        this.ethnicity = ethnicity;
        this.department = department;
        this.longitude = longitude;
        this.latitude = latitude;
        this.province = province;
        this.city = city;
        this.county = county;
        this.locationName = locationName;
        this.checkInDate = checkInDate;
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
     * @return longitude
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * 设置
     * @param longitude
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取
     * @return latitude
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * 设置
     * @param latitude
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
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

    public String toString() {
        return "CheckInStationVO{name = " + name + ", age = " + age + ", gender = " + gender + ", userType = " + userType + ", ethnicity = " + ethnicity + ", department = " + department + ", longitude = " + longitude + ", latitude = " + latitude + ", province = " + province + ", city = " + city + ", county = " + county + ", locationName = " + locationName + ", checkInDate = " + checkInDate + "}";
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
