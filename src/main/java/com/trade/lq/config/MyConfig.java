package com.trade.lq.config;

import com.trade.lq.filter.MyFilter;
import com.trade.lq.interceptor.LoginInterceptor;
import com.trade.lq.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * describle :
 * author : huh
 * 2020/8/19 0019
 * 下午 2:25
 */
@Configuration // 另一种方式 @ServletComponentScan("com.trade.lq")
// 用于扫描servlet组件的一个注解 扫描带有@Webfilter @WebServlet 注解的类名 缺点：不能确定过滤器的顺序
public class MyConfig  implements WebMvcConfigurer {

    @Autowired
    RedisService redisService;
    //springMvc方法
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {

    }*/

    //RegistrationBean可以动态注册servlet组件
    //FilterRegistrationBean 用于动态注册Filter
    //ServletRegistrationBean 用于动态注册servlet
    //ServletListenerRegistrationBean 用于动态注册监听器
    @Bean
    public FilterRegistrationBean myFilter(){

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //装配过滤器
        filterRegistrationBean.setFilter(new MyFilter());
        //设置过滤器名称
        filterRegistrationBean.setName("myFilter");
        //映射的URL 表示那些请求需要过滤
        filterRegistrationBean.addUrlPatterns("/*");
        //设置过滤器饿有限级别数值越小级别越高
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*");
    }



}
