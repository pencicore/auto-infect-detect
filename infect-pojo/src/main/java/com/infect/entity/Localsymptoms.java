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
 * LocalSymptoms 实体类，记录局部症状
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("localsymptoms")
@ApiModel(value="Localsymptoms对象", description="局部症状表")
public class Localsymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "局部症状ID", required = true, example = "1")
    @TableId(value = "LocalSymptomsID", type = IdType.AUTO)
    private Integer localSymptomsId;

    @ApiModelProperty(value = "每日健康状态ID", required = true, example = "1001")
    private Integer statusId;

    @ApiModelProperty(value = "是否有结膜炎", required = true, example = "false")
    private Boolean hasConjunctivitis;

    @ApiModelProperty(value = "是否有眼结膜充血、肿胀疼痛", required = true, example = "true")
    private Boolean hasConjunctivalCongestion;

    @ApiModelProperty(value = "是否有上下眼睑水肿", required = true, example = "false")
    private Boolean hasEyelidEdema;

    @ApiModelProperty(value = "是否有嗅觉味觉减退或丧失", required = true, example = "true")
    private Boolean hasSmellTasteLoss;

    @ApiModelProperty(value = "是否有颜面潮红或苍白", required = true, example = "false")
    private Boolean hasFacialRednessOrPallor;

    @ApiModelProperty(value = "是否有颈部、胸部潮红", required = true, example = "true")
    private Boolean hasRednessNeckChest;

    @ApiModelProperty(value = "是否有口唇发绀", required = true, example = "false")
    private Boolean hasLipCyanosis;

    @ApiModelProperty(value = "是否有皮肤苍白或带青紫", required = true, example = "true")
    private Boolean hasSkinPallorOrBruising;

    @ApiModelProperty(value = "是否有牙龈出血", required = true, example = "false")
    private Boolean hasGumBleeding;

    @ApiModelProperty(value = "是否有肾区疼痛", required = true, example = "true")
    private Boolean hasKidneyPain;

    @ApiModelProperty(value = "是否有腰痛", required = true, example = "true")
    private Boolean hasLowBackPain;

    @ApiModelProperty(value = "是否有眼眶痛", required = true, example = "false")
    private Boolean hasOrbitalPain;

    @ApiModelProperty(value = "是否有口腔、鼻腔等处黏膜出血点", required = true, example = "false")
    private Boolean hasMucosalBleedingInOralOrNasal;

    @ApiModelProperty(value = "是否有腋下/上臂/胸部或其它部位皮肤出血点", required = true, example = "true")
    private Boolean hasSkinBleedingPoints;

}
