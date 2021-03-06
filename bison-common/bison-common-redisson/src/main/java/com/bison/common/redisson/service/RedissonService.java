package com.bison.common.redisson.service;

import org.apache.poi.ss.formula.functions.T;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Changhai
 * @time: 2020/8/8 0:50
 */
@Service
public class RedissonService {

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 保存
     * @param key 键
     * @param value 值
     * @param time 有效期
     */
    public void set(String key, Object value, long time) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.set(value, time, TimeUnit.SECONDS);
    }

    /**
     * 保存
     * @param key 键
     * @param value 值
     */
    public void set(String key, Object value) {
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.set(value);
    }

    /**
     * 获取 value
     *
     * @param key 键
     * @return
     */
    public Object get(String key) {
        return redissonClient.getBucket(key).get();
    }


    /**
     * 获取列表 list
     *
     * @param key
     * @return
     */
    public List<T> getRList(String key) {
        RList<T> rList = redissonClient.getList(key);
        return rList;
    }

    /**
     * 保存list
     *
     * @param key
     * @return
     */
    public void setRList(String key, List<T> list) {
        RList<Object> rList = redissonClient.getList(key);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            rList.add(it.next());
        }
    }

    /**
     * 保存list
     *
     * @param key
     * @return
     */
    public void setRList(String key, List<T> list, long time) {
        RList<Object> rList = redissonClient.getList(key);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            rList.add(it.next());
        }
        rList.expire(time, TimeUnit.SECONDS);
    }


    /**
     * 获取set列表
     *
     * @param key
     * @return
     */
    public Set<T> getRSet(String key) {
        RSet<T> rSet = redissonClient.getSet(key);
        return rSet;
    }

    /**
     * 保存set
     *
     * @param key
     * @return
     */
    public void setRSet(String key, Set<T> sets) {
        RSet<T> rSet = redissonClient.getSet(key);
        Iterator<T> it = sets.iterator();
        while (it.hasNext()) {
            rSet.add(it.next());
        }
    }

    /**
     * 保存set
     *
     * @param key
     * @return
     */
    public void setRSet(String key, Set<T> sets, long time) {
        RSet<T> rSet = redissonClient.getSet(key);
        Iterator<T> it = sets.iterator();
        while (it.hasNext()) {
            rSet.add(it.next());
        }
        rSet.expire(time, TimeUnit.SECONDS);
    }



    /**
     * 获取sSet列表
     *
     * @param key
     * @return
     */
    public SortedSet<T> getSortedSet(String key) {
        RSortedSet<T> rSortedSet = redissonClient.getSortedSet(key);
        return rSortedSet;
    }

    /**
     * 保存sSet
     *
     * @param key
     * @return
     */
    public void setSortedSet(String key, Set<T> sets) {
        RSortedSet<T> rSortedSet = redissonClient.getSortedSet(key);
        Iterator<T> it = sets.iterator();
        while (it.hasNext()) {
            rSortedSet.add(it.next());
        }
    }


    /**
     *
     * @param key
     * @param hashKey
     * @return
     */
    Object hGet(String key, String hashKey){
        return redissonClient.getMap(key).get(hashKey);
    }

    /**
     *
     * @param key
     * @param dataMap
     */
    public void hSetAll(String key, Map<String, T> dataMap) {
        RMap<String, T> rMap = redissonClient.getMap(key);
        rMap.putAll(dataMap);
    }

    /**
     *
     * @param key
     * @param dataMap
     * @param time
     */
    public void hSetAll(String key, Map<String, T> dataMap, long time) {
        RMap<String, T> rMap = redissonClient.getMap(key);
        rMap.putAll(dataMap);
        rMap.expire(time, TimeUnit.SECONDS);
    }


    /**
     * 保存布隆过滤器
     *
     * @param key
     * @return
     */
    public void setBloomFilter(String key, T value) {
        RBloomFilter bloomFilter = redissonClient.getBloomFilter(key);
        bloomFilter.add(value);
    }

    /**
     * 值是否存在
     *
     * @param key
     * @return
     */
    public Boolean getBloomFilter(String key, T value) {
        RBloomFilter bloomFilter = redissonClient.getBloomFilter(key);
        return bloomFilter.contains(value);
    }
}
