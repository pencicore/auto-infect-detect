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
@TableName("diagnosislocalsymptoms")
@ApiModel(value="Diagnosislocalsymptoms对象", description="")
public class Diagnosislocalsymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisLocalSymptomID", type = IdType.AUTO)
    private Integer diagnosisLocalSymptomId;

    private Integer diagnosisResultsId;

    private Boolean hasConjunctivitis;

    private Boolean hasConjunctivalCongestion;

    private Boolean hasEyelidEdema;

    private Boolean hasSmellTasteLoss;

    private Boolean hasFacialRednessOrPallor;

    private Boolean hasRednessNeckChest;

    private Boolean hasLipCyanosis;

    private Boolean hasSkinPallorOrBruising;

    private Boolean hasGumBleeding;

    private Boolean hasKidneyPain;

    private Boolean hasLowBackPain;

    private Boolean hasOrbitalPain;

    private Boolean hasHepatomegaly;

    private Boolean hasSplenomegaly;

    private Boolean hasMucosalBleedingInOralOrNasal;

    private Boolean hasSkinBleedingPoints;
}
