package com.infect.dto.system;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@ApiOperation("查询疾病统计报表DTO")
public class DiseaseStatisticsDTO {

    public static final String AUTOMATIC_DIAGNOSIS = "自动诊断";

    public static final String HOSPITAL_DIAGNOSIS = "医院诊断";

    @ApiModelProperty(value = "数据类型（只能为“自动诊断”或“医院诊断”）", example = "自动诊断")
    private String sourceType;

    @ApiModelProperty(value = "疾病类型列表", example = "新型冠状病毒")
    private List<String> diseaseList;

    @ApiModelProperty(value = "时间段-开始时间",example = "2023-09-30")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBegin;

    @ApiModelProperty(value = "时间段-结束时间",example = "2024-09-30")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateEnd;


    public DiseaseStatisticsDTO() {
    }

    public DiseaseStatisticsDTO(String sourceType, List<String> diseaseList, LocalDate dateBegin, LocalDate dateEnd) {
        this.sourceType = sourceType;
        this.diseaseList = diseaseList;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    /**
     * 获取
     * @return sourceType
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 设置
     * @param sourceType
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    /**
     * 获取
     * @return diseaseList
     */
    public List<String> getDiseaseList() {
        return diseaseList;
    }

    /**
     * 设置
     * @param diseaseList
     */
    public void setDiseaseList(List<String> diseaseList) {
        this.diseaseList = diseaseList;
    }

    /**
     * 获取
     * @return dateBegin
     */
    public LocalDate getDateBegin() {
        return dateBegin;
    }

    /**
     * 设置
     * @param dateBegin
     */
    public void setDateBegin(LocalDate dateBegin) {
        this.dateBegin = dateBegin;
    }

    /**
     * 获取
     * @return dateEnd
     */
    public LocalDate getDateEnd() {
        return dateEnd;
    }

    /**
     * 设置
     * @param dateEnd
     */
    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String toString() {
        return "DiseaseStatisticsDTO{sourceType = " + sourceType + ", diseaseList = " + diseaseList + ", dateBegin = " + dateBegin + ", dateEnd = " + dateEnd + "}";
    }
}
