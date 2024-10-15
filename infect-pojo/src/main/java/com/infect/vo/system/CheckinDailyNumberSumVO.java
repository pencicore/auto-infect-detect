package com.infect.vo.system;

import java.time.LocalDate;
import java.util.List;

public class CheckinDailyNumberSumVO {

    private LocalDate checkInDateStart;

    private LocalDate checkInDateEnd;

    private List<CheckinDailyNumberVO> list;

    public CheckinDailyNumberSumVO() {
    }

    public CheckinDailyNumberSumVO(LocalDate checkInDateStart, LocalDate checkInDateEnd, List<CheckinDailyNumberVO> list) {
        this.checkInDateStart = checkInDateStart;
        this.checkInDateEnd = checkInDateEnd;
        this.list = list;
    }

    /**
     * 获取
     * @return checkInDateStart
     */
    public LocalDate getCheckInDateStart() {
        return checkInDateStart;
    }

    /**
     * 设置
     * @param checkInDateStart
     */
    public void setCheckInDateStart(LocalDate checkInDateStart) {
        this.checkInDateStart = checkInDateStart;
    }

    /**
     * 获取
     * @return checkInDateEnd
     */
    public LocalDate getCheckInDateEnd() {
        return checkInDateEnd;
    }

    /**
     * 设置
     * @param checkInDateEnd
     */
    public void setCheckInDateEnd(LocalDate checkInDateEnd) {
        this.checkInDateEnd = checkInDateEnd;
    }

    /**
     * 获取
     * @return list
     */
    public List<CheckinDailyNumberVO> getList() {
        return list;
    }

    /**
     * 设置
     * @param list
     */
    public void setList(List<CheckinDailyNumberVO> list) {
        this.list = list;
    }

    public String toString() {
        return "CheckinDailyNumberSumVO{checkInDateStart = " + checkInDateStart + ", checkInDateEnd = " + checkInDateEnd + ", list = " + list + "}";
    }
}
