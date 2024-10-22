package com.infect.dto.system;

import org.springframework.web.multipart.MultipartFile;

public class LearningMaterialDTO {

    private String diseaseTypeName;

    private String title;

    private String materialType;

    private MultipartFile file;

    private String link;

    public LearningMaterialDTO() {
    }

    public LearningMaterialDTO(String diseaseTypeName, String title, String materialType, MultipartFile file, String link) {
        this.diseaseTypeName = diseaseTypeName;
        this.title = title;
        this.materialType = materialType;
        this.file = file;
        this.link = link;
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
     * @return file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * 设置
     * @param file
     */
    public void setFile(MultipartFile file) {
        this.file = file;
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

    public String toString() {
        return "LearningMaterialDTO{diseaseTypeName = " + diseaseTypeName + ", title = " + title + ", materialType = " + materialType + ", file = " + file + ", link = " + link + "}";
    }
}
