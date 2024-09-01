package com.infect.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("登录")
public class UserLoginDTO {

    @ApiModelProperty(value = "电话号码", example = "28328495177", required = true)
    private String phoneNumber;

    @ApiModelProperty(value = "密码",example = "12345678", required = true)
    private String password;
}
