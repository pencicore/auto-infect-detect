package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
@TableName("riskfactorsandexposure")
@ApiModel(value="Riskfactorsandexposure对象", description="")
public class Riskfactorsandexposure implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "RiskFactorsAndExposureID", type = IdType.AUTO)
    private Integer RiskFactorsAndExposureID;

    private Integer StatusID;

    private String ContactWithFeverPatient;

    private String ContactWithDiarrheaPatient;

    private String ContactWithRashPatient;

    private String ContactWithTuberculosisPatient;

    private Boolean IsGroupDining;

    private Boolean IsDiningOut;

    private Boolean IsDiningUnclear;

    private Boolean HasDrinkingRawWater;

    private Boolean HasEatingRawFood;

    private Boolean HasEatingColdCookedFood;

    private Boolean HasEatingSeafood;

    private String FoodNames;

    private String DiningPlace;

    private String GroupOutbreak;

    private String OutdoorStayOrWorkWithinMonth;

    private String WildActivityHistory;

    private String OtherWildActivityName;

    private String PlagueArea;

    private String SpecificPlagueLocation;

    private String AnthraxArea;

    private String SpecificAnthraxLocation;

    private String MalariaArea;

    private String SpecificMalariaLocation;

    private String ContactWithAnimalProducts;

    private LocalDate ContactDate;

    private String ContactWithAnimals;

    private String ContactPlace;

    private Boolean HasContactWithRat;

    private Boolean HasContactWithMarmot;

    private Boolean HasContactWithLice;

    private Boolean HasContactWithFlea;

    private Boolean HasContactWithCat;

    private Boolean HasContactWithBird;

    private Boolean HasContactWithPig;

    private Boolean HasContactWithHorse;

    private Boolean HasContactWithMule;

    private Boolean HasContactWithDonkey;

    private Boolean HasContactWithCow;

    private Boolean HasContactWithSheep;

    private Boolean HasContactWithDog;

    private Boolean HasContactWithRabbit;

    private Boolean HasContactWithWolf;

    private Boolean HasContactWithTiger;

    private Boolean HasContactWithOtherAnimal;

    private String OtherAnimalName;

    private Boolean IsHillyOrMountainous;

    private Boolean IsPlain;

    private Boolean IsOtherResidenceType;

    private Boolean HasMosquitoBite;

    private String TickBite;

    private String FleaBite;

    private String ContactWithRatIn2Months;

    private String RatContactMethod;

    private String EatenFoodContaminatedByRatFeces;

    private String DrunkWaterFromDitchesOrPonds;

    private String RestedNearRatHoles;

    private String RatOrRatDroppingsAtWorkplace;

    private String ContactWithPatientExcreta;


}
