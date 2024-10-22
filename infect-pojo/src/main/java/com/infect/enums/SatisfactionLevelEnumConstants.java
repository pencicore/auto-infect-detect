package com.infect.enums;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 满意度等级常量类
 * </p>
 *
 * @author author
 * @since 2024-10-22
 */
@ApiModel(value = "SatisfactionLevel", description = "满意度等级常量")
public class SatisfactionLevelEnumConstants {

    @ApiModelProperty(value = "非常满意")
    public static final String VERY_SATISFIED = "非常满意";

    @ApiModelProperty(value = "满意")
    public static final String SATISFIED = "满意";

    @ApiModelProperty(value = "一般")
    public static final String NEUTRAL = "一般";

    @ApiModelProperty(value = "不满意")
    public static final String DISSATISFIED = "不满意";

    @ApiModelProperty(value = "非常不满意")
    public static final String VERY_DISSATISFIED = "非常不满意";

    // 私有化构造函数，防止实例化
    private SatisfactionLevelEnumConstants() {
    }
}
