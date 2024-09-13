package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * <p>
 * 诊断呼吸系统症状实体类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("diagnosisrespiratorysymptoms")
@ApiModel(value = "Diagnosisrespiratorysymptoms对象", description = "诊断呼吸系统症状")
public class Diagnosisrespiratorysymptoms implements Serializable {
    @Override
    public String toString() {
        return "Diagnosisrespiratorysymptoms{" +
                "diagnosisRespiratorySymptomId=" + diagnosisRespiratorySymptomId +
                ", diagnosisResultsId=" + diagnosisResultsId +
                ", hasCough=" + hasCough +
                ", hasSputum=" + hasSputum +
                ", hasBloodySputum=" + hasBloodySputum +
                ", hasHemoptysis=" + hasHemoptysis +
                ", hasSoreThroat=" + hasSoreThroat +
                ", hasDryThroat=" + hasDryThroat +
                ", hasNasalCongestion=" + hasNasalCongestion +
                ", hasRunnyNose=" + hasRunnyNose +
                ", hasPharyngealHyperemia=" + hasPharyngealHyperemia +
                ", hasChestTightness=" + hasChestTightness +
                ", hasShortnessOfBreath=" + hasShortnessOfBreath +
                ", hasBreathingDifficulty=" + hasBreathingDifficulty +
                ", hasHoarseness=" + hasHoarseness +
                ", hasBronchitis=" + hasBronchitis +
                ", hasLungRales=" + hasLungRales +
                '}';
    }

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisRespiratorySymptomID", type = IdType.AUTO)
    @ApiModelProperty(value = "呼吸系统症状ID，自增", required = true, hidden = true)
    private Integer diagnosisRespiratorySymptomId;

    @ApiModelProperty(value = "诊断结果ID，关联DiagnosisResults表", hidden = true)
    private Integer diagnosisResultsId;

    @ApiModelProperty(value = "是否咳嗽", required = true, example = "true")
    private Boolean hasCough;

    @ApiModelProperty(value = "是否咳痰", required = true, example = "false")
    private Boolean hasSputum;

    @ApiModelProperty(value = "是否血痰", required = true, example = "false")
    private Boolean hasBloodySputum;

    @ApiModelProperty(value = "是否咳血", required = true, example = "false")
    private Boolean hasHemoptysis;

    @ApiModelProperty(value = "是否咽痛", required = true, example = "true")
    private Boolean hasSoreThroat;

    @ApiModelProperty(value = "是否咽干", required = true, example = "true")
    private Boolean hasDryThroat;

    @ApiModelProperty(value = "是否鼻塞", required = true, example = "false")
    private Boolean hasNasalCongestion;

    @ApiModelProperty(value = "是否流涕", required = true, example = "true")
    private Boolean hasRunnyNose;

    @ApiModelProperty(value = "是否咽充血", required = true, example = "false")
    private Boolean hasPharyngealHyperemia;

    @ApiModelProperty(value = "是否胸闷", required = true, example = "true")
    private Boolean hasChestTightness;

    @ApiModelProperty(value = "是否气促", required = true, example = "true")
    private Boolean hasShortnessOfBreath;

    @ApiModelProperty(value = "是否呼吸困难", required = true, example = "false")
    private Boolean hasBreathingDifficulty;

    @ApiModelProperty(value = "是否声音嘶哑", required = true, example = "false")
    private Boolean hasHoarseness;

    @ApiModelProperty(value = "是否支气管炎或支气管肺炎", required = true, example = "false")
    private Boolean hasBronchitis;

    @ApiModelProperty(value = "是否听诊肺部有散在湿性罗音", required = true, example = "true")
    private Boolean hasLungRales;

    public Integer getDiagnosisRespiratorySymptomId() {
        return diagnosisRespiratorySymptomId;
    }

    public void setDiagnosisRespiratorySymptomId(Integer diagnosisRespiratorySymptomId) {
        this.diagnosisRespiratorySymptomId = diagnosisRespiratorySymptomId;
    }

    public Integer getDiagnosisResultsId() {
        return diagnosisResultsId;
    }

    public void setDiagnosisResultsId(Integer diagnosisResultsId) {
        this.diagnosisResultsId = diagnosisResultsId;
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

    public Boolean getHasPharyngealHyperemia() {
        return hasPharyngealHyperemia;
    }

    public void setHasPharyngealHyperemia(Boolean hasPharyngealHyperemia) {
        this.hasPharyngealHyperemia = hasPharyngealHyperemia;
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

    public Boolean getHasLungRales() {
        return hasLungRales;
    }

    public void setHasLungRales(Boolean hasLungRales) {
        this.hasLungRales = hasLungRales;
    }
}
