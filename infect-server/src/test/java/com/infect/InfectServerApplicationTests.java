package com.infect;

import com.infect.constants.JwtConstant;
import com.infect.mapper.UserMapper;
import com.infect.properties.JwtProperties;
import com.infect.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class InfectServerApplicationTests {

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(jwtProperties);

        Map<String,Object> clain=new HashMap<>();
        clain.put(JwtConstant.UserId,"1");
        String jwt = JwtUtil.createJWT(jwtProperties.getAdminSecretKey(), jwtProperties.getAdminTtl(), clain);

        System.out.println(jwt);

        Claims claims = JwtUtil.parseJWT(jwtProperties.getAdminSecretKey(),jwt);
        System.out.println(claims.get(JwtConstant.UserId));
    }

    @Test
    void UserTest(){

    }

    @Test
    void ExcelTest(){

    }

}
