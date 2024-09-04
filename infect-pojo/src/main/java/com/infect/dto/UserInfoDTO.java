package com.infect.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import java.time.LocalDate;

@ApiModel(description = "用户信息数据传输对象")
public class UserInfoDTO {

    @ApiModelProperty(value = "姓名", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value = "性别", required = true, example = "男")
    private String gender;

    @ApiModelProperty(value = "是否怀孕", required = true, example = "false")
    private Boolean isPregnant;

    @ApiModelProperty(value = "怀孕周数", required = true, example = "12")
    private Integer pregnancyWeeks;

    @ApiModelProperty(value = "身份证号", required = true, example = "123456789012345678")
    private String idNumber;

    @ApiModelProperty(value = "出生日期", required = true, example = "1990-01-01")
    private LocalDate birthDate;

    @ApiModelProperty(value = "年龄", required = true, example = "30")
    private Integer age;

    @ApiModelProperty(value = "民族", required = true, example = "汉族")
    private String ethnicity;

    @ApiModelProperty(value = "教育水平", required = true, example = "大专/本科")
    private String educationLevel;

    @ApiModelProperty(value = "在高原工作的开始日期", required = true, example = "2020-01-01")
    private LocalDate workOnPlateauStartDate;

    @ApiModelProperty(value = "部门", required = true, example = "安全部")
    private String department;

    @ApiModelProperty(value = "特殊职业", required = true, example = "医务人员")
    private String specificOccupation;

    @ApiModelProperty(value = "具体医务人员类别", required = true, example = "医生")
    private String medicalPersonnelType;

    @ApiModelProperty(value = "其他医务人员类别的具体名称", required = true, example = "急诊科医生")
    private String otherPositionName;

    @ApiModelProperty(value = "电话号码", required = true, example = "13800000000")
    private String phoneNumber;

    @ApiModelProperty(value = "其他电话号码", required = true, example = "13900000000")
    private String otherPhoneNumber;

    @ApiModelProperty(value = "是否有既往病史", required = true, example = "true")
    private Boolean hasMedicalHistory;

    @ApiModelProperty(value = "高血压", required = true, example = "false")
    private Boolean hasHypertension;

    @ApiModelProperty(value = "糖尿病", required = true, example = "false")
    private Boolean hasDiabetes;

    @ApiModelProperty(value = "高脂血症", required = true, example = "false")
    private Boolean hasHyperlipidemia;

    @ApiModelProperty(value = "高尿酸", required = true, example = "false")
    private Boolean hasHyperuricemia;

    @ApiModelProperty(value = "冠心病", required = true, example = "false")
    private Boolean hasCoronaryHeartDisease;

    @ApiModelProperty(value = "脑卒中", required = true, example = "false")
    private Boolean hasStroke;

    @ApiModelProperty(value = "其他心脑血管疾病", required = true, example = "false")
    private Boolean hasOtherCardiovascularDiseases;

    @ApiModelProperty(value = "哮喘", required = true, example = "false")
    private Boolean hasAsthma;

    @ApiModelProperty(value = "慢性阻塞性肺部疾病", required = true, example = "false")
    private Boolean hasCOPD;

    @ApiModelProperty(value = "消化性溃疡", required = true, example = "false")
    private Boolean hasPepticUlcer;

    @ApiModelProperty(value = "恶性肿瘤", required = true, example = "false")
    private Boolean hasMalignantTumor;

    @ApiModelProperty(value = "肺癌", required = true, example = "false")
    private Boolean hasLungCancer;

    @ApiModelProperty(value = "其他癌症", required = true, example = "false")
    private Boolean hasOtherCancer;

    @ApiModelProperty(value = "其他癌症的具体名称", required = true, example = "淋巴癌")
    private String otherCancerName;

    @ApiModelProperty(value = "严重精神障碍", required = true, example = "false")
    private Boolean hasSevereMentalDisorders;

    @ApiModelProperty(value = "结核病", required = true, example = "false")
    private Boolean hasTuberculosis;

    @ApiModelProperty(value = "肝炎", required = true, example = "false")
    private Boolean hasHepatitis;

    @ApiModelProperty(value = "职业病", required = true, example = "false")
    private Boolean hasOccupationalDisease;

    @ApiModelProperty(value = "慢性肾病", required = true, example = "false")
    private Boolean hasChronicKidneyDisease;

    @ApiModelProperty(value = "慢性肝病", required = true, example = "false")
    private Boolean hasChronicLiverDisease;

    @ApiModelProperty(value = "免疫缺陷类疾病", required = true, example = "false")
    private Boolean hasImmunodeficiency;

    @ApiModelProperty(value = "斑疹伤寒", required = true, example = "false")
    private Boolean hasTyphus;

    @ApiModelProperty(value = "产后（6周以内）", required = true, example = "false")
    private Boolean isPostpartumInSixWeeks;

    @ApiModelProperty(value = "粉尘接触史", required = true, example = "false")
    private Boolean hasDustExposure;

    @ApiModelProperty(value = "有其他疾病", required = true, example = "false")
    private Boolean hasOtherDiseases;

    @ApiModelProperty(value = "其他疾病名称", required = true, example = "高血糖")
    private String otherDiseasesName;

    @ApiModelProperty(value = "吸烟状态", required = true, example = "从不吸")
    private String smokingStatus;

    @ApiModelProperty(value = "喝酒状态", required = true, example = "偶尔喝酒（小于3次/周）")
    private String drinkingStatus;

    @ApiModelProperty(value = "身高", required = true, example = "170")
    private Integer height;

    @ApiModelProperty(value = "体重", required = true, example = "65")
    private Integer weight;

    @ApiModelProperty(value = "新冠疫苗接种情况", required = true, example = "true")
    private Boolean isVaccinatedForCOVID;

    @ApiModelProperty(value = "流感疫苗接种情况", required = true, example = "true")
    private Boolean isVaccinatedForFlu;

    @ApiModelProperty(value = "鼠疫疫苗接种情况", required = true, example = "true")
    private Boolean isVaccinatedForPlague;

    @ApiModelProperty(value = "卡介苗接种情况", required = true, example = "true")
    private Boolean isVaccinatedForBCG;

    @ApiModelProperty(value = "肝炎疫苗接种情况", required = true, example = "true")
    private Boolean isVaccinatedForHepatitis;

    @ApiModelProperty(value = "紧急联系人姓名", required = true, example = "mary")
    private String emergencyContactName;

    @ApiModelProperty(value = "紧急联系人电话", required = true, example = "12345678912")
    private String emergencyContactPhoneNumber;

    @ApiModelProperty(value = "紧急联系人关系", required = true, example = "朋友")
    private String emergencyContactRelation;

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
