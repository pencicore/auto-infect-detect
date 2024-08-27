package com.infect.vo;

import com.infect.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@ApiModel("用户登录")
public class UserLoginVO {

    @ApiModelProperty(value = "是否完善信息",example = "true")
    private boolean isInformationComplete;

    @ApiModelProperty(value = "token(JWT)",example = "一个jwt")
    private String token;

    @ApiModelProperty(value = "用户信息")
    private User user;
}
