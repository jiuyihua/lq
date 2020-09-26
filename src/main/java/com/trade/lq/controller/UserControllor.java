package com.trade.lq.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * describle :
 * author : huh
 * 2020/8/29 0029
 * 上午 9:08
 */
@Controller
public class UserControllor {

    @PostMapping(value = "/regist")
    public String userRegist(){
        return  "注册成功！";
    }
     /*想session中存储数,这里的port主要是区分是哪个服务器提供的服务（分布式集群服务器）
     此时的sesion已经存入redis服务器上了*/
    @Value("${server.port}")
    String port;
    /*@PostMapping("/login")
    public String userLogin(String name , HttpSession session){
        System.out.println("sesionId:"+session.getId());
        session.setAttribute("name",name);
        return port;
    }
*/
    @RequestMapping(value = "/login_page",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @GetMapping("/getUser")
    public String gerUser(HttpSession session){
        System.out.println("sesionId:"+session.getId());
        return port+": user :"+session.getAttribute("name").toString();
    }

}
