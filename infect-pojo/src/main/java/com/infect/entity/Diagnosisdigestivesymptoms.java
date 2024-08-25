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
    private Integer DiagnosisDigestiveSymptomID;

    private Integer DiagnosisResultsID;

    private Boolean IsDiarrheaFrequencyGEThreeTimesPerDay;

    private Integer DiarrheaTimesPerDay;

    private Boolean HasStoolType1;

    @ApiModelProperty(value = "粪便性状1描述")
    private String StoolType1Detail;

    private Boolean HasStoolType2;

    @ApiModelProperty(value = "粪便性状2描述")
    private String StoolType2Detail;

    @ApiModelProperty(value = "腹泻方式")
    private String DiarrheaMode;

    @ApiModelProperty(value = "粪便量")
    private String StoolAmount;

    @ApiModelProperty(value = "粪便气味")
    private String StoolOdor;

    private Boolean HasVomiting;

    @ApiModelProperty(value = "呕吐方式")
    private String VomitingMode;

    private Boolean HasNausea;

    private Boolean HasAppetiteLoss;

    private Boolean HasAbdominalDistension;

    private Boolean HasAbdominalPain;

    private Boolean HasBorborygmus;

    private Boolean HasUpperAbdominalDiscomfort;

    private Boolean HasConstipation;

    private Boolean HasOliguriaOrAnuria;


}
