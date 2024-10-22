package com.infect.temporary;

public class SatisfactionPairTemp {

    private String SatisfactionLevel;

    private Integer count;


    public SatisfactionPairTemp() {
    }

    public SatisfactionPairTemp(String SatisfactionLevel, Integer count) {
        this.SatisfactionLevel = SatisfactionLevel;
        this.count = count;
    }

    /**
     * 获取
     * @return SatisfactionLevel
     */
    public String getSatisfactionLevel() {
        return SatisfactionLevel;
    }

    /**
     * 设置
     * @param SatisfactionLevel
     */
    public void setSatisfactionLevel(String SatisfactionLevel) {
        this.SatisfactionLevel = SatisfactionLevel;
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
        return "SatisfactionPairTemp{SatisfactionLevel = " + SatisfactionLevel + ", count = " + count + "}";
    }
}
