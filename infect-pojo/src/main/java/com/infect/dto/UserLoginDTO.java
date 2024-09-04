package com.infect.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("登录")
public class UserLoginDTO {

    @ApiModelProperty(value = "电话号码", example = "28328495177", required = true)
    private String phoneNumber;

    @ApiModelProperty(value = "密码",example = "12345678", required = true)
    private String password;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
