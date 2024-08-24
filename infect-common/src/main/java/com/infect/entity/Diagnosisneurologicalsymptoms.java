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
@TableName("diagnosisneurologicalsymptoms")
@ApiModel(value="Diagnosisneurologicalsymptoms对象", description="")
public class Diagnosisneurologicalsymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisNeurologicalSymptomID", type = IdType.AUTO)
    private Integer DiagnosisNeurologicalSymptomID;

    private Integer DiagnosisResultsID;

    private Boolean HasDelirium;

    private Boolean HasConvulsion;

    private Boolean HasDrowsiness;

    private Boolean HasComa;

    private Boolean HasStiffNeck;

    private Boolean HasRestlessness;

    private Boolean HasMuscleParalysisNeckShoulder;

    private Boolean HasMuscleParalysisLimbs;

    private Boolean HasSwallowingDifficulty;

    private Boolean HasSpeechDisorder;

    private Boolean HasConsciousnessDisorder;

    private Boolean HasDizziness;

    private Boolean HasTinnitus;

    private Boolean HasHearingLoss;


}
