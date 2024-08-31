package com.infect.controller.railwayEmployee;


import com.infect.entity.Diagnosisexaminations;
import com.infect.entity.Diagnosisreports;
import com.infect.result.Result;
import com.infect.service.IDiagnosisexaminationsService;
import com.infect.utils.BaseContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Api(tags = "诊断检查项目相关接口")
@Slf4j
@RestController
@RequestMapping("/railwayemployee/diagnosisexaminations")
public class EmployeeDiagnosisexaminationsController {

    @Autowired
    private IDiagnosisexaminationsService diagnosisexaminationsService;

    @ApiOperation("提交诊断检查项目表")
    @PostMapping("/examinations")
    public Result saveDiagnosisExaminations(@RequestBody Diagnosisexaminations diagnosisexaminations) {
        log.info("用户{}提交诊断检查项目表:{}", BaseContext.getCurrentId(), diagnosisexaminations);

        diagnosisexaminationsService.saveDiagnosisExaminations(BaseContext.getCurrentId(), diagnosisexaminations);
        return Result.success();
    }

    @ApiOperation("提交诊断检查项目文件")
    @PostMapping("report")
    public Result saveDiagnosisReports(@RequestBody Diagnosisreports diagnosisreports) {
        log.info("用户{}提交诊断检查项目文件：{}", BaseContext.getCurrentId(), diagnosisreports);
        //TODO
        return Result.success();
    }

}
