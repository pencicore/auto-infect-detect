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
@TableName("aisymptomweighting")
@ApiModel(value="Aisymptomweighting对象", description="")
public class Aisymptomweighting implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "SymptomWeightingID", type = IdType.AUTO)
    private Integer symptomWeightingId;

    private Integer diseaseTypeId;

    private String diseaseTypeName;

    private String tableName;

    private String symptomFieldName;

    private BigDecimal weightScore;

    public Integer getSymptomWeightingId() {
        return symptomWeightingId;
    }

    public void setSymptomWeightingId(Integer symptomWeightingId) {
        this.symptomWeightingId = symptomWeightingId;
    }

    public Integer getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(Integer diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    public String getDiseaseTypeName() {
        return diseaseTypeName;
    }

    public void setDiseaseTypeName(String diseaseTypeName) {
        this.diseaseTypeName = diseaseTypeName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSymptomFieldName() {
        return symptomFieldName;
    }

    public void setSymptomFieldName(String symptomFieldName) {
        this.symptomFieldName = symptomFieldName;
    }

    public BigDecimal getWeightScore() {
        return weightScore;
    }

    public void setWeightScore(BigDecimal weightScore) {
        this.weightScore = weightScore;
    }
}
