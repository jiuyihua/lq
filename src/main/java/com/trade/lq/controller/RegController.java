package com.trade.lq.controller;

import com.trade.lq.entity.User;
import com.trade.lq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * describle :
 * author : huh
 * 2020/9/16 0016
 * 下午 5:57
 */
@RestController
public class RegController {
    @Autowired
    UserService userService;

    public User regUser(User user){

        User userDetails = userService.regUser(user);
        return userDetails;
    };


}
