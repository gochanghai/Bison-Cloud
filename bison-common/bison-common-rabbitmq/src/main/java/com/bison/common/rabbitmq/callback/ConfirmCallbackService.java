package com.bison.common.rabbitmq.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Changhai
 * @time: 2020/7/5 18:59
 */
@Component
public class ConfirmCallbackService implements RabbitTemplate.ConfirmCallback {

    private static final Logger log = LoggerFactory.getLogger(ConfirmCallbackService.class);

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (!ack) {
            log.error("消息发送异常!");
        } else {
            log.info("发送者爸爸已经收到确认，correlationData={} ,ack={}, cause={}", correlationData.getId(), ack, cause);
        }
    }
}
