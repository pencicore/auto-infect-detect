package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDate;
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
@TableName("diagnosisresults")
@ApiModel(value="Diagnosisresults对象", description="")
public class Diagnosisresults implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisResultsID", type = IdType.AUTO)
    private Integer diagnosisResultsId;

    private Integer userId;

    private LocalDate submissionTime;

    private Integer submissionUserId;

    private String submissionUserName;

    private String submissionUserType;

    private String diseaseType;

    private String otherDiseaseName;

    private String plagueSubtype;

    private String anthraxSubtype;

    private String discoveryMethod;

    private String otherDiscoveryMethodName;

    private String diseaseOutcome;

    private String hospitalName;

    private LocalDate admissionDate;

    private LocalDate dischargeDate;

    private LocalDate deathDate;

    private String admissionSymptomsAndSigns;

    private String registrationClassification;

    private String otherRegistrationDetails;
}
