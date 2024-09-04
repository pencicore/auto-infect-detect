package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * Diagnosislocalsymptoms 实体类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("diagnosislocalsymptoms")
@ApiModel(value = "Diagnosislocalsymptoms对象", description = "诊断局部症状表")
public class Diagnosislocalsymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "局部症状ID", hidden = true)
    @TableId(value = "DiagnosisLocalSymptomID", type = IdType.AUTO)
    private Integer diagnosisLocalSymptomId;

    @ApiModelProperty(value = "诊断结果ID", hidden = true)
    private Integer diagnosisResultsId;

    @ApiModelProperty(value = "是否结膜炎", required = true, example = "false")
    private Boolean hasConjunctivitis;

    @ApiModelProperty(value = "是否眼结膜充血、肿胀疼痛", required = true, example = "true")
    private Boolean hasConjunctivalCongestion;

    @ApiModelProperty(value = "是否上下眼睑水肿", required = true, example = "false")
    private Boolean hasEyelidEdema;

    @ApiModelProperty(value = "是否嗅觉味觉减退或丧失", required = true, example = "true")
    private Boolean hasSmellTasteLoss;

    @ApiModelProperty(value = "是否颜面潮红或苍白", required = true, example = "false")
    private Boolean hasFacialRednessOrPallor;

    @ApiModelProperty(value = "是否潮红（颈部、胸部）", required = true, example = "true")
    private Boolean hasRednessNeckChest;

    @ApiModelProperty(value = "是否口唇发绀", required = true, example = "false")
    private Boolean hasLipCyanosis;

    @ApiModelProperty(value = "是否皮肤苍白或带青紫", required = true, example = "true")
    private Boolean hasSkinPallorOrBruising;

    @ApiModelProperty(value = "是否牙龈出血", required = true, example = "false")
    private Boolean hasGumBleeding;

    @ApiModelProperty(value = "是否肾区疼痛", required = true, example = "true")
    private Boolean hasKidneyPain;

    @ApiModelProperty(value = "是否腰痛", required = true, example = "false")
    private Boolean hasLowBackPain;

    @ApiModelProperty(value = "是否眼眶痛", required = true, example = "true")
    private Boolean hasOrbitalPain;

    @ApiModelProperty(value = "是否肝肿大", required = true, example = "false")
    private Boolean hasHepatomegaly;

    @ApiModelProperty(value = "是否脾肿大", required = true, example = "true")
    private Boolean hasSplenomegaly;

    @ApiModelProperty(value = "是否口腔、鼻腔等处黏膜有出血点", required = true, example = "false")
    private Boolean hasMucosalBleedingInOralOrNasal;

    @ApiModelProperty(value = "是否腋下/上臂/胸部或其他部位有皮肤出血点", required = true, example = "true")
    private Boolean hasSkinBleedingPoints;

    public Integer getDiagnosisLocalSymptomId() {
        return diagnosisLocalSymptomId;
    }

    public void setDiagnosisLocalSymptomId(Integer diagnosisLocalSymptomId) {
        this.diagnosisLocalSymptomId = diagnosisLocalSymptomId;
    }

    public Integer getDiagnosisResultsId() {
        return diagnosisResultsId;
    }

    public void setDiagnosisResultsId(Integer diagnosisResultsId) {
        this.diagnosisResultsId = diagnosisResultsId;
    }

    public Boolean getHasConjunctivitis() {
        return hasConjunctivitis;
    }

    public void setHasConjunctivitis(Boolean hasConjunctivitis) {
        this.hasConjunctivitis = hasConjunctivitis;
    }

    public Boolean getHasConjunctivalCongestion() {
        return hasConjunctivalCongestion;
    }

    public void setHasConjunctivalCongestion(Boolean hasConjunctivalCongestion) {
        this.hasConjunctivalCongestion = hasConjunctivalCongestion;
    }

    public Boolean getHasEyelidEdema() {
        return hasEyelidEdema;
    }

    public void setHasEyelidEdema(Boolean hasEyelidEdema) {
        this.hasEyelidEdema = hasEyelidEdema;
    }

    public Boolean getHasSmellTasteLoss() {
        return hasSmellTasteLoss;
    }

    public void setHasSmellTasteLoss(Boolean hasSmellTasteLoss) {
        this.hasSmellTasteLoss = hasSmellTasteLoss;
    }

    public Boolean getHasFacialRednessOrPallor() {
        return hasFacialRednessOrPallor;
    }

    public void setHasFacialRednessOrPallor(Boolean hasFacialRednessOrPallor) {
        this.hasFacialRednessOrPallor = hasFacialRednessOrPallor;
    }

    public Boolean getHasRednessNeckChest() {
        return hasRednessNeckChest;
    }

    public void setHasRednessNeckChest(Boolean hasRednessNeckChest) {
        this.hasRednessNeckChest = hasRednessNeckChest;
    }

    public Boolean getHasLipCyanosis() {
        return hasLipCyanosis;
    }

    public void setHasLipCyanosis(Boolean hasLipCyanosis) {
        this.hasLipCyanosis = hasLipCyanosis;
    }

    public Boolean getHasSkinPallorOrBruising() {
        return hasSkinPallorOrBruising;
    }

    public void setHasSkinPallorOrBruising(Boolean hasSkinPallorOrBruising) {
        this.hasSkinPallorOrBruising = hasSkinPallorOrBruising;
    }

    public Boolean getHasGumBleeding() {
        return hasGumBleeding;
    }

    public void setHasGumBleeding(Boolean hasGumBleeding) {
        this.hasGumBleeding = hasGumBleeding;
    }

    public Boolean getHasKidneyPain() {
        return hasKidneyPain;
    }

    public void setHasKidneyPain(Boolean hasKidneyPain) {
        this.hasKidneyPain = hasKidneyPain;
    }

    public Boolean getHasLowBackPain() {
        return hasLowBackPain;
    }

    public void setHasLowBackPain(Boolean hasLowBackPain) {
        this.hasLowBackPain = hasLowBackPain;
    }

    public Boolean getHasOrbitalPain() {
        return hasOrbitalPain;
    }

    public void setHasOrbitalPain(Boolean hasOrbitalPain) {
        this.hasOrbitalPain = hasOrbitalPain;
    }

    public Boolean getHasHepatomegaly() {
        return hasHepatomegaly;
    }

    public void setHasHepatomegaly(Boolean hasHepatomegaly) {
        this.hasHepatomegaly = hasHepatomegaly;
    }

    public Boolean getHasSplenomegaly() {
        return hasSplenomegaly;
    }

    public void setHasSplenomegaly(Boolean hasSplenomegaly) {
        this.hasSplenomegaly = hasSplenomegaly;
    }

    public Boolean getHasMucosalBleedingInOralOrNasal() {
        return hasMucosalBleedingInOralOrNasal;
    }

    public void setHasMucosalBleedingInOralOrNasal(Boolean hasMucosalBleedingInOralOrNasal) {
        this.hasMucosalBleedingInOralOrNasal = hasMucosalBleedingInOralOrNasal;
    }

    public Boolean getHasSkinBleedingPoints() {
        return hasSkinBleedingPoints;
    }

    public void setHasSkinBleedingPoints(Boolean hasSkinBleedingPoints) {
        this.hasSkinBleedingPoints = hasSkinBleedingPoints;
    }
}
