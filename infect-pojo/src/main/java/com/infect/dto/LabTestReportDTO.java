package com.infect.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.util.List;

@ApiModel(value = "LabTestReportDTO对象", description = "实验室检测报告数据传输对象")
public class LabTestReportDTO {

    @ApiModelProperty(value = "是否已进行病毒抗原检测", example = "true", required = true)
    private Boolean isVirusAntigenTestDone;

    @ApiModelProperty(value = "是否已进行病毒核酸检测", example = "true", required = true)
    private Boolean isVirusNucleicAcidTestDone;

    @ApiModelProperty(value = "是否已进行病毒培养分离", example = "false", required = true)
    private Boolean isVirusCultureIsolationDone;

    @ApiModelProperty(value = "是否已进行血清学检测", example = "true", required = true)
    private Boolean isSerologicalTestDone;

    @ApiModelProperty(value = "病原学及血清学检查结果", example = "阴性", required = true)
    private String pathogenicTestResults;

    @ApiModelProperty(value = "实验室检测报告文件ID列表", example = "[1, 2, 3]", required = true)
    private List<Integer> LabTestFileIds;

    public LabTestReportDTO() {
    }

    public LabTestReportDTO(Boolean isVirusAntigenTestDone, Boolean isVirusNucleicAcidTestDone, Boolean isVirusCultureIsolationDone, Boolean isSerologicalTestDone, String pathogenicTestResults, List<Integer> LabTestFileIds) {
        this.isVirusAntigenTestDone = isVirusAntigenTestDone;
        this.isVirusNucleicAcidTestDone = isVirusNucleicAcidTestDone;
        this.isVirusCultureIsolationDone = isVirusCultureIsolationDone;
        this.isSerologicalTestDone = isSerologicalTestDone;
        this.pathogenicTestResults = pathogenicTestResults;
        this.LabTestFileIds = LabTestFileIds;
    }

    /**
     * 获取
     * @return isVirusAntigenTestDone
     */
    public Boolean getIsVirusAntigenTestDone() {
        return isVirusAntigenTestDone;
    }

    /**
     * 设置
     * @param isVirusAntigenTestDone
     */
    public void setIsVirusAntigenTestDone(Boolean isVirusAntigenTestDone) {
        this.isVirusAntigenTestDone = isVirusAntigenTestDone;
    }

    /**
     * 获取
     * @return isVirusNucleicAcidTestDone
     */
    public Boolean getIsVirusNucleicAcidTestDone() {
        return isVirusNucleicAcidTestDone;
    }

    /**
     * 设置
     * @param isVirusNucleicAcidTestDone
     */
    public void setIsVirusNucleicAcidTestDone(Boolean isVirusNucleicAcidTestDone) {
        this.isVirusNucleicAcidTestDone = isVirusNucleicAcidTestDone;
    }

    /**
     * 获取
     * @return isVirusCultureIsolationDone
     */
    public Boolean getIsVirusCultureIsolationDone() {
        return isVirusCultureIsolationDone;
    }

    /**
     * 设置
     * @param isVirusCultureIsolationDone
     */
    public void setIsVirusCultureIsolationDone(Boolean isVirusCultureIsolationDone) {
        this.isVirusCultureIsolationDone = isVirusCultureIsolationDone;
    }

    /**
     * 获取
     * @return isSerologicalTestDone
     */
    public Boolean getIsSerologicalTestDone() {
        return isSerologicalTestDone;
    }

    /**
     * 设置
     * @param isSerologicalTestDone
     */
    public void setIsSerologicalTestDone(Boolean isSerologicalTestDone) {
        this.isSerologicalTestDone = isSerologicalTestDone;
    }

    /**
     * 获取
     * @return pathogenicTestResults
     */
    public String getPathogenicTestResults() {
        return pathogenicTestResults;
    }

    /**
     * 设置
     * @param pathogenicTestResults
     */
    public void setPathogenicTestResults(String pathogenicTestResults) {
        this.pathogenicTestResults = pathogenicTestResults;
    }

    /**
     * 获取
     * @return LabTestFileIds
     */
    public List<Integer> getLabTestFileIds() {
        return LabTestFileIds;
    }

    /**
     * 设置
     * @param LabTestFileIds
     */
    public void setLabTestFileIds(List<Integer> LabTestFileIds) {
        this.LabTestFileIds = LabTestFileIds;
    }

    public String toString() {
        return "LabTestReportDTO{isVirusAntigenTestDone = " + isVirusAntigenTestDone + ", isVirusNucleicAcidTestDone = " + isVirusNucleicAcidTestDone + ", isVirusCultureIsolationDone = " + isVirusCultureIsolationDone + ", isSerologicalTestDone = " + isSerologicalTestDone + ", pathogenicTestResults = " + pathogenicTestResults + ", LabTestFileIds = " + LabTestFileIds + "}";
    }
}
