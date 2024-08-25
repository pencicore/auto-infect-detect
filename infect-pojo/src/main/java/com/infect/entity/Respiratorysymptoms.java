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
@TableName("respiratorysymptoms")
@ApiModel(value="Respiratorysymptoms对象", description="")
public class Respiratorysymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "RespiratorySymptomsID", type = IdType.AUTO)
    private Integer respiratorySymptomsId;

    private Integer statusId;

    private Boolean hasCough;

    private Boolean hasSputum;

    private Boolean hasBloodySputum;

    private Boolean hasHemoptysis;

    private Boolean hasSoreThroat;

    private Boolean hasDryThroat;

    private Boolean hasNasalCongestion;

    private Boolean hasRunnyNose;

    private Boolean hasChestTightness;

    private Boolean hasShortnessOfBreath;

    private Boolean hasBreathingDifficulty;

    private Boolean hasHoarseness;

    private Boolean hasBronchitis;

}
