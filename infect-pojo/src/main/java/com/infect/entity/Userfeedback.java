package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("userfeedback")
@ApiModel(value="Userfeedback对象", description="")
public class Userfeedback implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "FeedbackID", type = IdType.AUTO)
    private Integer FeedbackID;

    private Integer UserID;

    private String Name;

    private String PhoneNumber;

    private String FeedbackTitle;

    private String FeedbackText;

    private LocalDateTime FeedbackDate;


}
