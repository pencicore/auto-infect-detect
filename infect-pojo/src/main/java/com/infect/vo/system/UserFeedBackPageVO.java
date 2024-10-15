package com.infect.vo.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

public class UserFeedBackPageVO {

    //User表信息
    @ApiModelProperty(value = "用户ID，自增", example = "1")
    private Integer userId;

    @ApiModelProperty(value = "用户姓名", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value = "电话号码", required = true, example = "13812345678")
    private String phoneNumber;

    //UserFeedBack表信息
    @TableId(value = "FeedbackID", type = IdType.AUTO)
    private Integer feedbackId;

    @ApiModelProperty(value = "反馈意见标题", example = "关于系统的建议", required = true)
    private String feedbackTitle;

    @ApiModelProperty(value = "反馈意见文本", example = "系统使用过程中遇到的问题是...", required = true)
    private String feedbackText;

    @ApiModelProperty(value = "反馈发布时间", example = "2024-08-28T10:00:00", required = true)
    private LocalDateTime feedbackDate;

    public UserFeedBackPageVO() {
    }

    public UserFeedBackPageVO(Integer userId, String name, String phoneNumber, Integer feedbackId, String feedbackTitle, String feedbackText, LocalDateTime feedbackDate) {
        this.userId = userId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.feedbackId = feedbackId;
        this.feedbackTitle = feedbackTitle;
        this.feedbackText = feedbackText;
        this.feedbackDate = feedbackDate;
    }

    /**
     * 获取
     * @return userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取
     * @return feedbackId
     */
    public Integer getFeedbackId() {
        return feedbackId;
    }

    /**
     * 设置
     * @param feedbackId
     */
    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    /**
     * 获取
     * @return feedbackTitle
     */
    public String getFeedbackTitle() {
        return feedbackTitle;
    }

    /**
     * 设置
     * @param feedbackTitle
     */
    public void setFeedbackTitle(String feedbackTitle) {
        this.feedbackTitle = feedbackTitle;
    }

    /**
     * 获取
     * @return feedbackText
     */
    public String getFeedbackText() {
        return feedbackText;
    }

    /**
     * 设置
     * @param feedbackText
     */
    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    /**
     * 获取
     * @return feedbackDate
     */
    public LocalDateTime getFeedbackDate() {
        return feedbackDate;
    }

    /**
     * 设置
     * @param feedbackDate
     */
    public void setFeedbackDate(LocalDateTime feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public String toString() {
        return "UserFeedBackPageVO{userId = " + userId + ", name = " + name + ", phoneNumber = " + phoneNumber + ", feedbackId = " + feedbackId + ", feedbackTitle = " + feedbackTitle + ", feedbackText = " + feedbackText + ", feedbackDate = " + feedbackDate + "}";
    }
}
