package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
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
@TableName("diagnosisresults")
@ApiModel(value="Diagnosisresults对象", description="")
public class Diagnosisresults implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiagnosisResultsID", type = IdType.AUTO)
    private Integer DiagnosisResultsID;

    private Integer UserID;

    private LocalDate SubmissionTime;

    private Integer SubmissionUserID;

    private String SubmissionUserName;

    private String SubmissionUserType;

    private String DiseaseType;

    private String OtherDiseaseName;

    private String PlagueSubtype;

    private String AnthraxSubtype;

    private String DiscoveryMethod;

    private String OtherDiscoveryMethodName;

    private String DiseaseOutcome;

    private String HospitalName;

    private LocalDate AdmissionDate;

    private LocalDate DischargeDate;

    private LocalDate DeathDate;

    private String AdmissionSymptomsAndSigns;

    private String RegistrationClassification;

    private String OtherRegistrationDetails;


}
