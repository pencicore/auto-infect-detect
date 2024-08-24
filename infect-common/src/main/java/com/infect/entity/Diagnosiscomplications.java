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
    private Integer DiagnosisComplicationID;

    private Integer DiagnosisResultsID;

    private Boolean HasComplications;

    private Boolean HasViralPneumonia;

    private Boolean HasBacterialPneumonia;

    private Boolean HasFungalPneumonia;

    private Boolean HasRespiratoryFailure;

    private Boolean HasARDS;

    private Boolean HasDIC;

    private Boolean HasToxicShock;

    private Boolean HasMeningitis;

    private Boolean HasEncephalitis;

    private Boolean HasBacteremia;

    private Boolean HasMyocarditis;

    private Boolean HasAcuteLungInjury;

    private Boolean HasAcuteKidneyInjury;

    private Boolean HasEpilepsy;

    private Boolean HasToxicHepatitis;

    private Boolean HasFluidOverload;

    private Boolean HasSuperinfection;

    private Boolean HasHypoxemia;

    private Boolean HasSepticShock;

    private Boolean HasMetabolicAcidosis;

    private Boolean HasElectrolyteImbalance;

    private Boolean HasHemolysis;

    private Boolean HasGastrointestinalBleeding;

    private Boolean HasCoagulationDisorder;

    private Boolean HasMultipleOrganFailure;

    private Boolean HasBronchitis;

    private Boolean HasBronchopneumonia;

    private Boolean HasAnemia;

    private Boolean HasHepatosplenomegaly;

    private Boolean HasBrainEdema;

    private Boolean HasHUS;

    private Boolean HasHematemesis;

    private Boolean HasMelena;

    private Boolean HasHemoptysis;

    private Boolean HasAbdominalHemorrhage;

    private Boolean HasNasalBleeding;

    private Boolean HasVaginalBleeding;

    private Boolean HasHypertensiveEncephalopathy;

    private Boolean HasIntracranialHemorrhage;

    private Boolean HasPulmonaryEdema;

    private Boolean HasSecondaryInfection;

    private Boolean HasSpontaneousRenalRupture;

    private Boolean HasMyocardialDamage;

    private Boolean HasLiverDamage;

    private Boolean OtherComplications;

    private String OtherComplicationsName;


}
