package com.netease.easeshopping.configuration;

import com.alibaba.fastjson.JSONObject;
import com.netease.easeshopping.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession session = request.getSession();
        User user = new User();
        user.setUsername(authentication.getName());
        session.setAttribute("user", user);
        response.getWriter().write(json.toString());
    }
}
