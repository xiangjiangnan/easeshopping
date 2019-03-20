package com.netease.easeshopping.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用于捕捉各个Controller出现的异常
 */
@ControllerAdvice
public class MyControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String errorHandler(Exception e){
        return "您访问的页面出错了(╯^╰〉！";
    }
}
