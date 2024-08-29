package com.infect.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * <p>
 * 全身状况表
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("generalsymptoms")
@ApiModel(value="Generalsymptoms对象", description="全身状况表")
public class Generalsymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "GeneralSymptomsID", type = IdType.AUTO)
    @ApiModelProperty(value = "全身症状ID，自增")
    private Integer generalSymptomsId;

    @ApiModelProperty(value = "每日健康状态ID")
    private Integer statusId;

    @ApiModelProperty(value = "是否发热", required = true, example = "true")
    private Boolean hasFever;

    @ApiModelProperty(value = "最高体温", required = true, example = "38.5")
    private BigDecimal highestTemperature;

    @ApiModelProperty(value = "发热持续时间（小时）", required = true, example = "5")
    private Integer feverDuration;

    @ApiModelProperty(value = "是否寒战", required = true, example = "true")
    private Boolean hasChills;

    @ApiModelProperty(value = "是否大汗", required = true, example = "true")
    private Boolean hasSweating;

    @ApiModelProperty(value = "是否乏力", required = true, example = "true")
    private Boolean hasFatigue;

    @ApiModelProperty(value = "是否头痛", required = true, example = "true")
    private Boolean hasHeadache;

    @ApiModelProperty(value = "是否肌肉酸痛", required = true, example = "true")
    private Boolean hasMusclePain;

    @ApiModelProperty(value = "是否关节酸痛", required = true, example = "true")
    private Boolean hasJointPain;

    @ApiModelProperty(value = "是否淋巴结肿大", required = true, example = "true")
    private Boolean hasLymphNodeSwelling;

    @ApiModelProperty(value = "是否腹股沟淋巴结肿大", required = true, example = "true")
    private Boolean hasLymphNodeSwellingGroin;

    @ApiModelProperty(value = "是否腋下淋巴结肿大", required = true, example = "true")
    private Boolean hasLymphNodeSwellingArmpit;

    @ApiModelProperty(value = "是否锁骨下淋巴结肿大", required = true, example = "true")
    private Boolean hasLymphNodeSwellingSubclavian;

    @ApiModelProperty(value = "是否颈部淋巴结肿大", required = true, example = "true")
    private Boolean hasLymphNodeSwellingNeck;

    @ApiModelProperty(value = "是否肘部淋巴结肿大", required = true, example = "true")
    private Boolean hasLymphNodeSwellingElbow;

    @ApiModelProperty(value = "是否腘窝淋巴结肿大", required = true, example = "true")
    private Boolean hasLymphNodeSwellingPopliteal;

    @ApiModelProperty(value = "是否皮肤发绀", required = true, example = "true")
    private Boolean hasCyanosis;

    @ApiModelProperty(value = "是否皮下及黏膜出血或出血点", required = true, example = "true")
    private Boolean hasSubcutaneousAndMucosalBleedingSpots;

    @ApiModelProperty(value = "是否皮肤可见剧痛的红色丘疹", required = true, example = "true")
    private Boolean hasPainfulRedRash;

    @ApiModelProperty(value = "是否皮肤可见血性水泡", required = true, example = "true")
    private Boolean hasBloodBlisters;

    @ApiModelProperty(value = "是否皮肤溃疡", required = true, example = "true")
    private Boolean hasSkinUlcer;

    @ApiModelProperty(value = "是否充血性或点状出血疹", required = true, example = "true")
    private Boolean hasCongestiveOrPetechialRash;

    @ApiModelProperty(value = "是否脱水", required = true, example = "true")
    private Boolean hasDehydration;

    @ApiModelProperty(value = "脱水程度", required = true, allowableValues = "重度, 中度, 轻度", example = "中度")
    private String dehydration;

    @ApiModelProperty(value = "是否有瘙痒性斑丘疹/水疱", required = true, example = "true")
    private Boolean hasItchyRash;

    @ApiModelProperty(value = "手指瘙痒性斑丘疹/水疱", required = true, example = "true")
    private Boolean itchyRashOnFingers;

    @ApiModelProperty(value = "手背瘙痒性斑丘疹/水疱", required = true, example = "true")
    private Boolean itchyRashOnBackOfHands;

    @ApiModelProperty(value = "上肢瘙痒性斑丘疹/水疱", required = true, example = "true")
    private Boolean itchyRashOnUpperLimbs;

    @ApiModelProperty(value = "下肢瘙痒性斑丘疹/水疱", required = true, example = "true")
    private Boolean itchyRashOnLowerLimbs;

    @ApiModelProperty(value = "足背瘙痒性斑丘疹/水疱", required = true, example = "true")
    private Boolean itchyRashOnFeet;

    @ApiModelProperty(value = "面部瘙痒性斑丘疹/水疱", required = true, example = "true")
    private Boolean itchyRashOnFace;

    @ApiModelProperty(value = "其他部位瘙痒性斑丘疹/水疱", required = true, example = "true")
    private Boolean itchyRashOnOther;

    @ApiModelProperty(value = "是否水肿", required = true, example = "true")
    private Boolean hasEdema;

    @ApiModelProperty(value = "是否盗汗", required = true, example = "true")
    private Boolean hasNightSweats;

    @ApiModelProperty(value = "是否消瘦", required = true, example = "true")
    private Boolean hasWeightLoss;

    @ApiModelProperty(value = "是否虚脱/全身无力", required = true, example = "true")
    private Boolean hasExhaustion;
}
