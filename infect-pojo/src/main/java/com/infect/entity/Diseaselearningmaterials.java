package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("diseaselearningmaterials")
@ApiModel(value="Diseaselearningmaterials对象", description="")
public class Diseaselearningmaterials implements Serializable {

    @TableId(value = "MaterialID", type = IdType.AUTO)
    private Integer materialId;

    private Integer diseaseTypeId;

    private String diseaseTypeName;

    private String title;

    private String materialType;

    private String filePath;

    private String link;

    private Integer sequenceNumber;

    private LocalDateTime publishDate;

    private Boolean isDeleted;

    private LocalDateTime deletedDate;

    public Diseaselearningmaterials() {
    }

    public Diseaselearningmaterials(Integer materialId, Integer diseaseTypeId, String diseaseTypeName, String title, String materialType, String filePath, String link, Integer sequenceNumber, LocalDateTime publishDate, Boolean isDeleted, LocalDateTime deletedDate) {
        this.materialId = materialId;
        this.diseaseTypeId = diseaseTypeId;
        this.diseaseTypeName = diseaseTypeName;
        this.title = title;
        this.materialType = materialType;
        this.filePath = filePath;
        this.link = link;
        this.sequenceNumber = sequenceNumber;
        this.publishDate = publishDate;
        this.isDeleted = isDeleted;
        this.deletedDate = deletedDate;
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
     * @return diseaseTypeId
     */
    public Integer getDiseaseTypeId() {
        return diseaseTypeId;
    }

    /**
     * 设置
     * @param diseaseTypeId
     */
    public void setDiseaseTypeId(Integer diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    /**
     * 获取
     * @return diseaseTypeName
     */
    public String getDiseaseTypeName() {
        return diseaseTypeName;
    }

    /**
     * 设置
     * @param diseaseTypeName
     */
    public void setDiseaseTypeName(String diseaseTypeName) {
        this.diseaseTypeName = diseaseTypeName;
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
     * @return materialType
     */
    public String getMaterialType() {
        return materialType;
    }

    /**
     * 设置
     * @param materialType
     */
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
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

    /**
     * 获取
     * @return deletedDate
     */
    public LocalDateTime getDeletedDate() {
        return deletedDate;
    }

    /**
     * 设置
     * @param deletedDate
     */
    public void setDeletedDate(LocalDateTime deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String toString() {
        return "Diseaselearningmaterials{materialId = " + materialId + ", diseaseTypeId = " + diseaseTypeId + ", diseaseTypeName = " + diseaseTypeName + ", title = " + title + ", materialType = " + materialType + ", filePath = " + filePath + ", link = " + link + ", sequenceNumber = " + sequenceNumber + ", publishDate = " + publishDate + ", isDeleted = " + isDeleted + ", deletedDate = " + deletedDate + "}";
    }
}
