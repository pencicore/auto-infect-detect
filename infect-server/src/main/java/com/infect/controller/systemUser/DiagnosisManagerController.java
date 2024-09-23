package com.infect.controller.systemUser;

import com.infect.dto.AllDiagnosisAndResultDTO;
import com.infect.dto.system.DiagnosisPageDTO;
import com.infect.dto.system.UserBaseInfoDTO;
import com.infect.entity.*;
import com.infect.entity.armorFusion.AllDiagnosis;
import com.infect.enums.DiagnosisResultsEnumConstants;
import com.infect.result.PageResult;
import com.infect.result.Result;
import com.infect.service.IDiagnosisresultsService;
import com.infect.service.IUserService;
import com.infect.service.MyDiagnosisService;
import com.infect.utils.BaseContext;
import com.infect.vo.system.DiagnosisPageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "诊断信息管理")
@RestController
@RequestMapping("/systemUser/diagnosisManager")
public class DiagnosisManagerController {

    @Autowired
    private MyDiagnosisService diagnosisService;

    @Autowired
    private IDiagnosisresultsService diagnosisresultsService;

    @Autowired
    private IUserService userService;

    @PostMapping("/pageSelectDiagnosis")
    @ApiOperation(value = "根据用户名，电话，部门，时间分页查询用户诊断信息")
    public Result<PageResult<DiagnosisPageVO>> pageSelectDiagnosis(@RequestBody DiagnosisPageDTO diagnosisPageDTO){
        PageResult<DiagnosisPageVO> result = diagnosisresultsService.pageSelectDiagnosis(diagnosisPageDTO);
        return Result.success(result);
    }

    @GetMapping("/selectDiagnosis/{diagnosisResultsID}")
    @ApiOperation(value = "根据诊断id查询诊断信息")
    public Result<AllDiagnosis> selectDiagnosis(@PathVariable Integer diagnosisResultsID){
        AllDiagnosis allDiagnosis = diagnosisService.getAllDiagnosis(diagnosisResultsID);
        return Result.success(allDiagnosis);
    }

    @PostMapping("/updateDiagnosis")
    @ApiOperation(value = "根据id更新诊断信息")
    public Result updateDiagnosis(@RequestBody AllDiagnosis allDiagnosis){
        diagnosisService.updateDiagnosis(allDiagnosis);
        return Result.success();
    }

    @PostMapping("/saveDiagnosis")
    @ApiOperation(value = "添加诊断信息")
    public Result saveDiagnosis(@RequestBody AllDiagnosisAndResultDTO allDiagnosisAndResultDTO){
        diagnosisService.saveDiagnosis(BaseContext.getCurrentId(), allDiagnosisAndResultDTO, DiagnosisResultsEnumConstants.SUBMISSION_USER_TYPE_ADMIN);
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

    @GetMapping("/getExcelClinicalInformationExportForm")
    @ApiOperation(value = "导出文件：导出临床信息导出表")
    public void getExcelClinicalInformationExportForm(HttpServletResponse response){
        diagnosisService.getExcelClinicalInformationExportForm(response);
    }

}
