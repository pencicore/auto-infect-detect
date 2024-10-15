package com.infect.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component

@ConfigurationProperties(prefix = "infect.path")
public class PathProperties {
    private String diagnosisFilePath;
    private String labTestFilePath;

    private String diseaseLearningMaterialPath;

    public PathProperties() {
    }

    public PathProperties(String diagnosisFilePath, String labTestFilePath, String diseaseLearningMaterialPath) {
        this.diagnosisFilePath = diagnosisFilePath;
        this.labTestFilePath = labTestFilePath;
        this.diseaseLearningMaterialPath = diseaseLearningMaterialPath;
    }

    /**
     * 获取
     * @return diagnosisFilePath
     */
    public String getDiagnosisFilePath() {
        return diagnosisFilePath;
    }

    /**
     * 设置
     * @param diagnosisFilePath
     */
    public void setDiagnosisFilePath(String diagnosisFilePath) {
        this.diagnosisFilePath = diagnosisFilePath;
    }

    /**
     * 获取
     * @return labTestFilePath
     */
    public String getLabTestFilePath() {
        return labTestFilePath;
    }

    /**
     * 设置
     * @param labTestFilePath
     */
    public void setLabTestFilePath(String labTestFilePath) {
        this.labTestFilePath = labTestFilePath;
    }

    /**
     * 获取
     * @return diseaseLearningMaterialPath
     */
    public String getDiseaseLearningMaterialPath() {
        return diseaseLearningMaterialPath;
    }

    /**
     * 设置
     * @param diseaseLearningMaterialPath
     */
    public void setDiseaseLearningMaterialPath(String diseaseLearningMaterialPath) {
        this.diseaseLearningMaterialPath = diseaseLearningMaterialPath;
    }

    public String toString() {
        return "PathProperties{diagnosisFilePath = " + diagnosisFilePath + ", labTestFilePath = " + labTestFilePath + ", diseaseLearningMaterialPath = " + diseaseLearningMaterialPath + "}";
    }
}
