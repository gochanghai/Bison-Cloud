package com.bison.common.redis.service;

import com.bison.common.core.utils.SpringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @description: 实现相对安全的分布式锁
 * @author: Changhai.liu
 * @date: 2020/8/13 0:40
 */
public class DistributedLocker {

    private static final StringRedisTemplate redisTemplate = SpringUtils.getBean(StringRedisTemplate.class);

    /**
     * 获取锁
     * @return
     */
    public Boolean lock(String key, String val, int time, TimeUnit unit){
        String luaScript = "if redis.call('setnx',KEYS[1],ARGV[1]) == 1 then  return redis.call('expire',KEYS[1],ARGV[2])  else return 0 end";
        RedisScript<String> redisScript = RedisScript.of(luaScript);
        redisTemplate.execute(redisScript, Collections.singletonList(key), Collections.singleton(val));
        return true;
    }

    /**
     * 释放锁
     * @param key
     * @param val
     */
    public void safedUnLock(String key, String val) {
        String luaScript = "local in = ARGV[1] local curr=redis.call('get', KEYS[1]) if in==curr then redis.call('del', KEYS[1]) end return '0";
        RedisScript<String> redisScript = RedisScript.of(luaScript);
        redisTemplate.execute(redisScript, Collections.singletonList(key), Collections.singleton(val));
    }
}
