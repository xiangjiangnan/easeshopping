package com.netease.easeshopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.netease.easeshopping.model.wrapper.LoginWrapper;
import com.netease.easeshopping.model.User;
import com.netease.easeshopping.service.CommodityService;
import com.netease.easeshopping.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private CommodityService commodityService;

    /**
     * @return 进入登录页面
     */
    @RequestMapping(path={"/login"}, method = {RequestMethod.GET})
    public String login(){
        return "login/login";
    }

    /**
     * @param username
     * @param password
     * @param session
     * @return 返回到首页
     * 主要实现对用户登录信息的校验，并返回到首页面
     */
    @RequestMapping(path = {"/api/login"}, params = {"username" ,"password"},  method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JSONObject login(HttpServletResponse response, @RequestParam("username") String username,
                 @RequestParam("password") String password, HttpSession session){
        LoginWrapper wrapper = null;
        JSONObject json = new JSONObject();
        wrapper = loginService.login(username, password);
        if(wrapper.getObject() != null){
            session.setAttribute("user", (User)wrapper.getObject());
        }
        json.put("code", wrapper.getCode());
        json.put("result", wrapper.getResult());
        json.put("message", wrapper.getMessage());
        return json;
    }

    /**
     * @param session
     * @return 返回到首页
     * 实现用户的登出
     */
    @RequestMapping(path = {"/logout"}, method = {RequestMethod.GET, RequestMethod.POST})
    public void logout(HttpSession session, HttpServletResponse response) throws IOException {
        response.sendRedirect("/login");
    }
}
