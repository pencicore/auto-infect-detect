package com.infect.controller.cdcStaff;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.infect.entity.Dailyhealthstatus;
import com.infect.entity.User;
import com.infect.result.Result;
import com.infect.service.IDailyhealthstatusService;
import com.infect.service.IUserService;
import com.infect.temporary.DiseaseNameNumberPairTemp;
import com.infect.temporary.StationTemp;
import com.infect.vo.system.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Api(tags = "统计报表-数据大屏")
@RestController
@RequestMapping("cdcStaff/statisticsDataView")
public class StatisticsDataViewController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IDailyhealthstatusService dailyhealthstatusService;

    @GetMapping("/getStatisticsData")
    @ApiOperation("获取统计数据（总人数，总打卡数，今日打卡数，今日健康数，今日患病数）")
    public Result<StatisticsDataVO> getStatisticsData(){
        StatisticsDataVO statisticsDataVO = new StatisticsDataVO();

        Integer userNumber = Math.toIntExact(userService.count(
                new LambdaQueryWrapper<User>()
                        .eq(User::getIsActived, true)
        ));
        Integer userDiseaseNumber = Math.toIntExact(
                dailyhealthstatusService.count(
                        new LambdaQueryWrapper<Dailyhealthstatus>()
                                .eq(Dailyhealthstatus::getIsHealth, false)
                                .eq(Dailyhealthstatus::getCheckInDate, LocalDate.now())
                )
        );
        Integer userHealthNumber = Math.toIntExact(
                dailyhealthstatusService.count(
                        new LambdaQueryWrapper<Dailyhealthstatus>()
                                .eq(Dailyhealthstatus::getIsHealth, true)
                                .eq(Dailyhealthstatus::getCheckInDate, LocalDate.now())
                )
        );
        Integer checkInNumber = Math.toIntExact(
                dailyhealthstatusService.count()
        );

        statisticsDataVO.setUserNumber(userNumber);
        statisticsDataVO.setUserDiseaseNumber(userDiseaseNumber);
        statisticsDataVO.setUserHealthNumber(userHealthNumber);
        statisticsDataVO.setCheckInNumber(checkInNumber);

        return Result.success(statisticsDataVO);
    }

    @GetMapping("/getDiseaseDataToday")
    @ApiOperation("获取当日疾病分布")
    public Result<List<DiseaseNameNumberPairTemp>> getDiseaseDataToday(){
        List<DiseaseNameNumberPairTemp> list = dailyhealthstatusService.getDiseaseDataToday();
        return Result.success(list);
    }

    @GetMapping("/getUserStation")
    @ApiOperation("获取全部用户地理位置信息")
    public Result<List<StationTemp>> getUserStation(){
        List<StationTemp> list = dailyhealthstatusService.getUserStation();
        return Result.success(list);
    }

    @GetMapping("/getChickInInfoByText")
    @ApiOperation("根据手机号筛选数据")
    public Result<List<CheckinInfoStatisticsVO>> getChickInInfoByText(String phoneNumber, Integer infoNumber){
        if(infoNumber==null){
            infoNumber = 20;
        }
        List<CheckinInfoStatisticsVO> list = dailyhealthstatusService.getChickInInfoByText(phoneNumber,infoNumber);
        return Result.success(list);
    }

    @PostMapping("/getCheckInDailyNumber")
    @ApiOperation("获取一段时间的打卡时间分布")
    public Result<List<CheckinDailyNumberSumVO>> getCheckInDailyNumber(@RequestBody @DateTimeFormat(pattern = "yyyy-MM-dd") List<LocalDate> dateList){
        List<CheckinDailyNumberSumVO> voList = dailyhealthstatusService.getCheckInDailyNumber(dateList);
        return Result.success(voList);
    }

    @GetMapping("/getImportantUserInfo")
    @ApiOperation("获取重点人员跟踪信息")
    public Result<List<ImportantUserInfoVO>> getImportantUserInfo(){
        List<ImportantUserInfoVO> list = userService.getImportantUserInfo();
        return Result.success(list);
    }

}
