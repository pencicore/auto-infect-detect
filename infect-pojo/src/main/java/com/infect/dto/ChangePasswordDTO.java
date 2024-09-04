package com.infect.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("密码")
public class ChangePasswordDTO {

    @ApiModelProperty(value = "原密码",required = true,example = "12345678")
    private String oldPassword;

    @ApiModelProperty(value = "新密码",required = true,example = "12345678")
    private String newPassword;

    @ApiModelProperty(value = "确认新密码",required = true,example = "12345678")
    private String confirmPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
