package com.infect.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component

@ConfigurationProperties(prefix = "infect.path")
public class PathProperties {
    private String diagnosisFilePath;
    private String labTestFilePath;

    public String getDiagnosisFilePath() {
        return diagnosisFilePath;
    }

    public void setDiagnosisFilePath(String diagnosisFilePath) {
        this.diagnosisFilePath = diagnosisFilePath;
    }

    public String getLabTestFilePath() {
        return labTestFilePath;
    }

    public void setLabTestFilePath(String labTestFilePath) {
        this.labTestFilePath = labTestFilePath;
    }
}
