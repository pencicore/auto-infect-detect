package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.sql.Blob;
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
@TableName("diagnosisreports")
@ApiModel(value="Diagnosisreports对象", description="")
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Diagnosisreports implements Serializable {

    @TableId(value = "ReportID", type = IdType.AUTO)
    private Integer reportId;

    private Integer diagnosisResultsId;

    private String reportType;

//    private Blob file;

    private String fileName;

    private String filePath;

    private String fileType;

    private LocalDateTime uploadDate;

    public Diagnosisreports() {
    }

    public Diagnosisreports(Integer reportId, Integer diagnosisResultsId, String reportType, String fileName, String filePath, String fileType, LocalDateTime uploadDate) {
        this.reportId = reportId;
        this.diagnosisResultsId = diagnosisResultsId;
        this.reportType = reportType;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.uploadDate = uploadDate;
    }

    /**
     * 获取
     * @return reportId
     */
    public Integer getReportId() {
        return reportId;
    }

    /**
     * 设置
     * @param reportId
     */
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    /**
     * 获取
     * @return diagnosisResultsId
     */
    public Integer getDiagnosisResultsId() {
        return diagnosisResultsId;
    }

    /**
     * 设置
     * @param diagnosisResultsId
     */
    public void setDiagnosisResultsId(Integer diagnosisResultsId) {
        this.diagnosisResultsId = diagnosisResultsId;
    }

    /**
     * 获取
     * @return reportType
     */
    public String getReportType() {
        return reportType;
    }

    /**
     * 设置
     * @param reportType
     */
    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    /**
     * 获取
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 设置
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 获取
     * @return fileType
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 设置
     * @param fileType
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * 获取
     * @return uploadDate
     */
    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    /**
     * 设置
     * @param uploadDate
     */
    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String toString() {
        return "Diagnosisreports{reportId = " + reportId + ", diagnosisResultsId = " + diagnosisResultsId + ", reportType = " + reportType + ", fileName = " + fileName + ", filePath = " + filePath + ", fileType = " + fileType + ", uploadDate = " + uploadDate + "}";
    }
}
