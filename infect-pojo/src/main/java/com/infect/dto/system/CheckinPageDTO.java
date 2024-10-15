package com.infect.dto.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.time.LocalDate;

@ApiModel("用户签到信息分页查询DTO")
public class CheckinPageDTO {

    @ApiModelProperty(value = "姓名", example = "黄兵")
    private String name;

    @ApiModelProperty(value = "电话",example = "1380000000")
    private String phoneNumber;

    @ApiModelProperty(value = "部门/工种",example = "工程技术部")
    private String department;

    @ApiModelProperty(value = "特殊职业", example = "医务人员")
    private String specificOccupation;

    @ApiModelProperty(value = "是否患病，true 表示健康，false 表示不健康", example = "true")
    private Boolean isHealth;

    @ApiModelProperty(value = "签到日期，格式为 yyyy-MM-dd", example = "2024-10-08")
    private LocalDate checkInDateBegin;

    @ApiModelProperty(value = "签到日期，格式为 yyyy-MM-dd", example = "2020-10-08")
    private LocalDate checkInDateEnd;

    @ApiModelProperty(value = "页码",example = "0")
    private Integer pageNo;

    @ApiModelProperty(value = "信息数",example = "10")
    private Integer pageSize;

    public CheckinPageDTO() {
    }

    public CheckinPageDTO(String name, String phoneNumber, String department, String specificOccupation, Boolean isHealth, LocalDate checkInDateBegin, LocalDate checkInDateEnd, Integer pageNo, Integer pageSize) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.specificOccupation = specificOccupation;
        this.isHealth = isHealth;
        this.checkInDateBegin = checkInDateBegin;
        this.checkInDateEnd = checkInDateEnd;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取
     * @return specificOccupation
     */
    public String getSpecificOccupation() {
        return specificOccupation;
    }

    /**
     * 设置
     * @param specificOccupation
     */
    public void setSpecificOccupation(String specificOccupation) {
        this.specificOccupation = specificOccupation;
    }

    /**
     * 获取
     * @return isHealth
     */
    public Boolean getIsHealth() {
        return isHealth;
    }

    /**
     * 设置
     * @param isHealth
     */
    public void setIsHealth(Boolean isHealth) {
        this.isHealth = isHealth;
    }

    /**
     * 获取
     * @return checkInDateBegin
     */
    public LocalDate getCheckInDateBegin() {
        return checkInDateBegin;
    }

    /**
     * 设置
     * @param checkInDateBegin
     */
    public void setCheckInDateBegin(LocalDate checkInDateBegin) {
        this.checkInDateBegin = checkInDateBegin;
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
     * @return pageNo
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * 设置
     * @param pageNo
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 获取
     * @return pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String toString() {
        return "CheckinPageDTO{name = " + name + ", phoneNumber = " + phoneNumber + ", department = " + department + ", specificOccupation = " + specificOccupation + ", isHealth = " + isHealth + ", checkInDateBegin = " + checkInDateBegin + ", checkInDateEnd = " + checkInDateEnd + ", pageNo = " + pageNo + ", pageSize = " + pageSize + "}";
    }
}
