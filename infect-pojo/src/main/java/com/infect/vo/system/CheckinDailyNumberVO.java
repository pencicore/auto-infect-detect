package com.infect.vo.system;

import java.time.LocalDate;

public class CheckinDailyNumberVO {

    private LocalDate checkInDate;

    private Integer count;

    public CheckinDailyNumberVO() {
    }

    public CheckinDailyNumberVO(LocalDate checkInDate, Integer count) {
        this.checkInDate = checkInDate;
        this.count = count;
    }

    /**
     * 获取
     * @return checkInDate
     */
    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    /**
     * 设置
     * @param checkInDate
     */
    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
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
        return "CheckinDailyNumberVO{checkInDate = " + checkInDate + ", count = " + count + "}";
    }
}
