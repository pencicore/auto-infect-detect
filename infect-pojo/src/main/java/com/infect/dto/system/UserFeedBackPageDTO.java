package com.infect.dto.system;

import io.swagger.annotations.ApiModelProperty;

public class UserFeedBackPageDTO {

    @ApiModelProperty(value = "用户姓名", required = true, example = "张三")
    private String name;

    @ApiModelProperty(value = "电话号码", required = true, example = "13812345678")
    private String phoneNumber;

    @ApiModelProperty(value = "反馈意见标题", example = "关于系统的建议", required = true)
    private String feedbackTitle;

    @ApiModelProperty(value = "页码", example = "1")
    private Integer pageNo;

    @ApiModelProperty(value = "信息数", example = "20")
    private Integer pageSize;

    public UserFeedBackPageDTO() {
    }

    public UserFeedBackPageDTO(String name, String phoneNumber, String feedbackTitle) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.feedbackTitle = feedbackTitle;
    }

    public UserFeedBackPageDTO(String name, String phoneNumber, String feedbackTitle, Integer pageNo, Integer pageSize) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.feedbackTitle = feedbackTitle;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
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

    public String toString() {
        return "UserFeedBackPageDTO{name = " + name + ", phoneNumber = " + phoneNumber + ", feedbackTitle = " + feedbackTitle + "}";
    }

    /**
     * 获取
     * @return pageNo
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * 设置
     * @param pageNo
     */
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 获取
     * @return pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
