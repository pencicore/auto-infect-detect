package com.infect.controller.common;


import cn.hutool.core.bean.BeanUtil;
import com.infect.dto.UserRegisterDTO;
import com.infect.entity.User;
import com.infect.result.Result;
import com.infect.service.IUserService;
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
@Api(tags = "员工相关接口")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "员工注册")
    @PostMapping("/register")
    public Result register(@RequestBody UserRegisterDTO userRegisterDTO){
        log.info("用户注册：{}",userRegisterDTO);
        if(userRegisterDTO.getIsActived() == null){
            userRegisterDTO.setIsActived(false);
        }
        User user = BeanUtil.copyProperties(userRegisterDTO, User.class);
        log.info(user.toString());
        userService.save(user);
        return Result.success();
    }

}
