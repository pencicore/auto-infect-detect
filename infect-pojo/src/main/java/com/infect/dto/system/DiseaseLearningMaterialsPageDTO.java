package com.infect.dto.system;

import io.swagger.annotations.ApiModelProperty;

public class DiseaseLearningMaterialsPageDTO {

    @ApiModelProperty(value = "疾病类型名", example = "新型冠状病毒")
    private String DiseaseTypeName;

    @ApiModelProperty(value = "页码", example = "1")
    private Integer pageNo;

    @ApiModelProperty(value = "信息数", example = "20")
    private Integer pageSize;

    public DiseaseLearningMaterialsPageDTO() {
    }

    public DiseaseLearningMaterialsPageDTO(String DiseaseTypeName, Integer pageNo, Integer pageSize) {
        this.DiseaseTypeName = DiseaseTypeName;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * 获取
     * @return DiseaseTypeName
     */
    public String getDiseaseTypeName() {
        return DiseaseTypeName;
    }

    /**
     * 设置
     * @param DiseaseTypeName
     */
    public void setDiseaseTypeName(String DiseaseTypeName) {
        this.DiseaseTypeName = DiseaseTypeName;
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
        return "DiseaseLearningMaterialsPageDTO{DiseaseTypeName = " + DiseaseTypeName + ", pageNo = " + pageNo + ", pageSize = " + pageSize + "}";
    }
}
