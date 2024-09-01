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
 * 诊断神经系统症状实体类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("diagnosisneurologicalsymptoms")
@ApiModel(value = "Diagnosisneurologicalsymptoms对象", description = "诊断神经系统症状")
public class Diagnosisneurologicalsymptoms implements Serializable {

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
}
