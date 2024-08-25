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
    private Integer diagnosisPersonalInfoId;

    private Integer diagnosisResultsId;

    private BigDecimal height;

    private BigDecimal weight;

    private String bloodPressure;

    private BigDecimal bloodSugarFasting;

    private BigDecimal bloodSugarRandom;

    private BigDecimal cholesterolTotal;

    private BigDecimal triglycerides;

    private BigDecimal cholesterolLipid;

    private BigDecimal hdl;

    private BigDecimal ldl;

    private BigDecimal bloodOxygen;
}
