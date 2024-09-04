package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 诊断检查项目
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("diagnosisexaminations")
@ApiModel(value="Diagnosisexaminations对象", description="诊断检查项目")
public class Diagnosisexaminations implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ExaminationID", type = IdType.AUTO)
    @ApiModelProperty(value = "检查项目ID", hidden = true)
    private Integer examinationId;

    @ApiModelProperty(value = "诊断结果ID", hidden = true)
    private Integer diagnosisResultsId;

    @ApiModelProperty(value = "是否进行血常规", example = "true", required = true)
    private Boolean hasBloodTest;

    @ApiModelProperty(value = "是否进行尿常规", example = "false", required = true)
    private Boolean hasUrineTest;

    @ApiModelProperty(value = "是否进行粪便常规", example = "true", required = true)
    private Boolean hasStoolTest;

    @ApiModelProperty(value = "是否进行影像学检查", example = "true", required = true)
    private Boolean hasImaging;

    @ApiModelProperty(value = "是否进行B超", example = "false", required = true)
    private Boolean hasUltrasound;

    public Integer getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(Integer examinationId) {
        this.examinationId = examinationId;
    }

    public Integer getDiagnosisResultsId() {
        return diagnosisResultsId;
    }

    public void setDiagnosisResultsId(Integer diagnosisResultsId) {
        this.diagnosisResultsId = diagnosisResultsId;
    }

    public Boolean getHasBloodTest() {
        return hasBloodTest;
    }

    public void setHasBloodTest(Boolean hasBloodTest) {
        this.hasBloodTest = hasBloodTest;
    }

    public Boolean getHasUrineTest() {
        return hasUrineTest;
    }

    public void setHasUrineTest(Boolean hasUrineTest) {
        this.hasUrineTest = hasUrineTest;
    }

    public Boolean getHasStoolTest() {
        return hasStoolTest;
    }

    public void setHasStoolTest(Boolean hasStoolTest) {
        this.hasStoolTest = hasStoolTest;
    }

    public Boolean getHasImaging() {
        return hasImaging;
    }

    public void setHasImaging(Boolean hasImaging) {
        this.hasImaging = hasImaging;
    }

    public Boolean getHasUltrasound() {
        return hasUltrasound;
    }

    public void setHasUltrasound(Boolean hasUltrasound) {
        this.hasUltrasound = hasUltrasound;
    }
}
