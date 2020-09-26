package com.trade.lq.service.impl;

import com.trade.lq.dao.UserMapper;
import com.trade.lq.entity.User;
import com.trade.lq.service.RedisService;
import com.trade.lq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * describle :
 * author : huh
 * 2020/8/18 0018
 * 下午 7:36
 */
@Service
public class UserServiceImpl implements UserService {

    RedisService redisService;

    @Autowired
    UserMapper userMapper;
    public User Sel(int id){
        return userMapper.Sel(id);
    }


    private static final String USER_SESSION_ID = "USER_SESSION_";
    private static final int USER_SESSION_SECONDES = 10*3600;

      /**
       *
       * 实现了UserDetailsService接口，并实现了loadUserByUsername()方法，username为用户登录时输入的用户名
       * 查到用户就由系统的DaoAuthenticationProvider类去比对密码是否正确
       * loadUserByUsername在用户登录时自动调用
       */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("UserServiceImpl > loadUserByUsername(String username) >username="+username);
        User user = getUserByUserName(username);
        user.setRoles(userMapper.getUserRolesByUid(user.getId()));
        return user;
    }

    @Override
    public User getUserByUserName(String userName) {
        User user = userMapper.getUserByUserName(userName);
        if (user == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        return user;
    }

    @Override
    public User regUser(User user) {
        String passEncoder = new BCryptPasswordEncoder(10).encode(user.getPassWord()).toString();
        user.setPassWord(passEncoder);
        System.out.println("passEncoder="+passEncoder);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name",user.getUserName());
        map.put("passWord",user.getPassWord());
        map.put("realName",user.getRealName());
        map.put("enabled",user.getEnable());
        map.put("locked",user.getLocked());
        if(userMapper.regUser(map)){
            return user;
        }
        System.out.println("用户注册失败");
        return null;
    }

/*

    public String generatorCacheKey(String sessionId){
        return USER_SESSION_CACHE_PRE+sessionId;
    }

    public Session getSession(String sessionId){
        String key = generatorCacheKey(sessionId);
        return JedisUtils.getObject(key, Session.class);
    }

    public void setSession(String sessionId,Session session){
        String key = generatorCacheKey(sessionId);
        JedisUtils.setObject(key, session);
        JedisUtils.expireKey(key, SESSION_EXPERI_SECONDS);
    }

    public void delSession(String sessionId){
        String key = generatorCacheKey(sessionId);
        JedisUtils.delete(key);
    }
*/



}
