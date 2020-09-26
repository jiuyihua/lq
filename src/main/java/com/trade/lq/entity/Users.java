/*
package com.trade.lq.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

*/
/**
 * describle ;
 * author ; huh
 * 2020/8/17 0017
 * 下午 3;21
 *
 *  @Data 自动给我们生成get set方法
 *  @Component 表示这个类为IOC容器受管的一个对象
 *  @ConfigurationProperties  表示这个类 核心作用：在SB自动加载的时候回扫描resource下面的文件
 *  @ConfigurationProperties(prefix = "user") 如果指定前缀 则绑定获yml中的值或者对象 yml的配置为
 *  user ;
 *    name ;
 *    age ;
 *
 *  1、使用@value  注解进行值绑定   @Value("${user.name}")
 *
 *  @ConfigurationProperties 松散绑定 只需要指定属性参数名的前缀即可松散绑定的bean属性名不需要精确匹配
 *  ru;@ConfigurationProperties(prefix = "user")
 *  yml中可依据使用驼峰
 *  如：userName user_name
 *
 *
 *//*

@Component
@ConfigurationProperties(prefix = "user")
@Data
public class Users {
    //@Value(value = "${user.userName}")
    private String userName;
    //@Value(value = "${user.age}")
    private Integer age;
    private ArrayList tels;
    private Map<String, Object> scores;// private Properties scores
    private List<Mall> malls;



}
*/
