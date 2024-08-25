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
@TableName("localsymptoms")
@ApiModel(value="Localsymptoms对象", description="")
public class Localsymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "LocalSymptomsID", type = IdType.AUTO)
    private Integer localSymptomsId;

    private Integer statusId;

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

    private Boolean hasMucosalBleedingInOralOrNasal;

    private Boolean hasSkinBleedingPoints;

}
