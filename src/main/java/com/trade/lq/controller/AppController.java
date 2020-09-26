package com.trade.lq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * describle :
 * author : huh
 * 2020/9/17 0017
 * 下午 1:45
 */
@RestController
public class AppController {

    @RequestMapping("/app/helloAndriod")
    public String helloAndriod(){
        return "hello andriod!";
    }

    @RequestMapping("/app/helloIOS")
    public String helloIOS(){
        return "hello IOS!";
    }

}
