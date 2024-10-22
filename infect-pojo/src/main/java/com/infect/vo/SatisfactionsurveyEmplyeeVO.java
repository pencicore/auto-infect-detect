package com.infect.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

public class SatisfactionsurveyEmplyeeVO {
    @ApiModelProperty(value = "调查ID", example = "1")
    private Integer surveyID;

    @ApiModelProperty(value = "调查标题", example = "客户服务满意度调查")
    private String surveyTitle;

    @ApiModelProperty(value = "调查内容", example = "请对我们的客户服务进行打分和反馈")
    private String surveyContent;

    public SatisfactionsurveyEmplyeeVO() {
    }

    public SatisfactionsurveyEmplyeeVO(Integer surveyID, String surveyTitle, String surveyContent) {
        this.surveyID = surveyID;
        this.surveyTitle = surveyTitle;
        this.surveyContent = surveyContent;
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
     * @return surveyContent
     */
    public String getSurveyContent() {
        return surveyContent;
    }

    /**
     * 设置
     * @param surveyContent
     */
    public void setSurveyContent(String surveyContent) {
        this.surveyContent = surveyContent;
    }

    public String toString() {
        return "SatisfactionsurveyEmplyeeVO{surveyID = " + surveyID + ", surveyTitle = " + surveyTitle + ", surveyContent = " + surveyContent + "}";
    }
}
