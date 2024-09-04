package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 *
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("labtestreport")
@ApiModel(value="Labtestreport对象", description="")
public class Labtestreport implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "LabTestReportID", type = IdType.AUTO)
    private Integer labTestReportId;

    private Integer userId;

    private LocalDate uploadDate;

    private Boolean isVirusAntigenTestDone;

    private Boolean isVirusNucleicAcidTestDone;

    private Boolean isVirusCultureIsolationDone;

    private Boolean isSerologicalTestDone;

    private String pathogenicTestResults;

    public Integer getLabTestReportId() {
        return labTestReportId;
    }

    public void setLabTestReportId(Integer labTestReportId) {
        this.labTestReportId = labTestReportId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

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
}
