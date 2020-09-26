/*
package com.trade.lq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

*/
/**
 * describle :
 * author : huh
 * 2020/8/29 0029
 * 上午 11:44
 *//*

@Configuration
//该注解用于读取配置文件中的属性
@ConfigurationProperties("spring.redis.cluster")
@Data
public class RedisConfig {

    */
/*List<Integer> ports;
    String host;

    JedisPoolConfig jedispoolConfig;

    @Bean
    RedisClusterConfiguration redisClusterConfiguration(){
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        List<RedisNode> nodes = new ArrayList<>();
        RedisClusterNode redisNode = new RedisClusterNode();
        for (Integer port :ports) {
            nodes.add(new RedisNode(host,port));
        }
        redisClusterConfiguration.setPassword(RedisPassword.of(""));
        redisClusterConfiguration.setClusterNodes(nodes);
        return redisClusterConfiguration;
    }*//*


    private String nodes;

    JedisPoolConfig poolConfig;


    @Bean
    public Set<RedisNode> getNodes(){
        System.out.println("nodes="+nodes);
        //获取redis集群的ip及端口号等相关信息；
        String[] serverArray = nodes.split(",");
        System.out.println("nodes serverArray="+serverArray);
        Set<RedisNode> nodes = new HashSet<>();

        //遍历add到HostAndPort中；
        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            System.out.println("ip="+ipPortPair[0].trim()+"&&"+"port="+ipPortPair[1].trim());
            nodes.add(new RedisNode(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
        return nodes;
    }

    @Bean
    RedisClusterConfiguration redisClusterConfiguration(){
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        redisClusterConfiguration.setPassword(RedisPassword.of(""));
        redisClusterConfiguration.setClusterNodes(getNodes());
        return redisClusterConfiguration;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration(),poolConfig);
        return jedisConnectionFactory;
    }
    @Bean
    RedisTemplate redisTemplate(){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        //必须序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        return redisTemplate;
    }

    @Bean
    StringRedisTemplate stringRedisTemplate(){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory());
        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
        stringRedisTemplate.setValueSerializer(new StringRedisSerializer());
        return  stringRedisTemplate;
    }




}
*/
