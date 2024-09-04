package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 循环系统症状实体类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("circulatorysymptoms")
@ApiModel(value="Circulatorysymptoms对象", description="循环系统症状")
public class Circulatorysymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CirculatorySymptomsID", type = IdType.AUTO)
    @ApiModelProperty(value = "循环系统症状ID")
    private Integer circulatorySymptomsId;

    @ApiModelProperty(value = "每日健康状态ID")
    private Integer statusId;

    @ApiModelProperty(value = "是否有心律不齐", required = true, example = "false")
    private Boolean hasArrhythmia;

    @ApiModelProperty(value = "是否有胸痛", required = true, example = "true")
    private Boolean hasChestPain;

    @ApiModelProperty(value = "是否有脉搏细速", required = true, example = "false")
    private Boolean hasRapidPulse;

    @ApiModelProperty(value = "是否有心悸", required = true, example = "true")
    private Boolean hasPalpitation;

    @ApiModelProperty(value = "是否有低血压", required = true, example = "false")
    private Boolean hasLowBloodPressure;

    public Integer getCirculatorySymptomsId() {
        return circulatorySymptomsId;
    }

    public void setCirculatorySymptomsId(Integer circulatorySymptomsId) {
        this.circulatorySymptomsId = circulatorySymptomsId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
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

    public Boolean getHasLowBloodPressure() {
        return hasLowBloodPressure;
    }

    public void setHasLowBloodPressure(Boolean hasLowBloodPressure) {
        this.hasLowBloodPressure = hasLowBloodPressure;
    }
}
