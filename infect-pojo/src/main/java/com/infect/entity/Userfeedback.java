package com.infect.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("userfeedback")
@ApiModel(value="Userfeedback对象", description="用户反馈意见表")
public class Userfeedback implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "反馈ID", hidden = true)
    @TableId(value = "FeedbackID", type = IdType.AUTO)
    private Integer feedbackId;

    @ApiModelProperty(value = "用户ID", hidden = true)
    private Integer userId;

    @ApiModelProperty(value = "姓名", example = "张三", required = true)
    private String name;

    @ApiModelProperty(value = "电话号码", example = "13800138000", required = true)
    private String phoneNumber;

    @ApiModelProperty(value = "反馈意见标题", example = "关于系统的建议", required = true)
    private String feedbackTitle;

    @ApiModelProperty(value = "反馈意见文本", example = "系统使用过程中遇到的问题是...", required = true)
    private String feedbackText;

    @ApiModelProperty(value = "反馈发布时间", example = "2024-08-28T10:00:00", required = true)
    private LocalDateTime feedbackDate;

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFeedbackTitle() {
        return feedbackTitle;
    }

    public void setFeedbackTitle(String feedbackTitle) {
        this.feedbackTitle = feedbackTitle;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public LocalDateTime getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(LocalDateTime feedbackDate) {
        this.feedbackDate = feedbackDate;
    }
}
