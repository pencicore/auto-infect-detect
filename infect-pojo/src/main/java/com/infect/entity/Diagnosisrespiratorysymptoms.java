package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 诊断呼吸系统症状实体类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("diagnosisrespiratorysymptoms")
@ApiModel(value = "Diagnosisrespiratorysymptoms对象", description = "诊断呼吸系统症状")
public class Diagnosisrespiratorysymptoms implements Serializable {

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
}
