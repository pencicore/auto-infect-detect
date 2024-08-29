package com.infect.controller.railwayEmployee;


import com.infect.entity.Userfeedback;
import com.infect.result.Result;
import com.infect.service.IUserfeedbackService;
import com.infect.utils.BaseContext;
import io.swagger.annotations.Api;
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
@Api(tags = "用户反馈相关接口")
@Slf4j
@RestController
@RequestMapping("/railwayemployee/feedback")
public class EmployeeUserfeedbackController {

    @Autowired
    private IUserfeedbackService userfeedbackService;

    @ApiOperation(value = "用户提交反馈")
    @PostMapping("submit")
    public Result submitUserFeedback(@RequestBody Userfeedback userfeedback){
        log.info("用户{}提交反馈：{}", BaseContext.getCurrentId(),userfeedback);

        userfeedback.setUserId(BaseContext.getCurrentId());
        userfeedbackService.save(userfeedback);

        return Result.success();
    }

}
