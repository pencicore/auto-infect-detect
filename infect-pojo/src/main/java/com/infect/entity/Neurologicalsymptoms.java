package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * <p>
 * NeurologicalSymptoms 实体类，记录神经系统症状
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("neurologicalsymptoms")
@ApiModel(value="Neurologicalsymptoms对象", description="神经系统症状表")
public class Neurologicalsymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "神经系统症状ID")
    @TableId(value = "NeurologicalSymptomsID", type = IdType.AUTO)
    private Integer neurologicalSymptomsId;

    @ApiModelProperty(value = "每日健康状态ID")
    private Integer statusId;

    @ApiModelProperty(value = "是否有儋妄", required = true, example = "false")
    private Boolean hasDelirium;

    @ApiModelProperty(value = "是否有抽搐", required = true, example = "true")
    private Boolean hasConvulsion;

    @ApiModelProperty(value = "是否有昏睡", required = true, example = "false")
    private Boolean hasDrowsiness;

    @ApiModelProperty(value = "是否有昏迷", required = true, example = "false")
    private Boolean hasComa;

    @ApiModelProperty(value = "是否有颈部强直", required = true, example = "false")
    private Boolean hasStiffNeck;

    @ApiModelProperty(value = "是否有烦躁不安", required = true, example = "true")
    private Boolean hasRestlessness;

    @ApiModelProperty(value = "是否有颈肩部肌肉迟缓性瘫痪", required = true, example = "false")
    private Boolean hasMuscleParalysisNeckShoulder;

    @ApiModelProperty(value = "是否有肢体肌肉迟缓性瘫痪", required = true, example = "true")
    private Boolean hasMuscleParalysisLimbs;

    @ApiModelProperty(value = "是否有吞咽困难", required = true, example = "false")
    private Boolean hasSwallowingDifficulty;

    @ApiModelProperty(value = "是否有语言障碍", required = true, example = "true")
    private Boolean hasSpeechDisorder;

    @ApiModelProperty(value = "是否有意识障碍或惊厥", required = true, example = "false")
    private Boolean hasConsciousnessDisorder;

    @ApiModelProperty(value = "是否有头晕", required = true, example = "true")
    private Boolean hasDizziness;

    @ApiModelProperty(value = "是否有耳鸣", required = true, example = "false")
    private Boolean hasTinnitus;

    @ApiModelProperty(value = "是否有听力减退", required = true, example = "false")
    private Boolean hasHearingLoss;

    public Integer getNeurologicalSymptomsId() {
        return neurologicalSymptomsId;
    }

    public void setNeurologicalSymptomsId(Integer neurologicalSymptomsId) {
        this.neurologicalSymptomsId = neurologicalSymptomsId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
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
