package com.trade.lq.config;

import com.trade.lq.entity.Resource;
import com.trade.lq.dao.ResourceMapper;
import com.trade.lq.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
*
 * describle :
 * author : huh
 * 2020/8/30 0030
 * 下午 5:37
 *
 *
 *
*/


@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    AntPathMatcher antPathMatcher = new AntPathMatcher();//ant风格的请求URL匹配
    @Autowired
    ResourceMapper menuMapper;

    /**
     *
     * getAttributes()确定此请求需要哪些角色
     *
     * */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<Resource> allMenus = menuMapper.getAllResource();
        for (Resource menu : allMenus) {
            System.out.println("menu.getRoles().size()="+menu.getRoles().size());
            System.out.println("menu.getRoles().getNameZh()="+menu.getRoles().get(0).getNameZh());
            System.out.println("requestUrl="+requestUrl);

            if (antPathMatcher.match(menu.getPattern(), requestUrl)) {
                //List<Role> roles = menu.getRoles();
                System.out.println("menu.getId()="+menu.getId());
                List<Role> roles = menuMapper.getRoleByResource(menu.getId());
                System.out.println("roles.size="+roles.size());
                String[] roleArr = new String[roles.size()];
                for (int i = 0; i < roleArr.length; i++) {
                    roleArr[i] = roles.get(i).getName();
                    System.out.println("roles.getName()="+roles.get(i).getName());
                    System.out.println("roles.getNameZh()="+roles.get(i).getNameZh());
                    System.out.println("roles.getId()="+roles.get(i).getId());
                }
                System.out.println("roleArr.size="+roleArr.length);
                return SecurityConfig.createList(roleArr);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    /*返回所有定义好的权限资源，在spring boot启用的时候回校验相关的匹配是否正确，如果不需要校验返回null*/
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /*返回类对象是否支持校验*/
    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
