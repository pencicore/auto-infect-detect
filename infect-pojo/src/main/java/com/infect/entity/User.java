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
    private Integer userId;

    private String password;

    private String userType;

    private Boolean isActived;

    private String name;

    private String gender;

    private Boolean isPregnant;

    private Integer pregnancyWeeks;

    private String idNumber;

    private LocalDate birthDate;

    private Integer age;

    private String ethnicity;

    private String educationLevel;

    private LocalDate workOnPlateauStartDate;

    private String department;

    private String specificOccupation;

    private String medicalPersonnelType;

    private String otherPositionName;

    private String phoneNumber;

    private String otherPhoneNumber;

    private Boolean hasMedicalHistory;

    private Boolean hasHypertension;

    private Boolean hasDiabetes;

    private Boolean hasHyperlipidemia;

    private Boolean hasHyperuricemia;

    private Boolean hasCoronaryHeartDisease;

    private Boolean hasStroke;

    private Boolean hasOtherCardiovascularDiseases;

    private Boolean hasAsthma;

    private Boolean hasCOPD;

    private Boolean hasPepticUlcer;

    private Boolean hasMalignantTumor;

    private Boolean hasLungCancer;

    private Boolean hasOtherCancer;

    private String otherCancerName;

    private Boolean hasSevereMentalDisorders;

    private Boolean hasTuberculosis;

    private Boolean hasHepatitis;

    private Boolean hasOccupationalDisease;

    private Boolean hasChronicKidneyDisease;

    private Boolean hasChronicLiverDisease;

    private Boolean hasImmunodeficiency;

    private Boolean hasTyphus;

    private Boolean isPostpartumInSixWeeks;

    private Boolean hasDustExposure;

    private Boolean hasOtherDiseases;

    private String otherDiseasesName;

    private String smokingStatus;

    private String drinkingStatus;

    private Integer height;

    private Integer weight;

    private Boolean isVaccinatedForCOVID;

    private Boolean isVaccinatedForFlu;

    private Boolean isVaccinatedForPlague;

    private Boolean isVaccinatedForBCG;

    private Boolean isVaccinatedForHepatitis;

    private String emergencyContactName;

    private String emergencyContactPhoneNumber;

    private String emergencyContactRelation;

}
