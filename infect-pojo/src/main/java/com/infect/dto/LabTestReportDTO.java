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

    public Boolean getVirusAntigenTestDone() {
        return isVirusAntigenTestDone;
    }

    public void setVirusAntigenTestDone(Boolean virusAntigenTestDone) {
        isVirusAntigenTestDone = virusAntigenTestDone;
    }

    public Boolean getVirusNucleicAcidTestDone() {
        return isVirusNucleicAcidTestDone;
    }

    public void setVirusNucleicAcidTestDone(Boolean virusNucleicAcidTestDone) {
        isVirusNucleicAcidTestDone = virusNucleicAcidTestDone;
    }

    public Boolean getVirusCultureIsolationDone() {
        return isVirusCultureIsolationDone;
    }

    public void setVirusCultureIsolationDone(Boolean virusCultureIsolationDone) {
        isVirusCultureIsolationDone = virusCultureIsolationDone;
    }

    public Boolean getSerologicalTestDone() {
        return isSerologicalTestDone;
    }

    public void setSerologicalTestDone(Boolean serologicalTestDone) {
        isSerologicalTestDone = serologicalTestDone;
    }

    public String getPathogenicTestResults() {
        return pathogenicTestResults;
    }

    public void setPathogenicTestResults(String pathogenicTestResults) {
        this.pathogenicTestResults = pathogenicTestResults;
    }

    public List<Integer> getLabTestFileIds() {
        return LabTestFileIds;
    }

    public void setLabTestFileIds(List<Integer> labTestFileIds) {
        LabTestFileIds = labTestFileIds;
    }
}
