package com.infect;

import com.infect.constants.JwtConstant;
import com.infect.entity.Diseasescoring;
import com.infect.entity.MockMultipartFile;
import com.infect.entity.User;
import com.infect.mapper.UserMapper;
import com.infect.properties.JwtProperties;
import com.infect.utils.ExcelPencilUtil;
import com.infect.utils.ExcelUtil;
import com.infect.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.infect.utils.ExcelUtil.readExcelFile;

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
//        for (int i = 3; i < 10; i++){
//            User user = new User();
//            user.setIdNumber("11111111111111111" + i);
//            user.setName("张三" + i);
//            user.setPassword("123456789");
//            user.setPhoneNumber(i+i+i+i+i+i+i+i+i+i+i+"");
//            userMapper.insert(user);
//        }
//        String fileName = "传染病初始权重打分表加工.xlsx";
//        // 获取文件输入流
//        InputStream inputStream = ExcelUtil.class.getClassLoader().getResourceAsStream("templates/" + fileName);
//
//        if (inputStream == null) {
//            throw new IllegalArgumentException("File not found: " + fileName);
//        }
//        try {
//            // 将输入流转换为字节数组
//            byte[] bytes = IOUtils.toByteArray(inputStream);
//
//            // 创建一个 MultipartFile 对象
//            MultipartFile multipartFile = new MockMultipartFile(fileName, fileName, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", new ByteArrayInputStream(bytes));
//
//            // 调用 readExcelFile 方法
//            List<List<String>> lists = readExcelFile(multipartFile, 0);
//            System.out.println(lists);
//            System.out.println(lists.get(2).get(3));
//            System.out.println(lists.get(2).get(117));
//        }catch(Exception e){
//                e.printStackTrace();
//        }
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
