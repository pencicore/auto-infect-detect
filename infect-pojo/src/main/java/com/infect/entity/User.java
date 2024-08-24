package com.infect.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.infect.enums.user.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("User")
@ApiModel(description = "用户实体")
public class User {

    @TableId(value = "UserID", type = IdType.AUTO)
    @ApiModelProperty(value = "用户ID", example = "1")
    private int userId;

    @ApiModelProperty(value = "密码", required = true)
    @TableField("Password")
    private String password;

    @ApiModelProperty(value = "用户类型", required = true, example = "系统管理员")
//    @Enumerated(EnumType.STRING)
    @TableField("UserType")
    private UserType userType;

    @ApiModelProperty(value = "是否激活", example = "true")
    @TableField("IsActived")
    private boolean isActived = true;

    @ApiModelProperty(value = "姓名", required = true)
    @TableField("Name")
    private String name;

    @ApiModelProperty(value = "性别", example = "男")
//    @Enumerated(EnumType.STRING)
    @TableField("Gender")
    private Gender gender;

    @ApiModelProperty(value = "是否怀孕")
    private Boolean isPregnant;

    @ApiModelProperty(value = "怀孕周数", example = "12")
    private Integer pregnancyWeeks;

    @ApiModelProperty(value = "身份证号", example = "123456789012345678")
//    @Column(unique = true)
    private String idNumber;

    @ApiModelProperty(value = "出生日期", example = "1990-01-01")
    private Date birthDate;

    @ApiModelProperty(value = "年龄", example = "30")
    private Integer age;

    @ApiModelProperty(value = "民族", example = "汉族")
//    @Enumerated(EnumType.STRING)
    private Ethnicity ethnicity;

    @ApiModelProperty(value = "教育水平", example = "大专/本科")
//    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;

    @ApiModelProperty(value = "在高原工作的开始日期", example = "2020-01-01")
    private Date workOnPlateauStartDate;

    @ApiModelProperty(value = "部门", example = "工程技术部")
//    @Enumerated(EnumType.STRING)
    private Department department;

    @ApiModelProperty(value = "特殊职业", example = "医务人员")
//    @Enumerated(EnumType.STRING)
    private SpecificOccupation specificOccupation;

    @ApiModelProperty(value = "具体医务人员类别", example = "医生")
//    @Enumerated(EnumType.STRING)
    private MedicalPersonnelType medicalPersonnelType;

    @ApiModelProperty(value = "具体医务人员其他类别的具体名称")
    private String otherPositionName;

    @ApiModelProperty(value = "电话号码", required = true, example = "12345678901")
//    @Column(nullable = false)
    private String phoneNumber;

    @ApiModelProperty(value = "其他电话号码", example = "9876543210")
    private String otherPhoneNumber;

    @ApiModelProperty(value = "是否有既往病史", example = "false")
    private Boolean hasMedicalHistory;

    @ApiModelProperty(value = "高血压", example = "false")
    private Boolean hasHypertension;

    @ApiModelProperty(value = "糖尿病", example = "false")
    private Boolean hasDiabetes;

    @ApiModelProperty(value = "高脂血症", example = "false")
    private Boolean hasHyperlipidemia;

    @ApiModelProperty(value = "高尿酸", example = "false")
    private Boolean hasHyperuricemia;

    @ApiModelProperty(value = "冠心病", example = "false")
    private Boolean hasCoronaryHeartDisease;

    @ApiModelProperty(value = "脑卒中", example = "false")
    private Boolean hasStroke;

    @ApiModelProperty(value = "其他心脑血管疾病", example = "false")
    private Boolean hasOtherCardiovascularDiseases;

    @ApiModelProperty(value = "哮喘", example = "false")
    private Boolean hasAsthma;

    @ApiModelProperty(value = "慢性阻塞性肺部疾病", example = "false")
    private Boolean hasCOPD;

    @ApiModelProperty(value = "消化性溃疡", example = "false")
    private Boolean hasPepticUlcer;

    @ApiModelProperty(value = "恶性肿瘤", example = "false")
    private Boolean hasMalignantTumor;

    @ApiModelProperty(value = "肺癌", example = "false")
    private Boolean hasLungCancer;

    @ApiModelProperty(value = "其他癌症", example = "false")
    private Boolean hasOtherCancer;

    @ApiModelProperty(value = "其他癌症的具体名称")
    private String otherCancerName;

    @ApiModelProperty(value = "严重精神障碍", example = "false")
    private Boolean hasSevereMentalDisorders;

    @ApiModelProperty(value = "结核病", example = "false")
    private Boolean hasTuberculosis;

    @ApiModelProperty(value = "肝炎", example = "false")
    private Boolean hasHepatitis;

    @ApiModelProperty(value = "职业病", example = "false")
    private Boolean hasOccupationalDisease;

    @ApiModelProperty(value = "慢性肾病", example = "false")
    private Boolean hasChronicKidneyDisease;

    @ApiModelProperty(value = "慢性肝病", example = "false")
    private Boolean hasChronicLiverDisease;

    @ApiModelProperty(value = "免疫缺陷类疾病", example = "false")
    private Boolean hasImmunodeficiency;

    @ApiModelProperty(value = "是否有斑疹伤寒", example = "false")
    private Boolean hasTyphus;

    @ApiModelProperty(value = "产后（6周以内）", example = "false")
    private Boolean isPostpartumInSixWeeks;

    @ApiModelProperty(value = "粉尘接触史", example = "false")
    private Boolean hasDustExposure;

    @ApiModelProperty(value = "有其他疾病", example = "false")
    private Boolean hasOtherDiseases;

    @ApiModelProperty(value = "其他疾病名称")
    private String otherDiseasesName;

    @ApiModelProperty(value = "吸烟状态", example = "从不吸")
//    @Enumerated(EnumType.STRING)
    private SmokingStatus smokingStatus;

    @ApiModelProperty(value = "喝酒状态", example = "偶尔喝酒（小于3次/周）")
//    @Enumerated(EnumType.STRING)
    private DrinkingStatus drinkingStatus;

    @ApiModelProperty(value = "身高", example = "170")
    private Integer height;

    @ApiModelProperty(value = "体重", example = "70")
    private Integer weight;

    @ApiModelProperty(value = "新冠疫苗接种情况", example = "true")
    private Boolean isVaccinatedForCOVID;

    @ApiModelProperty(value = "流感疫苗接种情况", example = "true")
    private Boolean isVaccinatedForFlu;

    @ApiModelProperty(value = "鼠疫疫苗接种情况", example = "true")
    private Boolean isVaccinatedForPlague;

    @ApiModelProperty(value = "卡介苗接种情况", example = "true")
    private Boolean isVaccinatedForBCG;

    @ApiModelProperty(value = "肝炎疫苗接种情况", example = "true")
    private Boolean isVaccinatedForHepatitis;
}