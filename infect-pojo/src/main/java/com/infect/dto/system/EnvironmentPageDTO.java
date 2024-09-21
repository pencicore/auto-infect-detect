package com.infect.dto.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "系统管理员分页查询工作环境dto对象")
public class EnvironmentPageDTO {

    @ApiModelProperty(value = "年月，格式为YYYY-MM")
    private String beginYearMonth;

    @ApiModelProperty(value = "年月，格式为YYYY-MM")
    private String endYearMonth;

    @ApiModelProperty(value = "工务段名称", required = true, example = "某某工务段")
    private String workStationName;

    @ApiModelProperty(value = "页码",example = "0")
    private Integer pageNo;

    @ApiModelProperty(value = "信息数",example = "10")
    private Integer pageSize;

    public EnvironmentPageDTO() {
    }

    public EnvironmentPageDTO(String beginYearMonth, String endYearMonth, String workStationName, Integer pageNo, Integer pageSize) {
        this.beginYearMonth = beginYearMonth;
        this.endYearMonth = endYearMonth;
        this.workStationName = workStationName;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * 获取
     * @return beginYearMonth
     */
    public String getBeginYearMonth() {
        return beginYearMonth;
    }

    /**
     * 设置
     * @param beginYearMonth
     */
    public void setBeginYearMonth(String beginYearMonth) {
        this.beginYearMonth = beginYearMonth;
    }

    /**
     * 获取
     * @return endYearMonth
     */
    public String getEndYearMonth() {
        return endYearMonth;
    }

    /**
     * 设置
     * @param endYearMonth
     */
    public void setEndYearMonth(String endYearMonth) {
        this.endYearMonth = endYearMonth;
    }

    /**
     * 获取
     * @return workStationName
     */
    public String getWorkStationName() {
        return workStationName;
    }

    /**
     * 设置
     * @param workStationName
     */
    public void setWorkStationName(String workStationName) {
        this.workStationName = workStationName;
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
        return "EnvironmentPageDTO{beginYearMonth = " + beginYearMonth + ", endYearMonth = " + endYearMonth + ", workStationName = " + workStationName + ", pageNo = " + pageNo + ", pageSize = " + pageSize + "}";
    }
}
