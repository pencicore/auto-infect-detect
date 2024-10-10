package com.infect.vo;

import com.infect.entity.Dailyhealthstatus;
import com.infect.entity.Diseasescoring;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("每日打卡信息")
public class DailyhealthstatusGetVO {

    @ApiModelProperty(value = "今天是否签到", example = "true")
    private Boolean hasSignedToday;

    private Boolean hasMonthSigned;

    @ApiModelProperty(value = "签到信息表")
    private Dailyhealthstatus dailyhealthstatus;

    private List<Diseasescoring> diseasescoringList;

    public List<Diseasescoring> getDiseasescoringList() {
        return diseasescoringList;
    }

    public void setDiseasescoringList(List<Diseasescoring> diseasescoringList) {
        this.diseasescoringList = diseasescoringList;
    }

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

    public Boolean getHasMonthSigned() {
        return hasMonthSigned;
    }

    public void setHasMonthSigned(Boolean hasMonthSigned) {
        this.hasMonthSigned = hasMonthSigned;
    }
}
