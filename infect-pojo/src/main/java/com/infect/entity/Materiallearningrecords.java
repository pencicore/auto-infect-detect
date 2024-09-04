package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
@TableName("materiallearningrecords")
@ApiModel(value="Materiallearningrecords对象", description="")
public class Materiallearningrecords implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "RecordID", type = IdType.AUTO)
    private Integer recordId;

    private Integer userId;

    private Integer materialId;

    private LocalDateTime clickedDate;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public LocalDateTime getClickedDate() {
        return clickedDate;
    }

    public void setClickedDate(LocalDateTime clickedDate) {
        this.clickedDate = clickedDate;
    }
}
