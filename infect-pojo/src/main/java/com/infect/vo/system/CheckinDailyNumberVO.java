package com.infect.vo.system;

import java.time.LocalDate;

public class CheckinDailyNumberVO {

    private String DiseaseTypeName;

    private Integer count;

    public CheckinDailyNumberVO() {
    }

    public CheckinDailyNumberVO(String DiseaseTypeName, Integer count) {
        this.DiseaseTypeName = DiseaseTypeName;
        this.count = count;
    }

    /**
     * 获取
     * @return DiseaseTypeName
     */
    public String getDiseaseTypeName() {
        return DiseaseTypeName;
    }

    /**
     * 设置
     * @param DiseaseTypeName
     */
    public void setDiseaseTypeName(String DiseaseTypeName) {
        this.DiseaseTypeName = DiseaseTypeName;
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
        return "CheckinDailyNumberVO{DiseaseTypeName = " + DiseaseTypeName + ", count = " + count + "}";
    }
}
