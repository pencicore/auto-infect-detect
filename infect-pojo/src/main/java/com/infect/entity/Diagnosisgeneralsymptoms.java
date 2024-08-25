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
@TableName("diagnosisgeneralsymptoms")
@ApiModel(value="Diagnosisgeneralsymptoms对象", description="")
public class Diagnosisgeneralsymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisGeneralSymptomID", type = IdType.AUTO)
    private Integer diagnosisGeneralSymptomId;

    private Integer diagnosisResultsId;

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

    private Boolean hasSevereAnemia;

    private Boolean hasPainfulRedRash;

    private Boolean hasBloodBlisters;

    private Boolean hasSkinUlcer;

    private Boolean hasSubcutaneousAndMucosalBleedingCavity;

    private Boolean hasCongestiveOrPetechialRash;

    private Boolean hasDehydration;

    private String dehydrationSeverity;

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

    private Boolean hasWhiteBloodCells;

    private Boolean hasBloodPressureDrop;

    private Integer lowestBloodPressure;

    private Boolean hasShockSyndrome;

    private Boolean hasHighIntracranialPressure;

    private Boolean hasTurbidCerebrospinalFluid;

    private Boolean hasBleeding;

    private Integer bleedingVolume;

    private String bleedingCavity;

    private Boolean hasPlasmaLeakage;

    private Boolean hasOtherOrganDamage;

    private Boolean hasKernigSign;

    private Boolean hasBrudzinskiSign;
}
