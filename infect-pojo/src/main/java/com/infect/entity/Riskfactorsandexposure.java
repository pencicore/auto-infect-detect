package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDate;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * <p>
 * 风险因素与暴露表
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("riskfactorsandexposure")
@ApiModel(value = "Riskfactorsandexposure对象", description = "风险因素与暴露信息")
public class Riskfactorsandexposure implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "RiskFactorsAndExposureID", type = IdType.AUTO)
    @ApiModelProperty(value = "风险因素与暴露ID")
    private Integer riskFactorsAndExposureId;

    @ApiModelProperty(value = "每日健康状态ID")
    private Integer statusId;

    @ApiModelProperty(value = "是否接触过发热或有呼吸道症状的患者", allowableValues = "是,否,不清楚", example = "是", required = true)
    private String contactWithFeverPatient;

    @ApiModelProperty(value = "是否接触过有腹泻症状的患者", allowableValues = "是,否,不清楚", example = "否", required = true)
    private String contactWithDiarrheaPatient;

    @ApiModelProperty(value = "是否接触过有皮疹的患者", allowableValues = "是,否,不清楚", example = "不清楚", required = true)
    private String contactWithRashPatient;

    @ApiModelProperty(value = "是否接触过诊断为结核病的患者", allowableValues = "是,否,不清楚", example = "是", required = true)
    private String contactWithTuberculosisPatient;

    @ApiModelProperty(value = "5天内是否集体堂食就餐", example = "true", required = true)
    private Boolean isGroupDining;

    @ApiModelProperty(value = "5天内是否外出就餐", example = "false", required = true)
    private Boolean isDiningOut;

    @ApiModelProperty(value = "5天内就餐情况不清楚", example = "false", required = true)
    private Boolean isDiningUnclear;

    @ApiModelProperty(value = "是否饮生水", example = "true", required = true)
    private Boolean hasDrinkingRawWater;

    @ApiModelProperty(value = "是否吃生冷食品", example = "false", required = true)
    private Boolean hasEatingRawFood;

    @ApiModelProperty(value = "是否熟食冷吃", example = "false", required = true)
    private Boolean hasEatingColdCookedFood;

    @ApiModelProperty(value = "是否吃海水产品", example = "true", required = true)
    private Boolean hasEatingSeafood;

    @ApiModelProperty(value = "食物名字", example = "生鱼片", required = true)
    private String foodNames;

    @ApiModelProperty(value = "就餐地点", example = "家里", required = true)
    private String diningPlace;

    @ApiModelProperty(value = "同一家庭、办公室、车间等集体单位是否有聚集性发病", allowableValues = "是,否,不清楚", example = "是", required = true)
    private String groupOutbreak;

    @ApiModelProperty(value = "发病前1月内是否在野外住宿或工作", allowableValues = "是,否,不清楚", example = "否", required = true)
    private String outdoorStayOrWorkWithinMonth;

    @ApiModelProperty(value = "野外/户外活动史", allowableValues = "种地,割草,打猎,采茶,放牧,采伐,旅游,其他", example = "打猎", required = true)
    private String wildActivityHistory;

    @ApiModelProperty(value = "其他户外活动方式名称", example = "登山", required = true)
    private String otherWildActivityName;

    @ApiModelProperty(value = "是否到过鼠疫流行区", allowableValues = "是,否,不清楚", example = "不清楚", required = true)
    private String plagueArea;

    @ApiModelProperty(value = "具体地点", example = "云南省", required = true)
    private String specificPlagueLocation;

    @ApiModelProperty(value = "是否到过炭疽流行区", allowableValues = "是,否,不清楚", example = "否", required = true)
    private String anthraxArea;

    @ApiModelProperty(value = "具体地点", example = "广西省", required = true)
    private String specificAnthraxLocation;

    @ApiModelProperty(value = "是否到过疟疾流行区", allowableValues = "是,否,不清楚", example = "是", required = true)
    private String malariaArea;

    @ApiModelProperty(value = "具体地点", example = "贵州省", required = true)
    private String specificMalariaLocation;

    @ApiModelProperty(value = "是否接触过动物制品", allowableValues = "是,否,不清楚", example = "是", required = true)
    private String contactWithAnimalProducts;

    @ApiModelProperty(value = "接触时间", example = "2024-08-27", required = true)
    private LocalDate contactDate;

    @ApiModelProperty(value = "是否接触过动物", allowableValues = "是,否,不清楚", example = "否", required = true)
    private String contactWithAnimals;

    @ApiModelProperty(value = "接触地点", example = "农田", required = true)
    private String contactPlace;

    @ApiModelProperty(value = "是否接触过老鼠", example = "true", required = true)
    private Boolean hasContactWithRat;

    @ApiModelProperty(value = "是否接触过旱獭", example = "false", required = true)
    private Boolean hasContactWithMarmot;

    @ApiModelProperty(value = "是否接触过虱", example = "false", required = true)
    private Boolean hasContactWithLice;

    @ApiModelProperty(value = "是否接触过蚤", example = "false", required = true)
    private Boolean hasContactWithFlea;

    @ApiModelProperty(value = "是否接触过猫", example = "true", required = true)
    private Boolean hasContactWithCat;

    @ApiModelProperty(value = "是否接触过鸟", example = "false", required = true)
    private Boolean hasContactWithBird;

    @ApiModelProperty(value = "是否接触过猪", example = "false", required = true)
    private Boolean hasContactWithPig;

    @ApiModelProperty(value = "是否接触过马", example = "true", required = true)
    private Boolean hasContactWithHorse;

    @ApiModelProperty(value = "是否接触过骡", example = "false", required = true)
    private Boolean hasContactWithMule;

    @ApiModelProperty(value = "是否接触过驴", example = "false", required = true)
    private Boolean hasContactWithDonkey;

    @ApiModelProperty(value = "是否接触过牛", example = "true", required = true)
    private Boolean hasContactWithCow;

    @ApiModelProperty(value = "是否接触过羊", example = "false", required = true)
    private Boolean hasContactWithSheep;

    @ApiModelProperty(value = "是否接触过狗", example = "true", required = true)
    private Boolean hasContactWithDog;

    @ApiModelProperty(value = "是否接触过兔", example = "false", required = true)
    private Boolean hasContactWithRabbit;

    @ApiModelProperty(value = "是否接触过狼", example = "false", required = true)
    private Boolean hasContactWithWolf;

    @ApiModelProperty(value = "是否接触过虎", example = "false", required = true)
    private Boolean hasContactWithTiger;

    @ApiModelProperty(value = "是否接触过其他动物", example = "false", required = true)
    private Boolean hasContactWithOtherAnimal;

    @ApiModelProperty(value = "其他动物名称", example = "猴子", required = true)
    private String otherAnimalName;

    @ApiModelProperty(value = "是否居住在丘陵或山区", example = "true", required = true)
    private Boolean isHillyOrMountainous;

    @ApiModelProperty(value = "是否居住在平原", example = "false", required = true)
    private Boolean isPlain;
    @ApiModelProperty(value = "是否居住在其他地区", example = "true", required = true)
    private Boolean isOtherResidenceType;

    @ApiModelProperty(value = "14天内是否明确被蚊虫叮咬过", example = "false", required = true)
    private Boolean hasMosquitoBite;

    @ApiModelProperty(value = "发病前2周内是否被蜱叮咬过", allowableValues = "是,否,不知道", example = "是", required = true)
    private String tickBite;

    @ApiModelProperty(value = "发病是否被跳蚤叮咬过", allowableValues = "是,否,不知道", example = "否", required = true)
    private String fleaBite;

    @ApiModelProperty(value = "发病前2个月内是否接触鼠类", allowableValues = "是,否,不清楚", example = "不清楚", required = true)
    private String contactWithRatIn2Months;

    @ApiModelProperty(value = "接触方式", allowableValues = "挖鼠洞,拿鼠,鼠咬,鼠尿,鼠粪,鼠血污染手,手被鼠夹打伤,其他", example = "挖鼠洞", required = true)
    private String ratContactMethod;

    @ApiModelProperty(value = "发病前1月内是否吃过被鼠排泄物污染的食物", allowableValues = "是,否,不清楚", example = "否", required = true)
    private String eatenFoodContaminatedByRatFeces;

    @ApiModelProperty(value = "发病前1月内是否在野外喝过沟（塘）水", allowableValues = "是,否,不清楚", example = "是", required = true)
    private String drunkWaterFromDitchesOrPonds;

    @ApiModelProperty(value = "发病前9天内是否在鼠洞附近坐卧", allowableValues = "是,否,不清楚", example = "否", required = true)
    private String restedNearRatHoles;

    @ApiModelProperty(value = "工作场所有无鼠或鼠排泄物", allowableValues = "是,否,不清楚", example = "不清楚", required = true)
    private String ratOrRatDroppingsAtWorkplace;

    @ApiModelProperty(value = "发病前1月内是否接触过病人排泄物（血、尿、便等）", allowableValues = "是,否,不清楚", example = "是", required = true)
    private String contactWithPatientExcreta;

    public Integer getRiskFactorsAndExposureId() {
        return riskFactorsAndExposureId;
    }

    public void setRiskFactorsAndExposureId(Integer riskFactorsAndExposureId) {
        this.riskFactorsAndExposureId = riskFactorsAndExposureId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getContactWithFeverPatient() {
        return contactWithFeverPatient;
    }

    public void setContactWithFeverPatient(String contactWithFeverPatient) {
        this.contactWithFeverPatient = contactWithFeverPatient;
    }

    public String getContactWithDiarrheaPatient() {
        return contactWithDiarrheaPatient;
    }

    public void setContactWithDiarrheaPatient(String contactWithDiarrheaPatient) {
        this.contactWithDiarrheaPatient = contactWithDiarrheaPatient;
    }

    public String getContactWithRashPatient() {
        return contactWithRashPatient;
    }

    public void setContactWithRashPatient(String contactWithRashPatient) {
        this.contactWithRashPatient = contactWithRashPatient;
    }

    public String getContactWithTuberculosisPatient() {
        return contactWithTuberculosisPatient;
    }

    public void setContactWithTuberculosisPatient(String contactWithTuberculosisPatient) {
        this.contactWithTuberculosisPatient = contactWithTuberculosisPatient;
    }

    public Boolean getGroupDining() {
        return isGroupDining;
    }

    public void setGroupDining(Boolean groupDining) {
        isGroupDining = groupDining;
    }

    public Boolean getDiningOut() {
        return isDiningOut;
    }

    public void setDiningOut(Boolean diningOut) {
        isDiningOut = diningOut;
    }

    public Boolean getDiningUnclear() {
        return isDiningUnclear;
    }

    public void setDiningUnclear(Boolean diningUnclear) {
        isDiningUnclear = diningUnclear;
    }

    public Boolean getHasDrinkingRawWater() {
        return hasDrinkingRawWater;
    }

    public void setHasDrinkingRawWater(Boolean hasDrinkingRawWater) {
        this.hasDrinkingRawWater = hasDrinkingRawWater;
    }

    public Boolean getHasEatingRawFood() {
        return hasEatingRawFood;
    }

    public void setHasEatingRawFood(Boolean hasEatingRawFood) {
        this.hasEatingRawFood = hasEatingRawFood;
    }

    public Boolean getHasEatingColdCookedFood() {
        return hasEatingColdCookedFood;
    }

    public void setHasEatingColdCookedFood(Boolean hasEatingColdCookedFood) {
        this.hasEatingColdCookedFood = hasEatingColdCookedFood;
    }

    public Boolean getHasEatingSeafood() {
        return hasEatingSeafood;
    }

    public void setHasEatingSeafood(Boolean hasEatingSeafood) {
        this.hasEatingSeafood = hasEatingSeafood;
    }

    public String getFoodNames() {
        return foodNames;
    }

    public void setFoodNames(String foodNames) {
        this.foodNames = foodNames;
    }

    public String getDiningPlace() {
        return diningPlace;
    }

    public void setDiningPlace(String diningPlace) {
        this.diningPlace = diningPlace;
    }

    public String getGroupOutbreak() {
        return groupOutbreak;
    }

    public void setGroupOutbreak(String groupOutbreak) {
        this.groupOutbreak = groupOutbreak;
    }

    public String getOutdoorStayOrWorkWithinMonth() {
        return outdoorStayOrWorkWithinMonth;
    }

    public void setOutdoorStayOrWorkWithinMonth(String outdoorStayOrWorkWithinMonth) {
        this.outdoorStayOrWorkWithinMonth = outdoorStayOrWorkWithinMonth;
    }

    public String getWildActivityHistory() {
        return wildActivityHistory;
    }

    public void setWildActivityHistory(String wildActivityHistory) {
        this.wildActivityHistory = wildActivityHistory;
    }

    public String getOtherWildActivityName() {
        return otherWildActivityName;
    }

    public void setOtherWildActivityName(String otherWildActivityName) {
        this.otherWildActivityName = otherWildActivityName;
    }

    public String getPlagueArea() {
        return plagueArea;
    }

    public void setPlagueArea(String plagueArea) {
        this.plagueArea = plagueArea;
    }

    public String getSpecificPlagueLocation() {
        return specificPlagueLocation;
    }

    public void setSpecificPlagueLocation(String specificPlagueLocation) {
        this.specificPlagueLocation = specificPlagueLocation;
    }

    public String getAnthraxArea() {
        return anthraxArea;
    }

    public void setAnthraxArea(String anthraxArea) {
        this.anthraxArea = anthraxArea;
    }

    public String getSpecificAnthraxLocation() {
        return specificAnthraxLocation;
    }

    public void setSpecificAnthraxLocation(String specificAnthraxLocation) {
        this.specificAnthraxLocation = specificAnthraxLocation;
    }

    public String getMalariaArea() {
        return malariaArea;
    }

    public void setMalariaArea(String malariaArea) {
        this.malariaArea = malariaArea;
    }

    public String getSpecificMalariaLocation() {
        return specificMalariaLocation;
    }

    public void setSpecificMalariaLocation(String specificMalariaLocation) {
        this.specificMalariaLocation = specificMalariaLocation;
    }

    public String getContactWithAnimalProducts() {
        return contactWithAnimalProducts;
    }

    public void setContactWithAnimalProducts(String contactWithAnimalProducts) {
        this.contactWithAnimalProducts = contactWithAnimalProducts;
    }

    public LocalDate getContactDate() {
        return contactDate;
    }

    public void setContactDate(LocalDate contactDate) {
        this.contactDate = contactDate;
    }

    public String getContactWithAnimals() {
        return contactWithAnimals;
    }

    public void setContactWithAnimals(String contactWithAnimals) {
        this.contactWithAnimals = contactWithAnimals;
    }

    public String getContactPlace() {
        return contactPlace;
    }

    public void setContactPlace(String contactPlace) {
        this.contactPlace = contactPlace;
    }

    public Boolean getHasContactWithRat() {
        return hasContactWithRat;
    }

    public void setHasContactWithRat(Boolean hasContactWithRat) {
        this.hasContactWithRat = hasContactWithRat;
    }

    public Boolean getHasContactWithMarmot() {
        return hasContactWithMarmot;
    }

    public void setHasContactWithMarmot(Boolean hasContactWithMarmot) {
        this.hasContactWithMarmot = hasContactWithMarmot;
    }

    public Boolean getHasContactWithLice() {
        return hasContactWithLice;
    }

    public void setHasContactWithLice(Boolean hasContactWithLice) {
        this.hasContactWithLice = hasContactWithLice;
    }

    public Boolean getHasContactWithFlea() {
        return hasContactWithFlea;
    }

    public void setHasContactWithFlea(Boolean hasContactWithFlea) {
        this.hasContactWithFlea = hasContactWithFlea;
    }

    public Boolean getHasContactWithCat() {
        return hasContactWithCat;
    }

    public void setHasContactWithCat(Boolean hasContactWithCat) {
        this.hasContactWithCat = hasContactWithCat;
    }

    public Boolean getHasContactWithBird() {
        return hasContactWithBird;
    }

    public void setHasContactWithBird(Boolean hasContactWithBird) {
        this.hasContactWithBird = hasContactWithBird;
    }

    public Boolean getHasContactWithPig() {
        return hasContactWithPig;
    }

    public void setHasContactWithPig(Boolean hasContactWithPig) {
        this.hasContactWithPig = hasContactWithPig;
    }

    public Boolean getHasContactWithHorse() {
        return hasContactWithHorse;
    }

    public void setHasContactWithHorse(Boolean hasContactWithHorse) {
        this.hasContactWithHorse = hasContactWithHorse;
    }

    public Boolean getHasContactWithMule() {
        return hasContactWithMule;
    }

    public void setHasContactWithMule(Boolean hasContactWithMule) {
        this.hasContactWithMule = hasContactWithMule;
    }

    public Boolean getHasContactWithDonkey() {
        return hasContactWithDonkey;
    }

    public void setHasContactWithDonkey(Boolean hasContactWithDonkey) {
        this.hasContactWithDonkey = hasContactWithDonkey;
    }

    public Boolean getHasContactWithCow() {
        return hasContactWithCow;
    }

    public void setHasContactWithCow(Boolean hasContactWithCow) {
        this.hasContactWithCow = hasContactWithCow;
    }

    public Boolean getHasContactWithSheep() {
        return hasContactWithSheep;
    }

    public void setHasContactWithSheep(Boolean hasContactWithSheep) {
        this.hasContactWithSheep = hasContactWithSheep;
    }

    public Boolean getHasContactWithDog() {
        return hasContactWithDog;
    }

    public void setHasContactWithDog(Boolean hasContactWithDog) {
        this.hasContactWithDog = hasContactWithDog;
    }

    public Boolean getHasContactWithRabbit() {
        return hasContactWithRabbit;
    }

    public void setHasContactWithRabbit(Boolean hasContactWithRabbit) {
        this.hasContactWithRabbit = hasContactWithRabbit;
    }

    public Boolean getHasContactWithWolf() {
        return hasContactWithWolf;
    }

    public void setHasContactWithWolf(Boolean hasContactWithWolf) {
        this.hasContactWithWolf = hasContactWithWolf;
    }

    public Boolean getHasContactWithTiger() {
        return hasContactWithTiger;
    }

    public void setHasContactWithTiger(Boolean hasContactWithTiger) {
        this.hasContactWithTiger = hasContactWithTiger;
    }

    public Boolean getHasContactWithOtherAnimal() {
        return hasContactWithOtherAnimal;
    }

    public void setHasContactWithOtherAnimal(Boolean hasContactWithOtherAnimal) {
        this.hasContactWithOtherAnimal = hasContactWithOtherAnimal;
    }

    public String getOtherAnimalName() {
        return otherAnimalName;
    }

    public void setOtherAnimalName(String otherAnimalName) {
        this.otherAnimalName = otherAnimalName;
    }

    public Boolean getHillyOrMountainous() {
        return isHillyOrMountainous;
    }

    public void setHillyOrMountainous(Boolean hillyOrMountainous) {
        isHillyOrMountainous = hillyOrMountainous;
    }

    public Boolean getPlain() {
        return isPlain;
    }

    public void setPlain(Boolean plain) {
        isPlain = plain;
    }

    public Boolean getOtherResidenceType() {
        return isOtherResidenceType;
    }

    public void setOtherResidenceType(Boolean otherResidenceType) {
        isOtherResidenceType = otherResidenceType;
    }

    public Boolean getHasMosquitoBite() {
        return hasMosquitoBite;
    }

    public void setHasMosquitoBite(Boolean hasMosquitoBite) {
        this.hasMosquitoBite = hasMosquitoBite;
    }

    public String getTickBite() {
        return tickBite;
    }

    public void setTickBite(String tickBite) {
        this.tickBite = tickBite;
    }

    public String getFleaBite() {
        return fleaBite;
    }

    public void setFleaBite(String fleaBite) {
        this.fleaBite = fleaBite;
    }

    public String getContactWithRatIn2Months() {
        return contactWithRatIn2Months;
    }

    public void setContactWithRatIn2Months(String contactWithRatIn2Months) {
        this.contactWithRatIn2Months = contactWithRatIn2Months;
    }

    public String getRatContactMethod() {
        return ratContactMethod;
    }

    public void setRatContactMethod(String ratContactMethod) {
        this.ratContactMethod = ratContactMethod;
    }

    public String getEatenFoodContaminatedByRatFeces() {
        return eatenFoodContaminatedByRatFeces;
    }

    public void setEatenFoodContaminatedByRatFeces(String eatenFoodContaminatedByRatFeces) {
        this.eatenFoodContaminatedByRatFeces = eatenFoodContaminatedByRatFeces;
    }

    public String getDrunkWaterFromDitchesOrPonds() {
        return drunkWaterFromDitchesOrPonds;
    }

    public void setDrunkWaterFromDitchesOrPonds(String drunkWaterFromDitchesOrPonds) {
        this.drunkWaterFromDitchesOrPonds = drunkWaterFromDitchesOrPonds;
    }

    public String getRestedNearRatHoles() {
        return restedNearRatHoles;
    }

    public void setRestedNearRatHoles(String restedNearRatHoles) {
        this.restedNearRatHoles = restedNearRatHoles;
    }

    public String getRatOrRatDroppingsAtWorkplace() {
        return ratOrRatDroppingsAtWorkplace;
    }

    public void setRatOrRatDroppingsAtWorkplace(String ratOrRatDroppingsAtWorkplace) {
        this.ratOrRatDroppingsAtWorkplace = ratOrRatDroppingsAtWorkplace;
    }

    public String getContactWithPatientExcreta() {
        return contactWithPatientExcreta;
    }

    public void setContactWithPatientExcreta(String contactWithPatientExcreta) {
        this.contactWithPatientExcreta = contactWithPatientExcreta;
    }
}
