package com.infect.dto.system;

import io.swagger.annotations.ApiModelProperty;

public class DiseaseTypePageDTO {

    @ApiModelProperty(value = "文本", example = "新冠")
    private String text;

    @ApiModelProperty(value = "页码", example = "1")
    private Integer pageNo;

    @ApiModelProperty(value = "信息数", example = "20")
    private Integer pageSize;

    public DiseaseTypePageDTO() {
    }

    public DiseaseTypePageDTO(String text, Integer pageNo, Integer pageSize) {
        this.text = text;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * 获取
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * 设置
     * @param text
     */
    public void setText(String text) {
        this.text = text;
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
        return "DiseaseTypePageDTO{text = " + text + ", pageNo = " + pageNo + ", pageSize = " + pageSize + "}";
    }
}
