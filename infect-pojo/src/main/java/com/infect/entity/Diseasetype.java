package com.infect.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("diseasetype")
@ApiModel(value="Diseasetype对象", description="")
public class Diseasetype implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DiseaseTypeID", type = IdType.AUTO)
    private Integer diseaseTypeId;

    private String diseaseTypeName;

    private Boolean hasSubtype;

}
