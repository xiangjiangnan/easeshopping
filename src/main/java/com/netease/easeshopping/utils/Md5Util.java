package com.netease.easeshopping.utils;

import java.security.MessageDigest;
import java.util.Map;
import com.alibaba.fastjson.JSONObject;

/**
 * 用于对前端传过来的密码MD5加密，以及返回一些json字符串
 */
public class Md5Util {

    private static String[] hex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

    public static String encodeByMd5(String password) throws Exception{
        MessageDigest md5 = MessageDigest.getInstance("md5");
        byte[] results = md5.digest(password.getBytes());
        return byteArrayToString(results);
    }

    private static String byteArrayToString(byte[] results){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<results.length;i++){
            //将每一位byte转发String
            sb.append(byteToString(results[i]));
        }
        return sb.toString();
    }

    private static String byteToString(byte b){
        int n = b;
        if(n < 0 ){
            n = 256 + n ;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hex[d1] + hex[d2];
    }

    public static JSONObject getJSON(int code, Map<String, Object> map) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            json.put(entry.getKey(), entry.getValue());
        }
        return json;
    }

    public static String getJSONString(int code, String msg) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        return json.toJSONString();
    }

    public static String getJSONString(int code, Map<String, Object> map) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            json.put(entry.getKey(), entry.getValue());
        }
        return json.toJSONString();
    }
}
