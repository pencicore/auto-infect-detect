package com.infect;

import com.infect.constants.JwtConstant;
import com.infect.entity.User;
import com.infect.mapper.UserMapper;
import com.infect.properties.JwtProperties;
import com.infect.utils.ExcelPencilUtil;
import com.infect.utils.ExcelUtil;
import com.infect.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        String projectDir = System.getProperty("user.dir");
        System.out.println("项目根目录: " + projectDir);

        String fileName = projectDir + "\\src\\main\\resources\\templates\\个人信息导出表.xlsx";

        List<User> listUser = userMapper.selectList(null);
        List<List<Object>> listList = new ArrayList<>();

        for (Object obj:
             listUser) {
            List<Object> temp = new ArrayList<>();
            temp.add(obj);
            listList.add(temp);
        }

        ExcelPencilUtil.getExcel(null, "个人信息导出表.xlsx", fileName
                        , 1,1,52
                        ,1,1
                        ,listList);
    }

}
