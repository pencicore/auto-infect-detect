package com.infect.controller.railwayEmployee;


import cn.hutool.core.bean.BeanUtil;
import com.infect.dto.DiagnosisResultsEmpDTO;
import com.infect.entity.Diagnosisresults;
import com.infect.enums.DiagnosisResultsEnumConstants;
import com.infect.result.Result;
import com.infect.service.IDiagnosisresultsService;
import com.infect.service.IUserService;
import com.infect.utils.BaseContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Api(tags = "诊断结果相关接口")
@Slf4j
@RestController
@RequestMapping("/railwayemployee/diagnosisresults")
public class EmployeeDiagnosisresultsController {

    @Autowired
    private IDiagnosisresultsService diagnosisresultsService;

    @ApiOperation(value = "铁路工人自己提交诊断结果，不可修改")
    @PostMapping()
    public Result saveDiagnosisResult(@RequestBody DiagnosisResultsEmpDTO diagnosisResultsEmpDTO) {
        log.info("用户（铁路工人）{}自己提交诊断结果：{}", BaseContext.getCurrentId(), diagnosisResultsEmpDTO);
        diagnosisresultsService.saveDiagnosisResult(diagnosisResultsEmpDTO, BaseContext.getCurrentId(), BaseContext.getCurrentId());
        return Result.success();
    }

    @ApiOperation(value = "根据日期查询诊断结果")
    @GetMapping()
    public Result<Diagnosisresults> getDiagnosisResult(
            @ApiParam(value = "查询时间", required = true, example = "2024-08-29")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        log.info("用户{}查询{}诊断结果", BaseContext.getCurrentId(), date);
        Diagnosisresults diagnosisresults = diagnosisresultsService.getDiagnosisResult(date, BaseContext.getCurrentId());
        return Result.success(diagnosisresults);
    }

}
