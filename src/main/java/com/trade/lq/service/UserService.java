package com.trade.lq.service;

import com.trade.lq.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * describle :
 * author : huh
 * 2020/8/30 0030
 * 下午 3:08
 */
public interface UserService extends UserDetailsService {

    public User getUserByUserName(String userName);

    public User regUser(User user);
}
