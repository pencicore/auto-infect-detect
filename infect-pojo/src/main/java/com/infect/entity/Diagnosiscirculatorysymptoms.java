package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 诊断循环系统症状实体类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("diagnosiscirculatorysymptoms")
@ApiModel(value = "Diagnosiscirculatorysymptoms对象", description = "诊断循环系统症状")
public class Diagnosiscirculatorysymptoms implements Serializable {
    @Override
    public String toString() {
        return "Diagnosiscirculatorysymptoms{" +
                "diagnosisCirculatorySymptomId=" + diagnosisCirculatorySymptomId +
                ", diagnosisResultsId=" + diagnosisResultsId +
                ", hasArrhythmia=" + hasArrhythmia +
                ", hasChestPain=" + hasChestPain +
                ", hasRapidPulse=" + hasRapidPulse +
                ", hasPalpitation=" + hasPalpitation +
                '}';
    }

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisCirculatorySymptomID", type = IdType.AUTO)
    @ApiModelProperty(value = "循环系统症状ID，自增", required = true, hidden = true)
    private Integer diagnosisCirculatorySymptomId;

    @ApiModelProperty(value = "诊断结果ID，关联DiagnosisResults表", hidden = true)
    private Integer diagnosisResultsId;

    @ApiModelProperty(value = "是否心律不齐", required = true, example = "true")
    private Boolean hasArrhythmia;

    @ApiModelProperty(value = "是否胸痛", required = true, example = "false")
    private Boolean hasChestPain;

    @ApiModelProperty(value = "是否脉搏细速", required = true, example = "true")
    private Boolean hasRapidPulse;

    @ApiModelProperty(value = "是否心悸", required = true, example = "false")
    private Boolean hasPalpitation;

    public Integer getDiagnosisCirculatorySymptomId() {
        return diagnosisCirculatorySymptomId;
    }

    public void setDiagnosisCirculatorySymptomId(Integer diagnosisCirculatorySymptomId) {
        this.diagnosisCirculatorySymptomId = diagnosisCirculatorySymptomId;
    }

    public Integer getDiagnosisResultsId() {
        return diagnosisResultsId;
    }

    public void setDiagnosisResultsId(Integer diagnosisResultsId) {
        this.diagnosisResultsId = diagnosisResultsId;
    }

    public Boolean getHasArrhythmia() {
        return hasArrhythmia;
    }

    public void setHasArrhythmia(Boolean hasArrhythmia) {
        this.hasArrhythmia = hasArrhythmia;
    }

    public Boolean getHasChestPain() {
        return hasChestPain;
    }

    public void setHasChestPain(Boolean hasChestPain) {
        this.hasChestPain = hasChestPain;
    }

    public Boolean getHasRapidPulse() {
        return hasRapidPulse;
    }

    public void setHasRapidPulse(Boolean hasRapidPulse) {
        this.hasRapidPulse = hasRapidPulse;
    }

    public Boolean getHasPalpitation() {
        return hasPalpitation;
    }

    public void setHasPalpitation(Boolean hasPalpitation) {
        this.hasPalpitation = hasPalpitation;
    }
}
