package com.trade.lq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication//(exclude = {ShiroAnnotationProcessorAutoConfiguration.class, ShiroAutoConfiguration.class, ShiroBeanAutoConfiguration.class}) //(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}) //复合注解

@MapperScan("com.trade.lq.dao")
public class LqApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LqApplication.class, args);
       /* RedisServiceImpl redisServiceImpl = context.getBean("redisServiceImpl", RedisServiceImpl.class);
        System.out.println(redisServiceImpl.setKey("name","lq"));
        System.out.println("------------------------");
        System.out.println("------------------------");
        System.out.println("------------------------");
        System.out.println("------------------------");
        System.out.println("------------------------");
        System.out.println(redisServiceImpl.getKey("name"));*/



    }

}
