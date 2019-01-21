package com.netease.easeshopping.contrloller;

import com.alibaba.fastjson.JSONObject;
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
import java.util.Map;

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
        Map<String, Object> map = null;
        JSONObject json = new JSONObject();
        try {
            map = loginService.login(username, password);
            if(map.containsKey("token")){
                session.setAttribute("user", (User)map.get("token"));
                json.put("code", 200);
                json.put("result", "success");
                json.put("message", "check ok");
                System.out.println("show");
            }else {
                json.put("code", 400);
                json.put("result", "failed");
                json.put("message", map.get("msg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.put("code", 500);
            json.put("result", "failed");
            json.put("message", "exception");
        }
        return json;
    }

    /**
     * @param session
     * @return 返回到首页
     * 实现用户的登出
     */
    @RequestMapping(path = {"/logout"}, method = {RequestMethod.GET, RequestMethod.POST})
    public void logout(HttpSession session, HttpServletResponse response){
        session.setAttribute("user", null);
        try {
            response.sendRedirect("/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
