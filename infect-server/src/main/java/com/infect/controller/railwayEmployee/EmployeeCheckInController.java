package com.infect.controller.railwayEmployee;

import com.infect.dto.AllSymptomsDTO;
import com.infect.dto.RailwayEmployeeCheckInDTO;
import com.infect.entity.Diseasescoring;
import com.infect.entity.Workenvironmentinfo;
import com.infect.result.Result;
import com.infect.service.IDailyhealthstatusService;
import com.infect.service.IWorkenvironmentinfoService;
import com.infect.utils.BaseContext;
import com.infect.vo.DailyhealthstatusGetVO;
import com.infect.vo.MonthlyHealthStatusVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Api(tags = "打卡和监控功能相关接口")
//@Slf4j
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
        dailyhealthstatusService.userCheckIn(railwayEmployeeCheckInDTO);
        return Result.success();
    }

    @ApiOperation(value = "根据id和日期查询铁路工人今日打卡情况")
    @GetMapping("/select/daily")
    public Result<DailyhealthstatusGetVO> getDailyCheckIn(
            @ApiParam(value = "查询时间", required = true, example = "2024-08-29")
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String date){
        // 创建 DateTimeFormatter 对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 解析字符串并转换为 LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        DailyhealthstatusGetVO dailyhealthstatusGetVO = dailyhealthstatusService.getDailyCheckIn(localDate);
        return Result.success(dailyhealthstatusGetVO);
    }

    @ApiOperation(value = "根据id和year和month查询工人本月的打卡情况")
    @PostMapping("/select/month")
    public Result<List<MonthlyHealthStatusVO>> getMonthCheckIn(
            @ApiParam(value = "查询时间", required = true, example = "2024-08")
            @RequestBody String yearMonth) {
        List<MonthlyHealthStatusVO> ClearHealthCostsGetVO = dailyhealthstatusService.getWorkEnvironmentInfo(BaseContext.getCurrentId(),yearMonth);
        List<MonthlyHealthStatusVO> NewClearHealthCostsGetVO= dailyhealthstatusService.getDiagnoseInfo(yearMonth,BaseContext.getCurrentId(),ClearHealthCostsGetVO);
        List<MonthlyHealthStatusVO> FinalHealthCostsGetVO = dailyhealthstatusService.getExamineInfo(BaseContext.getCurrentId(),yearMonth,NewClearHealthCostsGetVO);
        return Result.success(FinalHealthCostsGetVO);
    }

    @ApiOperation(value = "提交/修改当月工作环境信息")
    @PostMapping("/month")
    public Result saveWorkEnvironmentInfo(@RequestBody Workenvironmentinfo workenvironmentinfo) {
        workenvironmentinfoService.saveWorkEnvironmentInfo(workenvironmentinfo);
        return Result.success();
    }

    @ApiOperation(value = "更新当月工作环境信息")
    @PostMapping("/update/month")
    public Result updateWorkEnvironmentInfo(@RequestBody Workenvironmentinfo workenvironmentinfo) {
        workenvironmentinfoService.updateWorkEnvironmentInfo(workenvironmentinfo);
        return Result.success();
    }

    @ApiOperation(value = "获取当月工作环境信息")
    @PostMapping("/environment/info")
    public Result saveRiskFactorsAndExposure(@ApiParam(value = "查询时间", required = true, example = "2024-08")
                                                 @RequestBody String date) {
        Workenvironmentinfo workenvironmentinfo = workenvironmentinfoService.getEnvironmentInfo(BaseContext.getCurrentId(),date);
        return Result.success(workenvironmentinfo);
    }

    @ApiOperation(value = "一次性提交所有症状信息")
    @PostMapping("/all")
    public Result saveAllSymptoms(@RequestBody AllSymptomsDTO allSymptomsDTO){
        List<Diseasescoring> diseasescoringList = dailyhealthstatusService.saveAllSymptoms(allSymptomsDTO);
        return Result.success(diseasescoringList);
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
