package com.infect.vo.system;

import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.time.LocalTime;

public class CheckinInfoStatisticsVO {

    @ApiModelProperty(value = "用户姓名")
    private String name;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "签到日期，格式为 yyyy-MM-dd", required = true, example = "2024-10-08")
    private LocalDate checkInDate;

    @ApiModelProperty(value = "签到时间，格式为 HH:mm:ss", required = true, example = "08:30:00")
    private LocalTime checkInTime;

    @ApiModelProperty(value = "健康状态，true 表示健康，false 表示不健康", required = true, example = "true")
    private Boolean isHealth;

    @ApiModelProperty(value = "最可能疾病类型名称", example = "感冒")
    private String diseaseTypeName;

    @ApiModelProperty(value = "确诊疾病名称", example = "流感")
    private String diagnosisDiseaseTypeName;


    public CheckinInfoStatisticsVO() {
    }

    public CheckinInfoStatisticsVO(String name, Integer userId, LocalDate checkInDate, LocalTime checkInTime, Boolean isHealth, String diseaseTypeName, String diagnosisDiseaseTypeName) {
        this.name = name;
        this.userId = userId;
        this.checkInDate = checkInDate;
        this.checkInTime = checkInTime;
        this.isHealth = isHealth;
        this.diseaseTypeName = diseaseTypeName;
        this.diagnosisDiseaseTypeName = diagnosisDiseaseTypeName;
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
     * @return checkInTime
     */
    public LocalTime getCheckInTime() {
        return checkInTime;
    }

    /**
     * 设置
     * @param checkInTime
     */
    public void setCheckInTime(LocalTime checkInTime) {
        this.checkInTime = checkInTime;
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

    public String toString() {
        return "CheckinInfoStatisticsVO{name = " + name + ", userId = " + userId + ", checkInDate = " + checkInDate + ", checkInTime = " + checkInTime + ", isHealth = " + isHealth + ", diseaseTypeName = " + diseaseTypeName + ", diagnosisDiseaseTypeName = " + diagnosisDiseaseTypeName + "}";
    }
}
