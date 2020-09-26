package com.trade.lq.controller;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * describle :
 * author : huh
 * 2020/8/30 0030
 * 上午 10:50
 */
@RestController
public class MyErrorController implements ErrorController {

    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return null;
    }

    //自定义错误异常消息
    @RequestMapping("/myerror")
    public String error(HttpServletRequest request){
        String massage = errorAttributes.getError(new ServletWebRequest(request)).getMessage().toString();

        return "Error:"+massage;
    }

}
