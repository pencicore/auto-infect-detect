package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 满意度调查实体类
 * </p>
 *
 * @author author
 * @since 2024-10-22
 */
@TableName("satisfactionsurvey")
@ApiModel(value="SatisfactionSurvey对象", description="满意度调查表")
public class Satisfactionsurvey implements Serializable {

    @ApiModelProperty(value = "调查ID", example = "1")
    @TableId(value = "SurveyID", type = IdType.AUTO)
    private Integer surveyID;

    @ApiModelProperty(value = "调查标题", example = "客户服务满意度调查")
    @TableField("SurveyTitle")
    private String surveyTitle;

    @ApiModelProperty(value = "调查内容", example = "请对我们的客户服务进行打分和反馈")
    @TableField("SurveyContent")
    private String surveyContent;

    @ApiModelProperty(value = "是否开放", example = "true")
    @TableField("IsOpen")
    private Boolean isOpen;

    @ApiModelProperty(value = "最近一次开放时间", example = "2024-10-21T15:30:00")
    @TableField("LastOpenTime")
    private LocalDateTime lastOpenTime;

    @ApiModelProperty(value = "最近一次关闭时间", example = "2024-10-22T18:00:00")
    @TableField("LastCloseTime")
    private LocalDateTime lastCloseTime;

    @ApiModelProperty(value = "创建时间", example = "2024-10-21T15:30:00")
    private LocalDateTime createTime;

    public Satisfactionsurvey() {
    }

    public Satisfactionsurvey(Integer surveyID, String surveyTitle, String surveyContent, Boolean isOpen, LocalDateTime lastOpenTime, LocalDateTime lastCloseTime, LocalDateTime createTime) {
        this.surveyID = surveyID;
        this.surveyTitle = surveyTitle;
        this.surveyContent = surveyContent;
        this.isOpen = isOpen;
        this.lastOpenTime = lastOpenTime;
        this.lastCloseTime = lastCloseTime;
        this.createTime = createTime;
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
     * @return lastOpenTime
     */
    public LocalDateTime getLastOpenTime() {
        return lastOpenTime;
    }

    /**
     * 设置
     * @param lastOpenTime
     */
    public void setLastOpenTime(LocalDateTime lastOpenTime) {
        this.lastOpenTime = lastOpenTime;
    }

    /**
     * 获取
     * @return lastCloseTime
     */
    public LocalDateTime getLastCloseTime() {
        return lastCloseTime;
    }

    /**
     * 设置
     * @param lastCloseTime
     */
    public void setLastCloseTime(LocalDateTime lastCloseTime) {
        this.lastCloseTime = lastCloseTime;
    }

    /**
     * 获取
     * @return createTime
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String toString() {
        return "Satisfactionsurvey{surveyID = " + surveyID + ", surveyTitle = " + surveyTitle + ", surveyContent = " + surveyContent + ", isOpen = " + isOpen + ", lastOpenTime = " + lastOpenTime + ", lastCloseTime = " + lastCloseTime + ", createTime = " + createTime + "}";
    }
}
