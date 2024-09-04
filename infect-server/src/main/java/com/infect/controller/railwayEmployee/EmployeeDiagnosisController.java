package com.infect.controller.railwayEmployee;

import com.infect.dto.AllDiagnosisAndResultDTO;
import com.infect.dto.DiagnosisReportsDTO;
import com.infect.entity.*;
import com.infect.result.Result;
import com.infect.service.*;
import com.infect.utils.BaseContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "健康状况，录入诊断信息相关接口")
@RestController
@RequestMapping("/railwayemployee/diagnosis")
public class EmployeeDiagnosisController {

    @Autowired
    private IDiagnosisexaminationsService diagnosisexaminationsService;

    @Autowired
    private IDiagnosispersonalinfoService diagnosispersonalinfoService;

    @Autowired
    private IDiagnosisresultsService diagnosisresultsService;

    @Autowired
    private MyDiagnosisService myDiagnosisService;

    @ApiOperation(value = "铁路工人提交诊断报告文件")
    @PostMapping("/file")
    public Result<Integer> uploadReportFile(@ModelAttribute DiagnosisReportsDTO diagnosisReportsDTO){
//        log.info("用户（铁路工人）{}提交诊断报告文件：{}",BaseContext.getCurrentId(),diagnosisReportsDTO);
        Integer reportId = myDiagnosisService.uploadReportFile(diagnosisReportsDTO);
        return Result.success(reportId);
    }

    @ApiOperation(value = "铁路工人提交诊断结果和所有诊断症状信息")
    @PostMapping("/result")
    public Result saveDiagnosis(@RequestBody AllDiagnosisAndResultDTO allDiagnosisAndResultDTO) {
//        log.info("用户（铁路工人）{}提交诊断结果和所有诊断症状信息：{}",BaseContext.getCurrentId(),allDiagnosisAndResultDTO);
        myDiagnosisService.saveDiagnosis(BaseContext.getCurrentId(),allDiagnosisAndResultDTO);
        return Result.success();
    }

//    @ApiOperation(value = "铁路工人自己提交诊断结果，不可修改")
//    @PostMapping("/result")
//    public Result saveDiagnosisResult(@RequestBody DiagnosisResultsEmpDTO diagnosisResultsEmpDTO) {
//        log.info("用户（铁路工人）{}自己提交诊断结果：{}", BaseContext.getCurrentId(), diagnosisResultsEmpDTO);
//        diagnosisresultsService.saveDiagnosisResult(diagnosisResultsEmpDTO, BaseContext.getCurrentId(), BaseContext.getCurrentId());
//        return Result.success();
//    }

//    @ApiOperation(value = "根据日期查询诊断结果")
//    @GetMapping()
//    public Result<Diagnosisresults> getDiagnosisResult(
//            @ApiParam(value = "查询时间", required = true, example = "2024-08-29")
//            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
//        log.info("用户{}查询{}诊断结果", BaseContext.getCurrentId(), date);
//        Diagnosisresults diagnosisresults = diagnosisresultsService.getDiagnosisResult(date, BaseContext.getCurrentId());
//        return Result.success(diagnosisresults);
//    }

//    @ApiOperation(value = "提交个人基本情况")
//    @PostMapping("/personal")
//    public Result saveDiagnosisPersonal(@RequestBody Diagnosispersonalinfo diagnosispersonalinfo) {
//        log.info("用户{}提交诊断个人基本信息表：{}", BaseContext.getCurrentId(), diagnosispersonalinfo);
//        diagnosispersonalinfoService.saveDiagnosisPersonal(BaseContext.getCurrentId(), diagnosispersonalinfo);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交全身症状信息")
//    @PostMapping("/general-symptoms")
//    public Result saveGeneralSymptoms(@RequestBody Diagnosisgeneralsymptoms generalSymptoms) {
//        log.info("用户{}提交诊断全身症状表：{}", BaseContext.getCurrentId(), generalSymptoms);
//        diagnosispersonalinfoService.saveDiagnosisGeneralSymptoms(BaseContext.getCurrentId(), generalSymptoms);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交呼吸系统症状信息")
//    @PostMapping("/respiratory-symptoms")
//    public Result saveRespiratorySymptoms(@RequestBody Diagnosisrespiratorysymptoms respiratorySymptoms) {
//        log.info("用户{}提交诊断呼吸系统症状表：{}", BaseContext.getCurrentId(), respiratorySymptoms);
//        diagnosispersonalinfoService.saveDiagnosisRespiratorySymptoms(BaseContext.getCurrentId(), respiratorySymptoms);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交消化系统症状信息")
//    @PostMapping("/digestive-symptoms")
//    public Result saveDigestiveSymptoms(@RequestBody Diagnosisdigestivesymptoms digestiveSymptoms) {
//        log.info("用户{}提交诊断消化系统症状表：{}", BaseContext.getCurrentId(), digestiveSymptoms);
//        diagnosispersonalinfoService.saveDiagnosisDigestiveSymptoms(BaseContext.getCurrentId(), digestiveSymptoms);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交循环系统症状信息")
//    @PostMapping("/circulatory-symptoms")
//    public Result saveCirculatorySymptoms(@RequestBody Diagnosiscirculatorysymptoms circulatorySymptoms) {
//        log.info("用户{}提交诊断循环系统症状表：{}", BaseContext.getCurrentId(), circulatorySymptoms);
//        diagnosispersonalinfoService.saveDiagnosisCirculatorySymptoms(BaseContext.getCurrentId(), circulatorySymptoms);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交神经系统症状信息")
//    @PostMapping("/neurological-symptoms")
//    public Result saveNeurologicalSymptoms(@RequestBody Diagnosisneurologicalsymptoms neurologicalSymptoms) {
//        log.info("用户{}提交诊断神经系统症状表：{}", BaseContext.getCurrentId(), neurologicalSymptoms);
//        diagnosispersonalinfoService.saveDiagnosisNeurologicalSymptoms(BaseContext.getCurrentId(), neurologicalSymptoms);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交局部症状信息")
//    @PostMapping("/local-symptoms")
//    public Result saveLocalSymptoms(@RequestBody Diagnosislocalsymptoms localSymptoms) {
//        log.info("用户{}提交诊断局部症状表：{}", BaseContext.getCurrentId(), localSymptoms);
//        diagnosispersonalinfoService.saveDiagnosisLocalSymptoms(BaseContext.getCurrentId(), localSymptoms);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交其他症状信息")
//    @PostMapping("/other-symptoms")
//    public Result saveOtherSymptoms(@RequestBody Diagnosisothersymptoms otherSymptoms) {
//        log.info("用户{}提交诊断其他症状表：{}", BaseContext.getCurrentId(), otherSymptoms);
//        diagnosispersonalinfoService.saveDiagnosisOtherSymptoms(BaseContext.getCurrentId(), otherSymptoms);
//        return Result.success();
//    }
//
//    @ApiOperation(value = "提交并发症信息")
//    @PostMapping("/complications")
//    public Result saveComplications(@RequestBody Diagnosiscomplications complications) {
//        log.info("用户{}提交诊断并发症表：{}", BaseContext.getCurrentId(), complications);
//        diagnosispersonalinfoService.saveDiagnosisComplications(BaseContext.getCurrentId(), complications);
//        return Result.success();
//    }
//    @ApiOperation("提交诊断检查项目表")
//    @PostMapping("/examinations")
//    public Result saveDiagnosisExaminations(@RequestBody Diagnosisexaminations diagnosisexaminations) {
//        log.info("用户{}提交诊断检查项目表:{}", BaseContext.getCurrentId(), diagnosisexaminations);
//
//        diagnosisexaminationsService.saveDiagnosisExaminations(BaseContext.getCurrentId(), diagnosisexaminations);
//        return Result.success();
//    }
//
//    @ApiOperation("提交诊断检查项目文件")
//    @PostMapping("report")
//    public Result saveDiagnosisReports(@RequestBody Diagnosisreports diagnosisreports) {
//        log.info("用户{}提交诊断检查项目文件：{}", BaseContext.getCurrentId(), diagnosisreports);
//        //TODO
//        return Result.success();
//    }
}
