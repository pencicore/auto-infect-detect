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

    @TableId(value = "LabTestReportID", type = IdType.AUTO)
    private Integer labTestReportId;

    private Integer userId;

    private LocalDate uploadDate;

    private Boolean isVirusAntigenTestDone;

    private Boolean isVirusNucleicAcidTestDone;

    private Boolean isVirusCultureIsolationDone;

    private Boolean isSerologicalTestDone;

    private String pathogenicTestResults;

    public Labtestreport() {
    }

    public Labtestreport(Integer labTestReportId, Integer userId, LocalDate uploadDate, Boolean isVirusAntigenTestDone, Boolean isVirusNucleicAcidTestDone, Boolean isVirusCultureIsolationDone, Boolean isSerologicalTestDone, String pathogenicTestResults) {
        this.labTestReportId = labTestReportId;
        this.userId = userId;
        this.uploadDate = uploadDate;
        this.isVirusAntigenTestDone = isVirusAntigenTestDone;
        this.isVirusNucleicAcidTestDone = isVirusNucleicAcidTestDone;
        this.isVirusCultureIsolationDone = isVirusCultureIsolationDone;
        this.isSerologicalTestDone = isSerologicalTestDone;
        this.pathogenicTestResults = pathogenicTestResults;
    }

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

    public String toString() {
        return "Labtestreport{labTestReportId = " + labTestReportId + ", userId = " + userId + ", uploadDate = " + uploadDate + ", isVirusAntigenTestDone = " + isVirusAntigenTestDone + ", isVirusNucleicAcidTestDone = " + isVirusNucleicAcidTestDone + ", isVirusCultureIsolationDone = " + isVirusCultureIsolationDone + ", isSerologicalTestDone = " + isSerologicalTestDone + ", pathogenicTestResults = " + pathogenicTestResults + "}";
    }
}
