package com.infect.controller.systemUser;

import com.infect.dto.LabTestReportDTO;
import com.infect.dto.system.DiagnosisPageDTO;
import com.infect.dto.system.UserBaseInfoDTO;
import com.infect.entity.Labtestreport;
import com.infect.entity.User;
import com.infect.entity.armorFusion.LabtestreportWirhFileList;
import com.infect.result.PageResult;
import com.infect.result.Result;
import com.infect.service.ILabtestreportService;
import com.infect.service.IUserService;
import com.infect.service.MyLabTestService;
import com.infect.vo.system.LabTestPageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "检查信息管理")
@RestController
@RequestMapping("/systemUser/labTestManager")
public class LabTestManagerController {

    @Autowired
    private ILabtestreportService labtestreportService;

    @Autowired
    private MyLabTestService labTestService;

    @Autowired
    private IUserService userService;

    @PostMapping("/pageSelectLabTest")
    @ApiOperation(value = "根据用户名，电话，部门，时间分页查询用户检查信息")
    public Result<PageResult<LabTestPageVO>> pageSelectLabTest(@RequestBody DiagnosisPageDTO labTestPageDTO){
        PageResult<LabTestPageVO> pageResult = labtestreportService.pageSelectLabTest(labTestPageDTO);
        return Result.success(pageResult);
    }

    @GetMapping("/selectLabTest/{labTestReportID}")
    @ApiOperation(value = "根据诊断id查询检查信息")
    public Result<LabtestreportWirhFileList> selectLabTest(@PathVariable Integer labTestReportID){
        LabtestreportWirhFileList labtestreportWirhFileList = labtestreportService.selectLabTest(labTestReportID);
        return Result.success(labtestreportWirhFileList);
    }

    @PostMapping("/updateLabTest")
    @ApiOperation(value = "根据id更新检查信息")
    public Result updateLabTest(@RequestBody LabtestreportWirhFileList labtestreportWirhFileList){
        labtestreportService.updateLabTest(labtestreportWirhFileList);
        return Result.success();
    }

    @PostMapping("/getUserByBaseInfo")
    @ApiOperation(value = "根据用户名，性别，联系电话，年龄查找对应用户信息")
    public Result<User> getUserByBaseInfo(@RequestBody UserBaseInfoDTO userBaseInfoDTO){
        User user = userService.getUserByBaseInfo(userBaseInfoDTO);
        if(user == null) {
            return Result.error("信息不够精确");
        }
        return Result.success(user);
    }

    @PostMapping("/saveLabTestReport")
    @ApiOperation("添加检查信息")
    public Result saveLabTestReport(@RequestBody LabTestReportDTO labTestReportDTO, Integer userId){
        labTestService.saveLabTest(labTestReportDTO, userId);
        return Result.success();
    }

    @GetMapping("/getDetectionInformationExportFormExcel")
    @ApiOperation("导出文件：导出检测信息导出表")
    public void getDetectionInformationExportFormExcel(HttpServletResponse response){
        labTestService.getDetectionInformationExportFormExcel(response);
    }

}
