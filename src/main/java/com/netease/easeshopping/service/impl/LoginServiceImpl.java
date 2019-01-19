package com.netease.easeshopping.service.impl;

import com.netease.easeshopping.dao.UserMapper;
import com.netease.easeshopping.model.User;
import com.netease.easeshopping.service.LoginService;
import com.netease.easeshopping.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> login(String username, String password) throws Exception{
        Map<String, Object> map = new HashMap<>();
        boolean flag = checkInfo(username, password, map);
        if(flag == false){
            return map;
        }
        User user = selectByUsername(username);
        if(user == null){
            map.put("msg", "该用户不存在。");
            return map;
        }
        try {
            if (!(Md5Util.encodeByMd5(password + user.getSalt()).toLowerCase()).equals(user.getPassword())) {
                map.put("msg", "用户密码错误。");
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user.getUsername().equals("buyer") || user.getUsername().equals("seller")) {
            map.put("token", user);
        }else{
            map.put("msg", "不合法的用户");
            return map;
        }
//        String ticket = addLoginTicket(user.getId());
//        map.put("ticket", ticket);
        return map;
    }

    @Override
    public void logout(){

    }

    private User selectByUsername(String username){
        return userMapper.selectByUsername(username);
    }

    private boolean checkInfo(String username, String password, Map<String, Object> map){
        boolean flag = false;
        if (username != null && username.trim().length() > 0) {
            String usernameMatch = "[a-zA-Z0-9_\u4E00-\uFA29]+";
            if (username.matches(usernameMatch)) {
                flag = true;
            } else {
                map.put("username", "用户名含有非法字符");
                flag = false;
            }
        }else{
            map.put("username", "用户名不能为空");
            flag = false;
        }
        if (password != null && password.trim().length()>0) {
            String passwordMatch = "[a-zA-Z0-9]+";
            if(password.matches(passwordMatch)){
                flag = true;
            }else{
                map.put("password", "密码含有非法字符");
                flag = false;
            }
        }else{
            map.put("msgpwd", "密码不能为空");
            flag = false;
        }
        return flag;
    }

//    private String addLoginTicket(int userId) {
//        LoginTicket ticket = loginTicketMapper.selectByPrimaryKey(userId);
//        ticket.setUserId(userId);
//        Date date = new Date();
//        date.setTime(date.getTime() + 1000*3600*24);
//        ticket.setExpired(date);
//        ticket.setStatus(0);
//        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
//        loginTicketMapper.updateByPrimaryKey(ticket);
//        return ticket.getTicket();
//    }
}
