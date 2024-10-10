package com.infect.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDate;
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
@TableName("diseasescoring")
@ApiModel(value="Diseasescoring对象", description="")
public class Diseasescoring implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ScoringID", type = IdType.AUTO)
    private Integer scoringId;

    private Integer statusId;

    private LocalDate symptomTime;

    private Integer diseaseTypeId;

    private String diseaseTypeName;

    private BigDecimal score;

    public Integer getScoringId() {
        return scoringId;
    }

    public void setScoringId(Integer scoringId) {
        this.scoringId = scoringId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public LocalDate getSymptomTime() {
        return symptomTime;
    }

    public void setSymptomTime(LocalDate symptomTime) {
        this.symptomTime = symptomTime;
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

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
