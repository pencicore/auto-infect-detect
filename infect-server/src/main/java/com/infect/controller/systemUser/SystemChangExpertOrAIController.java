package com.infect.controller.systemUser;

import com.infect.entity.Systemsettings;
import com.infect.result.Result;
import com.infect.service.ISystemsettingsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Api(tags = "系统管理-专家/AI诊断切换")
@RestController
@RequestMapping("/systemUser/systemChange")
public class SystemChangExpertOrAIController {

    @Autowired
    private ISystemsettingsService systemsettingsService;

    @PutMapping("/{isAI}")
    @ApiOperation(value = "修改诊断方式")
    public Result systemChangExpertOrAI(@PathVariable Boolean isAI){
        System.out.println(isAI);
        systemsettingsService.systemChangExpertOrAI(isAI);
        return Result.success();
    }

}
