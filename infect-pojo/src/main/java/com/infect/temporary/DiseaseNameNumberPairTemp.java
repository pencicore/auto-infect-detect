package com.infect.temporary;

public class DiseaseNameNumberPairTemp {

    private String diagnosisDiseaseTypeName;

    private Integer count;


    public DiseaseNameNumberPairTemp() {
    }

    public DiseaseNameNumberPairTemp(String diagnosisDiseaseTypeName, Integer count) {
        this.diagnosisDiseaseTypeName = diagnosisDiseaseTypeName;
        this.count = count;
    }

    /**
     * 获取
     * @return diagnosisDiseaseTypeName
     */
    public String getDiagnosisDiseaseTypeName() {
        return diagnosisDiseaseTypeName;
    }

    /**
     * 设置
     * @param diagnosisDiseaseTypeName
     */
    public void setDiagnosisDiseaseTypeName(String diagnosisDiseaseTypeName) {
        this.diagnosisDiseaseTypeName = diagnosisDiseaseTypeName;
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
        return "DiseaseNameNumberPairTemp{diagnosisDiseaseTypeName = " + diagnosisDiseaseTypeName + ", count = " + count + "}";
    }
}
