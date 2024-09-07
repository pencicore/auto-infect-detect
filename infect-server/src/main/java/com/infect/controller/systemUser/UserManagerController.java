package com.infect.controller.systemUser;

import cn.hutool.core.bean.BeanUtil;
import com.infect.dto.system.UserInfoDTO;
import com.infect.dto.system.UserPutDTO;
import com.infect.entity.User;
import com.infect.result.Result;
import com.infect.service.IUserService;
import com.infect.vo.system.UserInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "用户管理-系统管理员密码管理")
@RestController
@RequestMapping("/systemuser/password")
public class UserManagerController {

    @Autowired
    private IUserService userService;

    @PostMapping("/addOneUser")
    @ApiOperation(value = "系统管理员添加单个用户")
    public Result saveUserOne(@RequestBody UserPutDTO userPutDTO){
        User user= BeanUtil.copyProperties(userPutDTO,User.class);
        user.setPassword(user.getIdNumber().substring(12));
        userService.save(user);
        return Result.success();
    }

    @GetMapping("/getInfoByUserId/{userId}")
    @ApiOperation(value = "获取用户信息")
    public Result<UserInfoVO> getUserInfo(@PathVariable Integer userId){
        User user = userService.getById(userId);
        UserInfoVO userInfoVO = BeanUtil.copyProperties(user, UserInfoVO.class);
        if(userInfoVO == null) {
            return Result.error("用户id不存在");
        }
        return Result.success(userInfoVO);
    }

    @PostMapping("/updateUserInfo")
    @ApiOperation(value = "修改用户信息")
    public Result updateUserInfo(@RequestBody UserInfoDTO userInfoDTO){
        User user = BeanUtil.copyProperties(userInfoDTO, User.class);
        boolean res = userService.updateById(user);
        if(!res){
            return Result.error("用户id不存在");
        }
        return Result.success();
    }

    @PostMapping("/addManyUser")
    @ApiOperation(value = "根据.xlsx文件批量添加用户")
    public Result addManyUser(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        userService.addManyUser(multipartFile);
        return Result.success();
    }

    @PutMapping("/changeUserActive/{userId}")
    @ApiOperation(value = "切换用户状态")
    public Result changeUserActive(@PathVariable Integer userId){
        userService.changeUserActive(userId);
        return Result.success();
    }

    @PutMapping("/initPassword/{userId}")
    @ApiOperation(value = "初始化密码")
    public Result initPassword(@PathVariable Integer userId){
        userService.initPassword(userId);
        return Result.success();
    }

}
