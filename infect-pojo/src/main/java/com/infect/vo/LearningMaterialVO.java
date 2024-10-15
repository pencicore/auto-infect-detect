package com.infect.vo;

public class LearningMaterialVO {

    private String diseaseTypeName;

    private String title;

    private String materialType;

    private String filePath;

    private String link;

    public LearningMaterialVO() {
    }

    public LearningMaterialVO(String diseaseTypeName, String title, String materialType, String filePath, String link) {
        this.diseaseTypeName = diseaseTypeName;
        this.title = title;
        this.materialType = materialType;
        this.filePath = filePath;
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

    public String toString() {
        return "LearningMaterialVO{diseaseTypeName = " + diseaseTypeName + ", title = " + title + ", materialType = " + materialType + ", filePath = " + filePath + ", link = " + link + "}";
    }
}
