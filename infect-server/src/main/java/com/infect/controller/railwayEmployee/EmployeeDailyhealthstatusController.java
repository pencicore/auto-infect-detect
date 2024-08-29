package com.infect.controller.railwayEmployee;


import com.infect.dto.AllSymptomsDTO;
import com.infect.dto.RailwayEmployeeCheckInDTO;
import com.infect.entity.*;
import com.infect.result.Result;
import com.infect.service.IDailyhealthstatusService;
import com.infect.utils.BaseContext;
import com.infect.vo.DailyhealthstatusGetVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Api(tags = "每日健康签到相关接口")
@RestController
@RequestMapping("/railwayemployee/dailyhealthstatus")
@Slf4j
public class EmployeeDailyhealthstatusController {

    @Autowired
    private IDailyhealthstatusService dailyhealthstatusService;

    @ApiOperation(value = "根据id查询铁路工人今日打卡情况")
    @GetMapping("/status")
    public Result<DailyhealthstatusGetVO> getTodayCheckIn(){
        return Result.success(getDailyCheckIn(LocalDate.now()).getData());
    }

    @ApiOperation(value = "铁路工人签到")
    @PostMapping("/status/today")
    public Result userCheckIn(@RequestBody RailwayEmployeeCheckInDTO railwayEmployeeCheckInDTO){
        log.info("用户{}今日签到：{}", BaseContext.getCurrentId(), railwayEmployeeCheckInDTO);

        dailyhealthstatusService.userCheckIn(railwayEmployeeCheckInDTO);
        return Result.success();
    }

    @ApiOperation(value = "根据id和日期查询铁路工人今日打卡情况")
    @GetMapping("/status/daily")
    public Result<DailyhealthstatusGetVO> getDailyCheckIn(
            @ApiParam(value = "查询时间", required = true, example = "2024-08-29")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        log.info("查询用户{}在{}打卡情况", BaseContext.getCurrentId(),date);

        DailyhealthstatusGetVO dailyhealthstatusGetVO = dailyhealthstatusService.getDailyCheckIn(date);
        return Result.success(dailyhealthstatusGetVO);
    }

}
