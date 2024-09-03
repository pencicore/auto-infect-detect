package com.infect.controller.railwayEmployee;

import com.infect.dto.AllSymptomsDTO;
import com.infect.dto.RailwayEmployeeCheckInDTO;
import com.infect.entity.Workenvironmentinfo;
import com.infect.result.Result;
import com.infect.service.IDailyhealthstatusService;
import com.infect.service.IWorkenvironmentinfoService;
import com.infect.utils.BaseContext;
import com.infect.vo.DailyhealthstatusGetVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Api(tags = "打卡和监控功能相关接口")
@Slf4j
@RestController
@RequestMapping("/railwayemployee/checkin")
public class EmployeeCheckInController {

    @Autowired
    private IDailyhealthstatusService dailyhealthstatusService;

    @Autowired
    private IWorkenvironmentinfoService workenvironmentinfoService;

    @ApiOperation(value = "铁路工人签到")
    @PostMapping("/checkin")
    public Result userCheckIn(@RequestBody RailwayEmployeeCheckInDTO railwayEmployeeCheckInDTO){
        log.info("用户{}今日签到：{}", BaseContext.getCurrentId(), railwayEmployeeCheckInDTO);

        dailyhealthstatusService.userCheckIn(railwayEmployeeCheckInDTO);
        return Result.success();
    }

    @ApiOperation(value = "根据id和日期查询铁路工人今日打卡情况")
    @GetMapping("/select/daily")
    public Result<DailyhealthstatusGetVO> getDailyCheckIn(
            @ApiParam(value = "查询时间", required = true, example = "2024-08-29")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        log.info("查询用户{}在{}打卡情况", BaseContext.getCurrentId(),date);

        DailyhealthstatusGetVO dailyhealthstatusGetVO = dailyhealthstatusService.getDailyCheckIn(date);
        return Result.success(dailyhealthstatusGetVO);
    }

    @ApiOperation(value = "提交/修改当月工作环境信息")
    @PostMapping("/month")
    public Result saveWorkEnvironmentInfo(@RequestBody Workenvironmentinfo workenvironmentinfo) {
        log.info("用户{}提交当月工作环境信息：{}", BaseContext.getCurrentId(), workenvironmentinfo);
        workenvironmentinfoService.saveWorkEnvironmentInfo(workenvironmentinfo);

        return Result.success();
    }

    @ApiOperation(value = "一次性提交所有症状信息")
    @PostMapping("/all")
    public Result saveAllSymptoms(@RequestBody AllSymptomsDTO allSymptomsDTO){
        log.info("用户{}提交所有症状信息：{}", BaseContext.getCurrentId(),allSymptomsDTO);

        dailyhealthstatusService.saveAllSymptoms(allSymptomsDTO);
        return Result.success();
    }

//    @ApiOperation(value = "提交全身症状信息")
//    @PostMapping("/general")
//    public Result saveGeneralSymptoms(@RequestBody Generalsymptoms generalsymptoms){
//        log.info("用户{}提交全身症状信息：{}",BaseContext.getCurrentId(),generalsymptoms);
//
//        dailyhealthstatusService.saveGeneralSymptoms(generalsymptoms);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交呼吸系统症状信息")
//    @PostMapping("/respiratory")
//    public Result saveGeneralSymptoms(@RequestBody Respiratorysymptoms respiratorysymptoms){
//        log.info("用户{}提交呼吸症状信息：{}",BaseContext.getCurrentId(),respiratorysymptoms);
//
//        dailyhealthstatusService.saveRespiratorysymptoms(respiratorysymptoms);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交消化系统症状信息")
//    @PostMapping("/digestive")
//    public Result saveDigestiveSymptoms(@RequestBody Digestivesymptoms digestivesymptoms) {
//        log.info("用户{}提交消化系统症状信息：{}", BaseContext.getCurrentId(), digestivesymptoms);
//        dailyhealthstatusService.saveDigestiveSymptoms(digestivesymptoms);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交循环系统症状信息")
//    @PostMapping("/circulatory")
//    public Result saveCirculatorySymptoms(@RequestBody Circulatorysymptoms circulatorysymptoms) {
//        log.info("用户{}提交循环系统症状信息：{}", BaseContext.getCurrentId(), circulatorysymptoms);
//        dailyhealthstatusService.saveCirculatorySymptoms(circulatorysymptoms);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交神经系统症状信息")
//    @PostMapping("/neurological")
//    public Result saveNeurologicalSymptoms(@RequestBody Neurologicalsymptoms neurologicalSymptoms) {
//        log.info("用户{}提交神经系统症状信息：{}", BaseContext.getCurrentId(), neurologicalSymptoms);
//        dailyhealthstatusService.saveNeurologicalSymptoms(neurologicalSymptoms);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交局部症状信息")
//    @PostMapping("/local")
//    public Result saveLocalSymptoms(@RequestBody Localsymptoms localSymptoms) {
//        log.info("用户{}提交局部症状信息：{}", BaseContext.getCurrentId(), localSymptoms);
//        dailyhealthstatusService.saveLocalSymptoms(localSymptoms);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交其他症状信息")
//    @PostMapping("/other")
//    public Result saveOtherSymptoms(@RequestBody Othersymptoms otherSymptoms) {
//        log.info("用户{}提交其他症状信息：{}", BaseContext.getCurrentId(), otherSymptoms);
//        dailyhealthstatusService.saveOtherSymptoms(otherSymptoms);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交风险因素和暴露信息")
//    @PostMapping("/risk-factors")
//    public Result saveRiskFactorsAndExposure(@RequestBody Riskfactorsandexposure riskFactorsAndExposure) {
//        log.info("用户{}提交风险因素和暴露信息：{}", BaseContext.getCurrentId(), riskFactorsAndExposure);
//        dailyhealthstatusService.saveRiskFactorsAndExposure(riskFactorsAndExposure);
//        return Result.success();
//    }
}