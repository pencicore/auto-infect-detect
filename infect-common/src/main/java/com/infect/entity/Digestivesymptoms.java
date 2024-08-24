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
    private Integer DigestiveSymptomsID;

    private Integer StatusID;

    private Boolean arrheaFrequencyGEThreeTimesPerDay;

    private Integer DiarrheaTimesPerDay;

    private Boolean HasStoolType1;

    private String StoolType1Detail;

    private Boolean HasStoolType2;

    private String StoolType2Detail;

    private String DiarrheaMode;

    private String StoolAmount;

    private String StoolOdor;

    private Boolean HasVomiting;

    private String VomitingMode;

    private Boolean HasNausea;

    private Boolean HasAppetiteLoss;

    private Boolean HasAbdominalDistension;

    private Boolean HasAbdominalPain;

    private Boolean HasBorborygmus;

    private Boolean HasUpperAbdominalDiscomfort;

    private Boolean HasConstipation;

    private Boolean HasOliguriaOrAnuria;


}
