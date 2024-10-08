package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 诊断神经系统症状实体类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("diagnosisneurologicalsymptoms")
@ApiModel(value = "Diagnosisneurologicalsymptoms对象", description = "诊断神经系统症状")
public class Diagnosisneurologicalsymptoms implements Serializable {
    @Override
    public String toString() {
        return "Diagnosisneurologicalsymptoms{" +
                "diagnosisNeurologicalSymptomId=" + diagnosisNeurologicalSymptomId +
                ", diagnosisResultsId=" + diagnosisResultsId +
                ", hasDelirium=" + hasDelirium +
                ", hasConvulsion=" + hasConvulsion +
                ", hasDrowsiness=" + hasDrowsiness +
                ", hasComa=" + hasComa +
                ", hasStiffNeck=" + hasStiffNeck +
                ", hasRestlessness=" + hasRestlessness +
                ", hasMuscleParalysisNeckShoulder=" + hasMuscleParalysisNeckShoulder +
                ", hasMuscleParalysisLimbs=" + hasMuscleParalysisLimbs +
                ", hasSwallowingDifficulty=" + hasSwallowingDifficulty +
                ", hasSpeechDisorder=" + hasSpeechDisorder +
                ", hasConsciousnessDisorder=" + hasConsciousnessDisorder +
                ", hasDizziness=" + hasDizziness +
                ", hasTinnitus=" + hasTinnitus +
                ", hasHearingLoss=" + hasHearingLoss +
                '}';
    }

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisNeurologicalSymptomID", type = IdType.AUTO)
    @ApiModelProperty(value = "神经系统症状ID，自增", required = true, hidden = true)
    private Integer diagnosisNeurologicalSymptomId;

    @ApiModelProperty(value = "诊断结果ID，关联DiagnosisResults表", hidden = true)
    private Integer diagnosisResultsId;

    @ApiModelProperty(value = "是否儋妄", required = true, example = "false")
    private Boolean hasDelirium;

    @ApiModelProperty(value = "是否抽搐", required = true, example = "true")
    private Boolean hasConvulsion;

    @ApiModelProperty(value = "是否昏睡", required = true, example = "false")
    private Boolean hasDrowsiness;

    @ApiModelProperty(value = "是否昏迷", required = true, example = "false")
    private Boolean hasComa;

    @ApiModelProperty(value = "是否颈部强直", required = true, example = "false")
    private Boolean hasStiffNeck;

    @ApiModelProperty(value = "是否烦躁不安", required = true, example = "true")
    private Boolean hasRestlessness;

    @ApiModelProperty(value = "是否颈肩部肌肉迟缓性瘫痪", required = true, example = "false")
    private Boolean hasMuscleParalysisNeckShoulder;

    @ApiModelProperty(value = "是否肢体肌肉迟缓性瘫痪", required = true, example = "false")
    private Boolean hasMuscleParalysisLimbs;

    @ApiModelProperty(value = "是否吞咽困难", required = true, example = "true")
    private Boolean hasSwallowingDifficulty;

    @ApiModelProperty(value = "是否语言障碍", required = true, example = "true")
    private Boolean hasSpeechDisorder;

    @ApiModelProperty(value = "是否意识障碍或惊厥", required = true, example = "false")
    private Boolean hasConsciousnessDisorder;

    @ApiModelProperty(value = "是否头晕", required = true, example = "true")
    private Boolean hasDizziness;

    @ApiModelProperty(value = "是否耳鸣", required = true, example = "false")
    private Boolean hasTinnitus;

    @ApiModelProperty(value = "是否听力减退", required = true, example = "false")
    private Boolean hasHearingLoss;

    public Integer getDiagnosisNeurologicalSymptomId() {
        return diagnosisNeurologicalSymptomId;
    }

    public void setDiagnosisNeurologicalSymptomId(Integer diagnosisNeurologicalSymptomId) {
        this.diagnosisNeurologicalSymptomId = diagnosisNeurologicalSymptomId;
    }

    public Integer getDiagnosisResultsId() {
        return diagnosisResultsId;
    }

    public void setDiagnosisResultsId(Integer diagnosisResultsId) {
        this.diagnosisResultsId = diagnosisResultsId;
    }

    public Boolean getHasDelirium() {
        return hasDelirium;
    }

    public void setHasDelirium(Boolean hasDelirium) {
        this.hasDelirium = hasDelirium;
    }

    public Boolean getHasConvulsion() {
        return hasConvulsion;
    }

    public void setHasConvulsion(Boolean hasConvulsion) {
        this.hasConvulsion = hasConvulsion;
    }

    public Boolean getHasDrowsiness() {
        return hasDrowsiness;
    }

    public void setHasDrowsiness(Boolean hasDrowsiness) {
        this.hasDrowsiness = hasDrowsiness;
    }

    public Boolean getHasComa() {
        return hasComa;
    }

    public void setHasComa(Boolean hasComa) {
        this.hasComa = hasComa;
    }

    public Boolean getHasStiffNeck() {
        return hasStiffNeck;
    }

    public void setHasStiffNeck(Boolean hasStiffNeck) {
        this.hasStiffNeck = hasStiffNeck;
    }

    public Boolean getHasRestlessness() {
        return hasRestlessness;
    }

    public void setHasRestlessness(Boolean hasRestlessness) {
        this.hasRestlessness = hasRestlessness;
    }

    public Boolean getHasMuscleParalysisNeckShoulder() {
        return hasMuscleParalysisNeckShoulder;
    }

    public void setHasMuscleParalysisNeckShoulder(Boolean hasMuscleParalysisNeckShoulder) {
        this.hasMuscleParalysisNeckShoulder = hasMuscleParalysisNeckShoulder;
    }

    public Boolean getHasMuscleParalysisLimbs() {
        return hasMuscleParalysisLimbs;
    }

    public void setHasMuscleParalysisLimbs(Boolean hasMuscleParalysisLimbs) {
        this.hasMuscleParalysisLimbs = hasMuscleParalysisLimbs;
    }

    public Boolean getHasSwallowingDifficulty() {
        return hasSwallowingDifficulty;
    }

    public void setHasSwallowingDifficulty(Boolean hasSwallowingDifficulty) {
        this.hasSwallowingDifficulty = hasSwallowingDifficulty;
    }

    public Boolean getHasSpeechDisorder() {
        return hasSpeechDisorder;
    }

    public void setHasSpeechDisorder(Boolean hasSpeechDisorder) {
        this.hasSpeechDisorder = hasSpeechDisorder;
    }

    public Boolean getHasConsciousnessDisorder() {
        return hasConsciousnessDisorder;
    }

    public void setHasConsciousnessDisorder(Boolean hasConsciousnessDisorder) {
        this.hasConsciousnessDisorder = hasConsciousnessDisorder;
    }

    public Boolean getHasDizziness() {
        return hasDizziness;
    }

    public void setHasDizziness(Boolean hasDizziness) {
        this.hasDizziness = hasDizziness;
    }

    public Boolean getHasTinnitus() {
        return hasTinnitus;
    }

    public void setHasTinnitus(Boolean hasTinnitus) {
        this.hasTinnitus = hasTinnitus;
    }

    public Boolean getHasHearingLoss() {
        return hasHearingLoss;
    }

    public void setHasHearingLoss(Boolean hasHearingLoss) {
        this.hasHearingLoss = hasHearingLoss;
    }
}
