package com.trade.lq.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * describle :
 * author : huh
 * 2020/8/21 0021
 * 上午 9:47
 */
public abstract class JClusterCaseBase {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;




}
