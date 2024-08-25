package com.infect.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalTime;
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
@TableName("dailyhealthstatus")
@ApiModel(value="Dailyhealthstatus对象", description="")
public class Dailyhealthstatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "StatusID", type = IdType.AUTO)
    private Integer statusId;

    private Integer userId;

    private LocalDate checkInDate;

    private LocalTime checkInTime;

    private Boolean isHealth;

    private String diseaseTypeName;

    private String diagnosisDiseaseTypeName;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String province;

    private String city;

    private String county;

    private String locationName;
}
