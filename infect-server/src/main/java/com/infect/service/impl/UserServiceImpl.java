package com.infect.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.entity.User;
import com.infect.mapper.UserMapper;
import com.infect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> login(String name, String password) {
        if(name==null || password==null) {
            return null;
        }
        return lambdaQuery()
                .eq(User::getPhoneNumber,name)
                .eq(User::getPassword,password)
                .list();
    }
}
