package com.netease.easeshopping.service;

import com.netease.easeshopping.model.wrapper.LoginWrapper;

public interface LoginService {
    LoginWrapper login(String username, String password);
}
