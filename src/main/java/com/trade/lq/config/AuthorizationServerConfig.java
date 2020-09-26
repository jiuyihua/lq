package com.trade.lq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * describle :
 * author : huh
 * 2020/9/17 0017
 * 上午 11:05
 *  OAuth2授权服务器配置
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    //注入支持password模式
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    //刷新token提供支持
    @Autowired
    UserDetailsService userDetailsService;

    //密码加密
 /*   @Bean
    PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder();
    }
*/
    //配置授权服务器

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("password")//配置password授权模式
        .authorizedGrantTypes("password","refresh_token")//授权模式
        .accessTokenValiditySeconds(1800)//设置access过期时间
        .resourceIds("resourceId")//配置资源id
        .scopes("all").secret(new BCryptPasswordEncoder().encode("123"));//配置密码 $10$PJqCG5Hjv0XUnkNfpsx6IOrQvvxKCC28DMN78qBUwa1F8UhR77lTu

    }

    //令牌储存位置 注入的两个表示支持password模式以及令牌的刷新
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory)).authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }


    //设置支持client_id和client_secret做登录认证
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
    }
}
