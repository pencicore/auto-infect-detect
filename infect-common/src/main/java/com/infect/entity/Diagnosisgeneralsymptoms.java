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
    private Integer DiagnosisGeneralSymptomID;

    private Integer DiagnosisResultsID;

    private Boolean HasFever;

    private BigDecimal HighestTemperature;

    private Integer FeverDuration;

    private Boolean HasChills;

    private Boolean HasSweating;

    private Boolean HasFatigue;

    private Boolean HasHeadache;

    private Boolean HasMusclePain;

    private Boolean HasJointPain;

    private Boolean HasLymphNodeSwelling;

    private Boolean HasLymphNodeSwellingGroin;

    private Boolean HasLymphNodeSwellingArmpit;

    private Boolean HasLymphNodeSwellingSubclavian;

    private Boolean HasLymphNodeSwellingNeck;

    private Boolean HasLymphNodeSwellingElbow;

    private Boolean HasLymphNodeSwellingPopliteal;

    private Boolean HasCyanosis;

    private Boolean HasSubcutaneousAndMucosalBleedingSpots;

    private Boolean HasSevereAnemia;

    private Boolean HasPainfulRedRash;

    private Boolean HasBloodBlisters;

    private Boolean HasSkinUlcer;

    private Boolean HasSubcutaneousAndMucosalBleedingCavity;

    private Boolean HasCongestiveOrPetechialRash;

    private Boolean HasDehydration;

    private String DehydrationSeverity;

    private Boolean HasItchyRash;

    private Boolean ItchyRashOnFingers;

    private Boolean ItchyRashOnBackOfHands;

    private Boolean ItchyRashOnUpperLimbs;

    private Boolean ItchyRashOnLowerLimbs;

    private Boolean ItchyRashOnFeet;

    private Boolean ItchyRashOnFace;

    private Boolean ItchyRashOnOther;

    private Boolean HasEdema;

    private Boolean HasNightSweats;

    private Boolean HasWeightLoss;

    private Boolean HasExhaustion;

    private Boolean HasWhiteBloodCells;

    private Boolean HasBloodPressureDrop;

    private Integer LowestBloodPressure;

    private Boolean HasShockSyndrome;

    private Boolean HasHighIntracranialPressure;

    private Boolean HasTurbidCerebrospinalFluid;

    private Boolean HasBleeding;

    private Integer BleedingVolume;

    private String BleedingCavity;

    private Boolean HasPlasmaLeakage;

    private Boolean HasOtherOrganDamage;

    private Boolean HasKernigSign;

    private Boolean HasBrudzinskiSign;


}
