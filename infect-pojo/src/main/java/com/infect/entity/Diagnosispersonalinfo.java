package com.infect.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 诊断个人基本情况实体类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("diagnosispersonalinfo")
@ApiModel(value = "Diagnosispersonalinfo对象", description = "诊断个人基本情况")
public class Diagnosispersonalinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisPersonalInfoID", type = IdType.AUTO)
    @ApiModelProperty(value = "个人健康信息ID，自增", hidden = true)
    private Integer diagnosisPersonalInfoId;

    @ApiModelProperty(value = "诊断结果ID，关联DiagnosisResults表", hidden = true)
    private Integer diagnosisResultsId;

    @ApiModelProperty(value = "身高", required = true, example = "175.50")
    private BigDecimal height;

    @ApiModelProperty(value = "体重", required = true, example = "70.00")
    private BigDecimal weight;

    @ApiModelProperty(value = "血压", required = true, example = "120/80")
    private String bloodPressure;

    @ApiModelProperty(value = "空腹血糖", required = true, example = "5.6")
    private BigDecimal bloodSugarFasting;

    @ApiModelProperty(value = "随机血糖", required = true, example = "7.8")
    private BigDecimal bloodSugarRandom;

    @ApiModelProperty(value = "总胆固醇", required = true, example = "4.5")
    private BigDecimal cholesterolTotal;

    @ApiModelProperty(value = "甘油三酯", required = true, example = "1.7")
    private BigDecimal triglycerides;

    @ApiModelProperty(value = "胆固醇脂", required = true, example = "3.2")
    private BigDecimal cholesterolLipid;

    @ApiModelProperty(value = "高密度脂蛋白", required = true, example = "1.2")
    private BigDecimal hdl;

    @ApiModelProperty(value = "低密度脂蛋白", required = true, example = "2.5")
    private BigDecimal ldl;

    @ApiModelProperty(value = "血氧饱和度", required = true, example = "98.5")
    private BigDecimal bloodOxygen;
}
