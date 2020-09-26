package com.trade.lq.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
*
 * describle :
 * author : huh
 * 2020/8/30 0030
 * 下午 5:37
 *
 *
*/


@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {
    /**
    *
    *   该方法的作用是判断当前登录用户是否具备请求URL所需要的角色信息，如果不具备，就抛出异常，否则不做任何事情
    *
    *  @params 包含当前用户信息
    *  @params 可以获取当前请求对象
    *  @params FilterInvocationSecurityMetadataSourc中getAttributes的返回值,及当前请求URL的所需要的的角色
    *
    *
    *
    * */


    @Override
    public void decide(Authentication auth,Object object, Collection<ConfigAttribute> ca){
        Collection<? extends GrantedAuthority> auths = auth.getAuthorities();
        for (ConfigAttribute configAttribute : ca) {
            if ("ROLE_LOGIN".equals(configAttribute.getAttribute()) && auth instanceof UsernamePasswordAuthenticationToken) {
                return;
            }
            for (GrantedAuthority authority : auths) {
                //如果当前用户具备当前请求需要的角色，那么方法结束
                if (configAttribute.getAttribute().equals(authority.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
