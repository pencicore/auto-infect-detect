package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDate;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("diagnosisresults")
@ApiModel(value = "Diagnosisresults对象", description = "诊断结果实体")
public class Diagnosisresults implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "诊断结果ID，自增", hidden = true)
    @TableId(value = "DiagnosisResultsID", type = IdType.AUTO)
    private Integer diagnosisResultsId;

    @ApiModelProperty(value = "用户ID", required = true, example = "123")
    private Integer userId;

    @ApiModelProperty(value = "提交时间", hidden = true)
    private LocalDate submissionTime;

    @ApiModelProperty(value = "提交用户ID", hidden = true)
    private Integer submissionUserId;

    @ApiModelProperty(value = "提交用户名", required = true, example = "张三")
    private String submissionUserName;

    @ApiModelProperty(value = "提交用户类型", required = true, example = "铁路职工")
    private String submissionUserType;

    @ApiModelProperty(value = "诊断的疾病类型", required = true, example = "新型冠状病毒感染")
    private String diseaseType;

    @ApiModelProperty(value = "其他疾病名称", required = true, example = "未知疾病")
    private String otherDiseaseName;

    @ApiModelProperty(value = "鼠疫子类", example = "腺鼠疫")
    private String plagueSubtype;

    @ApiModelProperty(value = "炭疽子类", example = "皮肤炭疽")
    private String anthraxSubtype;

    @ApiModelProperty(value = "病例发现途径", required = true, example = "主动就诊")
    private String discoveryMethod;

    @ApiModelProperty(value = "其他途径名称", required = true, example = "社区筛查")
    private String otherDiscoveryMethodName;

    @ApiModelProperty(value = "疾病转归", required = true, example = "治愈")
    private String diseaseOutcome;

    @ApiModelProperty(value = "确诊医院名称", required = true, example = "北京市医院")
    private String hospitalName;

    @ApiModelProperty(value = "就诊/入院日期", example = "2024-08-20")
    private LocalDate admissionDate;

    @ApiModelProperty(value = "出院日期", example = "2024-08-27")
    private LocalDate dischargeDate;

    @ApiModelProperty(value = "死亡日期", example = "2024-08-28")
    private LocalDate deathDate;

    @ApiModelProperty(value = "就诊/入院时症状和体征", example = "高热、咳嗽、呼吸困难")
    private String admissionSymptomsAndSigns;

    @ApiModelProperty(value = "登记分类", example = "新患者")
    private String registrationClassification;

    @ApiModelProperty(value = "登记分类其他详情", example = "复发病例")
    private String otherRegistrationDetails;
}
