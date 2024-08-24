package com.infect.controller;

import com.infect.entity.User;
import com.infect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(String phoneNumber,String password){
        List<User> list = userService.login(phoneNumber,password);
        if(list==null) return "null";
        return list.get(0).toString();
    }

}
