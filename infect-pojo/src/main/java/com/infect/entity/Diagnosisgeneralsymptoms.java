package com.infect.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@TableName("diagnosisgeneralsymptoms")
@ApiModel(value = "DiagnosisGeneralSymptoms对象", description = "诊断全身症状表")
public class Diagnosisgeneralsymptoms implements Serializable {
    public Diagnosisgeneralsymptoms() {
    }

    public Diagnosisgeneralsymptoms(Integer diagnosisGeneralSymptomId, Integer diagnosisResultsId, Boolean hasFever, BigDecimal highestTemperature, Integer feverDuration, Boolean hasChills, Boolean hasSweating, Boolean hasFatigue, Boolean hasHeadache, Boolean hasMusclePain, Boolean hasJointPain, Boolean hasLymphNodeSwelling, Boolean hasLymphNodeSwellingGroin, Boolean hasLymphNodeSwellingArmpit, Boolean hasLymphNodeSwellingSubclavian, Boolean hasLymphNodeSwellingNeck, Boolean hasLymphNodeSwellingElbow, Boolean hasLymphNodeSwellingPopliteal, Boolean hasCyanosis, Boolean hasSubcutaneousAndMucosalBleedingSpots, Boolean hasSevereAnemia, Boolean hasPainfulRedRash, Boolean hasBloodBlisters, Boolean hasSkinUlcer, Boolean hasSubcutaneousAndMucosalBleedingCavity, Boolean hasCongestiveOrPetechialRash, Boolean hasPressureInsensitiveRash, Boolean hasDehydration, String dehydrationSeverity, Boolean hasItchyRash, Boolean itchyRashOnFingers, Boolean itchyRashOnBackOfHands, Boolean itchyRashOnUpperLimbs, Boolean itchyRashOnLowerLimbs, Boolean itchyRashOnFeet, Boolean itchyRashOnFace, Boolean itchyRashOnOther, Boolean hasEdema, Boolean hasNightSweats, Boolean hasWeightLoss, Boolean hasExhaustion, Boolean hasWhiteBloodCells, Boolean hasBloodPressureDrop, Integer lowestBloodPressure, Boolean hasShockSyndrome, Boolean hasHighIntracranialPressure, Boolean hasTurbidCerebrospinalFluid, Boolean hasBleeding, Integer bleedingVolume, String bleedingCavity, Boolean hasPlasmaLeakage, Boolean hasOtherOrganDamage, Boolean hasKernigSign, Boolean hasBrudzinskiSign) {
        this.diagnosisGeneralSymptomId = diagnosisGeneralSymptomId;
        this.diagnosisResultsId = diagnosisResultsId;
        this.hasFever = hasFever;
        this.highestTemperature = highestTemperature;
        this.feverDuration = feverDuration;
        this.hasChills = hasChills;
        this.hasSweating = hasSweating;
        this.hasFatigue = hasFatigue;
        this.hasHeadache = hasHeadache;
        this.hasMusclePain = hasMusclePain;
        this.hasJointPain = hasJointPain;
        this.hasLymphNodeSwelling = hasLymphNodeSwelling;
        this.hasLymphNodeSwellingGroin = hasLymphNodeSwellingGroin;
        this.hasLymphNodeSwellingArmpit = hasLymphNodeSwellingArmpit;
        this.hasLymphNodeSwellingSubclavian = hasLymphNodeSwellingSubclavian;
        this.hasLymphNodeSwellingNeck = hasLymphNodeSwellingNeck;
        this.hasLymphNodeSwellingElbow = hasLymphNodeSwellingElbow;
        this.hasLymphNodeSwellingPopliteal = hasLymphNodeSwellingPopliteal;
        this.hasCyanosis = hasCyanosis;
        this.hasSubcutaneousAndMucosalBleedingSpots = hasSubcutaneousAndMucosalBleedingSpots;
        this.hasSevereAnemia = hasSevereAnemia;
        this.hasPainfulRedRash = hasPainfulRedRash;
        this.hasBloodBlisters = hasBloodBlisters;
        this.hasSkinUlcer = hasSkinUlcer;
        this.hasSubcutaneousAndMucosalBleedingCavity = hasSubcutaneousAndMucosalBleedingCavity;
        this.hasCongestiveOrPetechialRash = hasCongestiveOrPetechialRash;
        this.hasPressureInsensitiveRash = hasPressureInsensitiveRash;
        this.hasDehydration = hasDehydration;
        this.dehydrationSeverity = dehydrationSeverity;
        this.hasItchyRash = hasItchyRash;
        this.itchyRashOnFingers = itchyRashOnFingers;
        this.itchyRashOnBackOfHands = itchyRashOnBackOfHands;
        this.itchyRashOnUpperLimbs = itchyRashOnUpperLimbs;
        this.itchyRashOnLowerLimbs = itchyRashOnLowerLimbs;
        this.itchyRashOnFeet = itchyRashOnFeet;
        this.itchyRashOnFace = itchyRashOnFace;
        this.itchyRashOnOther = itchyRashOnOther;
        this.hasEdema = hasEdema;
        this.hasNightSweats = hasNightSweats;
        this.hasWeightLoss = hasWeightLoss;
        this.hasExhaustion = hasExhaustion;
        this.hasWhiteBloodCells = hasWhiteBloodCells;
        this.hasBloodPressureDrop = hasBloodPressureDrop;
        this.lowestBloodPressure = lowestBloodPressure;
        this.hasShockSyndrome = hasShockSyndrome;
        this.hasHighIntracranialPressure = hasHighIntracranialPressure;
        this.hasTurbidCerebrospinalFluid = hasTurbidCerebrospinalFluid;
        this.hasBleeding = hasBleeding;
        this.bleedingVolume = bleedingVolume;
        this.bleedingCavity = bleedingCavity;
        this.hasPlasmaLeakage = hasPlasmaLeakage;
        this.hasOtherOrganDamage = hasOtherOrganDamage;
        this.hasKernigSign = hasKernigSign;
        this.hasBrudzinskiSign = hasBrudzinskiSign;
    }

    @Override
    public String toString() {
        return "Diagnosisgeneralsymptoms{" +
                "diagnosisGeneralSymptomId=" + diagnosisGeneralSymptomId +
                ", diagnosisResultsId=" + diagnosisResultsId +
                ", hasFever=" + hasFever +
                ", highestTemperature=" + highestTemperature +
                ", feverDuration=" + feverDuration +
                ", hasChills=" + hasChills +
                ", hasSweating=" + hasSweating +
                ", hasFatigue=" + hasFatigue +
                ", hasHeadache=" + hasHeadache +
                ", hasMusclePain=" + hasMusclePain +
                ", hasJointPain=" + hasJointPain +
                ", hasLymphNodeSwelling=" + hasLymphNodeSwelling +
                ", hasLymphNodeSwellingGroin=" + hasLymphNodeSwellingGroin +
                ", hasLymphNodeSwellingArmpit=" + hasLymphNodeSwellingArmpit +
                ", hasLymphNodeSwellingSubclavian=" + hasLymphNodeSwellingSubclavian +
                ", hasLymphNodeSwellingNeck=" + hasLymphNodeSwellingNeck +
                ", hasLymphNodeSwellingElbow=" + hasLymphNodeSwellingElbow +
                ", hasLymphNodeSwellingPopliteal=" + hasLymphNodeSwellingPopliteal +
                ", hasCyanosis=" + hasCyanosis +
                ", hasSubcutaneousAndMucosalBleedingSpots=" + hasSubcutaneousAndMucosalBleedingSpots +
                ", hasSevereAnemia=" + hasSevereAnemia +
                ", hasPainfulRedRash=" + hasPainfulRedRash +
                ", hasBloodBlisters=" + hasBloodBlisters +
                ", hasSkinUlcer=" + hasSkinUlcer +
                ", hasSubcutaneousAndMucosalBleedingCavity=" + hasSubcutaneousAndMucosalBleedingCavity +
                ", hasCongestiveOrPetechialRash=" + hasCongestiveOrPetechialRash +
                ", hasDehydration=" + hasDehydration +
                ", dehydrationSeverity='" + dehydrationSeverity + '\'' +
                ", hasItchyRash=" + hasItchyRash +
                ", itchyRashOnFingers=" + itchyRashOnFingers +
                ", itchyRashOnBackOfHands=" + itchyRashOnBackOfHands +
                ", itchyRashOnUpperLimbs=" + itchyRashOnUpperLimbs +
                ", itchyRashOnLowerLimbs=" + itchyRashOnLowerLimbs +
                ", itchyRashOnFeet=" + itchyRashOnFeet +
                ", itchyRashOnFace=" + itchyRashOnFace +
                ", itchyRashOnOther=" + itchyRashOnOther +
                ", hasEdema=" + hasEdema +
                ", hasNightSweats=" + hasNightSweats +
                ", hasWeightLoss=" + hasWeightLoss +
                ", hasExhaustion=" + hasExhaustion +
                ", hasWhiteBloodCells=" + hasWhiteBloodCells +
                ", hasBloodPressureDrop=" + hasBloodPressureDrop +
                ", lowestBloodPressure=" + lowestBloodPressure +
                ", hasShockSyndrome=" + hasShockSyndrome +
                ", hasHighIntracranialPressure=" + hasHighIntracranialPressure +
                ", hasTurbidCerebrospinalFluid=" + hasTurbidCerebrospinalFluid +
                ", hasBleeding=" + hasBleeding +
                ", bleedingVolume=" + bleedingVolume +
                ", bleedingCavity='" + bleedingCavity + '\'' +
                ", hasPlasmaLeakage=" + hasPlasmaLeakage +
                ", hasOtherOrganDamage=" + hasOtherOrganDamage +
                ", hasKernigSign=" + hasKernigSign +
                ", hasBrudzinskiSign=" + hasBrudzinskiSign +
                '}';
    }

    @ApiModelProperty(value = "全身症状ID", hidden = true)
    @TableId(value = "DiagnosisGeneralSymptomID", type = IdType.AUTO)
    private Integer diagnosisGeneralSymptomId;

    @ApiModelProperty(value = "诊断结果ID，关联DiagnosisResults表", hidden = true)
    private Integer diagnosisResultsId;

    @ApiModelProperty(value = "是否发热", example = "true", required = true)
    private Boolean hasFever;

    @ApiModelProperty(value = "最高体温（℃）", example = "39.5", required = true)
    private BigDecimal highestTemperature;

    @ApiModelProperty(value = "发热持续时间（小时）", example = "48", required = true)
    private Integer feverDuration;

    @ApiModelProperty(value = "是否寒战", example = "false", required = true)
    private Boolean hasChills;

    @ApiModelProperty(value = "是否大汗", example = "true", required = true)
    private Boolean hasSweating;

    @ApiModelProperty(value = "是否乏力", example = "true", required = true)
    private Boolean hasFatigue;

    @ApiModelProperty(value = "是否头痛", example = "false", required = true)
    private Boolean hasHeadache;

    @ApiModelProperty(value = "是否肌肉酸痛", example = "true", required = true)
    private Boolean hasMusclePain;

    @ApiModelProperty(value = "是否关节酸痛", example = "true", required = true)
    private Boolean hasJointPain;

    @ApiModelProperty(value = "是否淋巴结肿大", example = "false", required = true)
    private Boolean hasLymphNodeSwelling;

    @ApiModelProperty(value = "腹股沟淋巴结肿大", example = "false", required = true)
    private Boolean hasLymphNodeSwellingGroin;

    @ApiModelProperty(value = "腋下淋巴结肿大", example = "true", required = true)
    private Boolean hasLymphNodeSwellingArmpit;

    @ApiModelProperty(value = "锁骨下淋巴结肿大", example = "false", required = true)
    private Boolean hasLymphNodeSwellingSubclavian;

    @ApiModelProperty(value = "颈部淋巴结肿大", example = "true", required = true)
    private Boolean hasLymphNodeSwellingNeck;

    @ApiModelProperty(value = "肘部淋巴结肿大", example = "false", required = true)
    private Boolean hasLymphNodeSwellingElbow;

    @ApiModelProperty(value = "腘窝淋巴结肿大", example = "true", required = true)
    private Boolean hasLymphNodeSwellingPopliteal;

    @ApiModelProperty(value = "是否口唇、颜面、四肢及全身皮肤发绀", example = "false", required = true)
    private Boolean hasCyanosis;

    @ApiModelProperty(value = "是否皮下及黏膜出血或出血点", example = "true", required = true)
    private Boolean hasSubcutaneousAndMucosalBleedingSpots;

    @ApiModelProperty(value = "是否严重贫血", example = "false", required = true)
    private Boolean hasSevereAnemia;

    @ApiModelProperty(value = "是否皮肤可见剧痛的红色丘疹", example = "true", required = true)
    private Boolean hasPainfulRedRash;

    @ApiModelProperty(value = "是否皮肤可见周边呈灰黑色、基底坚硬的血性水泡", example = "false", required = true)
    private Boolean hasBloodBlisters;

    @ApiModelProperty(value = "是否皮肤出现呈灰黑色创面的溃疡", example = "true", required = true)
    private Boolean hasSkinUlcer;

    @ApiModelProperty(value = "是否皮下及黏膜出血腔道出血", example = "false", required = true)
    private Boolean hasSubcutaneousAndMucosalBleedingCavity;

    @ApiModelProperty(value = "皮疹：充血性或点状出血疹", example = "true", required = true)
    private Boolean hasCongestiveOrPetechialRash;

    @ApiModelProperty(value = "皮疹：起初压之退色，后期压之不退，多见于四肢、躯干，面部一般没有", example = "false")
    private Boolean hasPressureInsensitiveRash;

    @ApiModelProperty(value = "是否失水", example = "true", required = true)
    private Boolean hasDehydration;

    @ApiModelProperty(value = "失水程度", example = "中度", required = true)
    private String dehydrationSeverity;

    @ApiModelProperty(value = "是否瘙痒性斑丘疹/水疱", example = "true", required = true)
    private Boolean hasItchyRash;

    @ApiModelProperty(value = "手指瘙痒性斑丘疹/水疱", example = "false", required = true)
    private Boolean itchyRashOnFingers;

    @ApiModelProperty(value = "手背瘙痒性斑丘疹/水疱", example = "true", required = true)
    private Boolean itchyRashOnBackOfHands;

    @ApiModelProperty(value = "上肢瘙痒性斑丘疹/水疱", example = "true", required = true)
    private Boolean itchyRashOnUpperLimbs;

    @ApiModelProperty(value = "下肢瘙痒性斑丘疹/水疱", example = "false", required = true)
    private Boolean itchyRashOnLowerLimbs;

    @ApiModelProperty(value = "足背瘙痒性斑丘疹/水疱", example = "true", required = true)
    private Boolean itchyRashOnFeet;

    @ApiModelProperty(value = "面部瘙痒性斑丘疹/水疱", example = "false", required = true)
    private Boolean itchyRashOnFace;

    @ApiModelProperty(value = "其他部位瘙痒性斑丘疹/水疱", example = "true", required = true)
    private Boolean itchyRashOnOther;

    @ApiModelProperty(value = "是否水肿", example = "true", required = true)
    private Boolean hasEdema;

    @ApiModelProperty(value = "是否盗汗", example = "false", required = true)
    private Boolean hasNightSweats;

    @ApiModelProperty(value = "是否消瘦", example = "true", required = true)
    private Boolean hasWeightLoss;

    @ApiModelProperty(value = "是否虚脱/全身无力", example = "false", required = true)
    private Boolean hasExhaustion;

    @ApiModelProperty(value = "是否白细胞明显增高", example = "true", required = true)
    private Boolean hasWhiteBloodCells;

    @ApiModelProperty(value = "是否血压下降", example = "true", required = true)
    private Boolean hasBloodPressureDrop;

    @ApiModelProperty(value = "最低血压（mmHg）", example = "80", required = true)
    private Integer lowestBloodPressure;

    @ApiModelProperty(value = "是否休克症候群", example = "false", required = true)
    private Boolean hasShockSyndrome;

    @ApiModelProperty(value = "是否颅压高", example = "true", required = true)
    private Boolean hasHighIntracranialPressure;

    @ApiModelProperty(value = "是否脑脊液浊浑", example = "true", required = true)
    private Boolean hasTurbidCerebrospinalFluid;

    @ApiModelProperty(value = "是否出血", example = "false", required = true)
    private Boolean hasBleeding;

    @ApiModelProperty(value = "出血量（ml）", example = "500", required = true)
    private Integer bleedingVolume;

    @ApiModelProperty(value = "出血腔道", example = "口腔", required = true)
    private String bleedingCavity;

    @ApiModelProperty(value = "是否血浆渗漏表现", example = "true", required = true)
    private Boolean hasPlasmaLeakage;

    @ApiModelProperty(value = "是否其他重要脏器损伤", example = "false", required = true)
    private Boolean hasOtherOrganDamage;

    @ApiModelProperty(value = "是否Kernig征", example = "true", required = true)
    private Boolean hasKernigSign;

    @ApiModelProperty(value = "是否Brudzinski征", example = "true", required = true)
    private Boolean hasBrudzinskiSign;

    public Integer getDiagnosisGeneralSymptomId() {
        return diagnosisGeneralSymptomId;
    }

    public void setDiagnosisGeneralSymptomId(Integer diagnosisGeneralSymptomId) {
        this.diagnosisGeneralSymptomId = diagnosisGeneralSymptomId;
    }

    public Integer getDiagnosisResultsId() {
        return diagnosisResultsId;
    }

    public void setDiagnosisResultsId(Integer diagnosisResultsId) {
        this.diagnosisResultsId = diagnosisResultsId;
    }

    public Boolean getHasFever() {
        return hasFever;
    }

    public void setHasFever(Boolean hasFever) {
        this.hasFever = hasFever;
    }

    public BigDecimal getHighestTemperature() {
        return highestTemperature;
    }

    public void setHighestTemperature(BigDecimal highestTemperature) {
        this.highestTemperature = highestTemperature;
    }

    public Integer getFeverDuration() {
        return feverDuration;
    }

    public void setFeverDuration(Integer feverDuration) {
        this.feverDuration = feverDuration;
    }

    public Boolean getHasChills() {
        return hasChills;
    }

    public void setHasChills(Boolean hasChills) {
        this.hasChills = hasChills;
    }

    public Boolean getHasSweating() {
        return hasSweating;
    }

    public void setHasSweating(Boolean hasSweating) {
        this.hasSweating = hasSweating;
    }

    public Boolean getHasFatigue() {
        return hasFatigue;
    }

    public void setHasFatigue(Boolean hasFatigue) {
        this.hasFatigue = hasFatigue;
    }

    public Boolean getHasHeadache() {
        return hasHeadache;
    }

    public void setHasHeadache(Boolean hasHeadache) {
        this.hasHeadache = hasHeadache;
    }

    public Boolean getHasMusclePain() {
        return hasMusclePain;
    }

    public void setHasMusclePain(Boolean hasMusclePain) {
        this.hasMusclePain = hasMusclePain;
    }

    public Boolean getHasJointPain() {
        return hasJointPain;
    }

    public void setHasJointPain(Boolean hasJointPain) {
        this.hasJointPain = hasJointPain;
    }

    public Boolean getHasLymphNodeSwelling() {
        return hasLymphNodeSwelling;
    }

    public void setHasLymphNodeSwelling(Boolean hasLymphNodeSwelling) {
        this.hasLymphNodeSwelling = hasLymphNodeSwelling;
    }

    public Boolean getHasLymphNodeSwellingGroin() {
        return hasLymphNodeSwellingGroin;
    }

    public void setHasLymphNodeSwellingGroin(Boolean hasLymphNodeSwellingGroin) {
        this.hasLymphNodeSwellingGroin = hasLymphNodeSwellingGroin;
    }

    public Boolean getHasLymphNodeSwellingArmpit() {
        return hasLymphNodeSwellingArmpit;
    }

    public void setHasLymphNodeSwellingArmpit(Boolean hasLymphNodeSwellingArmpit) {
        this.hasLymphNodeSwellingArmpit = hasLymphNodeSwellingArmpit;
    }

    public Boolean getHasLymphNodeSwellingSubclavian() {
        return hasLymphNodeSwellingSubclavian;
    }

    public void setHasLymphNodeSwellingSubclavian(Boolean hasLymphNodeSwellingSubclavian) {
        this.hasLymphNodeSwellingSubclavian = hasLymphNodeSwellingSubclavian;
    }

    public Boolean getHasLymphNodeSwellingNeck() {
        return hasLymphNodeSwellingNeck;
    }

    public void setHasLymphNodeSwellingNeck(Boolean hasLymphNodeSwellingNeck) {
        this.hasLymphNodeSwellingNeck = hasLymphNodeSwellingNeck;
    }

    public Boolean getHasLymphNodeSwellingElbow() {
        return hasLymphNodeSwellingElbow;
    }

    public void setHasLymphNodeSwellingElbow(Boolean hasLymphNodeSwellingElbow) {
        this.hasLymphNodeSwellingElbow = hasLymphNodeSwellingElbow;
    }

    public Boolean getHasLymphNodeSwellingPopliteal() {
        return hasLymphNodeSwellingPopliteal;
    }

    public void setHasLymphNodeSwellingPopliteal(Boolean hasLymphNodeSwellingPopliteal) {
        this.hasLymphNodeSwellingPopliteal = hasLymphNodeSwellingPopliteal;
    }

    public Boolean getHasCyanosis() {
        return hasCyanosis;
    }

    public void setHasCyanosis(Boolean hasCyanosis) {
        this.hasCyanosis = hasCyanosis;
    }

    public Boolean getHasSubcutaneousAndMucosalBleedingSpots() {
        return hasSubcutaneousAndMucosalBleedingSpots;
    }

    public void setHasSubcutaneousAndMucosalBleedingSpots(Boolean hasSubcutaneousAndMucosalBleedingSpots) {
        this.hasSubcutaneousAndMucosalBleedingSpots = hasSubcutaneousAndMucosalBleedingSpots;
    }

    public Boolean getHasSevereAnemia() {
        return hasSevereAnemia;
    }

    public void setHasSevereAnemia(Boolean hasSevereAnemia) {
        this.hasSevereAnemia = hasSevereAnemia;
    }

    public Boolean getHasPainfulRedRash() {
        return hasPainfulRedRash;
    }

    public void setHasPainfulRedRash(Boolean hasPainfulRedRash) {
        this.hasPainfulRedRash = hasPainfulRedRash;
    }

    public Boolean getHasBloodBlisters() {
        return hasBloodBlisters;
    }

    public void setHasBloodBlisters(Boolean hasBloodBlisters) {
        this.hasBloodBlisters = hasBloodBlisters;
    }

    public Boolean getHasSkinUlcer() {
        return hasSkinUlcer;
    }

    public void setHasSkinUlcer(Boolean hasSkinUlcer) {
        this.hasSkinUlcer = hasSkinUlcer;
    }

    public Boolean getHasSubcutaneousAndMucosalBleedingCavity() {
        return hasSubcutaneousAndMucosalBleedingCavity;
    }

    public void setHasSubcutaneousAndMucosalBleedingCavity(Boolean hasSubcutaneousAndMucosalBleedingCavity) {
        this.hasSubcutaneousAndMucosalBleedingCavity = hasSubcutaneousAndMucosalBleedingCavity;
    }

    public Boolean getHasCongestiveOrPetechialRash() {
        return hasCongestiveOrPetechialRash;
    }

    public void setHasCongestiveOrPetechialRash(Boolean hasCongestiveOrPetechialRash) {
        this.hasCongestiveOrPetechialRash = hasCongestiveOrPetechialRash;
    }

    public Boolean getHasDehydration() {
        return hasDehydration;
    }

    public void setHasDehydration(Boolean hasDehydration) {
        this.hasDehydration = hasDehydration;
    }

    public String getDehydrationSeverity() {
        return dehydrationSeverity;
    }

    public void setDehydrationSeverity(String dehydrationSeverity) {
        this.dehydrationSeverity = dehydrationSeverity;
    }

    public Boolean getHasItchyRash() {
        return hasItchyRash;
    }

    public void setHasItchyRash(Boolean hasItchyRash) {
        this.hasItchyRash = hasItchyRash;
    }

    public Boolean getItchyRashOnFingers() {
        return itchyRashOnFingers;
    }

    public void setItchyRashOnFingers(Boolean itchyRashOnFingers) {
        this.itchyRashOnFingers = itchyRashOnFingers;
    }

    public Boolean getItchyRashOnBackOfHands() {
        return itchyRashOnBackOfHands;
    }

    public void setItchyRashOnBackOfHands(Boolean itchyRashOnBackOfHands) {
        this.itchyRashOnBackOfHands = itchyRashOnBackOfHands;
    }

    public Boolean getItchyRashOnUpperLimbs() {
        return itchyRashOnUpperLimbs;
    }

    public void setItchyRashOnUpperLimbs(Boolean itchyRashOnUpperLimbs) {
        this.itchyRashOnUpperLimbs = itchyRashOnUpperLimbs;
    }

    public Boolean getItchyRashOnLowerLimbs() {
        return itchyRashOnLowerLimbs;
    }

    public void setItchyRashOnLowerLimbs(Boolean itchyRashOnLowerLimbs) {
        this.itchyRashOnLowerLimbs = itchyRashOnLowerLimbs;
    }

    public Boolean getItchyRashOnFeet() {
        return itchyRashOnFeet;
    }

    public void setItchyRashOnFeet(Boolean itchyRashOnFeet) {
        this.itchyRashOnFeet = itchyRashOnFeet;
    }

    public Boolean getItchyRashOnFace() {
        return itchyRashOnFace;
    }

    public void setItchyRashOnFace(Boolean itchyRashOnFace) {
        this.itchyRashOnFace = itchyRashOnFace;
    }

    public Boolean getItchyRashOnOther() {
        return itchyRashOnOther;
    }

    public void setItchyRashOnOther(Boolean itchyRashOnOther) {
        this.itchyRashOnOther = itchyRashOnOther;
    }

    public Boolean getHasEdema() {
        return hasEdema;
    }

    public void setHasEdema(Boolean hasEdema) {
        this.hasEdema = hasEdema;
    }

    public Boolean getHasNightSweats() {
        return hasNightSweats;
    }

    public void setHasNightSweats(Boolean hasNightSweats) {
        this.hasNightSweats = hasNightSweats;
    }

    public Boolean getHasWeightLoss() {
        return hasWeightLoss;
    }

    public void setHasWeightLoss(Boolean hasWeightLoss) {
        this.hasWeightLoss = hasWeightLoss;
    }

    public Boolean getHasExhaustion() {
        return hasExhaustion;
    }

    public void setHasExhaustion(Boolean hasExhaustion) {
        this.hasExhaustion = hasExhaustion;
    }

    public Boolean getHasWhiteBloodCells() {
        return hasWhiteBloodCells;
    }

    public void setHasWhiteBloodCells(Boolean hasWhiteBloodCells) {
        this.hasWhiteBloodCells = hasWhiteBloodCells;
    }

    public Boolean getHasBloodPressureDrop() {
        return hasBloodPressureDrop;
    }

    public void setHasBloodPressureDrop(Boolean hasBloodPressureDrop) {
        this.hasBloodPressureDrop = hasBloodPressureDrop;
    }

    public Integer getLowestBloodPressure() {
        return lowestBloodPressure;
    }

    public void setLowestBloodPressure(Integer lowestBloodPressure) {
        this.lowestBloodPressure = lowestBloodPressure;
    }

    public Boolean getHasShockSyndrome() {
        return hasShockSyndrome;
    }

    public void setHasShockSyndrome(Boolean hasShockSyndrome) {
        this.hasShockSyndrome = hasShockSyndrome;
    }

    public Boolean getHasHighIntracranialPressure() {
        return hasHighIntracranialPressure;
    }

    public void setHasHighIntracranialPressure(Boolean hasHighIntracranialPressure) {
        this.hasHighIntracranialPressure = hasHighIntracranialPressure;
    }

    public Boolean getHasTurbidCerebrospinalFluid() {
        return hasTurbidCerebrospinalFluid;
    }

    public void setHasTurbidCerebrospinalFluid(Boolean hasTurbidCerebrospinalFluid) {
        this.hasTurbidCerebrospinalFluid = hasTurbidCerebrospinalFluid;
    }

    public Boolean getHasBleeding() {
        return hasBleeding;
    }

    public void setHasBleeding(Boolean hasBleeding) {
        this.hasBleeding = hasBleeding;
    }

    public Integer getBleedingVolume() {
        return bleedingVolume;
    }

    public void setBleedingVolume(Integer bleedingVolume) {
        this.bleedingVolume = bleedingVolume;
    }

    public String getBleedingCavity() {
        return bleedingCavity;
    }

    public void setBleedingCavity(String bleedingCavity) {
        this.bleedingCavity = bleedingCavity;
    }

    public Boolean getHasPlasmaLeakage() {
        return hasPlasmaLeakage;
    }

    public void setHasPlasmaLeakage(Boolean hasPlasmaLeakage) {
        this.hasPlasmaLeakage = hasPlasmaLeakage;
    }

    public Boolean getHasOtherOrganDamage() {
        return hasOtherOrganDamage;
    }

    public void setHasOtherOrganDamage(Boolean hasOtherOrganDamage) {
        this.hasOtherOrganDamage = hasOtherOrganDamage;
    }

    public Boolean getHasKernigSign() {
        return hasKernigSign;
    }

    public void setHasKernigSign(Boolean hasKernigSign) {
        this.hasKernigSign = hasKernigSign;
    }

    public Boolean getHasBrudzinskiSign() {
        return hasBrudzinskiSign;
    }

    public void setHasBrudzinskiSign(Boolean hasBrudzinskiSign) {
        this.hasBrudzinskiSign = hasBrudzinskiSign;
    }

    /**
     * 获取
     * @return hasPressureInsensitiveRash
     */
    public Boolean getHasPressureInsensitiveRash() {
        return hasPressureInsensitiveRash;
    }

    /**
     * 设置
     * @param hasPressureInsensitiveRash
     */
    public void setHasPressureInsensitiveRash(Boolean hasPressureInsensitiveRash) {
        this.hasPressureInsensitiveRash = hasPressureInsensitiveRash;
    }
}
