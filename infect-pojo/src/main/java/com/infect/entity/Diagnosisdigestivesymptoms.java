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
 * 诊断消化系统症状实体类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("diagnosisdigestivesymptoms")
@ApiModel(value = "Diagnosisdigestivesymptoms对象", description = "诊断消化系统症状")
public class Diagnosisdigestivesymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisDigestiveSymptomID", type = IdType.AUTO)
    @ApiModelProperty(value = "消化系统症状ID，自增", required = true, hidden = true)
    private Integer diagnosisDigestiveSymptomId;

    @ApiModelProperty(value = "诊断结果ID，关联DiagnosisResults表", hidden = true)
    private Integer diagnosisResultsId;

    @ApiModelProperty(value = "腹泻频率,T表示≥3次/天", required = true, example = "true")
    private Boolean isDiarrheaFrequencyGEThreeTimesPerDay;

    @ApiModelProperty(value = "腹泻次数（次/天）", required = true, example = "5")
    private Integer diarrheaTimesPerDay;

    @ApiModelProperty(value = "是否有粪便性状1", required = true, example = "true")
    private Boolean hasStoolType1;

    @ApiModelProperty(value = "粪便性状1描述", required = true, example = "水样")
    private String stoolType1Detail;

    @ApiModelProperty(value = "是否有粪便性状2", required = true, example = "false")
    private Boolean hasStoolType2;

    @ApiModelProperty(value = "粪便性状2描述", required = true, example = "大块黏膜")
    private String stoolType2Detail;

    @ApiModelProperty(value = "腹泻方式", required = true, example = "通畅")
    private String diarrheaMode;

    @ApiModelProperty(value = "粪便量", required = true, example = "多")
    private String stoolAmount;

    @ApiModelProperty(value = "粪便气味", required = true, example = "恶臭")
    private String stoolOdor;

    @ApiModelProperty(value = "是否呕吐", required = true, example = "false")
    private Boolean hasVomiting;

    @ApiModelProperty(value = "呕吐方式", required = true, example = "先泻后吐")
    private String vomitingMode;

    @ApiModelProperty(value = "是否恶心", required = true, example = "true")
    private Boolean hasNausea;

    @ApiModelProperty(value = "是否食欲减退", required = true, example = "true")
    private Boolean hasAppetiteLoss;

    @ApiModelProperty(value = "是否腹胀", required = true, example = "false")
    private Boolean hasAbdominalDistension;

    @ApiModelProperty(value = "是否腹痛", required = true, example = "true")
    private Boolean hasAbdominalPain;

    @ApiModelProperty(value = "是否腹鸣", required = true, example = "true")
    private Boolean hasBorborygmus;

    @ApiModelProperty(value = "是否上腹部不适", required = true, example = "false")
    private Boolean hasUpperAbdominalDiscomfort;

    @ApiModelProperty(value = "是否便秘", required = true, example = "true")
    private Boolean hasConstipation;

    @ApiModelProperty(value = "是否少尿或无尿", required = true, example = "false")
    private Boolean hasOliguriaOrAnuria;
}
