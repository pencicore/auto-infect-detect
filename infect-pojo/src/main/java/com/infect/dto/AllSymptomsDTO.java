package com.infect.dto;

import com.infect.entity.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("所有症状信息")
@Data
public class AllSymptomsDTO {
    private Generalsymptoms generalsymptoms;

    private Respiratorysymptoms respiratorysymptoms;

    private Digestivesymptoms digestivesymptoms;

    private Circulatorysymptoms circulatorysymptoms;

    private Neurologicalsymptoms neurologicalSymptoms;

    private Localsymptoms localSymptoms;

    private Othersymptoms otherSymptoms;

    private Riskfactorsandexposure riskFactorsAndExposure;
}
