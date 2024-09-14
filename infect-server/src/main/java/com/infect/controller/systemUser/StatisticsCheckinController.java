package com.infect.controller.systemUser;

import cn.hutool.core.bean.BeanUtil;
import com.infect.dto.system.CheckinPageDTO;
import com.infect.entity.Dailyhealthstatus;
import com.infect.entity.User;
import com.infect.result.PageResult;
import com.infect.result.Result;
import com.infect.service.IDailyhealthstatusService;
import com.infect.service.IUserService;
import com.infect.vo.system.CheckinInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "统计报表-职工打卡信息")
@RestController
@RequestMapping("/systemUser/statisticsCheckin")
public class StatisticsCheckinController {

    @Autowired
    private IDailyhealthstatusService dailyhealthstatusService;

    @Autowired
    private IUserService userService;

    @GetMapping("pageSelectCheckin")
    @ApiOperation("根据（是否患病，姓名，电话，部门，特殊职业，时间）分页查询用户签到情况")
    public Result<PageResult<CheckinInfoVO>> pageSelectCheckin(CheckinPageDTO checkinPageDTO){
        PageResult<CheckinInfoVO> pageResult = dailyhealthstatusService.pageSelectCheckin(checkinPageDTO);
        return Result.success(pageResult);
    }

    @GetMapping("selectCheckinById/{dailyHealthId}")
    @ApiOperation("根据id获取用户打卡信息")
    public Result<Dailyhealthstatus> selectCheckinById(@PathVariable Integer dailyHealthId){
        return Result.success(dailyhealthstatusService.getById(dailyHealthId));
    }

    @GetMapping("selectCheckinInfoById/{dailyHealthId}")
    @ApiOperation("根据id获取用户打卡位置信息")
    public Result<CheckinInfoVO> selectCheckinInfoById(@PathVariable Integer dailyHealthId){
        CheckinInfoVO checkinInfoVO = new CheckinInfoVO();
        Dailyhealthstatus dailyhealthstatus = dailyhealthstatusService.getById(dailyHealthId);
        User user = userService.getById(dailyhealthstatus.getUserId());
        BeanUtil.copyProperties(user, checkinInfoVO);
        BeanUtil.copyProperties(dailyhealthstatus, checkinInfoVO);
        return Result.success(checkinInfoVO);
    }

    @GetMapping("getEmployeeCheckInExcel")
    @ApiOperation("导出职工打卡信息导出表")
    public void getEmployeeCheckInExcel(HttpServletResponse response){
        dailyhealthstatusService.getEmployeeCheckInExcel(response);
    }

    @GetMapping("getEmployeeCheckInExcelAI")
    @ApiOperation("导出职工打卡信息导出表")
    public void getEmployeeCheckInExcelAI(HttpServletResponse response){
        dailyhealthstatusService.getEmployeeCheckInExcelAI(response);
    }

}
