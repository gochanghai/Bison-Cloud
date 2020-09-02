package com.bison.system.api.factory;

import com.bison.common.core.domain.R;
import com.bison.system.api.RemoteSysConfigService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统配置服务降级处理
 * @description:
 * @author: Changhai
 * @time: 2020/7/8 17:41
 */
public class RemoteSysConfigFallbackFactory implements FallbackFactory<RemoteSysConfigService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteSysConfigFallbackFactory.class);

    @Override
    public RemoteSysConfigService create(Throwable throwable) {
        log.error("系统配置服务调用失败:{}", throwable.getMessage());
        return new RemoteSysConfigService() {
            @Override
            public R<String> getSysConfigByConfigKey(String configKey) {
                return null;
            }
        };
    }
}
