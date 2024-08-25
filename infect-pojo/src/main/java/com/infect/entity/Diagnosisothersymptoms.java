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
@TableName("diagnosisothersymptoms")
@ApiModel(value="Diagnosisothersymptoms对象", description="")
public class Diagnosisothersymptoms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisOtherSymptomID", type = IdType.AUTO)
    private Integer DiagnosisOtherSymptomID;

    private Integer DiagnosisResultsID;

    private Boolean HasSuddenOnset;

    private Boolean HasRapidProgress;

    private Boolean HasPeriodicAttack;

    private Boolean HasForcedPosture;

    private Boolean HasCalfMusclePain;

    private Boolean HasOtherSymptoms;

    private String OtherSymptomsName;


}
