package com.infect.controller.railwayEmployee;

import cn.hutool.core.bean.BeanUtil;
import com.infect.dto.ChangePasswordDTO;
import com.infect.dto.UserInfoDTO;
import com.infect.entity.User;
import com.infect.entity.Userfeedback;
import com.infect.result.Result;
import com.infect.service.IUserService;
import com.infect.service.IUserfeedbackService;
import com.infect.utils.BaseContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户相关接口")
@Slf4j
@RestController
@RequestMapping("/railwayemployee/user")
public class EmployeeUserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserfeedbackService userfeedbackService;

    @ApiOperation(value = "提交个人信息")
    @PostMapping("/information")
    public Result submitUserProfile(@RequestBody UserInfoDTO userInfoDTO){
        log.info("用户{}提交个人信息：{}", BaseContext.getCurrentId(),userInfoDTO);

        User user= BeanUtil.copyProperties(userInfoDTO,User.class);
        user.setUserId(BaseContext.getCurrentId());
        user.setPhoneNumber(null);

        userService.updateById(user);
        return Result.success();
    }

    @ApiOperation(value = "修改密码")
    @PostMapping("/password")
    public Result changePassword(@RequestBody ChangePasswordDTO changePasswordDTO){
        log.info("用户{}修改密码：{}",BaseContext.getCurrentId(),changePasswordDTO);

        Boolean res = userService.changePassword(changePasswordDTO);

        if(!res){
            return Result.error("密码修改失败");
        }
        return Result.success();
    }

    @ApiOperation(value = "用户提交反馈")
    @PostMapping("submit")
    public Result submitUserFeedback(@RequestBody Userfeedback userfeedback){
        log.info("用户{}提交反馈：{}", BaseContext.getCurrentId(),userfeedback);

        userfeedback.setUserId(BaseContext.getCurrentId());
        userfeedbackService.save(userfeedback);

        return Result.success();
    }


}
