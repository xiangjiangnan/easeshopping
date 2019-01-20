package com.netease.easeshopping.service;

import java.util.Map;

public interface LoginService {
    Map<String, Object> login(String username, String password) throws Exception;
}
