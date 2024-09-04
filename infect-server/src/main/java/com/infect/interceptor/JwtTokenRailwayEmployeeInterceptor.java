package com.infect.interceptor;

import com.infect.constants.JwtConstant;
import com.infect.properties.JwtProperties;
import com.infect.utils.BaseContext;
import com.infect.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
2023/3/22 06-18
 */

/**
 * jwt令牌校验的拦截器
 */
@Component
//@Slf4j
public class JwtTokenRailwayEmployeeInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 校验jwt
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }

        //1、从请求头中获取令牌
        String token = request.getHeader(jwtProperties.getTokenName());

        //2、校验令牌
        try {
//            log.info("jwt校验:{}", token);
            Claims claims = JwtUtil.parseJWT(jwtProperties.getRailwayEmployeeSecretKey(), token);
            Integer userId = Integer.valueOf(claims.get(JwtConstant.UserId).toString());
//            log.info("当前用户id：{}", userId);

            /*
            2024/3/2 02-05
            将操作者的用户id存入到ThreadLocal中，便于该线程中其他方法来获取该属性
             */
            BaseContext.setCurrentId(userId);
            //3、通过，放行
            return true;
        } catch (Exception ex) {
            //4、不通过，响应401状态码
            response.setStatus(401);
            return false;
        }
    }
}
