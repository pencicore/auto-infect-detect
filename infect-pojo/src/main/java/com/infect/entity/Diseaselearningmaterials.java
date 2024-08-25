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
    private Integer MaterialID;

    private Integer DiseaseTypeID;

    private String DiseaseTypeName;

    private String Title;

    private String MaterialType;

    private String FilePath;

    private String Link;

    private Integer SequenceNumber;

    private LocalDateTime PublishDate;

    private Boolean IsDeleted;

    private LocalDateTime DeletedDate;


}
