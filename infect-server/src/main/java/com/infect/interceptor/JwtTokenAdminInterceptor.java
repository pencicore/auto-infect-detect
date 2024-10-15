package com.infect.interceptor;

import com.infect.constants.JwtConstant;
import com.infect.enums.UserEnumConstants;
import com.infect.properties.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtTokenAdminInterceptor extends JwtTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;

    private static final String[] userTypes = {
            JwtConstant.USER_TYPE_ADMIN
    };

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }

        //从请求头中获取令牌
        String token = request.getHeader(jwtProperties.getTokenName());
        if(token.startsWith(UserEnumConstants.TOKEN_PREFIX)){
            token = token.substring(UserEnumConstants.TOKEN_PREFIX.length());
        }

        System.out.println(token);
        try {
            //校验令牌
            this.parseJWT(token, userTypes);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
