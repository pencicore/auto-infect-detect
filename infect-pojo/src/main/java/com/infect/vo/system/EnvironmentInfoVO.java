package com.infect.vo.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("工作环境VO")
public class EnvironmentInfoVO {

    private Integer environmentId;

    @ApiModelProperty(value = "用户姓名", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value = "工务段名称", required = true, example = "某某工务段")
    private String workStationName;

    @ApiModelProperty(value = "工务段所在地海拔高度（米）", required = true, example = "1500")
    private Integer workStationAltitude;

    @ApiModelProperty(value = "当月平均气压（kPa）", required = true, example = "101.35")
    private BigDecimal avgMonthlyPressure;

    @ApiModelProperty(value = "当月最高气温（℃）", required = true, example = "35.6")
    private BigDecimal maxTemperature;

    @ApiModelProperty(value = "当月最低气温（℃）", required = true, example = "18.2")
    private BigDecimal minTemperature;

    @ApiModelProperty(value = "提交时间，自动记录时间戳", required = true, example = "2024-08-24T12:34:56")
    private LocalDateTime submissionTime;

    public EnvironmentInfoVO() {
    }

    public EnvironmentInfoVO(String name, String workStationName, Integer workStationAltitude, BigDecimal avgMonthlyPressure, BigDecimal maxTemperature, BigDecimal minTemperature, LocalDateTime submissionTime) {
        this.name = name;
        this.workStationName = workStationName;
        this.workStationAltitude = workStationAltitude;
        this.avgMonthlyPressure = avgMonthlyPressure;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.submissionTime = submissionTime;
    }

    public EnvironmentInfoVO(Integer environmentId, String name, String workStationName, Integer workStationAltitude, BigDecimal avgMonthlyPressure, BigDecimal maxTemperature, BigDecimal minTemperature, LocalDateTime submissionTime) {
        this.environmentId = environmentId;
        this.name = name;
        this.workStationName = workStationName;
        this.workStationAltitude = workStationAltitude;
        this.avgMonthlyPressure = avgMonthlyPressure;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.submissionTime = submissionTime;
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
     * @return workStationName
     */
    public String getWorkStationName() {
        return workStationName;
    }

    /**
     * 设置
     * @param workStationName
     */
    public void setWorkStationName(String workStationName) {
        this.workStationName = workStationName;
    }

    /**
     * 获取
     * @return workStationAltitude
     */
    public Integer getWorkStationAltitude() {
        return workStationAltitude;
    }

    /**
     * 设置
     * @param workStationAltitude
     */
    public void setWorkStationAltitude(Integer workStationAltitude) {
        this.workStationAltitude = workStationAltitude;
    }

    /**
     * 获取
     * @return avgMonthlyPressure
     */
    public BigDecimal getAvgMonthlyPressure() {
        return avgMonthlyPressure;
    }

    /**
     * 设置
     * @param avgMonthlyPressure
     */
    public void setAvgMonthlyPressure(BigDecimal avgMonthlyPressure) {
        this.avgMonthlyPressure = avgMonthlyPressure;
    }

    /**
     * 获取
     * @return maxTemperature
     */
    public BigDecimal getMaxTemperature() {
        return maxTemperature;
    }

    /**
     * 设置
     * @param maxTemperature
     */
    public void setMaxTemperature(BigDecimal maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    /**
     * 获取
     * @return minTemperature
     */
    public BigDecimal getMinTemperature() {
        return minTemperature;
    }

    /**
     * 设置
     * @param minTemperature
     */
    public void setMinTemperature(BigDecimal minTemperature) {
        this.minTemperature = minTemperature;
    }

    /**
     * 获取
     * @return submissionTime
     */
    public LocalDateTime getSubmissionTime() {
        return submissionTime;
    }

    /**
     * 设置
     * @param submissionTime
     */
    public void setSubmissionTime(LocalDateTime submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String toString() {
        return "EnvironmentInfoVO{name = " + name + ", workStationName = " + workStationName + ", workStationAltitude = " + workStationAltitude + ", avgMonthlyPressure = " + avgMonthlyPressure + ", maxTemperature = " + maxTemperature + ", minTemperature = " + minTemperature + ", submissionTime = " + submissionTime + "}";
    }

    /**
     * 获取
     * @return environmentId
     */
    public Integer getEnvironmentId() {
        return environmentId;
    }

    /**
     * 设置
     * @param environmentId
     */
    public void setEnvironmentId(Integer environmentId) {
        this.environmentId = environmentId;
    }
}
