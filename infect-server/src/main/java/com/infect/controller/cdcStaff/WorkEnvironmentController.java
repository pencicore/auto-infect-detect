package com.infect.controller.cdcStaff;

import com.infect.dto.system.EnvironmentPageDTO;
import com.infect.entity.Workenvironmentinfo;
import com.infect.result.PageResult;
import com.infect.result.Result;
import com.infect.service.IWorkenvironmentinfoService;
import com.infect.vo.system.EnvironmentInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "工作环境管理")
@RestController
@RequestMapping("/cdcStaff/workEnvironment")
public class WorkEnvironmentController {

    @Autowired
    private IWorkenvironmentinfoService workenvironmentinfoService;

    @GetMapping("/getWorkInfoById/{workId}")
    @ApiOperation(value = "根据id查询用户某月工作环境基本信息")
    public Result<Workenvironmentinfo> getWorkInfoById(@PathVariable Integer workId){
        Workenvironmentinfo workInfoById = workenvironmentinfoService.getWorkInfoById(workId);
        return Result.success(workInfoById);
    }

//    @PostMapping("/updateWorkInfoById")
//    @ApiOperation(value = "根据id修改用户某月工作环境基本信息")
//    public Result updateWorkInfoById(@RequestBody Workenvironmentinfo workenvironmentinfo){
//        //防止误操作
//        workenvironmentinfo.setUserId(null);
//        workenvironmentinfo.setSubmissionTime(null);
//        workenvironmentinfoService.updateById(workenvironmentinfo);
//        return Result.success();
//    }

    @PostMapping("/pageSelectWorkEnvironment")
    @ApiOperation(value = "根据地点名和时间分页查询用户填写得每月工作环境")
    public Result<PageResult<EnvironmentInfoVO>> pageSelectWorkEnvironment(@RequestBody EnvironmentPageDTO environmentPageDTO){
        PageResult<EnvironmentInfoVO> pageResult = workenvironmentinfoService.pageSelectWorkEnvironment(environmentPageDTO);
        return Result.success(pageResult);
    }

    @GetMapping("/queryAllWorkEnvironmentInfoToExcel")
    @ApiOperation(value = "将环境信息导出为.xlsx文件")
    public void queryAllWorkEnvironmentInfoToExcel(HttpServletResponse response) {
        workenvironmentinfoService.queryAllWorkEnvironmentInfoToExcel(response);
    }

}
