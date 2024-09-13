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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Api(tags = "用户相关接口")
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
//        log.info("用户{}提交个人信息：{}", BaseContext.getCurrentId(),userInfoDTO);
        User user= BeanUtil.copyProperties(userInfoDTO,User.class);
        user.setUserId(BaseContext.getCurrentId());
        user.setPhoneNumber(null);
        userService.updateById(user);
        return Result.success();
    }

    @ApiOperation(value = "修改密码")
    @PostMapping("/password")
    public Result changePassword(@RequestBody ChangePasswordDTO changePasswordDTO){
        Boolean res = userService.changePassword(changePasswordDTO);
        if(!res){
            return Result.error("密码修改失败");
        }
        return Result.success();
    }

    @ApiOperation(value = "用户提交反馈")
    @PostMapping("submit")
    public Result submitUserFeedback(@RequestBody Userfeedback userfeedback){
        User user = userService.getById(BaseContext.getCurrentId());
        if (user == null){
            return Result.error("用户不存在");
        }
        userfeedback.setUserId(user.getUserId());
        userfeedback.setName(user.getName());
        userfeedback.setPhoneNumber(user.getPhoneNumber());
        userfeedback.setFeedbackDate(LocalDateTime.now());
        userfeedbackService.save(userfeedback);

        return Result.success();
    }


}
