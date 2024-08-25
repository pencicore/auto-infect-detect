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
 * Entity representing a hospital.
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("hospital")
@ApiModel(value="Hospital对象", description="Entity representing a hospital.")
public class Hospital implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "HospitalID", type = IdType.AUTO)
    private Integer hospitalId;

    private String hospitalName;

    private String hospitalPhoneNumber;

    private String address;

}
