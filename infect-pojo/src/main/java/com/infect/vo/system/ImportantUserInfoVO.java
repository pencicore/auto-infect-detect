package com.infect.vo.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

public class ImportantUserInfoVO {

    //user表信息
    @ApiModelProperty(value = "用户ID，自增", example = "1")
    private Integer userId;

    @ApiModelProperty(value = "用户姓名", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value = "部门", example = "")
    private String department;

    //dailyHealth表信息
    @ApiModelProperty(value = "健康状态，true 表示健康，false 表示不健康", required = true, example = "true")
    private Boolean isHealth;

    @ApiModelProperty(value = "确诊疾病名称", example = "流感")
    private String diagnosisDiseaseTypeName;

    @ApiModelProperty(value = "经度", required = true, example = "116.397128")
    private BigDecimal longitude;

    @ApiModelProperty(value = "纬度", required = true, example = "39.916527")
    private BigDecimal latitude;

    @ApiModelProperty(value = "省", required = true, example = "北京市")
    private String province;

    @ApiModelProperty(value = "市", required = true, example = "北京市")
    private String city;

    @ApiModelProperty(value = "县", required = true, example = "东城区")
    private String county;

    public ImportantUserInfoVO() {
    }

    public ImportantUserInfoVO(Integer userId, String name, String gender, Boolean isHealth, String diagnosisDiseaseTypeName, BigDecimal longitude, BigDecimal latitude, String province, String city, String county) {
        this.userId = userId;
        this.name = name;
        this.department = gender;
        this.isHealth = isHealth;
        this.diagnosisDiseaseTypeName = diagnosisDiseaseTypeName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.province = province;
        this.city = city;
        this.county = county;
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
     * @return gender
     */
    public String getGender() {
        return department;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.department = gender;
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
     * @return diagnosisDiseaseTypeName
     */
    public String getDiagnosisDiseaseTypeName() {
        return diagnosisDiseaseTypeName;
    }

    /**
     * 设置
     * @param diagnosisDiseaseTypeName
     */
    public void setDiagnosisDiseaseTypeName(String diagnosisDiseaseTypeName) {
        this.diagnosisDiseaseTypeName = diagnosisDiseaseTypeName;
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

    public String toString() {
        return "ImportantUserInfoVO{userId = " + userId + ", name = " + name + ", gender = " + department + ", isHealth = " + isHealth + ", diagnosisDiseaseTypeName = " + diagnosisDiseaseTypeName + ", longitude = " + longitude + ", latitude = " + latitude + ", province = " + province + ", city = " + city + ", county = " + county + "}";
    }
}
