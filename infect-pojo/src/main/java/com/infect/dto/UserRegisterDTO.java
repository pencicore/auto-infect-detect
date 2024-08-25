package com.infect.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "信息" ,description = "员工登录时传递得数据模型")
public class UserRegisterDTO implements Serializable {

    @ApiModelProperty(value = "电话号码",example = "28328495177")
    private String phoneNumber;

    @ApiModelProperty(value = "姓名",example = "黄兵")
    private String name;

    @ApiModelProperty(value = "人员身份",example = "铁路职工")
    private String userType;

    @ApiModelProperty("是否激活")
    private Boolean isActived;

    @ApiModelProperty(value = "密码",example = "12345678")
    private String password;

}
