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
 *
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("diagnosiscomplications")
@ApiModel(value="Diagnosiscomplications对象", description="")
public class Diagnosiscomplications implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisComplicationID", type = IdType.AUTO)
    private Integer diagnosisComplicationId;

    private Integer diagnosisResultsId;

    private Boolean hasComplications;

    private Boolean hasViralPneumonia;

    private Boolean hasBacterialPneumonia;

    private Boolean hasFungalPneumonia;

    private Boolean hasRespiratoryFailure;

    private Boolean hasArds;

    private Boolean hasDic;

    private Boolean hasToxicShock;

    private Boolean hasMeningitis;

    private Boolean hasEncephalitis;

    private Boolean hasBacteremia;

    private Boolean hasMyocarditis;

    private Boolean hasAcuteLungInjury;

    private Boolean hasAcuteKidneyInjury;

    private Boolean hasEpilepsy;

    private Boolean hasToxicHepatitis;

    private Boolean hasFluidOverload;

    private Boolean hasSuperinfection;

    private Boolean hasHypoxemia;

    private Boolean hasSepticShock;

    private Boolean hasMetabolicAcidosis;

    private Boolean hasElectrolyteImbalance;

    private Boolean hasHemolysis;

    private Boolean hasGastrointestinalBleeding;

    private Boolean hasCoagulationDisorder;

    private Boolean hasMultipleOrganFailure;

    private Boolean hasBronchitis;

    private Boolean hasBronchopneumonia;

    private Boolean hasAnemia;

    private Boolean hasHepatosplenomegaly;

    private Boolean hasBrainEdema;

    private Boolean hasHus;

    private Boolean hasHematemesis;

    private Boolean hasMelena;

    private Boolean hasHemoptysis;

    private Boolean hasAbdominalHemorrhage;

    private Boolean hasNasalBleeding;

    private Boolean hasVaginalBleeding;

    private Boolean hasHypertensiveEncephalopathy;

    private Boolean hasIntracranialHemorrhage;

    private Boolean hasPulmonaryEdema;

    private Boolean hasSecondaryInfection;

    private Boolean hasSpontaneousRenalRupture;

    private Boolean hasMyocardialDamage;

    private Boolean hasLiverDamage;

    private Boolean otherComplications;

    private String otherComplicationsName;
}