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
    private Integer LocalSymptomsID;

    private Integer StatusID;

    private Boolean HasConjunctivitis;

    private Boolean HasConjunctivalCongestion;

    private Boolean HasEyelidEdema;

    private Boolean HasSmellTasteLoss;

    private Boolean HasFacialRednessOrPallor;

    private Boolean HasRednessNeckChest;

    private Boolean HasLipCyanosis;

    private Boolean HasSkinPallorOrBruising;

    private Boolean HasGumBleeding;

    private Boolean HasKidneyPain;

    private Boolean HasLowBackPain;

    private Boolean HasOrbitalPain;

    private Boolean HasMucosalBleedingInOralOrNasal;

    private Boolean HasSkinBleedingPoints;


}
