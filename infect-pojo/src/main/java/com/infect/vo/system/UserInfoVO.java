package com.infect.vo.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@ApiModel("用户导入DTO")
public class UserInfoVO {

    @ApiModelProperty(value = "用户类型", required = true, example = "系统管理员")
    private String userType;

    @ApiModelProperty(value = "是否激活", required = true, example = "true")
    private Boolean isActived;

    @ApiModelProperty(value = "姓名", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value = "性别", required = true, example = "男")
    private String gender;

    @ApiModelProperty(value = "是否怀孕", example = "false")
    private Boolean isPregnant;

    @ApiModelProperty(value = "怀孕周数", example = "0")
    private Integer pregnancyWeeks;

    @ApiModelProperty(value = "身份证号", required = true, example = "123456789012345678")
    private String idNumber;

    @ApiModelProperty(value = "出生日期", example = "1990-01-01")
    private LocalDate birthDate;

    @ApiModelProperty(value = "年龄", example = "30")
    private Integer age;

    @ApiModelProperty(value = "民族", example = "汉族")
    private String ethnicity;

    @ApiModelProperty(value = "教育水平", example = "大专/本科")
    private String educationLevel;

    @ApiModelProperty(value = "在高原工作的开始日期", example = "2015-01-01")
    private LocalDate workOnPlateauStartDate;

    @ApiModelProperty(value = "部门", example = "安全部")
    private String department;

    @ApiModelProperty(value = "特殊职业", example = "医务人员")
    private String specificOccupation;

    @ApiModelProperty(value = "医务人员类型", example = "医生")
    private String medicalPersonnelType;

    @ApiModelProperty(value = "其他职位名称", example = "其他医务类别")
    private String otherPositionName;

    @ApiModelProperty(value = "电话号码", required = true, example = "13800138000")
    private String phoneNumber;

    @ApiModelProperty(value = "其他电话号码", example = "13800138001")
    private String otherPhoneNumber;

    @ApiModelProperty(value = "是否有既往病史", example = "false")
    private Boolean hasMedicalHistory;

    @ApiModelProperty(value = "是否有高血压", example = "false")
    private Boolean hasHypertension;

    @ApiModelProperty(value = "是否有糖尿病", example = "false")
    private Boolean hasDiabetes;

    @ApiModelProperty(value = "是否有高脂血症", example = "false")
    private Boolean hasHyperlipidemia;

    @ApiModelProperty(value = "是否有高尿酸", example = "false")
    private Boolean hasHyperuricemia;

    @ApiModelProperty(value = "是否有冠心病", example = "false")
    private Boolean hasCoronaryHeartDisease;

    @ApiModelProperty(value = "是否有脑卒中", example = "false")
    private Boolean hasStroke;

    @ApiModelProperty(value = "是否有其他心脑血管疾病", example = "false")
    private Boolean hasOtherCardiovascularDiseases;

    @ApiModelProperty(value = "是否有哮喘", example = "false")
    private Boolean hasAsthma;

    @ApiModelProperty(value = "是否有慢性阻塞性肺部疾病", example = "false")
    private Boolean hasCOPD;

    @ApiModelProperty(value = "是否有消化性溃疡", example = "false")
    private Boolean hasPepticUlcer;

    @ApiModelProperty(value = "是否有恶性肿瘤", example = "false")
    private Boolean hasMalignantTumor;

    @ApiModelProperty(value = "是否有肺癌", example = "false")
    private Boolean hasLungCancer;

    @ApiModelProperty(value = "是否有其他癌症", example = "false")
    private Boolean hasOtherCancer;

    @ApiModelProperty(value = "其他癌症名称", example = "皮肤癌")
    private String otherCancerName;

    @ApiModelProperty(value = "是否有严重精神障碍", example = "false")
    private Boolean hasSevereMentalDisorders;

    @ApiModelProperty(value = "是否有结核病", example = "false")
    private Boolean hasTuberculosis;

    @ApiModelProperty(value = "是否有肝炎", example = "false")
    private Boolean hasHepatitis;

    @ApiModelProperty(value = "是否有职业病", example = "false")
    private Boolean hasOccupationalDisease;

    @ApiModelProperty(value = "是否有慢性肾病", example = "false")
    private Boolean hasChronicKidneyDisease;

    @ApiModelProperty(value = "是否有慢性肝病", example = "false")
    private Boolean hasChronicLiverDisease;

    @ApiModelProperty(value = "是否有免疫缺陷类疾病", example = "false")
    private Boolean hasImmunodeficiency;

    @ApiModelProperty(value = "是否有斑疹伤寒", example = "false")
    private Boolean hasTyphus;

    @ApiModelProperty(value = "是否为产后6周以内", example = "false")
    private Boolean isPostpartumInSixWeeks;

    @ApiModelProperty(value = "是否有粉尘接触史", example = "false")
    private Boolean hasDustExposure;

    @ApiModelProperty(value = "是否有其他疾病", example = "false")
    private Boolean hasOtherDiseases;

    @ApiModelProperty(value = "其他疾病名称", example = "贫血")
    private String otherDiseasesName;

    @ApiModelProperty(value = "吸烟状态", example = "从不吸")
    private String smokingStatus;

    @ApiModelProperty(value = "喝酒状态", example = "偶尔喝酒（小于3次/周）")
    private String drinkingStatus;

    @ApiModelProperty(value = "身高", example = "170")
    private Integer height;

    @ApiModelProperty(value = "体重", example = "60")
    private Integer weight;

    @ApiModelProperty(value = "是否接种新冠疫苗", example = "true")
    private Boolean isVaccinatedForCOVID;

    @ApiModelProperty(value = "是否接种流感疫苗", example = "true")
    private Boolean isVaccinatedForFlu;

    @ApiModelProperty(value = "是否接种鼠疫疫苗", example = "false")
    private Boolean isVaccinatedForPlague;

    @ApiModelProperty(value = "是否接种卡介苗", example = "true")
    private Boolean isVaccinatedForBCG;

    @ApiModelProperty(value = "是否接种肝炎疫苗", example = "true")
    private Boolean isVaccinatedForHepatitis;

    @ApiModelProperty(value = "紧急联系人姓名", example = "李四")
    private String emergencyContactName;

    @ApiModelProperty(value = "紧急联系人电话", example = "13900139000")
    private String emergencyContactPhoneNumber;

    @ApiModelProperty(value = "紧急联系人关系", example = "朋友")
    private String emergencyContactRelation;

    public UserInfoVO() {
    }

    public UserInfoVO(String userType, Boolean isActived, String name, String gender, Boolean isPregnant, Integer pregnancyWeeks, String idNumber, LocalDate birthDate, Integer age, String ethnicity, String educationLevel, LocalDate workOnPlateauStartDate, String department, String specificOccupation, String medicalPersonnelType, String otherPositionName, String phoneNumber, String otherPhoneNumber, Boolean hasMedicalHistory, Boolean hasHypertension, Boolean hasDiabetes, Boolean hasHyperlipidemia, Boolean hasHyperuricemia, Boolean hasCoronaryHeartDisease, Boolean hasStroke, Boolean hasOtherCardiovascularDiseases, Boolean hasAsthma, Boolean hasCOPD, Boolean hasPepticUlcer, Boolean hasMalignantTumor, Boolean hasLungCancer, Boolean hasOtherCancer, String otherCancerName, Boolean hasSevereMentalDisorders, Boolean hasTuberculosis, Boolean hasHepatitis, Boolean hasOccupationalDisease, Boolean hasChronicKidneyDisease, Boolean hasChronicLiverDisease, Boolean hasImmunodeficiency, Boolean hasTyphus, Boolean isPostpartumInSixWeeks, Boolean hasDustExposure, Boolean hasOtherDiseases, String otherDiseasesName, String smokingStatus, String drinkingStatus, Integer height, Integer weight, Boolean isVaccinatedForCOVID, Boolean isVaccinatedForFlu, Boolean isVaccinatedForPlague, Boolean isVaccinatedForBCG, Boolean isVaccinatedForHepatitis, String emergencyContactName, String emergencyContactPhoneNumber, String emergencyContactRelation) {
        this.userType = userType;
        this.isActived = isActived;
        this.name = name;
        this.gender = gender;
        this.isPregnant = isPregnant;
        this.pregnancyWeeks = pregnancyWeeks;
        this.idNumber = idNumber;
        this.birthDate = birthDate;
        this.age = age;
        this.ethnicity = ethnicity;
        this.educationLevel = educationLevel;
        this.workOnPlateauStartDate = workOnPlateauStartDate;
        this.department = department;
        this.specificOccupation = specificOccupation;
        this.medicalPersonnelType = medicalPersonnelType;
        this.otherPositionName = otherPositionName;
        this.phoneNumber = phoneNumber;
        this.otherPhoneNumber = otherPhoneNumber;
        this.hasMedicalHistory = hasMedicalHistory;
        this.hasHypertension = hasHypertension;
        this.hasDiabetes = hasDiabetes;
        this.hasHyperlipidemia = hasHyperlipidemia;
        this.hasHyperuricemia = hasHyperuricemia;
        this.hasCoronaryHeartDisease = hasCoronaryHeartDisease;
        this.hasStroke = hasStroke;
        this.hasOtherCardiovascularDiseases = hasOtherCardiovascularDiseases;
        this.hasAsthma = hasAsthma;
        this.hasCOPD = hasCOPD;
        this.hasPepticUlcer = hasPepticUlcer;
        this.hasMalignantTumor = hasMalignantTumor;
        this.hasLungCancer = hasLungCancer;
        this.hasOtherCancer = hasOtherCancer;
        this.otherCancerName = otherCancerName;
        this.hasSevereMentalDisorders = hasSevereMentalDisorders;
        this.hasTuberculosis = hasTuberculosis;
        this.hasHepatitis = hasHepatitis;
        this.hasOccupationalDisease = hasOccupationalDisease;
        this.hasChronicKidneyDisease = hasChronicKidneyDisease;
        this.hasChronicLiverDisease = hasChronicLiverDisease;
        this.hasImmunodeficiency = hasImmunodeficiency;
        this.hasTyphus = hasTyphus;
        this.isPostpartumInSixWeeks = isPostpartumInSixWeeks;
        this.hasDustExposure = hasDustExposure;
        this.hasOtherDiseases = hasOtherDiseases;
        this.otherDiseasesName = otherDiseasesName;
        this.smokingStatus = smokingStatus;
        this.drinkingStatus = drinkingStatus;
        this.height = height;
        this.weight = weight;
        this.isVaccinatedForCOVID = isVaccinatedForCOVID;
        this.isVaccinatedForFlu = isVaccinatedForFlu;
        this.isVaccinatedForPlague = isVaccinatedForPlague;
        this.isVaccinatedForBCG = isVaccinatedForBCG;
        this.isVaccinatedForHepatitis = isVaccinatedForHepatitis;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
        this.emergencyContactRelation = emergencyContactRelation;
    }

    /**
     * 获取
     * @return userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 获取
     * @return isActived
     */
    public Boolean getIsActived() {
        return isActived;
    }

    /**
     * 设置
     * @param isActived
     */
    public void setIsActived(Boolean isActived) {
        this.isActived = isActived;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return isPregnant
     */
    public Boolean getIsPregnant() {
        return isPregnant;
    }

    /**
     * 设置
     * @param isPregnant
     */
    public void setIsPregnant(Boolean isPregnant) {
        this.isPregnant = isPregnant;
    }

    /**
     * 获取
     * @return pregnancyWeeks
     */
    public Integer getPregnancyWeeks() {
        return pregnancyWeeks;
    }

    /**
     * 设置
     * @param pregnancyWeeks
     */
    public void setPregnancyWeeks(Integer pregnancyWeeks) {
        this.pregnancyWeeks = pregnancyWeeks;
    }

    /**
     * 获取
     * @return idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置
     * @param idNumber
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * 获取
     * @return birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * 设置
     * @param birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return ethnicity
     */
    public String getEthnicity() {
        return ethnicity;
    }

    /**
     * 设置
     * @param ethnicity
     */
    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    /**
     * 获取
     * @return educationLevel
     */
    public String getEducationLevel() {
        return educationLevel;
    }

    /**
     * 设置
     * @param educationLevel
     */
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    /**
     * 获取
     * @return workOnPlateauStartDate
     */
    public LocalDate getWorkOnPlateauStartDate() {
        return workOnPlateauStartDate;
    }

    /**
     * 设置
     * @param workOnPlateauStartDate
     */
    public void setWorkOnPlateauStartDate(LocalDate workOnPlateauStartDate) {
        this.workOnPlateauStartDate = workOnPlateauStartDate;
    }

    /**
     * 获取
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取
     * @return specificOccupation
     */
    public String getSpecificOccupation() {
        return specificOccupation;
    }

    /**
     * 设置
     * @param specificOccupation
     */
    public void setSpecificOccupation(String specificOccupation) {
        this.specificOccupation = specificOccupation;
    }

    /**
     * 获取
     * @return medicalPersonnelType
     */
    public String getMedicalPersonnelType() {
        return medicalPersonnelType;
    }

    /**
     * 设置
     * @param medicalPersonnelType
     */
    public void setMedicalPersonnelType(String medicalPersonnelType) {
        this.medicalPersonnelType = medicalPersonnelType;
    }

    /**
     * 获取
     * @return otherPositionName
     */
    public String getOtherPositionName() {
        return otherPositionName;
    }

    /**
     * 设置
     * @param otherPositionName
     */
    public void setOtherPositionName(String otherPositionName) {
        this.otherPositionName = otherPositionName;
    }

    /**
     * 获取
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取
     * @return otherPhoneNumber
     */
    public String getOtherPhoneNumber() {
        return otherPhoneNumber;
    }

    /**
     * 设置
     * @param otherPhoneNumber
     */
    public void setOtherPhoneNumber(String otherPhoneNumber) {
        this.otherPhoneNumber = otherPhoneNumber;
    }

    /**
     * 获取
     * @return hasMedicalHistory
     */
    public Boolean getHasMedicalHistory() {
        return hasMedicalHistory;
    }

    /**
     * 设置
     * @param hasMedicalHistory
     */
    public void setHasMedicalHistory(Boolean hasMedicalHistory) {
        this.hasMedicalHistory = hasMedicalHistory;
    }

    /**
     * 获取
     * @return hasHypertension
     */
    public Boolean getHasHypertension() {
        return hasHypertension;
    }

    /**
     * 设置
     * @param hasHypertension
     */
    public void setHasHypertension(Boolean hasHypertension) {
        this.hasHypertension = hasHypertension;
    }

    /**
     * 获取
     * @return hasDiabetes
     */
    public Boolean getHasDiabetes() {
        return hasDiabetes;
    }

    /**
     * 设置
     * @param hasDiabetes
     */
    public void setHasDiabetes(Boolean hasDiabetes) {
        this.hasDiabetes = hasDiabetes;
    }

    /**
     * 获取
     * @return hasHyperlipidemia
     */
    public Boolean getHasHyperlipidemia() {
        return hasHyperlipidemia;
    }

    /**
     * 设置
     * @param hasHyperlipidemia
     */
    public void setHasHyperlipidemia(Boolean hasHyperlipidemia) {
        this.hasHyperlipidemia = hasHyperlipidemia;
    }

    /**
     * 获取
     * @return hasHyperuricemia
     */
    public Boolean getHasHyperuricemia() {
        return hasHyperuricemia;
    }

    /**
     * 设置
     * @param hasHyperuricemia
     */
    public void setHasHyperuricemia(Boolean hasHyperuricemia) {
        this.hasHyperuricemia = hasHyperuricemia;
    }

    /**
     * 获取
     * @return hasCoronaryHeartDisease
     */
    public Boolean getHasCoronaryHeartDisease() {
        return hasCoronaryHeartDisease;
    }

    /**
     * 设置
     * @param hasCoronaryHeartDisease
     */
    public void setHasCoronaryHeartDisease(Boolean hasCoronaryHeartDisease) {
        this.hasCoronaryHeartDisease = hasCoronaryHeartDisease;
    }

    /**
     * 获取
     * @return hasStroke
     */
    public Boolean getHasStroke() {
        return hasStroke;
    }

    /**
     * 设置
     * @param hasStroke
     */
    public void setHasStroke(Boolean hasStroke) {
        this.hasStroke = hasStroke;
    }

    /**
     * 获取
     * @return hasOtherCardiovascularDiseases
     */
    public Boolean getHasOtherCardiovascularDiseases() {
        return hasOtherCardiovascularDiseases;
    }

    /**
     * 设置
     * @param hasOtherCardiovascularDiseases
     */
    public void setHasOtherCardiovascularDiseases(Boolean hasOtherCardiovascularDiseases) {
        this.hasOtherCardiovascularDiseases = hasOtherCardiovascularDiseases;
    }

    /**
     * 获取
     * @return hasAsthma
     */
    public Boolean getHasAsthma() {
        return hasAsthma;
    }

    /**
     * 设置
     * @param hasAsthma
     */
    public void setHasAsthma(Boolean hasAsthma) {
        this.hasAsthma = hasAsthma;
    }

    /**
     * 获取
     * @return hasCOPD
     */
    public Boolean getHasCOPD() {
        return hasCOPD;
    }

    /**
     * 设置
     * @param hasCOPD
     */
    public void setHasCOPD(Boolean hasCOPD) {
        this.hasCOPD = hasCOPD;
    }

    /**
     * 获取
     * @return hasPepticUlcer
     */
    public Boolean getHasPepticUlcer() {
        return hasPepticUlcer;
    }

    /**
     * 设置
     * @param hasPepticUlcer
     */
    public void setHasPepticUlcer(Boolean hasPepticUlcer) {
        this.hasPepticUlcer = hasPepticUlcer;
    }

    /**
     * 获取
     * @return hasMalignantTumor
     */
    public Boolean getHasMalignantTumor() {
        return hasMalignantTumor;
    }

    /**
     * 设置
     * @param hasMalignantTumor
     */
    public void setHasMalignantTumor(Boolean hasMalignantTumor) {
        this.hasMalignantTumor = hasMalignantTumor;
    }

    /**
     * 获取
     * @return hasLungCancer
     */
    public Boolean getHasLungCancer() {
        return hasLungCancer;
    }

    /**
     * 设置
     * @param hasLungCancer
     */
    public void setHasLungCancer(Boolean hasLungCancer) {
        this.hasLungCancer = hasLungCancer;
    }

    /**
     * 获取
     * @return hasOtherCancer
     */
    public Boolean getHasOtherCancer() {
        return hasOtherCancer;
    }

    /**
     * 设置
     * @param hasOtherCancer
     */
    public void setHasOtherCancer(Boolean hasOtherCancer) {
        this.hasOtherCancer = hasOtherCancer;
    }

    /**
     * 获取
     * @return otherCancerName
     */
    public String getOtherCancerName() {
        return otherCancerName;
    }

    /**
     * 设置
     * @param otherCancerName
     */
    public void setOtherCancerName(String otherCancerName) {
        this.otherCancerName = otherCancerName;
    }

    /**
     * 获取
     * @return hasSevereMentalDisorders
     */
    public Boolean getHasSevereMentalDisorders() {
        return hasSevereMentalDisorders;
    }

    /**
     * 设置
     * @param hasSevereMentalDisorders
     */
    public void setHasSevereMentalDisorders(Boolean hasSevereMentalDisorders) {
        this.hasSevereMentalDisorders = hasSevereMentalDisorders;
    }

    /**
     * 获取
     * @return hasTuberculosis
     */
    public Boolean getHasTuberculosis() {
        return hasTuberculosis;
    }

    /**
     * 设置
     * @param hasTuberculosis
     */
    public void setHasTuberculosis(Boolean hasTuberculosis) {
        this.hasTuberculosis = hasTuberculosis;
    }

    /**
     * 获取
     * @return hasHepatitis
     */
    public Boolean getHasHepatitis() {
        return hasHepatitis;
    }

    /**
     * 设置
     * @param hasHepatitis
     */
    public void setHasHepatitis(Boolean hasHepatitis) {
        this.hasHepatitis = hasHepatitis;
    }

    /**
     * 获取
     * @return hasOccupationalDisease
     */
    public Boolean getHasOccupationalDisease() {
        return hasOccupationalDisease;
    }

    /**
     * 设置
     * @param hasOccupationalDisease
     */
    public void setHasOccupationalDisease(Boolean hasOccupationalDisease) {
        this.hasOccupationalDisease = hasOccupationalDisease;
    }

    /**
     * 获取
     * @return hasChronicKidneyDisease
     */
    public Boolean getHasChronicKidneyDisease() {
        return hasChronicKidneyDisease;
    }

    /**
     * 设置
     * @param hasChronicKidneyDisease
     */
    public void setHasChronicKidneyDisease(Boolean hasChronicKidneyDisease) {
        this.hasChronicKidneyDisease = hasChronicKidneyDisease;
    }

    /**
     * 获取
     * @return hasChronicLiverDisease
     */
    public Boolean getHasChronicLiverDisease() {
        return hasChronicLiverDisease;
    }

    /**
     * 设置
     * @param hasChronicLiverDisease
     */
    public void setHasChronicLiverDisease(Boolean hasChronicLiverDisease) {
        this.hasChronicLiverDisease = hasChronicLiverDisease;
    }

    /**
     * 获取
     * @return hasImmunodeficiency
     */
    public Boolean getHasImmunodeficiency() {
        return hasImmunodeficiency;
    }

    /**
     * 设置
     * @param hasImmunodeficiency
     */
    public void setHasImmunodeficiency(Boolean hasImmunodeficiency) {
        this.hasImmunodeficiency = hasImmunodeficiency;
    }

    /**
     * 获取
     * @return hasTyphus
     */
    public Boolean getHasTyphus() {
        return hasTyphus;
    }

    /**
     * 设置
     * @param hasTyphus
     */
    public void setHasTyphus(Boolean hasTyphus) {
        this.hasTyphus = hasTyphus;
    }

    /**
     * 获取
     * @return isPostpartumInSixWeeks
     */
    public Boolean getIsPostpartumInSixWeeks() {
        return isPostpartumInSixWeeks;
    }

    /**
     * 设置
     * @param isPostpartumInSixWeeks
     */
    public void setIsPostpartumInSixWeeks(Boolean isPostpartumInSixWeeks) {
        this.isPostpartumInSixWeeks = isPostpartumInSixWeeks;
    }

    /**
     * 获取
     * @return hasDustExposure
     */
    public Boolean getHasDustExposure() {
        return hasDustExposure;
    }

    /**
     * 设置
     * @param hasDustExposure
     */
    public void setHasDustExposure(Boolean hasDustExposure) {
        this.hasDustExposure = hasDustExposure;
    }

    /**
     * 获取
     * @return hasOtherDiseases
     */
    public Boolean getHasOtherDiseases() {
        return hasOtherDiseases;
    }

    /**
     * 设置
     * @param hasOtherDiseases
     */
    public void setHasOtherDiseases(Boolean hasOtherDiseases) {
        this.hasOtherDiseases = hasOtherDiseases;
    }

    /**
     * 获取
     * @return otherDiseasesName
     */
    public String getOtherDiseasesName() {
        return otherDiseasesName;
    }

    /**
     * 设置
     * @param otherDiseasesName
     */
    public void setOtherDiseasesName(String otherDiseasesName) {
        this.otherDiseasesName = otherDiseasesName;
    }

    /**
     * 获取
     * @return smokingStatus
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /**
     * 设置
     * @param smokingStatus
     */
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    /**
     * 获取
     * @return drinkingStatus
     */
    public String getDrinkingStatus() {
        return drinkingStatus;
    }

    /**
     * 设置
     * @param drinkingStatus
     */
    public void setDrinkingStatus(String drinkingStatus) {
        this.drinkingStatus = drinkingStatus;
    }

    /**
     * 获取
     * @return height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 设置
     * @param height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 获取
     * @return weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置
     * @param weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取
     * @return isVaccinatedForCOVID
     */
    public Boolean getIsVaccinatedForCOVID() {
        return isVaccinatedForCOVID;
    }

    /**
     * 设置
     * @param isVaccinatedForCOVID
     */
    public void setIsVaccinatedForCOVID(Boolean isVaccinatedForCOVID) {
        this.isVaccinatedForCOVID = isVaccinatedForCOVID;
    }

    /**
     * 获取
     * @return isVaccinatedForFlu
     */
    public Boolean getIsVaccinatedForFlu() {
        return isVaccinatedForFlu;
    }

    /**
     * 设置
     * @param isVaccinatedForFlu
     */
    public void setIsVaccinatedForFlu(Boolean isVaccinatedForFlu) {
        this.isVaccinatedForFlu = isVaccinatedForFlu;
    }

    /**
     * 获取
     * @return isVaccinatedForPlague
     */
    public Boolean getIsVaccinatedForPlague() {
        return isVaccinatedForPlague;
    }

    /**
     * 设置
     * @param isVaccinatedForPlague
     */
    public void setIsVaccinatedForPlague(Boolean isVaccinatedForPlague) {
        this.isVaccinatedForPlague = isVaccinatedForPlague;
    }

    /**
     * 获取
     * @return isVaccinatedForBCG
     */
    public Boolean getIsVaccinatedForBCG() {
        return isVaccinatedForBCG;
    }

    /**
     * 设置
     * @param isVaccinatedForBCG
     */
    public void setIsVaccinatedForBCG(Boolean isVaccinatedForBCG) {
        this.isVaccinatedForBCG = isVaccinatedForBCG;
    }

    /**
     * 获取
     * @return isVaccinatedForHepatitis
     */
    public Boolean getIsVaccinatedForHepatitis() {
        return isVaccinatedForHepatitis;
    }

    /**
     * 设置
     * @param isVaccinatedForHepatitis
     */
    public void setIsVaccinatedForHepatitis(Boolean isVaccinatedForHepatitis) {
        this.isVaccinatedForHepatitis = isVaccinatedForHepatitis;
    }

    /**
     * 获取
     * @return emergencyContactName
     */
    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    /**
     * 设置
     * @param emergencyContactName
     */
    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    /**
     * 获取
     * @return emergencyContactPhoneNumber
     */
    public String getEmergencyContactPhoneNumber() {
        return emergencyContactPhoneNumber;
    }

    /**
     * 设置
     * @param emergencyContactPhoneNumber
     */
    public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
        this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
    }

    /**
     * 获取
     * @return emergencyContactRelation
     */
    public String getEmergencyContactRelation() {
        return emergencyContactRelation;
    }

    /**
     * 设置
     * @param emergencyContactRelation
     */
    public void setEmergencyContactRelation(String emergencyContactRelation) {
        this.emergencyContactRelation = emergencyContactRelation;
    }

    public String toString() {
        return "UserPutDTO{userType = " + userType + ", isActived = " + isActived + ", name = " + name + ", gender = " + gender + ", isPregnant = " + isPregnant + ", pregnancyWeeks = " + pregnancyWeeks + ", idNumber = " + idNumber + ", birthDate = " + birthDate + ", age = " + age + ", ethnicity = " + ethnicity + ", educationLevel = " + educationLevel + ", workOnPlateauStartDate = " + workOnPlateauStartDate + ", department = " + department + ", specificOccupation = " + specificOccupation + ", medicalPersonnelType = " + medicalPersonnelType + ", otherPositionName = " + otherPositionName + ", phoneNumber = " + phoneNumber + ", otherPhoneNumber = " + otherPhoneNumber + ", hasMedicalHistory = " + hasMedicalHistory + ", hasHypertension = " + hasHypertension + ", hasDiabetes = " + hasDiabetes + ", hasHyperlipidemia = " + hasHyperlipidemia + ", hasHyperuricemia = " + hasHyperuricemia + ", hasCoronaryHeartDisease = " + hasCoronaryHeartDisease + ", hasStroke = " + hasStroke + ", hasOtherCardiovascularDiseases = " + hasOtherCardiovascularDiseases + ", hasAsthma = " + hasAsthma + ", hasCOPD = " + hasCOPD + ", hasPepticUlcer = " + hasPepticUlcer + ", hasMalignantTumor = " + hasMalignantTumor + ", hasLungCancer = " + hasLungCancer + ", hasOtherCancer = " + hasOtherCancer + ", otherCancerName = " + otherCancerName + ", hasSevereMentalDisorders = " + hasSevereMentalDisorders + ", hasTuberculosis = " + hasTuberculosis + ", hasHepatitis = " + hasHepatitis + ", hasOccupationalDisease = " + hasOccupationalDisease + ", hasChronicKidneyDisease = " + hasChronicKidneyDisease + ", hasChronicLiverDisease = " + hasChronicLiverDisease + ", hasImmunodeficiency = " + hasImmunodeficiency + ", hasTyphus = " + hasTyphus + ", isPostpartumInSixWeeks = " + isPostpartumInSixWeeks + ", hasDustExposure = " + hasDustExposure + ", hasOtherDiseases = " + hasOtherDiseases + ", otherDiseasesName = " + otherDiseasesName + ", smokingStatus = " + smokingStatus + ", drinkingStatus = " + drinkingStatus + ", height = " + height + ", weight = " + weight + ", isVaccinatedForCOVID = " + isVaccinatedForCOVID + ", isVaccinatedForFlu = " + isVaccinatedForFlu + ", isVaccinatedForPlague = " + isVaccinatedForPlague + ", isVaccinatedForBCG = " + isVaccinatedForBCG + ", isVaccinatedForHepatitis = " + isVaccinatedForHepatitis + ", emergencyContactName = " + emergencyContactName + ", emergencyContactPhoneNumber = " + emergencyContactPhoneNumber + ", emergencyContactRelation = " + emergencyContactRelation + "}";
    }
}