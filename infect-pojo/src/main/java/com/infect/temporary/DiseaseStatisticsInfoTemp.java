package com.infect.temporary;

import java.time.LocalDate;

public class DiseaseStatisticsInfoTemp {

    private LocalDate submissionTime;

    private String diseaseType;

    private Integer count;

    public DiseaseStatisticsInfoTemp() {
    }

    public DiseaseStatisticsInfoTemp(LocalDate submissionTime, String diseaseType, Integer count) {
        this.submissionTime = submissionTime;
        this.diseaseType = diseaseType;
        this.count = count;
    }

    /**
     * 获取
     * @return submissionTime
     */
    public LocalDate getSubmissionTime() {
        return submissionTime;
    }

    /**
     * 设置
     * @param submissionTime
     */
    public void setSubmissionTime(LocalDate submissionTime) {
        this.submissionTime = submissionTime;
    }

    /**
     * 获取
     * @return diseaseType
     */
    public String getDiseaseType() {
        return diseaseType;
    }

    /**
     * 设置
     * @param diseaseType
     */
    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    /**
     * 获取
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    public String toString() {
        return "DiseaseStatisticsInfoTemp{submissionTime = " + submissionTime + ", diseaseType = " + diseaseType + ", count = " + count + "}";
    }
}
