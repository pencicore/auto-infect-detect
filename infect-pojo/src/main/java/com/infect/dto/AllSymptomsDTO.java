package com.infect.dto;

import com.infect.entity.*;
import io.swagger.annotations.ApiModel;

@ApiModel("所有症状信息")
public class AllSymptomsDTO {
    private Generalsymptoms generalsymptoms;

    private Respiratorysymptoms respiratorysymptoms;

    private Digestivesymptoms digestivesymptoms;

    private Circulatorysymptoms circulatorysymptoms;

    private Neurologicalsymptoms neurologicalSymptoms;

    private Localsymptoms localSymptoms;

    private Othersymptoms otherSymptoms;

    private Riskfactorsandexposure riskFactorsAndExposure;

    public Generalsymptoms getGeneralsymptoms() {
        return generalsymptoms;
    }

    public void setGeneralsymptoms(Generalsymptoms generalsymptoms) {
        this.generalsymptoms = generalsymptoms;
    }

    public Respiratorysymptoms getRespiratorysymptoms() {
        return respiratorysymptoms;
    }

    public void setRespiratorysymptoms(Respiratorysymptoms respiratorysymptoms) {
        this.respiratorysymptoms = respiratorysymptoms;
    }

    public Digestivesymptoms getDigestivesymptoms() {
        return digestivesymptoms;
    }

    public void setDigestivesymptoms(Digestivesymptoms digestivesymptoms) {
        this.digestivesymptoms = digestivesymptoms;
    }

    public Circulatorysymptoms getCirculatorysymptoms() {
        return circulatorysymptoms;
    }

    public void setCirculatorysymptoms(Circulatorysymptoms circulatorysymptoms) {
        this.circulatorysymptoms = circulatorysymptoms;
    }

    public Neurologicalsymptoms getNeurologicalSymptoms() {
        return neurologicalSymptoms;
    }

    public void setNeurologicalSymptoms(Neurologicalsymptoms neurologicalSymptoms) {
        this.neurologicalSymptoms = neurologicalSymptoms;
    }

    public Localsymptoms getLocalSymptoms() {
        return localSymptoms;
    }

    public void setLocalSymptoms(Localsymptoms localSymptoms) {
        this.localSymptoms = localSymptoms;
    }

    public Othersymptoms getOtherSymptoms() {
        return otherSymptoms;
    }

    public void setOtherSymptoms(Othersymptoms otherSymptoms) {
        this.otherSymptoms = otherSymptoms;
    }

    public Riskfactorsandexposure getRiskFactorsAndExposure() {
        return riskFactorsAndExposure;
    }

    public void setRiskFactorsAndExposure(Riskfactorsandexposure riskFactorsAndExposure) {
        this.riskFactorsAndExposure = riskFactorsAndExposure;
    }
}
