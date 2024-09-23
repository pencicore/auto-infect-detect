package com.infect.dto.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class DiagnosisPageDTO {

    @ApiModelProperty(value = "用户姓名", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value = "电话号码", required = true, example = "13812345678")
    private String phoneNumber;

    @ApiModelProperty(value = "部门", example = "工程技术部")
    private String department;

    @ApiModelProperty(value = "开始日期", example = "2000-01-01")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate;

    @ApiModelProperty(value = "开始日期", example = "2050-01-01")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @ApiModelProperty(value = "页码", example = "1")
    private Integer pageNo;

    @ApiModelProperty(value = "信息数", example = "20")
    private Integer pageSize;

    public DiagnosisPageDTO() {
    }

    public DiagnosisPageDTO(String name, String phoneNumber, String department, LocalDate beginDate, LocalDate endDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public DiagnosisPageDTO(String name, String phoneNumber, String department, LocalDate beginDate, LocalDate endDate, Integer pageNo, Integer pageSize) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.beginDate = beginDate;
        this.endDate = endDate;
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
     * @return beginDate
     */
    public LocalDate getBeginDate() {
        return beginDate;
    }

    /**
     * 设置
     * @param beginDate
     */
    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 获取
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * 设置
     * @param endDate
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String toString() {
        return "DiagnosisPageDTO{name = " + name + ", phoneNumber = " + phoneNumber + ", department = " + department + ", beginDate = " + beginDate + ", endDate = " + endDate + "}";
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
}
