package com.ruoyi.common.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @description: websocket配置类
 * @author: Changhai
 * @time: 2020/7/8 1:15
 */
@Configuration
public class WebSocketConfig {

    /**
     * ServerEndpointExporter会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint
     *
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
