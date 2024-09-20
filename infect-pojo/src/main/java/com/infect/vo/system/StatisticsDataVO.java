package com.infect.vo.system;

public class StatisticsDataVO {

    private Integer UserNumber;

    private Integer UserDiseaseNumber;

    private Integer UserHealthNumber;

    private Integer CheckInNumber;


    public StatisticsDataVO() {
    }

    public StatisticsDataVO(Integer UserNumber, Integer UserDiseaseNumber, Integer UserHealthNumber, Integer CheckInNumber) {
        this.UserNumber = UserNumber;
        this.UserDiseaseNumber = UserDiseaseNumber;
        this.UserHealthNumber = UserHealthNumber;
        this.CheckInNumber = CheckInNumber;
    }

    /**
     * 获取
     * @return UserNumber
     */
    public Integer getUserNumber() {
        return UserNumber;
    }

    /**
     * 设置
     * @param UserNumber
     */
    public void setUserNumber(Integer UserNumber) {
        this.UserNumber = UserNumber;
    }

    /**
     * 获取
     * @return UserDiseaseNumber
     */
    public Integer getUserDiseaseNumber() {
        return UserDiseaseNumber;
    }

    /**
     * 设置
     * @param UserDiseaseNumber
     */
    public void setUserDiseaseNumber(Integer UserDiseaseNumber) {
        this.UserDiseaseNumber = UserDiseaseNumber;
    }

    /**
     * 获取
     * @return UserHealthNumber
     */
    public Integer getUserHealthNumber() {
        return UserHealthNumber;
    }

    /**
     * 设置
     * @param UserHealthNumber
     */
    public void setUserHealthNumber(Integer UserHealthNumber) {
        this.UserHealthNumber = UserHealthNumber;
    }

    /**
     * 获取
     * @return CheckInNumber
     */
    public Integer getCheckInNumber() {
        return CheckInNumber;
    }

    /**
     * 设置
     * @param CheckInNumber
     */
    public void setCheckInNumber(Integer CheckInNumber) {
        this.CheckInNumber = CheckInNumber;
    }

    public String toString() {
        return "StatisticsDataVO{UserNumber = " + UserNumber + ", UserDiseaseNumber = " + UserDiseaseNumber + ", UserHealthNumber = " + UserHealthNumber + ", CheckInNumber = " + CheckInNumber + "}";
    }
}
