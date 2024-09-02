package com.infect.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Data
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
}
