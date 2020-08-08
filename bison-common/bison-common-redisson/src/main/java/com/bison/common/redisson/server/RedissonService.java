package com.bison.common.redis.service;

import org.redisson.RedissonObject;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Changhai
 * @time: 2020/8/8 0:50
 */
@Service
public class RedissonService {

    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private RedissonObject redissonObject;


    /**
     * 获取列表
     *
     * @param objectName
     * @return
     */
    public <V> RList<V> getRList(String objectName) {
        RList<V> rList = redissonClient.getList(objectName);
        return rList;
    }
}
