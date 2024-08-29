package com.infect.controller.railwayEmployee;


import com.infect.entity.Workenvironmentinfo;
import com.infect.result.Result;
import com.infect.service.IWorkenvironmentinfoService;
import com.infect.utils.BaseContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Api(tags = "铁路工人每月工作环境相关接口")
@Slf4j
@RestController
@RequestMapping("/railwayemployee/environment")
public class EmployeeWorkenvironmentinfoController {

    @Autowired
    private IWorkenvironmentinfoService workenvironmentinfoService;

    @ApiOperation(value = "提交/修改当月工作环境信息")
    @PostMapping()
    public Result saveWorkEnvironmentInfo(@RequestBody Workenvironmentinfo workenvironmentinfo) {
        log.info("用户{}提交当月工作环境信息：{}", BaseContext.getCurrentId(), workenvironmentinfo);
        workenvironmentinfoService.saveWorkEnvironmentInfo(workenvironmentinfo);

        return Result.success();
    }

    @ApiOperation(value = "查询某月工作环境信息")
    @GetMapping()
    public Result<Workenvironmentinfo> getWorkEnvironmentInfo(@ApiParam(value = "年月，格式为yyyy-MM", required = true, example = "2024-08") String yearMonth) {
        log.info("用户{}查询{}的工作环境信息", BaseContext.getCurrentId(), yearMonth);
        Workenvironmentinfo workenvironmentinfo = workenvironmentinfoService.getWorkEnvironmentInfo(BaseContext.getCurrentId(), yearMonth);
        return Result.success(workenvironmentinfo);
    }


}
