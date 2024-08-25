package com.infect.entity;

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
@TableName("diagnosisdigestivesymptoms")
@ApiModel(value="Diagnosisdigestivesymptoms对象", description="")
public class Diagnosisdigestivesymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisDigestiveSymptomID", type = IdType.AUTO)
    private Integer diagnosisDigestiveSymptomId;

    private Integer diagnosisResultsId;

    private Boolean isDiarrheaFrequencyGEThreeTimesPerDay;

    private Integer diarrheaTimesPerDay;

    private Boolean hasStoolType1;

    @ApiModelProperty(value = "粪便性状1描述")
    private String stoolType1Detail;

    private Boolean hasStoolType2;

    @ApiModelProperty(value = "粪便性状2描述")
    private String stoolType2Detail;

    @ApiModelProperty(value = "腹泻方式")
    private String diarrheaMode;

    @ApiModelProperty(value = "粪便量")
    private String stoolAmount;

    @ApiModelProperty(value = "粪便气味")
    private String stoolOdor;

    private Boolean hasVomiting;

    @ApiModelProperty(value = "呕吐方式")
    private String vomitingMode;

    private Boolean hasNausea;

    private Boolean hasAppetiteLoss;

    private Boolean hasAbdominalDistension;

    private Boolean hasAbdominalPain;

    private Boolean hasBorborygmus;

    private Boolean hasUpperAbdominalDiscomfort;

    private Boolean hasConstipation;

    private Boolean hasOliguriaOrAnuria;
}
