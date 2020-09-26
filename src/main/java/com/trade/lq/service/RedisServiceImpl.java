package com.trade.lq.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * describle :
 * author : huh
 * 2020/8/17 0017
 * 下午 12:02
 *
 *   @Slf4j日志输出
 */
 @Service
 @Slf4j
public class RedisServiceImpl implements RedisService{

    @Autowired
    private RedisTemplate redisTemplate;

    //ClusterOperations clusterOperations = redisTemplate.opsForCluster();

    public boolean setKey(String key,String value){
        redisTemplate.opsForValue().set(key,value);
        return true;
    }
    public Object getKey(Object key){
        log.info("--------------查询："+key);
        return redisTemplate.opsForValue().get(key);
    }


   /* 注入并使用RedisTemplate或其任何opsForX（）实例…。
    // inject the actual template
    @Autowired
    private RedisTemplate<String, String> template;

    // inject the template as ListOperations
    // can also inject as Value, Set, ZSet, and HashOperations
    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;

    public void addLink(String userId, URL url) {
        listOps.leftPush(userId, url.toExternalForm());
        // or use template directly
        redisTemplate.boundListOps(userId).leftPush(url.toExternalForm());
    }
    */
}
