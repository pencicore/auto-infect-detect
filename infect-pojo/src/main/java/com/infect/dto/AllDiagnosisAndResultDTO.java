package com.infect.dto;

import com.infect.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("诊断结果和所有诊断信息")
@Data
public class AllDiagnosisAndResultDTO {

    //诊断结果dto
    private DiagnosisResultsEmpDTO diagnosisResultsEmpDTO;

    //诊断信息entity
    private Diagnosispersonalinfo diagnosispersonalinfo;

    private Diagnosisgeneralsymptoms diagnosisgeneralsymptoms;

    private Diagnosisrespiratorysymptoms diagnosisrespiratorysymptoms;

    private Diagnosisdigestivesymptoms diagnosisdigestivesymptoms;

    private Diagnosiscirculatorysymptoms diagnosiscirculatorysymptoms;

    private Diagnosisneurologicalsymptoms diagnosisneurologicalsymptoms;

    private Diagnosislocalsymptoms diagnosislocalsymptoms;

    private Diagnosisothersymptoms diagnosisothersymptoms;

    private Diagnosiscomplications diagnosiscomplications;
}
