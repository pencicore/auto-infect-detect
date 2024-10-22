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
 * 满意度打分实体类
 * </p>
 *
 * @author author
 * @since 2024-10-22
 */
@TableName("satisfactionrating")
@ApiModel(value="SatisfactionRating对象", description="满意度打分表")
public class Satisfactionrating implements Serializable {

    @ApiModelProperty(value = "打分ID", example = "1")
    @TableId(value = "RatingID", type = IdType.AUTO)
    private Integer ratingID;

    @ApiModelProperty(value = "调查ID", example = "1001")
    @TableField("SurveyID")
    private Integer surveyID;

    @ApiModelProperty(value = "用户ID", example = "2001")
    @TableField("UserID")
    private Integer userID;

    @ApiModelProperty(value = "用户手机号码", example = "13800138000")
    @TableField("PhoneNumber")
    private String phoneNumber;

    @ApiModelProperty(value = "打分时间", example = "2024-10-22T14:30:00")
    @TableField("RatingTime")
    private LocalDateTime ratingTime;

    @ApiModelProperty(value = "满意度等级", example = "非常满意")
    @TableField("SatisfactionLevel")
    private String satisfactionLevel;

    public Satisfactionrating() {
    }

    public Satisfactionrating(Integer ratingID, Integer surveyID, Integer userID, String phoneNumber, LocalDateTime ratingTime, String satisfactionLevel) {
        this.ratingID = ratingID;
        this.surveyID = surveyID;
        this.userID = userID;
        this.phoneNumber = phoneNumber;
        this.ratingTime = ratingTime;
        this.satisfactionLevel = satisfactionLevel;
    }

    @ApiModelProperty(value = "获取打分ID")
    public Integer getRatingID() {
        return ratingID;
    }

    @ApiModelProperty(value = "设置打分ID")
    public void setRatingID(Integer ratingID) {
        this.ratingID = ratingID;
    }

    @ApiModelProperty(value = "获取调查ID")
    public Integer getSurveyID() {
        return surveyID;
    }

    @ApiModelProperty(value = "设置调查ID")
    public void setSurveyID(Integer surveyID) {
        this.surveyID = surveyID;
    }

    @ApiModelProperty(value = "获取用户ID")
    public Integer getUserID() {
        return userID;
    }

    @ApiModelProperty(value = "设置用户ID")
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @ApiModelProperty(value = "获取用户手机号码")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @ApiModelProperty(value = "设置用户手机号码")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @ApiModelProperty(value = "获取打分时间")
    public LocalDateTime getRatingTime() {
        return ratingTime;
    }

    @ApiModelProperty(value = "设置打分时间")
    public void setRatingTime(LocalDateTime ratingTime) {
        this.ratingTime = ratingTime;
    }

    @ApiModelProperty(value = "获取满意度等级")
    public String getSatisfactionLevel() {
        return satisfactionLevel;
    }

    @ApiModelProperty(value = "设置满意度等级")
    public void setSatisfactionLevel(String satisfactionLevel) {
        this.satisfactionLevel = satisfactionLevel;
    }

    @Override
    public String toString() {
        return "Satisfactionrating{" +
                "ratingID=" + ratingID +
                ", surveyID=" + surveyID +
                ", userID=" + userID +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", ratingTime=" + ratingTime +
                ", satisfactionLevel='" + satisfactionLevel + '\'' +
                '}';
    }
}
