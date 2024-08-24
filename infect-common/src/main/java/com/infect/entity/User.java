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
@TableName("user")
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "UserID", type = IdType.AUTO)
    private Integer UserID;

    private String Password;

    private String UserType;

    private Boolean IsActived;

    private String Name;

    private String Gender;

    private Boolean IsPregnant;

    private Integer PregnancyWeeks;

    private String IDNumber;

    private LocalDate BirthDate;

    private Integer Age;

    private String Ethnicity;

    private String EducationLevel;

    private LocalDate WorkOnPlateauStartDate;

    private String Department;

    private String SpecificOccupation;

    private String MedicalPersonnelType;

    private String OtherPositionName;

    private String PhoneNumber;

    private String OtherPhoneNumber;

    private Boolean HasMedicalHistory;

    private Boolean HasHypertension;

    private Boolean HasDiabetes;

    private Boolean HasHyperlipidemia;

    private Boolean HasHyperuricemia;

    private Boolean HasCoronaryHeartDisease;

    private Boolean HasStroke;

    private Boolean HasOtherCardiovascularDiseases;

    private Boolean HasAsthma;

    private Boolean HasCOPD;

    private Boolean HasPepticUlcer;

    private Boolean HasMalignantTumor;

    private Boolean HasLungCancer;

    private Boolean HasOtherCancer;

    private String OtherCancerName;

    private Boolean HasSevereMentalDisorders;

    private Boolean HasTuberculosis;

    private Boolean HasHepatitis;

    private Boolean HasOccupationalDisease;

    private Boolean HasChronicKidneyDisease;

    private Boolean HasChronicLiverDisease;

    private Boolean HasImmunodeficiency;

    private Boolean HasTyphus;

    private Boolean IsPostpartumInSixWeeks;

    private Boolean HasDustExposure;

    private Boolean HasOtherDiseases;

    private String OtherDiseasesName;

    private String SmokingStatus;

    private String DrinkingStatus;

    private Integer Height;

    private Integer Weight;

    private Boolean IsVaccinatedForCOVID;

    private Boolean IsVaccinatedForFlu;

    private Boolean IsVaccinatedForPlague;

    private Boolean IsVaccinatedForBCG;

    private Boolean IsVaccinatedForHepatitis;


}
