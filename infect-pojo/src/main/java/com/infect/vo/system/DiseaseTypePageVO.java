package com.infect.vo.system;

import com.infect.entity.Diseasesubtype;

import java.util.List;

public class DiseaseTypePageVO {

    private Integer diseaseTypeId;

    private String diseaseTypeName;

    private Boolean hasSubtype;

    private List<Diseasesubtype> subDiseaseList;

    public DiseaseTypePageVO() {
    }

    public DiseaseTypePageVO(Integer diseaseTypeId, String diseaseTypeName, Boolean hasSubtype, List<Diseasesubtype> subDiseaseList) {
        this.diseaseTypeId = diseaseTypeId;
        this.diseaseTypeName = diseaseTypeName;
        this.hasSubtype = hasSubtype;
        this.subDiseaseList = subDiseaseList;
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
     * @return hasSubtype
     */
    public Boolean getHasSubtype() {
        return hasSubtype;
    }

    /**
     * 设置
     * @param hasSubtype
     */
    public void setHasSubtype(Boolean hasSubtype) {
        this.hasSubtype = hasSubtype;
    }

    /**
     * 获取
     * @return subDiseaseList
     */
    public List<Diseasesubtype> getSubDiseaseList() {
        return subDiseaseList;
    }

    /**
     * 设置
     * @param subDiseaseList
     */
    public void setSubDiseaseList(List<Diseasesubtype> subDiseaseList) {
        this.subDiseaseList = subDiseaseList;
    }

    public String toString() {
        return "DiseaseTypePageVO{diseaseTypeId = " + diseaseTypeId + ", diseaseTypeName = " + diseaseTypeName + ", hasSubtype = " + hasSubtype + ", subDiseaseList = " + subDiseaseList + "}";
    }
}
