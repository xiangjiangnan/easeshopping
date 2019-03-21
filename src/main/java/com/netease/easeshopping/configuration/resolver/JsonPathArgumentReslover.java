package com.netease.easeshopping.configuration.resolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import org.apache.commons.io.IOUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JsonPathArgumentReslover implements HandlerMethodArgumentResolver {

    private static final String JSON_REQUEST_BODY = "JSON_REQUEST_BODY";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return true;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return JsonPath.read(getRequestBody(webRequest), parameter.getParameterAnnotation(JsonParam.class).value());
    }

    private JSONArray getRequestBody(NativeWebRequest webRequest) {
        HttpServletRequest servletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        String jsonBody = (String) servletRequest.getAttribute(JSON_REQUEST_BODY);
        if (jsonBody == null) {
            try {
                jsonBody = IOUtils.toString(servletRequest.getInputStream(), "utf-8");
                servletRequest.setAttribute(JSON_REQUEST_BODY, jsonBody);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        JSONArray jsonArray = JSON.parseArray(jsonBody);
        return jsonArray;
    }
}
