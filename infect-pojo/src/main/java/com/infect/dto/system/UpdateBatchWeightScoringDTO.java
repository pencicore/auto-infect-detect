package com.infect.dto.system;

import java.math.BigDecimal;

public class UpdateBatchWeightScoringDTO {

    private Integer symptomWeightingId;

    private BigDecimal weightScore;

    public UpdateBatchWeightScoringDTO() {
    }

    public UpdateBatchWeightScoringDTO(Integer symptomWeightingId, BigDecimal weightScore) {
        this.symptomWeightingId = symptomWeightingId;
        this.weightScore = weightScore;
    }

    /**
     * 获取
     * @return symptomWeightingId
     */
    public Integer getSymptomWeightingId() {
        return symptomWeightingId;
    }

    /**
     * 设置
     * @param symptomWeightingId
     */
    public void setSymptomWeightingId(Integer symptomWeightingId) {
        this.symptomWeightingId = symptomWeightingId;
    }

    /**
     * 获取
     * @return weightScore
     */
    public BigDecimal getWeightScore() {
        return weightScore;
    }

    /**
     * 设置
     * @param weightScore
     */
    public void setWeightScore(BigDecimal weightScore) {
        this.weightScore = weightScore;
    }

    public String toString() {
        return "UpdateBatchWeightScoringDTO{symptomWeightingId = " + symptomWeightingId + ", weightScore = " + weightScore + "}";
    }
}
