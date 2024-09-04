package com.infect.vo;

import com.infect.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("用户登录")
public class UserLoginVO {

    @ApiModelProperty(value = "是否完善信息",example = "true")
    private boolean informationComplete;

    @ApiModelProperty(value = "token(JWT)",example = "一个jwt")
    private String token;

    @ApiModelProperty(value = "用户信息")
    private User user;

    public boolean isInformationComplete() {
        return informationComplete;
    }

    public void setInformationComplete(boolean informationComplete) {
        this.informationComplete = informationComplete;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
