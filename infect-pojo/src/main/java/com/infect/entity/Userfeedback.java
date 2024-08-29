package com.infect.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
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
}
