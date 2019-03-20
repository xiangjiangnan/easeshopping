package com.netease.easeshopping.service.impl;

import com.netease.easeshopping.dao.UserMapper;
import com.netease.easeshopping.model.LoginWrapper;
import com.netease.easeshopping.model.User;
import com.netease.easeshopping.service.LoginService;
import com.netease.easeshopping.utils.CodeUtil;
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
    public LoginWrapper login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        LoginWrapper wrapper = new LoginWrapper();
        boolean flag = checkInfo(username, password, map);
        if(flag == false){
            wrapper.setCode(CodeUtil.ERROR.getCode());
            wrapper.setResult(CodeUtil.ERROR.getResult());
            wrapper.setMessage((String)map.get("message"));
            return wrapper;
        }
        User user = selectByUsername(username);
        if(user == null){
            wrapper.setCode(CodeUtil.FAILED.getCode());
            wrapper.setResult(CodeUtil.FAILED.getResult());
            wrapper.setMessage("该用户不存在。");
            return wrapper;
        }
        try {
            if (!(Md5Util.encodeByMd5(password).toLowerCase()).equals(user.getPassword())) {
            //if (!(Md5Util.encodeByMd5(password + user.getSalt()).toLowerCase()).equals(user.getPassword())) {
                wrapper.setCode(CodeUtil.FAILED.getCode());
                wrapper.setResult(CodeUtil.FAILED.getResult());
                wrapper.setMessage("用户密码错误。");
                return wrapper;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user.getUsername().equals("buyer") || user.getUsername().equals("seller")) {
            wrapper.setCode(CodeUtil.SUCCESS.getCode());
            wrapper.setResult(CodeUtil.SUCCESS.getResult());
            wrapper.setMessage("登录成功。");
            wrapper.setObject(user);
            map.put("token", user);
        }else{
            wrapper.setCode(CodeUtil.ERROR.getCode());
            wrapper.setResult(CodeUtil.ERROR.getResult());
            wrapper.setMessage("不合法的用户。");
            return wrapper;
        }
//        String ticket = addLoginTicket(user.getId());
//        map.put("ticket", ticket);
        return wrapper;
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
                map.put("message", "用户名含有非法字符");
                flag = false;
            }
        }else{
            map.put("message", "用户名不能为空");
            flag = false;
        }
        if (password != null && password.trim().length()>0) {
            String passwordMatch = "[a-zA-Z0-9]+";
            if(password.matches(passwordMatch)){
                flag = true;
            }else{
                map.put("message", "密码含有非法字符");
                flag = false;
            }
        }else{
            map.put("message", "密码不能为空");
            flag = false;
        }
        return flag;
    }
}
