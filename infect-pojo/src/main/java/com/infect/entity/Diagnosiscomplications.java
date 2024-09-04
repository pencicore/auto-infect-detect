package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * DiagnosisComplications 实体类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("diagnosiscomplications")
@ApiModel(value = "DiagnosisComplications对象", description = "诊断并发症表")
public class Diagnosiscomplications implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "并发症ID", hidden = true)
    @TableId(value = "DiagnosisComplicationID", type = IdType.AUTO)
    private Integer diagnosisComplicationId;

    @ApiModelProperty(value = "诊断结果ID", hidden = true)
    private Integer diagnosisResultsId;

    @ApiModelProperty(value = "是否有并发症", required = true, example = "true")
    private Boolean hasComplications;

    @ApiModelProperty(value = "是否病毒性肺炎", required = true, example = "false")
    private Boolean hasViralPneumonia;

    @ApiModelProperty(value = "是否细菌性肺炎", required = true, example = "true")
    private Boolean hasBacterialPneumonia;

    @ApiModelProperty(value = "是否真菌性肺炎", required = true, example = "false")
    private Boolean hasFungalPneumonia;

    @ApiModelProperty(value = "是否呼吸衰竭", required = true, example = "true")
    private Boolean hasRespiratoryFailure;

    @ApiModelProperty(value = "是否急性呼吸窘迫综合征 (ARDS)", required = true, example = "false")
    private Boolean hasArds;

    @ApiModelProperty(value = "是否弥散性血管内凝血 (DIC)", required = true, example = "true")
    private Boolean hasDic;

    @ApiModelProperty(value = "是否感染中毒性休克", required = true, example = "false")
    private Boolean hasToxicShock;

    @ApiModelProperty(value = "是否脑膜炎", required = true, example = "true")
    private Boolean hasMeningitis;

    @ApiModelProperty(value = "是否脑炎", required = true, example = "false")
    private Boolean hasEncephalitis;

    @ApiModelProperty(value = "是否菌血症", required = true, example = "true")
    private Boolean hasBacteremia;

    @ApiModelProperty(value = "是否心肌炎", required = true, example = "false")
    private Boolean hasMyocarditis;

    @ApiModelProperty(value = "是否急性肺损伤", required = true, example = "true")
    private Boolean hasAcuteLungInjury;

    @ApiModelProperty(value = "是否急性肾损伤", required = true, example = "false")
    private Boolean hasAcuteKidneyInjury;

    @ApiModelProperty(value = "是否癫痫", required = true, example = "true")
    private Boolean hasEpilepsy;

    @ApiModelProperty(value = "是否中毒性肝炎", required = true, example = "false")
    private Boolean hasToxicHepatitis;

    @ApiModelProperty(value = "是否输液过量", required = true, example = "true")
    private Boolean hasFluidOverload;

    @ApiModelProperty(value = "是否二重感染", required = true, example = "false")
    private Boolean hasSuperinfection;

    @ApiModelProperty(value = "是否低氧血症", required = true, example = "true")
    private Boolean hasHypoxemia;

    @ApiModelProperty(value = "是否脓毒症休克", required = true, example = "false")
    private Boolean hasSepticShock;

    @ApiModelProperty(value = "是否代谢性酸中毒", required = true, example = "true")
    private Boolean hasMetabolicAcidosis;

    @ApiModelProperty(value = "是否电解质及酸碱失衡", required = true, example = "false")
    private Boolean hasElectrolyteImbalance;

    @ApiModelProperty(value = "是否急性血管内溶血", required = true, example = "true")
    private Boolean hasHemolysis;

    @ApiModelProperty(value = "是否消化道出血", required = true, example = "false")
    private Boolean hasGastrointestinalBleeding;

    @ApiModelProperty(value = "是否凝血功能障碍", required = true, example = "true")
    private Boolean hasCoagulationDisorder;

    @ApiModelProperty(value = "是否多器官功能衰竭", required = true, example = "false")
    private Boolean hasMultipleOrganFailure;

    @ApiModelProperty(value = "是否支气管炎", required = true, example = "true")
    private Boolean hasBronchitis;

    @ApiModelProperty(value = "是否支气管肺炎", required = true, example = "false")
    private Boolean hasBronchopneumonia;

    @ApiModelProperty(value = "是否贫血", required = true, example = "true")
    private Boolean hasAnemia;

    @ApiModelProperty(value = "是否肝脾肿大", required = true, example = "false")
    private Boolean hasHepatosplenomegaly;

    @ApiModelProperty(value = "是否脑水肿", required = true, example = "true")
    private Boolean hasBrainEdema;

    @ApiModelProperty(value = "是否溶血性尿毒综合征", required = true, example = "false")
    private Boolean hasHus;

    @ApiModelProperty(value = "是否呕血", required = true, example = "true")
    private Boolean hasHematemesis;

    @ApiModelProperty(value = "是否便血", required = true, example = "false")
    private Boolean hasMelena;

    @ApiModelProperty(value = "是否咯血", required = true, example = "true")
    private Boolean hasHemoptysis;

    @ApiModelProperty(value = "是否腹腔出血", required = true, example = "false")
    private Boolean hasAbdominalHemorrhage;

    @ApiModelProperty(value = "是否鼻出血", required = true, example = "true")
    private Boolean hasNasalBleeding;

    @ApiModelProperty(value = "是否阴道出血", required = true, example = "false")
    private Boolean hasVaginalBleeding;

    @ApiModelProperty(value = "是否高血压脑病", required = true, example = "true")
    private Boolean hasHypertensiveEncephalopathy;

    @ApiModelProperty(value = "是否颅内出血", required = true, example = "false")
    private Boolean hasIntracranialHemorrhage;

    @ApiModelProperty(value = "是否肺水肿", required = true, example = "true")
    private Boolean hasPulmonaryEdema;

    @ApiModelProperty(value = "是否继发性感染", required = true, example = "false")
    private Boolean hasSecondaryInfection;

    @ApiModelProperty(value = "是否自发性肾破裂", required = true, example = "true")
    private Boolean hasSpontaneousRenalRupture;

    @ApiModelProperty(value = "是否心肌损害", required = true, example = "false")
    private Boolean hasMyocardialDamage;

    @ApiModelProperty(value = "是否肝损害", required = true, example = "true")
    private Boolean hasLiverDamage;

    @ApiModelProperty(value = "是否有其他并发症", required = true, example = "false")
    private Boolean otherComplications;

    @ApiModelProperty(value = "其他并发症名称", required = true, example = "其他症状描述")
    private String otherComplicationsName;

    public Integer getDiagnosisComplicationId() {
        return diagnosisComplicationId;
    }

    public void setDiagnosisComplicationId(Integer diagnosisComplicationId) {
        this.diagnosisComplicationId = diagnosisComplicationId;
    }

    public Integer getDiagnosisResultsId() {
        return diagnosisResultsId;
    }

    public void setDiagnosisResultsId(Integer diagnosisResultsId) {
        this.diagnosisResultsId = diagnosisResultsId;
    }

    public Boolean getHasComplications() {
        return hasComplications;
    }

    public void setHasComplications(Boolean hasComplications) {
        this.hasComplications = hasComplications;
    }

    public Boolean getHasViralPneumonia() {
        return hasViralPneumonia;
    }

    public void setHasViralPneumonia(Boolean hasViralPneumonia) {
        this.hasViralPneumonia = hasViralPneumonia;
    }

    public Boolean getHasBacterialPneumonia() {
        return hasBacterialPneumonia;
    }

    public void setHasBacterialPneumonia(Boolean hasBacterialPneumonia) {
        this.hasBacterialPneumonia = hasBacterialPneumonia;
    }

    public Boolean getHasFungalPneumonia() {
        return hasFungalPneumonia;
    }

    public void setHasFungalPneumonia(Boolean hasFungalPneumonia) {
        this.hasFungalPneumonia = hasFungalPneumonia;
    }

    public Boolean getHasRespiratoryFailure() {
        return hasRespiratoryFailure;
    }

    public void setHasRespiratoryFailure(Boolean hasRespiratoryFailure) {
        this.hasRespiratoryFailure = hasRespiratoryFailure;
    }

    public Boolean getHasArds() {
        return hasArds;
    }

    public void setHasArds(Boolean hasArds) {
        this.hasArds = hasArds;
    }

    public Boolean getHasDic() {
        return hasDic;
    }

    public void setHasDic(Boolean hasDic) {
        this.hasDic = hasDic;
    }

    public Boolean getHasToxicShock() {
        return hasToxicShock;
    }

    public void setHasToxicShock(Boolean hasToxicShock) {
        this.hasToxicShock = hasToxicShock;
    }

    public Boolean getHasMeningitis() {
        return hasMeningitis;
    }

    public void setHasMeningitis(Boolean hasMeningitis) {
        this.hasMeningitis = hasMeningitis;
    }

    public Boolean getHasEncephalitis() {
        return hasEncephalitis;
    }

    public void setHasEncephalitis(Boolean hasEncephalitis) {
        this.hasEncephalitis = hasEncephalitis;
    }

    public Boolean getHasBacteremia() {
        return hasBacteremia;
    }

    public void setHasBacteremia(Boolean hasBacteremia) {
        this.hasBacteremia = hasBacteremia;
    }

    public Boolean getHasMyocarditis() {
        return hasMyocarditis;
    }

    public void setHasMyocarditis(Boolean hasMyocarditis) {
        this.hasMyocarditis = hasMyocarditis;
    }

    public Boolean getHasAcuteLungInjury() {
        return hasAcuteLungInjury;
    }

    public void setHasAcuteLungInjury(Boolean hasAcuteLungInjury) {
        this.hasAcuteLungInjury = hasAcuteLungInjury;
    }

    public Boolean getHasAcuteKidneyInjury() {
        return hasAcuteKidneyInjury;
    }

    public void setHasAcuteKidneyInjury(Boolean hasAcuteKidneyInjury) {
        this.hasAcuteKidneyInjury = hasAcuteKidneyInjury;
    }

    public Boolean getHasEpilepsy() {
        return hasEpilepsy;
    }

    public void setHasEpilepsy(Boolean hasEpilepsy) {
        this.hasEpilepsy = hasEpilepsy;
    }

    public Boolean getHasToxicHepatitis() {
        return hasToxicHepatitis;
    }

    public void setHasToxicHepatitis(Boolean hasToxicHepatitis) {
        this.hasToxicHepatitis = hasToxicHepatitis;
    }

    public Boolean getHasFluidOverload() {
        return hasFluidOverload;
    }

    public void setHasFluidOverload(Boolean hasFluidOverload) {
        this.hasFluidOverload = hasFluidOverload;
    }

    public Boolean getHasSuperinfection() {
        return hasSuperinfection;
    }

    public void setHasSuperinfection(Boolean hasSuperinfection) {
        this.hasSuperinfection = hasSuperinfection;
    }

    public Boolean getHasHypoxemia() {
        return hasHypoxemia;
    }

    public void setHasHypoxemia(Boolean hasHypoxemia) {
        this.hasHypoxemia = hasHypoxemia;
    }

    public Boolean getHasSepticShock() {
        return hasSepticShock;
    }

    public void setHasSepticShock(Boolean hasSepticShock) {
        this.hasSepticShock = hasSepticShock;
    }

    public Boolean getHasMetabolicAcidosis() {
        return hasMetabolicAcidosis;
    }

    public void setHasMetabolicAcidosis(Boolean hasMetabolicAcidosis) {
        this.hasMetabolicAcidosis = hasMetabolicAcidosis;
    }

    public Boolean getHasElectrolyteImbalance() {
        return hasElectrolyteImbalance;
    }

    public void setHasElectrolyteImbalance(Boolean hasElectrolyteImbalance) {
        this.hasElectrolyteImbalance = hasElectrolyteImbalance;
    }

    public Boolean getHasHemolysis() {
        return hasHemolysis;
    }

    public void setHasHemolysis(Boolean hasHemolysis) {
        this.hasHemolysis = hasHemolysis;
    }

    public Boolean getHasGastrointestinalBleeding() {
        return hasGastrointestinalBleeding;
    }

    public void setHasGastrointestinalBleeding(Boolean hasGastrointestinalBleeding) {
        this.hasGastrointestinalBleeding = hasGastrointestinalBleeding;
    }

    public Boolean getHasCoagulationDisorder() {
        return hasCoagulationDisorder;
    }

    public void setHasCoagulationDisorder(Boolean hasCoagulationDisorder) {
        this.hasCoagulationDisorder = hasCoagulationDisorder;
    }

    public Boolean getHasMultipleOrganFailure() {
        return hasMultipleOrganFailure;
    }

    public void setHasMultipleOrganFailure(Boolean hasMultipleOrganFailure) {
        this.hasMultipleOrganFailure = hasMultipleOrganFailure;
    }

    public Boolean getHasBronchitis() {
        return hasBronchitis;
    }

    public void setHasBronchitis(Boolean hasBronchitis) {
        this.hasBronchitis = hasBronchitis;
    }

    public Boolean getHasBronchopneumonia() {
        return hasBronchopneumonia;
    }

    public void setHasBronchopneumonia(Boolean hasBronchopneumonia) {
        this.hasBronchopneumonia = hasBronchopneumonia;
    }

    public Boolean getHasAnemia() {
        return hasAnemia;
    }

    public void setHasAnemia(Boolean hasAnemia) {
        this.hasAnemia = hasAnemia;
    }

    public Boolean getHasHepatosplenomegaly() {
        return hasHepatosplenomegaly;
    }

    public void setHasHepatosplenomegaly(Boolean hasHepatosplenomegaly) {
        this.hasHepatosplenomegaly = hasHepatosplenomegaly;
    }

    public Boolean getHasBrainEdema() {
        return hasBrainEdema;
    }

    public void setHasBrainEdema(Boolean hasBrainEdema) {
        this.hasBrainEdema = hasBrainEdema;
    }

    public Boolean getHasHus() {
        return hasHus;
    }

    public void setHasHus(Boolean hasHus) {
        this.hasHus = hasHus;
    }

    public Boolean getHasHematemesis() {
        return hasHematemesis;
    }

    public void setHasHematemesis(Boolean hasHematemesis) {
        this.hasHematemesis = hasHematemesis;
    }

    public Boolean getHasMelena() {
        return hasMelena;
    }

    public void setHasMelena(Boolean hasMelena) {
        this.hasMelena = hasMelena;
    }

    public Boolean getHasHemoptysis() {
        return hasHemoptysis;
    }

    public void setHasHemoptysis(Boolean hasHemoptysis) {
        this.hasHemoptysis = hasHemoptysis;
    }

    public Boolean getHasAbdominalHemorrhage() {
        return hasAbdominalHemorrhage;
    }

    public void setHasAbdominalHemorrhage(Boolean hasAbdominalHemorrhage) {
        this.hasAbdominalHemorrhage = hasAbdominalHemorrhage;
    }

    public Boolean getHasNasalBleeding() {
        return hasNasalBleeding;
    }

    public void setHasNasalBleeding(Boolean hasNasalBleeding) {
        this.hasNasalBleeding = hasNasalBleeding;
    }

    public Boolean getHasVaginalBleeding() {
        return hasVaginalBleeding;
    }

    public void setHasVaginalBleeding(Boolean hasVaginalBleeding) {
        this.hasVaginalBleeding = hasVaginalBleeding;
    }

    public Boolean getHasHypertensiveEncephalopathy() {
        return hasHypertensiveEncephalopathy;
    }

    public void setHasHypertensiveEncephalopathy(Boolean hasHypertensiveEncephalopathy) {
        this.hasHypertensiveEncephalopathy = hasHypertensiveEncephalopathy;
    }

    public Boolean getHasIntracranialHemorrhage() {
        return hasIntracranialHemorrhage;
    }

    public void setHasIntracranialHemorrhage(Boolean hasIntracranialHemorrhage) {
        this.hasIntracranialHemorrhage = hasIntracranialHemorrhage;
    }

    public Boolean getHasPulmonaryEdema() {
        return hasPulmonaryEdema;
    }

    public void setHasPulmonaryEdema(Boolean hasPulmonaryEdema) {
        this.hasPulmonaryEdema = hasPulmonaryEdema;
    }

    public Boolean getHasSecondaryInfection() {
        return hasSecondaryInfection;
    }

    public void setHasSecondaryInfection(Boolean hasSecondaryInfection) {
        this.hasSecondaryInfection = hasSecondaryInfection;
    }

    public Boolean getHasSpontaneousRenalRupture() {
        return hasSpontaneousRenalRupture;
    }

    public void setHasSpontaneousRenalRupture(Boolean hasSpontaneousRenalRupture) {
        this.hasSpontaneousRenalRupture = hasSpontaneousRenalRupture;
    }

    public Boolean getHasMyocardialDamage() {
        return hasMyocardialDamage;
    }

    public void setHasMyocardialDamage(Boolean hasMyocardialDamage) {
        this.hasMyocardialDamage = hasMyocardialDamage;
    }

    public Boolean getHasLiverDamage() {
        return hasLiverDamage;
    }

    public void setHasLiverDamage(Boolean hasLiverDamage) {
        this.hasLiverDamage = hasLiverDamage;
    }

    public Boolean getOtherComplications() {
        return otherComplications;
    }

    public void setOtherComplications(Boolean otherComplications) {
        this.otherComplications = otherComplications;
    }

    public String getOtherComplicationsName() {
        return otherComplicationsName;
    }

    public void setOtherComplicationsName(String otherComplicationsName) {
        this.otherComplicationsName = otherComplicationsName;
    }
}
