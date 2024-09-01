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
 * 呼吸系统症状表
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
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
}
