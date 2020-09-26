package com.trade.lq.config;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * describle :
 * author : huh
 * 2020/9/17 0017
 * 下午 1:26
 */
public class WebCommConfig extends WebSecurityConfigurerAdapter {

  /*  @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_dba    >   ROLE_admin   >   ROLE_user";
        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }
*/
}
