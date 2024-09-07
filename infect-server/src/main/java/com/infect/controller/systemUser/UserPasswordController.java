package com.infect.controller.systemUser;

import com.infect.dto.ChangePasswordDTO;
import com.infect.result.Result;
import com.infect.service.IUserService;
import com.infect.utils.BaseContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户管理-系统管理员密码管理")
@RestController
@RequestMapping("/systemuser/password")
public class UserPasswordController {

    private IUserService userService;

    @ApiOperation(value = "系统管理员修改密码")
    @PostMapping("/change")
    public Result changePassword(@RequestBody ChangePasswordDTO changePasswordDTO){
        Boolean res = userService.changePassword(changePasswordDTO);
        if(res) {
            return Result.success();
        }
        else {
            return Result.error("原密码错误");
        }
    }

}
