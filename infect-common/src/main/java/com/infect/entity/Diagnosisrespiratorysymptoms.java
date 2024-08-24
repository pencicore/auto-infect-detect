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
@TableName("diagnosisrespiratorysymptoms")
@ApiModel(value="Diagnosisrespiratorysymptoms对象", description="")
public class Diagnosisrespiratorysymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisRespiratorySymptomID", type = IdType.AUTO)
    private Integer DiagnosisRespiratorySymptomID;

    private Integer DiagnosisResultsID;

    private Boolean HasCough;

    private Boolean HasSputum;

    private Boolean HasBloodySputum;

    private Boolean HasHemoptysis;

    private Boolean HasSoreThroat;

    private Boolean HasDryThroat;

    private Boolean HasNasalCongestion;

    private Boolean HasRunnyNose;

    private Boolean HasPharyngealHyperemia;

    private Boolean HasChestTightness;

    private Boolean HasShortnessOfBreath;

    private Boolean HasBreathingDifficulty;

    private Boolean HasHoarseness;

    private Boolean HasBronchitis;

    private Boolean HasLungRales;


}
