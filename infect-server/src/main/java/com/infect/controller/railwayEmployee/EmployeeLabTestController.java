package com.infect.controller.railwayEmployee;

import com.infect.dto.LabTestFileDTO;
import com.infect.dto.LabTestReportDTO;
import com.infect.result.Result;
import com.infect.service.MyLabTestService;
import com.infect.utils.BaseContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "健康状况，录入实验信息")
@RestController
@RequestMapping("/railwayemployee/labtest")
public class EmployeeLabTestController {

    @Autowired
    private MyLabTestService labTestService;

    @ApiOperation(value = "铁路工人提交实验文件")
    @PostMapping("/file")
    public Result<Integer> uploadLabTestFile(@ModelAttribute LabTestFileDTO labTestFileDTO){
        Integer labTestId = labTestService.uploadLabTestFile(labTestFileDTO);
        return Result.success(labTestId);
    }

    @ApiOperation(value = "铁路工人提交实验报告文件表")
    @PostMapping("/report")
    public Result saveLabTest(@RequestBody LabTestReportDTO labTestReportDTO){
        return labTestService.saveLabTest(labTestReportDTO, BaseContext.getCurrentId());
    }

    @ApiOperation(value = "铁路工人获取当日的提交报告")
    @PostMapping("/get/report")
    public Result<LabTestReportDTO> getReportFile(
            @ApiParam(value = "查询时间", required = true, example = "2024-08-29")
            @RequestBody String date){
        LabTestReportDTO labTestReportDTO = labTestService.getReportFile(date, BaseContext.getCurrentId());
        System.out.println(labTestReportDTO);
        return Result.success(labTestReportDTO);
    }
}
