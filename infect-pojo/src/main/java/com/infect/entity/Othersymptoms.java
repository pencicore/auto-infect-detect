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
@TableName("othersymptoms")
@ApiModel(value="Othersymptoms对象", description="")
public class Othersymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "OtherSymptomsID", type = IdType.AUTO)
    private Integer otherSymptomsId;

    private Integer statusId;

    private Boolean hasSuddenOnset;

    private Boolean hasRapidProgress;

    private Boolean hasPeriodicAttack;

    private Boolean hasForcedPosture;

    private Boolean hasCalfMusclePain;

    private String sleepQuality;

    private String nutritionStatus;

    private String workLifeStress;

    private String symptomSeverity;

    private Boolean hasOtherSymptoms;

    private String otherSymptomsName;

}
