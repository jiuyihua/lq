package com.trade.lq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * describle :
 * author : huh
 * 2020/8/30 0030
 * 上午 11:03
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "0";
    }
}
