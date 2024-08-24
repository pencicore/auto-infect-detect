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
 * 
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("diagnosispersonalinfo")
@ApiModel(value="Diagnosispersonalinfo对象", description="")
public class Diagnosispersonalinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisPersonalInfoID", type = IdType.AUTO)
    private Integer DiagnosisPersonalInfoID;

    private Integer DiagnosisResultsID;

    private BigDecimal Height;

    private BigDecimal Weight;

    private String BloodPressure;

    private BigDecimal BloodSugarFasting;

    private BigDecimal BloodSugarRandom;

    private BigDecimal CholesterolTotal;

    private BigDecimal Triglycerides;

    private BigDecimal CholesterolLipid;

    private BigDecimal hdl;

    private BigDecimal ldl;

    private BigDecimal BloodOxygen;


}
