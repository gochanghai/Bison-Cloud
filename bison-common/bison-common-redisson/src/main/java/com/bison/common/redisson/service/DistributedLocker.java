package com.bison.common.redisson.service;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Changhai.liu
 * @date: 2020/10/22 23:07
 */
public interface DistributedLocker {

    RLock lock(String lockKey);

    RLock lock(String lockKey, int timeout);

    RLock lock(String lockKey, TimeUnit unit, int timeout);

    boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime);

    void unlock(String lockKey);

    void unlock(RLock lock);
}
