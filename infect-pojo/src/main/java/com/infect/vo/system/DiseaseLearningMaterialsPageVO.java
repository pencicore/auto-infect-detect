package com.infect.vo.system;

import java.time.LocalDateTime;

public class DiseaseLearningMaterialsPageVO {

    private Integer materialId;

    private String title;

    private String filePath;

    private String link;

    private LocalDateTime publishDate;

    private Long studyCount;

    private Integer sequenceNumber;

    private Boolean isDeleted;

    public DiseaseLearningMaterialsPageVO() {
    }

    public DiseaseLearningMaterialsPageVO(Integer materialId, String title, String filePath, String link, LocalDateTime publishDate, Long studyCount, Integer sequenceNumber, Boolean isDeleted) {
        this.materialId = materialId;
        this.title = title;
        this.filePath = filePath;
        this.link = link;
        this.publishDate = publishDate;
        this.studyCount = studyCount;
        this.sequenceNumber = sequenceNumber;
        this.isDeleted = isDeleted;
    }

    /**
     * 获取
     * @return materialId
     */
    public Integer getMaterialId() {
        return materialId;
    }

    /**
     * 设置
     * @param materialId
     */
    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return link
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置
     * @param link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 获取
     * @return publishDate
     */
    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    /**
     * 设置
     * @param publishDate
     */
    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * 获取
     * @return studyCount
     */
    public Long getStudyCount() {
        return studyCount;
    }

    /**
     * 设置
     * @param studyCount
     */
    public void setStudyCount(Long studyCount) {
        this.studyCount = studyCount;
    }

    /**
     * 获取
     * @return sequenceNumber
     */
    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * 设置
     * @param sequenceNumber
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    /**
     * 获取
     * @return isDeleted
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置
     * @param isDeleted
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String toString() {
        return "DiseaseLearningMaterialsPageVO{materialId = " + materialId + ", title = " + title + ", filePath = " + filePath + ", link = " + link + ", publishDate = " + publishDate + ", studyCount = " + studyCount + ", sequenceNumber = " + sequenceNumber + ", isDeleted = " + isDeleted + "}";
    }
}
