package com.netease.easeshopping.configuration.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AuthorizationFailHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {
        JSONObject json = new JSONObject();
        if(e instanceof UsernameNotFoundException){
            json.put("code", 400);
            json.put("result", "failure");
            json.put("message", "用户名错误");
        }else {
        json.put("code", 400);
        json.put("result", "failure");
        json.put("message", "登录失败");
        }
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(json.toString());
    }
}
