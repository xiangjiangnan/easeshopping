package com.netease.easeshopping.configuration.handler;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        JSONObject json = new JSONObject();
        json.put("code", 200);
        json.put("result", "success");
        json.put("message", "登录成功");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(json.toString());
    }
}
