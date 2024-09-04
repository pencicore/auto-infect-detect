package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * <p>
 * 诊断消化系统症状实体类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */

//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
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

    public Integer getDiagnosisDigestiveSymptomId() {
        return diagnosisDigestiveSymptomId;
    }

    public void setDiagnosisDigestiveSymptomId(Integer diagnosisDigestiveSymptomId) {
        this.diagnosisDigestiveSymptomId = diagnosisDigestiveSymptomId;
    }

    public Integer getDiagnosisResultsId() {
        return diagnosisResultsId;
    }

    public void setDiagnosisResultsId(Integer diagnosisResultsId) {
        this.diagnosisResultsId = diagnosisResultsId;
    }

    public Boolean getDiarrheaFrequencyGEThreeTimesPerDay() {
        return isDiarrheaFrequencyGEThreeTimesPerDay;
    }

    public void setDiarrheaFrequencyGEThreeTimesPerDay(Boolean diarrheaFrequencyGEThreeTimesPerDay) {
        isDiarrheaFrequencyGEThreeTimesPerDay = diarrheaFrequencyGEThreeTimesPerDay;
    }

    public Integer getDiarrheaTimesPerDay() {
        return diarrheaTimesPerDay;
    }

    public void setDiarrheaTimesPerDay(Integer diarrheaTimesPerDay) {
        this.diarrheaTimesPerDay = diarrheaTimesPerDay;
    }

    public Boolean getHasStoolType1() {
        return hasStoolType1;
    }

    public void setHasStoolType1(Boolean hasStoolType1) {
        this.hasStoolType1 = hasStoolType1;
    }

    public String getStoolType1Detail() {
        return stoolType1Detail;
    }

    public void setStoolType1Detail(String stoolType1Detail) {
        this.stoolType1Detail = stoolType1Detail;
    }

    public Boolean getHasStoolType2() {
        return hasStoolType2;
    }

    public void setHasStoolType2(Boolean hasStoolType2) {
        this.hasStoolType2 = hasStoolType2;
    }

    public String getStoolType2Detail() {
        return stoolType2Detail;
    }

    public void setStoolType2Detail(String stoolType2Detail) {
        this.stoolType2Detail = stoolType2Detail;
    }

    public String getDiarrheaMode() {
        return diarrheaMode;
    }

    public void setDiarrheaMode(String diarrheaMode) {
        this.diarrheaMode = diarrheaMode;
    }

    public String getStoolAmount() {
        return stoolAmount;
    }

    public void setStoolAmount(String stoolAmount) {
        this.stoolAmount = stoolAmount;
    }

    public String getStoolOdor() {
        return stoolOdor;
    }

    public void setStoolOdor(String stoolOdor) {
        this.stoolOdor = stoolOdor;
    }

    public Boolean getHasVomiting() {
        return hasVomiting;
    }

    public void setHasVomiting(Boolean hasVomiting) {
        this.hasVomiting = hasVomiting;
    }

    public String getVomitingMode() {
        return vomitingMode;
    }

    public void setVomitingMode(String vomitingMode) {
        this.vomitingMode = vomitingMode;
    }

    public Boolean getHasNausea() {
        return hasNausea;
    }

    public void setHasNausea(Boolean hasNausea) {
        this.hasNausea = hasNausea;
    }

    public Boolean getHasAppetiteLoss() {
        return hasAppetiteLoss;
    }

    public void setHasAppetiteLoss(Boolean hasAppetiteLoss) {
        this.hasAppetiteLoss = hasAppetiteLoss;
    }

    public Boolean getHasAbdominalDistension() {
        return hasAbdominalDistension;
    }

    public void setHasAbdominalDistension(Boolean hasAbdominalDistension) {
        this.hasAbdominalDistension = hasAbdominalDistension;
    }

    public Boolean getHasAbdominalPain() {
        return hasAbdominalPain;
    }

    public void setHasAbdominalPain(Boolean hasAbdominalPain) {
        this.hasAbdominalPain = hasAbdominalPain;
    }

    public Boolean getHasBorborygmus() {
        return hasBorborygmus;
    }

    public void setHasBorborygmus(Boolean hasBorborygmus) {
        this.hasBorborygmus = hasBorborygmus;
    }

    public Boolean getHasUpperAbdominalDiscomfort() {
        return hasUpperAbdominalDiscomfort;
    }

    public void setHasUpperAbdominalDiscomfort(Boolean hasUpperAbdominalDiscomfort) {
        this.hasUpperAbdominalDiscomfort = hasUpperAbdominalDiscomfort;
    }

    public Boolean getHasConstipation() {
        return hasConstipation;
    }

    public void setHasConstipation(Boolean hasConstipation) {
        this.hasConstipation = hasConstipation;
    }

    public Boolean getHasOliguriaOrAnuria() {
        return hasOliguriaOrAnuria;
    }

    public void setHasOliguriaOrAnuria(Boolean hasOliguriaOrAnuria) {
        this.hasOliguriaOrAnuria = hasOliguriaOrAnuria;
    }
}
