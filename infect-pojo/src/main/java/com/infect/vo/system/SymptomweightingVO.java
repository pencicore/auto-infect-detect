package com.infect.vo.system;

import java.math.BigDecimal;

public class SymptomweightingVO {
    private Integer symptomWeightingId;

    private String tableName;

    private String symptomFieldName;

    private BigDecimal weightScore;


    public SymptomweightingVO() {
    }

    public SymptomweightingVO(Integer symptomWeightingId, String tableName, String symptomFieldName, BigDecimal weightScore) {
        this.symptomWeightingId = symptomWeightingId;
        this.tableName = tableName;
        this.symptomFieldName = symptomFieldName;
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
     * @return tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置
     * @param tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 获取
     * @return symptomFieldName
     */
    public String getSymptomFieldName() {
        return symptomFieldName;
    }

    /**
     * 设置
     * @param symptomFieldName
     */
    public void setSymptomFieldName(String symptomFieldName) {
        this.symptomFieldName = symptomFieldName;
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
        return "SymptomweightingVO{symptomWeightingId = " + symptomWeightingId + ", tableName = " + tableName + ", symptomFieldName = " + symptomFieldName + ", weightScore = " + weightScore + "}";
    }
}
