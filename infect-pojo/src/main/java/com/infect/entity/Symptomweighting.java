package com.infect.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("symptomweighting")
@ApiModel(value="Symptomweighting对象", description="")
public class Symptomweighting implements Serializable {

    @TableId(value = "SymptomWeightingID", type = IdType.AUTO)
    private Integer symptomWeightingId;

    private Integer diseaseTypeId;

    private String diseaseTypeName;

    private String tableName;

    private String symptomFieldName;

    private BigDecimal weightScore;


    public Symptomweighting() {
    }

    public Symptomweighting(Integer symptomWeightingId, Integer diseaseTypeId, String diseaseTypeName, String tableName, String symptomFieldName, BigDecimal weightScore) {
        this.symptomWeightingId = symptomWeightingId;
        this.diseaseTypeId = diseaseTypeId;
        this.diseaseTypeName = diseaseTypeName;
        this.tableName = tableName;
        this.symptomFieldName = symptomFieldName;
        this.weightScore = weightScore;
    }

    /**
     * 获取
     * @return symptomWeightingId
     */
    public Integer getSymptomWeightingId() {
        return symptomWeightingId;
    }

    /**
     * 设置
     * @param symptomWeightingId
     */
    public void setSymptomWeightingId(Integer symptomWeightingId) {
        this.symptomWeightingId = symptomWeightingId;
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
     * @return tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 设置
     * @param tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 获取
     * @return symptomFieldName
     */
    public String getSymptomFieldName() {
        return symptomFieldName;
    }

    /**
     * 设置
     * @param symptomFieldName
     */
    public void setSymptomFieldName(String symptomFieldName) {
        this.symptomFieldName = symptomFieldName;
    }

    /**
     * 获取
     * @return weightScore
     */
    public BigDecimal getWeightScore() {
        return weightScore;
    }

    /**
     * 设置
     * @param weightScore
     */
    public void setWeightScore(BigDecimal weightScore) {
        this.weightScore = weightScore;
    }

    public String toString() {
        return "Symptomweighting{symptomWeightingId = " + symptomWeightingId + ", diseaseTypeId = " + diseaseTypeId + ", diseaseTypeName = " + diseaseTypeName + ", tableName = " + tableName + ", symptomFieldName = " + symptomFieldName + ", weightScore = " + weightScore + "}";
    }
}
