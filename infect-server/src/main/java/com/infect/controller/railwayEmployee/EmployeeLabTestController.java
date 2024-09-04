package com.infect.controller.railwayEmployee;

import com.infect.dto.LabTestFileDTO;
import com.infect.dto.LabTestReportDTO;
import com.infect.result.Result;
import com.infect.service.ILabtestfilesService;
import com.infect.service.MyLabTestService;
import com.infect.utils.BaseContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
//        log.info("铁路工人上传实验报告文件：{}",labTestFileDTO);
        Integer labTestId = labTestService.uploadLabTestFile(labTestFileDTO);
        return Result.success(labTestId);
    }

    @ApiOperation(value = "铁路工人提交实验报告文件表")
    @PostMapping("/report")
    public Result saveLabTest(@RequestBody LabTestReportDTO labTestReportDTO){
//        log.info("铁路工人上传实验报告表：{}",labTestReportDTO);
        labTestService.saveLabTest(labTestReportDTO, BaseContext.getCurrentId());
        return Result.success();
    }

}
