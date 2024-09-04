package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * <p>
 * 呼吸系统症状表
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("respiratorysymptoms")
@ApiModel(value="Respiratorysymptoms对象", description="呼吸系统症状表")
public class Respiratorysymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "RespiratorySymptomsID", type = IdType.AUTO)
    @ApiModelProperty(value = "呼吸系统症状ID，自增")
    private Integer respiratorySymptomsId;

    @ApiModelProperty(value = "每日健康状态ID")
    private Integer statusId;

    @ApiModelProperty(value = "是否咳嗽", required = true, example = "true")
    private Boolean hasCough;

    @ApiModelProperty(value = "是否咳痰", required = true, example = "true")
    private Boolean hasSputum;

    @ApiModelProperty(value = "是否血痰", required = true, example = "true")
    private Boolean hasBloodySputum;

    @ApiModelProperty(value = "是否咳血", required = true, example = "true")
    private Boolean hasHemoptysis;

    @ApiModelProperty(value = "是否咽痛", required = true, example = "true")
    private Boolean hasSoreThroat;

    @ApiModelProperty(value = "是否咽干", required = true, example = "true")
    private Boolean hasDryThroat;

    @ApiModelProperty(value = "是否鼻塞", required = true, example = "true")
    private Boolean hasNasalCongestion;

    @ApiModelProperty(value = "是否流涕", required = true, example = "true")
    private Boolean hasRunnyNose;

    @ApiModelProperty(value = "是否胸闷", required = true, example = "true")
    private Boolean hasChestTightness;

    @ApiModelProperty(value = "是否气促", required = true, example = "true")
    private Boolean hasShortnessOfBreath;

    @ApiModelProperty(value = "是否呼吸困难", required = true, example = "true")
    private Boolean hasBreathingDifficulty;

    @ApiModelProperty(value = "是否声音嘶哑", required = true, example = "true")
    private Boolean hasHoarseness;

    @ApiModelProperty(value = "是否支气管炎或支气管肺炎", required = true, example = "true")
    private Boolean hasBronchitis;

    public Integer getRespiratorySymptomsId() {
        return respiratorySymptomsId;
    }

    public void setRespiratorySymptomsId(Integer respiratorySymptomsId) {
        this.respiratorySymptomsId = respiratorySymptomsId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Boolean getHasCough() {
        return hasCough;
    }

    public void setHasCough(Boolean hasCough) {
        this.hasCough = hasCough;
    }

    public Boolean getHasSputum() {
        return hasSputum;
    }

    public void setHasSputum(Boolean hasSputum) {
        this.hasSputum = hasSputum;
    }

    public Boolean getHasBloodySputum() {
        return hasBloodySputum;
    }

    public void setHasBloodySputum(Boolean hasBloodySputum) {
        this.hasBloodySputum = hasBloodySputum;
    }

    public Boolean getHasHemoptysis() {
        return hasHemoptysis;
    }

    public void setHasHemoptysis(Boolean hasHemoptysis) {
        this.hasHemoptysis = hasHemoptysis;
    }

    public Boolean getHasSoreThroat() {
        return hasSoreThroat;
    }

    public void setHasSoreThroat(Boolean hasSoreThroat) {
        this.hasSoreThroat = hasSoreThroat;
    }

    public Boolean getHasDryThroat() {
        return hasDryThroat;
    }

    public void setHasDryThroat(Boolean hasDryThroat) {
        this.hasDryThroat = hasDryThroat;
    }

    public Boolean getHasNasalCongestion() {
        return hasNasalCongestion;
    }

    public void setHasNasalCongestion(Boolean hasNasalCongestion) {
        this.hasNasalCongestion = hasNasalCongestion;
    }

    public Boolean getHasRunnyNose() {
        return hasRunnyNose;
    }

    public void setHasRunnyNose(Boolean hasRunnyNose) {
        this.hasRunnyNose = hasRunnyNose;
    }

    public Boolean getHasChestTightness() {
        return hasChestTightness;
    }

    public void setHasChestTightness(Boolean hasChestTightness) {
        this.hasChestTightness = hasChestTightness;
    }

    public Boolean getHasShortnessOfBreath() {
        return hasShortnessOfBreath;
    }

    public void setHasShortnessOfBreath(Boolean hasShortnessOfBreath) {
        this.hasShortnessOfBreath = hasShortnessOfBreath;
    }

    public Boolean getHasBreathingDifficulty() {
        return hasBreathingDifficulty;
    }

    public void setHasBreathingDifficulty(Boolean hasBreathingDifficulty) {
        this.hasBreathingDifficulty = hasBreathingDifficulty;
    }

    public Boolean getHasHoarseness() {
        return hasHoarseness;
    }

    public void setHasHoarseness(Boolean hasHoarseness) {
        this.hasHoarseness = hasHoarseness;
    }

    public Boolean getHasBronchitis() {
        return hasBronchitis;
    }

    public void setHasBronchitis(Boolean hasBronchitis) {
        this.hasBronchitis = hasBronchitis;
    }
}
