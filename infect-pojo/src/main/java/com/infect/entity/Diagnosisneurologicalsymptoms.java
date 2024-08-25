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
    private Integer diagnosisNeurologicalSymptomId;

    private Integer diagnosisResultsId;

    private Boolean hasDelirium;

    private Boolean hasConvulsion;

    private Boolean hasDrowsiness;

    private Boolean hasComa;

    private Boolean hasStiffNeck;

    private Boolean hasRestlessness;

    private Boolean hasMuscleParalysisNeckShoulder;

    private Boolean hasMuscleParalysisLimbs;

    private Boolean hasSwallowingDifficulty;

    private Boolean hasSpeechDisorder;

    private Boolean hasConsciousnessDisorder;

    private Boolean hasDizziness;

    private Boolean hasTinnitus;

    private Boolean hasHearingLoss;
}
