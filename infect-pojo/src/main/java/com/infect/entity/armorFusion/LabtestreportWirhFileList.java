package com.infect.entity.armorFusion;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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
@ApiModel(value="Labtestreport对象", description="")
public class LabtestreportWirhFileList implements Serializable {

    private Integer labTestReportId;

    private Integer userId;

    private LocalDate uploadDate;

    private Boolean isVirusAntigenTestDone;

    private Boolean isVirusNucleicAcidTestDone;

    private Boolean isVirusCultureIsolationDone;

    private Boolean isSerologicalTestDone;

    private String pathogenicTestResults;

    private List<Integer> fileIds;


    public LabtestreportWirhFileList() {
    }

    public LabtestreportWirhFileList(Integer labTestReportId, Integer userId, LocalDate uploadDate, Boolean isVirusAntigenTestDone, Boolean isVirusNucleicAcidTestDone, Boolean isVirusCultureIsolationDone, Boolean isSerologicalTestDone, String pathogenicTestResults, List<Integer> fileIds) {
        this.labTestReportId = labTestReportId;
        this.userId = userId;
        this.uploadDate = uploadDate;
        this.isVirusAntigenTestDone = isVirusAntigenTestDone;
        this.isVirusNucleicAcidTestDone = isVirusNucleicAcidTestDone;
        this.isVirusCultureIsolationDone = isVirusCultureIsolationDone;
        this.isSerologicalTestDone = isSerologicalTestDone;
        this.pathogenicTestResults = pathogenicTestResults;
        this.fileIds = fileIds;
    }

    /**
     * 获取
     * @return labTestReportId
     */
    public Integer getLabTestReportId() {
        return labTestReportId;
    }

    /**
     * 设置
     * @param labTestReportId
     */
    public void setLabTestReportId(Integer labTestReportId) {
        this.labTestReportId = labTestReportId;
    }

    /**
     * 获取
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return uploadDate
     */
    public LocalDate getUploadDate() {
        return uploadDate;
    }

    /**
     * 设置
     * @param uploadDate
     */
    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
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
     * @return fileIds
     */
    public List<Integer> getFileIds() {
        return fileIds;
    }

    /**
     * 设置
     * @param fileIds
     */
    public void setFileIds(List<Integer> fileIds) {
        this.fileIds = fileIds;
    }

    public String toString() {
        return "LabtestreportWirhFileList{labTestReportId = " + labTestReportId + ", userId = " + userId + ", uploadDate = " + uploadDate + ", isVirusAntigenTestDone = " + isVirusAntigenTestDone + ", isVirusNucleicAcidTestDone = " + isVirusNucleicAcidTestDone + ", isVirusCultureIsolationDone = " + isVirusCultureIsolationDone + ", isSerologicalTestDone = " + isSerologicalTestDone + ", pathogenicTestResults = " + pathogenicTestResults + ", fileIds = " + fileIds + "}";
    }
}
