package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * Diagnosisothersymptoms 实体类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("diagnosisothersymptoms")
@ApiModel(value = "Diagnosisothersymptoms对象", description = "诊断其他症状表")
public class Diagnosisothersymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "其他症状ID", hidden = true)
    @TableId(value = "DiagnosisOtherSymptomID", type = IdType.AUTO)
    private Integer diagnosisOtherSymptomId;

    @ApiModelProperty(value = "诊断结果ID", hidden = true)
    private Integer diagnosisResultsId;

    @ApiModelProperty(value = "是否突然发病", required = true, example = "true")
    private Boolean hasSuddenOnset;

    @ApiModelProperty(value = "是否病情进展迅速", required = true, example = "false")
    private Boolean hasRapidProgress;

    @ApiModelProperty(value = "是否周期性发作", required = true, example = "true")
    private Boolean hasPeriodicAttack;

    @ApiModelProperty(value = "是否强迫体位", required = true, example = "false")
    private Boolean hasForcedPosture;

    @ApiModelProperty(value = "是否腓肠肌疼痛", required = true, example = "true")
    private Boolean hasCalfMusclePain;

    @ApiModelProperty(value = "是否存在其他症状", required = true, example = "false")
    private Boolean hasOtherSymptoms;

    @ApiModelProperty(value = "其他症状", required = true, example = "头痛、恶心")
    private String otherSymptomsName;

    public Integer getDiagnosisOtherSymptomId() {
        return diagnosisOtherSymptomId;
    }

    public void setDiagnosisOtherSymptomId(Integer diagnosisOtherSymptomId) {
        this.diagnosisOtherSymptomId = diagnosisOtherSymptomId;
    }

    public Integer getDiagnosisResultsId() {
        return diagnosisResultsId;
    }

    public void setDiagnosisResultsId(Integer diagnosisResultsId) {
        this.diagnosisResultsId = diagnosisResultsId;
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
