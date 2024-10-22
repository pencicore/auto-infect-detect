package com.infect.vo.system;

public class SatisfactionNumberInfoVO {

    private Integer veryHappy;

    private Integer happy;

    private Integer normal;

    private Integer noHappy;

    private Integer veryNoHappy;

    private Double Satisfaction;

    public SatisfactionNumberInfoVO() {
    }

    public SatisfactionNumberInfoVO(Integer veryHappy, Integer happy, Integer normal, Integer noHappy, Integer veryNoHappy, Double Satisfaction) {
        this.veryHappy = veryHappy;
        this.happy = happy;
        this.normal = normal;
        this.noHappy = noHappy;
        this.veryNoHappy = veryNoHappy;
        this.Satisfaction = Satisfaction;
    }

    /**
     * 获取
     * @return veryHappy
     */
    public Integer getVeryHappy() {
        return veryHappy;
    }

    /**
     * 设置
     * @param veryHappy
     */
    public void setVeryHappy(Integer veryHappy) {
        this.veryHappy = veryHappy;
    }

    /**
     * 获取
     * @return happy
     */
    public Integer getHappy() {
        return happy;
    }

    /**
     * 设置
     * @param happy
     */
    public void setHappy(Integer happy) {
        this.happy = happy;
    }

    /**
     * 获取
     * @return normal
     */
    public Integer getNormal() {
        return normal;
    }

    /**
     * 设置
     * @param normal
     */
    public void setNormal(Integer normal) {
        this.normal = normal;
    }

    /**
     * 获取
     * @return noHappy
     */
    public Integer getNoHappy() {
        return noHappy;
    }

    /**
     * 设置
     * @param noHappy
     */
    public void setNoHappy(Integer noHappy) {
        this.noHappy = noHappy;
    }

    /**
     * 获取
     * @return veryNoHappy
     */
    public Integer getVeryNoHappy() {
        return veryNoHappy;
    }

    /**
     * 设置
     * @param veryNoHappy
     */
    public void setVeryNoHappy(Integer veryNoHappy) {
        this.veryNoHappy = veryNoHappy;
    }

    /**
     * 获取
     * @return Satisfaction
     */
    public Double getSatisfaction() {
        return Satisfaction;
    }

    /**
     * 设置
     * @param Satisfaction
     */
    public void setSatisfaction(Double Satisfaction) {
        this.Satisfaction = Satisfaction;
    }

    public String toString() {
        return "SatisfactionNumberInfoVO{veryHappy = " + veryHappy + ", happy = " + happy + ", normal = " + normal + ", noHappy = " + noHappy + ", veryNoHappy = " + veryNoHappy + ", Satisfaction = " + Satisfaction + "}";
    }
}
