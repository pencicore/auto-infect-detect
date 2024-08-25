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
@TableName("digestivesymptoms")
@ApiModel(value="Digestivesymptoms对象", description="")
public class Digestivesymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DigestiveSymptomsID", type = IdType.AUTO)
    private Integer digestiveSymptomsId;

    private Integer statusId;

    private Boolean diarrheaFrequencyGEThreeTimesPerDay;

    private Integer diarrheaTimesPerDay;

    private Boolean hasStoolType1;

    private String stoolType1Detail;

    private Boolean hasStoolType2;

    private String stoolType2Detail;

    private String diarrheaMode;

    private String stoolAmount;

    private String stoolOdor;

    private Boolean hasVomiting;

    private String vomitingMode;

    private Boolean hasNausea;

    private Boolean hasAppetiteLoss;

    private Boolean hasAbdominalDistension;

    private Boolean hasAbdominalPain;

    private Boolean hasBorborygmus;

    private Boolean hasUpperAbdominalDiscomfort;

    private Boolean hasConstipation;

    private Boolean hasOliguriaOrAnuria;

}
