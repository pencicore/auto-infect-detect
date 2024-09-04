package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * <p>
 * OtherSymptoms 实体类，记录其他症状
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("othersymptoms")
@ApiModel(value="Othersymptoms对象", description="其他症状表")
public class Othersymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "其他症状ID", required = true, example = "1")
    @TableId(value = "OtherSymptomsID", type = IdType.AUTO)
    private Integer otherSymptomsId;

    @ApiModelProperty(value = "每日健康状态ID", required = true, example = "1001")
    private Integer statusId;

    @ApiModelProperty(value = "是否突然发病", required = true, example = "false")
    private Boolean hasSuddenOnset;

    @ApiModelProperty(value = "是否病情进展迅速", required = true, example = "true")
    private Boolean hasRapidProgress;

    @ApiModelProperty(value = "是否周期性发作", required = true, example = "false")
    private Boolean hasPeriodicAttack;

    @ApiModelProperty(value = "是否有强迫体位", required = true, example = "true")
    private Boolean hasForcedPosture;

    @ApiModelProperty(value = "是否有腓肠肌疼痛", required = true, example = "false")
    private Boolean hasCalfMusclePain;

    @ApiModelProperty(value = "睡眠质量", required = true, example = "好")
    private String sleepQuality;

    @ApiModelProperty(value = "营养状况", required = true, example = "一般")
    private String nutritionStatus;

    @ApiModelProperty(value = "工作和生活压力", required = true, example = "大")
    private String workLifeStress;

    @ApiModelProperty(value = "自我感觉症状的严重程度", required = true, example = "中")
    private String symptomSeverity;

    @ApiModelProperty(value = "是否有其他症状", required = true, example = "false")
    private Boolean hasOtherSymptoms;

    @ApiModelProperty(value = "其他症状名称", required = true, example = "头痛、乏力")
    private String otherSymptomsName;

    public Integer getOtherSymptomsId() {
        return otherSymptomsId;
    }

    public void setOtherSymptomsId(Integer otherSymptomsId) {
        this.otherSymptomsId = otherSymptomsId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Boolean getHasSuddenOnset() {
        return hasSuddenOnset;
    }

    public void setHasSuddenOnset(Boolean hasSuddenOnset) {
        this.hasSuddenOnset = hasSuddenOnset;
    }

    public Boolean getHasRapidProgress() {
        return hasRapidProgress;
    }

    public void setHasRapidProgress(Boolean hasRapidProgress) {
        this.hasRapidProgress = hasRapidProgress;
    }

    public Boolean getHasPeriodicAttack() {
        return hasPeriodicAttack;
    }

    public void setHasPeriodicAttack(Boolean hasPeriodicAttack) {
        this.hasPeriodicAttack = hasPeriodicAttack;
    }

    public Boolean getHasForcedPosture() {
        return hasForcedPosture;
    }

    public void setHasForcedPosture(Boolean hasForcedPosture) {
        this.hasForcedPosture = hasForcedPosture;
    }

    public Boolean getHasCalfMusclePain() {
        return hasCalfMusclePain;
    }

    public void setHasCalfMusclePain(Boolean hasCalfMusclePain) {
        this.hasCalfMusclePain = hasCalfMusclePain;
    }

    public String getSleepQuality() {
        return sleepQuality;
    }

    public void setSleepQuality(String sleepQuality) {
        this.sleepQuality = sleepQuality;
    }

    public String getNutritionStatus() {
        return nutritionStatus;
    }

    public void setNutritionStatus(String nutritionStatus) {
        this.nutritionStatus = nutritionStatus;
    }

    public String getWorkLifeStress() {
        return workLifeStress;
    }

    public void setWorkLifeStress(String workLifeStress) {
        this.workLifeStress = workLifeStress;
    }

    public String getSymptomSeverity() {
        return symptomSeverity;
    }

    public void setSymptomSeverity(String symptomSeverity) {
        this.symptomSeverity = symptomSeverity;
    }

    public Boolean getHasOtherSymptoms() {
        return hasOtherSymptoms;
    }

    public void setHasOtherSymptoms(Boolean hasOtherSymptoms) {
        this.hasOtherSymptoms = hasOtherSymptoms;
    }

    public String getOtherSymptomsName() {
        return otherSymptomsName;
    }

    public void setOtherSymptomsName(String otherSymptomsName) {
        this.otherSymptomsName = otherSymptomsName;
    }
}
