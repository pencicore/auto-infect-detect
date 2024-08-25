package com.infect.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "信息" ,description = "员工登录时传递得数据模型")
public class UserRegisterDTO implements Serializable {

    @ApiModelProperty(value = "是否激活",example = "123456200304291234", required = true)
    private String UserId;

    @ApiModelProperty(value = "电话号码",example = "28328495177")
    private String PhoneNumber;

    @ApiModelProperty(value = "姓名",example = "黄兵")
    private String Name;

    @ApiModelProperty(value = "人员身份",example = "铁路职工")
    private String UserType;

    @ApiModelProperty("是否激活")
    private Boolean IsActived;

    @ApiModelProperty(value = "密码",example = "12345678")
    private String Password;

}
