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
@TableName("diseaselearningmaterials")
@ApiModel(value="Diseaselearningmaterials对象", description="")
public class Diseaselearningmaterials implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "MaterialID", type = IdType.AUTO)
    private Integer materialId;

    private Integer diseaseTypeId;

    private String diseaseTypeName;

    private String title;

    private String materialType;

    private String filePath;

    private String link;

    private Integer sequenceNumber;

    private LocalDateTime publishDate;

    private Boolean isDeleted;

    private LocalDateTime deletedDate;

}
