package com.infect.interceptor;

import cn.hutool.json.JSONObject;
import com.infect.constants.JwtConstant;
import com.infect.properties.JwtProperties;
import com.infect.utils.BaseContext;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class JwtTokenInterceptor {

    @Autowired
    private JwtProperties jwtProperties;

    public void parseJWT(String token, String[] strings) throws Exception {
        String[] parts = token.split("\\.");
        String payload = new String(Base64.getUrlDecoder().decode(parts[1]));

        // 解析 JSON
        JSONObject claims = new JSONObject(payload);

        // 获取信息
        String userType = claims.get(JwtConstant.USER_TYPE).toString();

        //检验身份
        boolean flag = false;
        for (String s: strings) {
            if (userType.equals(s)) {
                flag = true;
                break;
            }
        }
        if(!flag){
            throw new Exception("身份错误");
        }

        //添加userId信息到该线程上
        BaseContext.setCurrentId(
                Integer.valueOf(claims.get(JwtConstant.USER_ID).toString())
        );

        //校验身份
        String secretKey;
        if(JwtConstant.USER_TYPE_RAILWAY.equals(userType)){
            secretKey = jwtProperties.getRailwayEmployeeSecretKey();
        }
        else if (JwtConstant.USER_TYPE_ADMIN.equals(userType)){
            secretKey = jwtProperties.getAdminSecretKey();
        }
        else if (JwtConstant.USER_TYPE_CDC_STAFF.equals(userType)){
            secretKey = jwtProperties.getCdcStaffSecretKey();
        }
        else if (JwtConstant.USER_TYPE_MEDICAL_STAFF.equals(userType)){
            secretKey = jwtProperties.getMedicalStaffSecretKey();
        }
        else {
            throw new Exception("身份错误");
        }

        System.out.println("用户类型："+userType);
        System.out.println("用户ID："+BaseContext.getCurrentId());

        Jwts.parser().setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token);
    }

}
