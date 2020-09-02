package com.bison.system.api;

import com.bison.common.core.domain.R;
import com.bison.common.core.constant.ServiceNameConstants;
import com.bison.system.api.factory.RemoteSysConfigFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 系统配置服务
 * @description:
 * @author: Changhai
 * @time: 2020/7/8 17:38
 */
@FeignClient(contextId = "remoteSysConfigService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteSysConfigFallbackFactory.class)
public interface RemoteSysConfigService {

    /**
     * 根据参数键名查询参数值
     *
     * @param configKey 键
     * @return 结果
     */
    @GetMapping(value = "/config/configKey/{configKey}")
    R<String> getSysConfigByConfigKey(@PathVariable String configKey);
}
