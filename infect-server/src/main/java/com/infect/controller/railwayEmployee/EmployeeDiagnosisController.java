package com.infect.controller.railwayEmployee;

import com.infect.entity.*;
import com.infect.result.Result;
import com.infect.service.*;
import com.infect.utils.BaseContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "诊断症状相关接口")
@Slf4j
@RestController
@RequestMapping("/railwayemployee/diagnosis")
public class EmployeeDiagnosisController {

    @Autowired
    private IDiagnosispersonalinfoService diagnosispersonalinfoService;

    @ApiOperation(value = "提交个人基本情况")
    @PostMapping("/personal")
    public Result saveDiagnosisPersonal(@RequestBody Diagnosispersonalinfo diagnosispersonalinfo) {
        log.info("用户{}提交诊断个人基本信息表：{}", BaseContext.getCurrentId(), diagnosispersonalinfo);
        diagnosispersonalinfoService.saveDiagnosisPersonal(BaseContext.getCurrentId(), diagnosispersonalinfo);
        return Result.success();
    }

    @ApiOperation(value = "提交全身症状信息")
    @PostMapping("/general-symptoms")
    public Result saveGeneralSymptoms(@RequestBody Diagnosisgeneralsymptoms generalSymptoms) {
        log.info("用户{}提交诊断全身症状表：{}", BaseContext.getCurrentId(), generalSymptoms);
        diagnosispersonalinfoService.saveDiagnosisGeneralSymptoms(BaseContext.getCurrentId(), generalSymptoms);
        return Result.success();
    }

    @ApiOperation(value = "提交呼吸系统症状信息")
    @PostMapping("/respiratory-symptoms")
    public Result saveRespiratorySymptoms(@RequestBody Diagnosisrespiratorysymptoms respiratorySymptoms) {
        log.info("用户{}提交诊断呼吸系统症状表：{}", BaseContext.getCurrentId(), respiratorySymptoms);
        diagnosispersonalinfoService.saveDiagnosisRespiratorySymptoms(BaseContext.getCurrentId(), respiratorySymptoms);
        return Result.success();
    }

    @ApiOperation(value = "提交消化系统症状信息")
    @PostMapping("/digestive-symptoms")
    public Result saveDigestiveSymptoms(@RequestBody Diagnosisdigestivesymptoms digestiveSymptoms) {
        log.info("用户{}提交诊断消化系统症状表：{}", BaseContext.getCurrentId(), digestiveSymptoms);
        diagnosispersonalinfoService.saveDiagnosisDigestiveSymptoms(BaseContext.getCurrentId(), digestiveSymptoms);
        return Result.success();
    }

    @ApiOperation(value = "提交循环系统症状信息")
    @PostMapping("/circulatory-symptoms")
    public Result saveCirculatorySymptoms(@RequestBody Diagnosiscirculatorysymptoms circulatorySymptoms) {
        log.info("用户{}提交诊断循环系统症状表：{}", BaseContext.getCurrentId(), circulatorySymptoms);
        diagnosispersonalinfoService.saveDiagnosisCirculatorySymptoms(BaseContext.getCurrentId(), circulatorySymptoms);
        return Result.success();
    }

    @ApiOperation(value = "提交神经系统症状信息")
    @PostMapping("/neurological-symptoms")
    public Result saveNeurologicalSymptoms(@RequestBody Diagnosisneurologicalsymptoms neurologicalSymptoms) {
        log.info("用户{}提交诊断神经系统症状表：{}", BaseContext.getCurrentId(), neurologicalSymptoms);
        diagnosispersonalinfoService.saveDiagnosisNeurologicalSymptoms(BaseContext.getCurrentId(), neurologicalSymptoms);
        return Result.success();
    }

    @ApiOperation(value = "提交局部症状信息")
    @PostMapping("/local-symptoms")
    public Result saveLocalSymptoms(@RequestBody Diagnosislocalsymptoms localSymptoms) {
        log.info("用户{}提交诊断局部症状表：{}", BaseContext.getCurrentId(), localSymptoms);
        diagnosispersonalinfoService.saveDiagnosisLocalSymptoms(BaseContext.getCurrentId(), localSymptoms);
        return Result.success();
    }

    @ApiOperation(value = "提交其他症状信息")
    @PostMapping("/other-symptoms")
    public Result saveOtherSymptoms(@RequestBody Diagnosisothersymptoms otherSymptoms) {
        log.info("用户{}提交诊断其他症状表：{}", BaseContext.getCurrentId(), otherSymptoms);
        diagnosispersonalinfoService.saveDiagnosisOtherSymptoms(BaseContext.getCurrentId(), otherSymptoms);
        return Result.success();
    }

    @ApiOperation(value = "提交并发症信息")
    @PostMapping("/complications")
    public Result saveComplications(@RequestBody Diagnosiscomplications complications) {
        log.info("用户{}提交诊断并发症表：{}", BaseContext.getCurrentId(), complications);
        diagnosispersonalinfoService.saveDiagnosisComplications(BaseContext.getCurrentId(), complications);
        return Result.success();
    }
}
