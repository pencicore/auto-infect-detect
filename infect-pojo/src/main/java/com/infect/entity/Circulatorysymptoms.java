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
@TableName("circulatorysymptoms")
@ApiModel(value="Circulatorysymptoms对象", description="")
public class Circulatorysymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "CirculatorySymptomsID", type = IdType.AUTO)
    private Integer CirculatorySymptomsID;

    private Integer StatusID;

    private Boolean HasArrhythmia;

    private Boolean HasChestPain;

    private Boolean HasRapidPulse;

    private Boolean HasPalpitation;

    private Boolean HasLowBloodPressure;


}
