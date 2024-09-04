package com.infect.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "信息" ,description = "员工登录时传递得数据模型")
public class UserRegisterDTO implements Serializable {

    @ApiModelProperty(value = "电话号码",example = "28328495177", required = true)
    private String phoneNumber;

    @ApiModelProperty(value = "姓名",example = "黄兵",required = true)
    private String name;

    @ApiModelProperty(value = "人员身份",example = "铁路职工", required = true)
    private String userType;

    @ApiModelProperty("是否激活")
    private Boolean isActived;

    @ApiModelProperty(value = "密码",example = "12345678", required = true)
    private String password;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Boolean getIsActived() {
        return isActived;
    }

    public void setIsActived(Boolean actived) {
        isActived = actived;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
