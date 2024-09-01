package com.infect.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("密码")
@Data
public class ChangePasswordDTO {

    @ApiModelProperty(value = "原密码",required = true,example = "12345678")
    private String oldPassword;

    @ApiModelProperty(value = "新密码",required = true,example = "12345678")
    private String newPassword;
}
