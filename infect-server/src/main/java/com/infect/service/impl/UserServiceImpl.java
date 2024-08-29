package com.infect.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.infect.constants.JwtConstant;
import com.infect.dto.ChangePasswordDTO;
import com.infect.dto.UserLoginDTO;
import com.infect.entity.User;
import com.infect.enums.UserEnumConstants;
import com.infect.mapper.UserMapper;
import com.infect.properties.JwtProperties;
import com.infect.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.utils.BaseContext;
import com.infect.utils.JwtUtil;
import com.infect.vo.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) {
        //根据用户手机号码和密码查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .eq(User::getPhoneNumber, userLoginDTO.getPhoneNumber())
                .eq(User::getPassword,userLoginDTO.getPassword());
        User user = userMapper.selectOne(queryWrapper);

        //判断手机号码和密码是否正确,不正确直接返回null
        if(user==null){
            return null;
        }

        //判断账户是否可以使用，不能使用返回null
        if(!user.getIsActived()){
            return null;
        }

        //创建UserLoginVO对象，设置属性值
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setUser(user);

        //通过身份证号判断用户是否填写个人信息
        if(user.getIdNumber()=="" || user.getIdNumber()==null) {
            userLoginVO.setInformationComplete(false);
        }
        else {
            userLoginVO.setInformationComplete(true);
        }

        //根据不同身份，生成jwt
        String secretKey="";
        Long ttl=0L;
        if(user.getUserType().equals(UserEnumConstants.USER_TYPE_RAILWAY_EMPLOYEE)){
            //铁路工人
            secretKey= jwtProperties.getRailwayEmployeeSecretKey();
            ttl=jwtProperties.getRailwayEmployeeTtl();
        }
        else if(user.getUserType().equals(UserEnumConstants.USER_TYPE_ADMIN)){
            //系统管理员
            secretKey=jwtProperties.getAdminSecretKey();
            ttl=jwtProperties.getAdminTtl();
        }
        else if(user.getUserType().equals(UserEnumConstants.USER_TYPE_CDC_STAFF)){
            //疾控中心工作人员
            secretKey=jwtProperties.getCdcStaffSecretKey();
            ttl=jwtProperties.getCdcStaffTtl();
        }
        else if(user.getUserType().equals(UserEnumConstants.USER_TYPE_MEDICAL_STAFF)){
            //专职医护人员
            secretKey=jwtProperties.getMedicalStaffSecretKey();
            ttl=jwtProperties.getMedicalStaffTtl();
        }
        else {
            return null;
        }

        Map<String,Object> map=new HashMap();
        map.put(JwtConstant.UserId,user.getUserId().toString());
        String jwt= JwtUtil.createJWT(secretKey,ttl,map);
        userLoginVO.setToken(jwt);

        //将密码设置为空
        userLoginVO.getUser().setPassword("hello");

        return userLoginVO;
    }

    @Override
    public boolean changePassword(ChangePasswordDTO changePasswordDTO) {
        //检查原密码是否正确
        LambdaQueryWrapper<User> wrapper=new LambdaQueryWrapper<User>()
                .eq(User::getUserId, BaseContext.getCurrentId())
                .eq(User::getPassword, changePasswordDTO.getOldPassword());
        Long count=userMapper.selectCount(wrapper);
        if(count==0) {
            return false;
        }

        //修改密码为新密码
        User user=new User();
        user.setUserId(BaseContext.getCurrentId());
        user.setPassword(changePasswordDTO.getNewPassword());
        userMapper.updateById(user);

        return true;
    }
}
