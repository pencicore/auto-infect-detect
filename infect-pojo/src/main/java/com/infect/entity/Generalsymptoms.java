package com.infect.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
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

    public Integer getGeneralSymptomsId() {
        return generalSymptomsId;
    }

    public void setGeneralSymptomsId(Integer generalSymptomsId) {
        this.generalSymptomsId = generalSymptomsId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
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

    public String getDehydration() {
        return dehydration;
    }

    public void setDehydration(String dehydration) {
        this.dehydration = dehydration;
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
}
