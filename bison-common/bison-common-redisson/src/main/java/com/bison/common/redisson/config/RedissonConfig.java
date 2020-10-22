package com.bison.common.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @description:
 * @author: Changhai.liu
 * @date: 2020/10/22 22:54
 */
@Configuration
public class RedissonConfig {
    @Bean(destroyMethod="shutdown")
    public RedissonClient redisson() throws IOException {
        RedissonClient redisson = Redisson.create(
                Config.fromYAML(new ClassPathResource("redisson-single.yml").getInputStream()));
        return redisson;
    }

}
