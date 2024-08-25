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
    private Integer GeneralSymptomsID;

    private Integer StatusID;

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

    private Boolean hasSubcutaneousAndMucosalBleedingSpots;

    private Boolean HasPainfulRedRash;

    private Boolean HasBloodBlisters;

    private Boolean HasSkinUlcer;

    private Boolean HasCongestiveOrPetechialRash;

    private Boolean HasDehydration;

    private String Dehydration;

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


}
