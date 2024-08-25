package com.infect.entity;

import java.math.BigDecimal;
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
 *
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("generalsymptoms")
@ApiModel(value="Generalsymptoms对象", description="")
public class Generalsymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "GeneralSymptomsID", type = IdType.AUTO)
    private Integer generalSymptomsId;

    private Integer statusId;

    private Boolean hasFever;

    private BigDecimal highestTemperature;

    private Integer feverDuration;

    private Boolean hasChills;

    private Boolean hasSweating;

    private Boolean hasFatigue;

    private Boolean hasHeadache;

    private Boolean hasMusclePain;

    private Boolean hasJointPain;

    private Boolean hasLymphNodeSwelling;

    private Boolean hasLymphNodeSwellingGroin;

    private Boolean hasLymphNodeSwellingArmpit;

    private Boolean hasLymphNodeSwellingSubclavian;

    private Boolean hasLymphNodeSwellingNeck;

    private Boolean hasLymphNodeSwellingElbow;

    private Boolean hasLymphNodeSwellingPopliteal;

    private Boolean hasCyanosis;

    private Boolean hasSubcutaneousAndMucosalBleedingSpots;

    private Boolean hasPainfulRedRash;

    private Boolean hasBloodBlisters;

    private Boolean hasSkinUlcer;

    private Boolean hasCongestiveOrPetechialRash;

    private Boolean hasDehydration;

    private String dehydration;

    private Boolean hasItchyRash;

    private Boolean itchyRashOnFingers;

    private Boolean itchyRashOnBackOfHands;

    private Boolean itchyRashOnUpperLimbs;

    private Boolean itchyRashOnLowerLimbs;

    private Boolean itchyRashOnFeet;

    private Boolean itchyRashOnFace;

    private Boolean itchyRashOnOther;

    private Boolean hasEdema;

    private Boolean hasNightSweats;

    private Boolean hasWeightLoss;

    private Boolean hasExhaustion;

}
