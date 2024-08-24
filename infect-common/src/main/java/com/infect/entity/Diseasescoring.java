package com.infect.entity;

import java.math.BigDecimal;
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
@TableName("diseasescoring")
@ApiModel(value="Diseasescoring对象", description="")
public class Diseasescoring implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ScoringID", type = IdType.AUTO)
    private Integer ScoringID;

    private Integer StatusID;

    private LocalDate SymptomTime;

    private Integer DiseaseTypeID;

    private String DiseaseTypeName;

    private BigDecimal Score;


}
