package com.infect.controller.common;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.FileUtil;
import com.infect.dto.UserLoginDTO;
import com.infect.dto.UserRegisterDTO;
import com.infect.entity.User;
import com.infect.result.Result;
import com.infect.service.IUserService;
import com.infect.utils.ExcelUtil;
import com.infect.utils.GlobalExceptionHandler;
import com.infect.utils.TokenBucketLimiter;
import com.infect.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
public class UserController {

    @Autowired
    private IUserService userService;

//    private final TokenBucketLimiter limiter;
//    private final GlobalExceptionHandler globalExceptionHandler;
//
//    public UserController(TokenBucketLimiter limiter, GlobalExceptionHandler globalExceptionHandler) {
//        this.limiter = limiter;
//        this.globalExceptionHandler = globalExceptionHandler;
//    }

    @ApiOperation(value = "员工注册")
    @PostMapping("/register")
    public Result register(@RequestBody UserRegisterDTO userRegisterDTO){
//        log.info("用户注册：{}",userRegisterDTO);
        if(userRegisterDTO.getIsActived() == null){
            userRegisterDTO.setIsActived(false);
        }
        User user = BeanUtil.copyProperties(userRegisterDTO, User.class);
        userService.save(user);
        return Result.success();
    }

    @ApiOperation(value = "员工登录")
    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){


//        try {
//            globalExceptionHandler.checkRateLimit(3, 1); // 每次请求消耗 1 个令牌
            UserLoginVO userLoginVO = userService.login(userLoginDTO);
            if (userLoginVO == null){
                return Result.error("用户名或密码错误");
            }
            return Result.success(userLoginVO);
//        } catch (Exception e) {
//            throw new RuntimeException("Rate limit exceeded");
//        }

    }
}
