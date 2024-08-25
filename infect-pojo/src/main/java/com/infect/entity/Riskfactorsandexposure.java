package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDate;
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
@TableName("riskfactorsandexposure")
@ApiModel(value="Riskfactorsandexposure对象", description="")
public class Riskfactorsandexposure implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "RiskFactorsAndExposureID", type = IdType.AUTO)
    private Integer riskFactorsAndExposureId;

    private Integer statusId;

    private String contactWithFeverPatient;

    private String contactWithDiarrheaPatient;

    private String contactWithRashPatient;

    private String contactWithTuberculosisPatient;

    private Boolean isGroupDining;

    private Boolean isDiningOut;

    private Boolean isDiningUnclear;

    private Boolean hasDrinkingRawWater;

    private Boolean hasEatingRawFood;

    private Boolean hasEatingColdCookedFood;

    private Boolean hasEatingSeafood;

    private String foodNames;

    private String diningPlace;

    private String groupOutbreak;

    private String outdoorStayOrWorkWithinMonth;

    private String wildActivityHistory;

    private String otherWildActivityName;

    private String plagueArea;

    private String specificPlagueLocation;

    private String anthraxArea;

    private String specificAnthraxLocation;

    private String malariaArea;

    private String specificMalariaLocation;

    private String contactWithAnimalProducts;

    private LocalDate contactDate;

    private String contactWithAnimals;

    private String contactPlace;

    private Boolean hasContactWithRat;

    private Boolean hasContactWithMarmot;

    private Boolean hasContactWithLice;

    private Boolean hasContactWithFlea;

    private Boolean hasContactWithCat;

    private Boolean hasContactWithBird;

    private Boolean hasContactWithPig;

    private Boolean hasContactWithHorse;

    private Boolean hasContactWithMule;

    private Boolean hasContactWithDonkey;

    private Boolean hasContactWithCow;

    private Boolean hasContactWithSheep;

    private Boolean hasContactWithDog;

    private Boolean hasContactWithRabbit;

    private Boolean hasContactWithWolf;

    private Boolean hasContactWithTiger;

    private Boolean hasContactWithOtherAnimal;

    private String otherAnimalName;

    private Boolean isHillyOrMountainous;

    private Boolean isPlain;

    private Boolean isOtherResidenceType;

    private Boolean hasMosquitoBite;

    private String tickBite;

    private String fleaBite;

    private String contactWithRatIn2Months;

    private String ratContactMethod;

    private String eatenFoodContaminatedByRatFeces;

    private String drunkWaterFromDitchesOrPonds;

    private String restedNearRatHoles;

    private String ratOrRatDroppingsAtWorkplace;

    private String contactWithPatientExcreta;

}
