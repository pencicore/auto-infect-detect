package com.infect.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.infect.entity.User;

import java.util.List;

public interface UserService extends IService<User> {

    List<User> login(String name, String password);
}
