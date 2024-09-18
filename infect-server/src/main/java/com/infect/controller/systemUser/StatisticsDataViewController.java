package com.infect.controller.systemUser;
import com.infect.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "统计报表-数据大屏")
@RestController
@RequestMapping("systemUser/statisticsDataView")
public class StatisticsDataViewController {

    @GetMapping("/getStatisticsData")
    @ApiOperation("获取统计数据（总人数，总打卡数，今日打卡数，今日健康数，今日患病数）")
    public Result getStatisticsData(){

        return Result.success();
    }

}
