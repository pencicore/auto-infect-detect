package com.infect.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
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
}
