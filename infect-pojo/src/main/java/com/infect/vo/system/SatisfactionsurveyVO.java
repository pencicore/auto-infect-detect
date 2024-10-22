package com.infect.vo.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

public class SatisfactionsurveyVO {

    @ApiModelProperty(value = "调查ID", example = "1")
    private Integer surveyID;

    @ApiModelProperty(value = "调查标题", example = "客户服务满意度调查")
    private String surveyTitle;

    @ApiModelProperty(value = "是否开放", example = "true")
    private Boolean isOpen;

    @ApiModelProperty(value = "满意度", example = "74.23249752")
    private Double Satisfaction;

    public SatisfactionsurveyVO() {
    }

    public SatisfactionsurveyVO(Integer surveyID, String surveyTitle, Boolean isOpen, Double Satisfaction) {
        this.surveyID = surveyID;
        this.surveyTitle = surveyTitle;
        this.isOpen = isOpen;
        this.Satisfaction = Satisfaction;
    }

    /**
     * 获取
     * @return surveyID
     */
    public Integer getSurveyID() {
        return surveyID;
    }

    /**
     * 设置
     * @param surveyID
     */
    public void setSurveyID(Integer surveyID) {
        this.surveyID = surveyID;
    }

    /**
     * 获取
     * @return surveyTitle
     */
    public String getSurveyTitle() {
        return surveyTitle;
    }

    /**
     * 设置
     * @param surveyTitle
     */
    public void setSurveyTitle(String surveyTitle) {
        this.surveyTitle = surveyTitle;
    }

    /**
     * 获取
     * @return isOpen
     */
    public Boolean getIsOpen() {
        return isOpen;
    }

    /**
     * 设置
     * @param isOpen
     */
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    /**
     * 获取
     * @return Satisfaction
     */
    public Double getSatisfaction() {
        return Satisfaction;
    }

    /**
     * 设置
     * @param Satisfaction
     */
    public void setSatisfaction(Double Satisfaction) {
        this.Satisfaction = Satisfaction;
    }

    public String toString() {
        return "SatisfactionsurveyVO{surveyID = " + surveyID + ", surveyTitle = " + surveyTitle + ", isOpen = " + isOpen + ", Satisfaction = " + Satisfaction + "}";
    }
}

