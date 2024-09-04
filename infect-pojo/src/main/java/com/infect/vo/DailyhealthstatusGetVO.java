package com.infect.vo;

import com.infect.entity.Dailyhealthstatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("每日打卡信息")
public class DailyhealthstatusGetVO {

    @ApiModelProperty(value = "今天是否签到", example = "true")
    private Boolean hasSignedToday;

    @ApiModelProperty(value = "签到信息表")
    private Dailyhealthstatus dailyhealthstatus;

    public Boolean getHasSignedToday() {
        return hasSignedToday;
    }

    public void setHasSignedToday(Boolean hasSignedToday) {
        this.hasSignedToday = hasSignedToday;
    }

    public Dailyhealthstatus getDailyhealthstatus() {
        return dailyhealthstatus;
    }

    public void setDailyhealthstatus(Dailyhealthstatus dailyhealthstatus) {
        this.dailyhealthstatus = dailyhealthstatus;
    }
}
