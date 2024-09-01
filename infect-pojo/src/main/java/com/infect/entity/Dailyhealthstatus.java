package com.infect.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户每日健康状态
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("dailyhealthstatus")
@ApiModel(value="Dailyhealthstatus对象", description="用户每日健康状态记录")
public class Dailyhealthstatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "StatusID", type = IdType.AUTO)
    @ApiModelProperty(value = "状态ID，自增")
    private Integer statusId;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "签到日期，格式为 yyyy-MM-dd", required = true, example = "2024-10-08")
    private LocalDate checkInDate;

    @ApiModelProperty(value = "签到时间，格式为 HH:mm:ss", required = true, example = "08:30:00")
    private LocalTime checkInTime;

    @ApiModelProperty(value = "健康状态，true 表示健康，false 表示不健康", required = true, example = "true")
    private Boolean isHealth;

    @ApiModelProperty(value = "最可能疾病类型名称", example = "感冒")
    private String diseaseTypeName;

    @ApiModelProperty(value = "确诊疾病名称", example = "流感")
    private String diagnosisDiseaseTypeName;

    @ApiModelProperty(value = "经度", required = true, example = "116.397128")
    private BigDecimal longitude;

    @ApiModelProperty(value = "纬度", required = true, example = "39.916527")
    private BigDecimal latitude;

    @ApiModelProperty(value = "省", required = true, example = "北京市")
    private String province;

    @ApiModelProperty(value = "市", required = true, example = "北京市")
    private String city;

    @ApiModelProperty(value = "县", required = true, example = "东城区")
    private String county;

    @ApiModelProperty(value = "位置名称，如详细地址信息或地标", required = true, example = "天安门广场")
    private String locationName;
}
