package com.netease.easeshopping.utils;

public enum CodeUtil {
    SUCCESS(200, "success"),FAILED(400, "failed") ,ERROR(500, "error"), EXCEPTION(600, "exception");
    private final int code;
    private final String result;
    private CodeUtil(int code, String result){
        this.code = code;
        this.result = result;
    }
    public int getCode(){
        return code;
    }
    public String getResult(){
        return result;
    }
}
