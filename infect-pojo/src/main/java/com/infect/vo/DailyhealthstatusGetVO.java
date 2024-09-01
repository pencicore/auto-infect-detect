package com.infect.vo;

import com.infect.entity.Dailyhealthstatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel("每日打卡信息")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyhealthstatusGetVO {

    @ApiModelProperty(value = "今天是否签到", example = "true")
    private Boolean hasSignedToday;

    @ApiModelProperty(value = "签到信息表")
    private Dailyhealthstatus dailyhealthstatus;
}
