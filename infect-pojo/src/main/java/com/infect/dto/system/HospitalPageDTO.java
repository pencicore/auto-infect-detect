package com.infect.dto.system;

import io.swagger.annotations.ApiModelProperty;

public class HospitalPageDTO {

    @ApiModelProperty(value = "医院名", example = "西华医院")
    private String hospitalName;

    @ApiModelProperty(value = "页码", example = "0")
    private Integer pageNo;

    @ApiModelProperty(value = "信息数", example = "20")
    private Integer pageSize;

    public HospitalPageDTO() {
    }

    public HospitalPageDTO(String hospitalName, Integer pageNo, Integer pageSize) {
        this.hospitalName = hospitalName;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * 获取
     * @return hospitalName
     */
    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * 设置
     * @param hospitalName
     */
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
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
        return "HospitalPageDTO{hospitalName = " + hospitalName + ", pageNo = " + pageNo + ", pageSize = " + pageSize + "}";
    }
}
