package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;


/**
 * <p>
 *
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Boolean getIsActived() {
        return isActived;
    }

    public void setIsActived(Boolean actived) {
        isActived = actived;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getPregnant() {
        return isPregnant;
    }

    public void setPregnant(Boolean pregnant) {
        isPregnant = pregnant;
    }

    public Integer getPregnancyWeeks() {
        return pregnancyWeeks;
    }

    public void setPregnancyWeeks(Integer pregnancyWeeks) {
        this.pregnancyWeeks = pregnancyWeeks;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public LocalDate getWorkOnPlateauStartDate() {
        return workOnPlateauStartDate;
    }

    public void setWorkOnPlateauStartDate(LocalDate workOnPlateauStartDate) {
        this.workOnPlateauStartDate = workOnPlateauStartDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSpecificOccupation() {
        return specificOccupation;
    }

    public void setSpecificOccupation(String specificOccupation) {
        this.specificOccupation = specificOccupation;
    }

    public String getMedicalPersonnelType() {
        return medicalPersonnelType;
    }

    public void setMedicalPersonnelType(String medicalPersonnelType) {
        this.medicalPersonnelType = medicalPersonnelType;
    }

    public String getOtherPositionName() {
        return otherPositionName;
    }

    public void setOtherPositionName(String otherPositionName) {
        this.otherPositionName = otherPositionName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOtherPhoneNumber() {
        return otherPhoneNumber;
    }

    public void setOtherPhoneNumber(String otherPhoneNumber) {
        this.otherPhoneNumber = otherPhoneNumber;
    }

    public Boolean getHasMedicalHistory() {
        return hasMedicalHistory;
    }

    public void setHasMedicalHistory(Boolean hasMedicalHistory) {
        this.hasMedicalHistory = hasMedicalHistory;
    }

    public Boolean getHasHypertension() {
        return hasHypertension;
    }

    public void setHasHypertension(Boolean hasHypertension) {
        this.hasHypertension = hasHypertension;
    }

    public Boolean getHasDiabetes() {
        return hasDiabetes;
    }

    public void setHasDiabetes(Boolean hasDiabetes) {
        this.hasDiabetes = hasDiabetes;
    }

    public Boolean getHasHyperlipidemia() {
        return hasHyperlipidemia;
    }

    public void setHasHyperlipidemia(Boolean hasHyperlipidemia) {
        this.hasHyperlipidemia = hasHyperlipidemia;
    }

    public Boolean getHasHyperuricemia() {
        return hasHyperuricemia;
    }

    public void setHasHyperuricemia(Boolean hasHyperuricemia) {
        this.hasHyperuricemia = hasHyperuricemia;
    }

    public Boolean getHasCoronaryHeartDisease() {
        return hasCoronaryHeartDisease;
    }

    public void setHasCoronaryHeartDisease(Boolean hasCoronaryHeartDisease) {
        this.hasCoronaryHeartDisease = hasCoronaryHeartDisease;
    }

    public Boolean getHasStroke() {
        return hasStroke;
    }

    public void setHasStroke(Boolean hasStroke) {
        this.hasStroke = hasStroke;
    }

    public Boolean getHasOtherCardiovascularDiseases() {
        return hasOtherCardiovascularDiseases;
    }

    public void setHasOtherCardiovascularDiseases(Boolean hasOtherCardiovascularDiseases) {
        this.hasOtherCardiovascularDiseases = hasOtherCardiovascularDiseases;
    }

    public Boolean getHasAsthma() {
        return hasAsthma;
    }

    public void setHasAsthma(Boolean hasAsthma) {
        this.hasAsthma = hasAsthma;
    }

    public Boolean getHasCOPD() {
        return hasCOPD;
    }

    public void setHasCOPD(Boolean hasCOPD) {
        this.hasCOPD = hasCOPD;
    }

    public Boolean getHasPepticUlcer() {
        return hasPepticUlcer;
    }

    public void setHasPepticUlcer(Boolean hasPepticUlcer) {
        this.hasPepticUlcer = hasPepticUlcer;
    }

    public Boolean getHasMalignantTumor() {
        return hasMalignantTumor;
    }

    public void setHasMalignantTumor(Boolean hasMalignantTumor) {
        this.hasMalignantTumor = hasMalignantTumor;
    }

    public Boolean getHasLungCancer() {
        return hasLungCancer;
    }

    public void setHasLungCancer(Boolean hasLungCancer) {
        this.hasLungCancer = hasLungCancer;
    }

    public Boolean getHasOtherCancer() {
        return hasOtherCancer;
    }

    public void setHasOtherCancer(Boolean hasOtherCancer) {
        this.hasOtherCancer = hasOtherCancer;
    }

    public String getOtherCancerName() {
        return otherCancerName;
    }

    public void setOtherCancerName(String otherCancerName) {
        this.otherCancerName = otherCancerName;
    }

    public Boolean getHasSevereMentalDisorders() {
        return hasSevereMentalDisorders;
    }

    public void setHasSevereMentalDisorders(Boolean hasSevereMentalDisorders) {
        this.hasSevereMentalDisorders = hasSevereMentalDisorders;
    }

    public Boolean getHasTuberculosis() {
        return hasTuberculosis;
    }

    public void setHasTuberculosis(Boolean hasTuberculosis) {
        this.hasTuberculosis = hasTuberculosis;
    }

    public Boolean getHasHepatitis() {
        return hasHepatitis;
    }

    public void setHasHepatitis(Boolean hasHepatitis) {
        this.hasHepatitis = hasHepatitis;
    }

    public Boolean getHasOccupationalDisease() {
        return hasOccupationalDisease;
    }

    public void setHasOccupationalDisease(Boolean hasOccupationalDisease) {
        this.hasOccupationalDisease = hasOccupationalDisease;
    }

    public Boolean getHasChronicKidneyDisease() {
        return hasChronicKidneyDisease;
    }

    public void setHasChronicKidneyDisease(Boolean hasChronicKidneyDisease) {
        this.hasChronicKidneyDisease = hasChronicKidneyDisease;
    }

    public Boolean getHasChronicLiverDisease() {
        return hasChronicLiverDisease;
    }

    public void setHasChronicLiverDisease(Boolean hasChronicLiverDisease) {
        this.hasChronicLiverDisease = hasChronicLiverDisease;
    }

    public Boolean getHasImmunodeficiency() {
        return hasImmunodeficiency;
    }

    public void setHasImmunodeficiency(Boolean hasImmunodeficiency) {
        this.hasImmunodeficiency = hasImmunodeficiency;
    }

    public Boolean getHasTyphus() {
        return hasTyphus;
    }

    public void setHasTyphus(Boolean hasTyphus) {
        this.hasTyphus = hasTyphus;
    }

    public Boolean getPostpartumInSixWeeks() {
        return isPostpartumInSixWeeks;
    }

    public void setPostpartumInSixWeeks(Boolean postpartumInSixWeeks) {
        isPostpartumInSixWeeks = postpartumInSixWeeks;
    }

    public Boolean getHasDustExposure() {
        return hasDustExposure;
    }

    public void setHasDustExposure(Boolean hasDustExposure) {
        this.hasDustExposure = hasDustExposure;
    }

    public Boolean getHasOtherDiseases() {
        return hasOtherDiseases;
    }

    public void setHasOtherDiseases(Boolean hasOtherDiseases) {
        this.hasOtherDiseases = hasOtherDiseases;
    }

    public String getOtherDiseasesName() {
        return otherDiseasesName;
    }

    public void setOtherDiseasesName(String otherDiseasesName) {
        this.otherDiseasesName = otherDiseasesName;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public String getDrinkingStatus() {
        return drinkingStatus;
    }

    public void setDrinkingStatus(String drinkingStatus) {
        this.drinkingStatus = drinkingStatus;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean getVaccinatedForCOVID() {
        return isVaccinatedForCOVID;
    }

    public void setVaccinatedForCOVID(Boolean vaccinatedForCOVID) {
        isVaccinatedForCOVID = vaccinatedForCOVID;
    }

    public Boolean getVaccinatedForFlu() {
        return isVaccinatedForFlu;
    }

    public void setVaccinatedForFlu(Boolean vaccinatedForFlu) {
        isVaccinatedForFlu = vaccinatedForFlu;
    }

    public Boolean getVaccinatedForPlague() {
        return isVaccinatedForPlague;
    }

    public void setVaccinatedForPlague(Boolean vaccinatedForPlague) {
        isVaccinatedForPlague = vaccinatedForPlague;
    }

    public Boolean getVaccinatedForBCG() {
        return isVaccinatedForBCG;
    }

    public void setVaccinatedForBCG(Boolean vaccinatedForBCG) {
        isVaccinatedForBCG = vaccinatedForBCG;
    }

    public Boolean getVaccinatedForHepatitis() {
        return isVaccinatedForHepatitis;
    }

    public void setVaccinatedForHepatitis(Boolean vaccinatedForHepatitis) {
        isVaccinatedForHepatitis = vaccinatedForHepatitis;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhoneNumber() {
        return emergencyContactPhoneNumber;
    }

    public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
        this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
    }

    public String getEmergencyContactRelation() {
        return emergencyContactRelation;
    }

    public void setEmergencyContactRelation(String emergencyContactRelation) {
        this.emergencyContactRelation = emergencyContactRelation;
    }
}
