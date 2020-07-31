package com.bison.common.rabbitmq.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: Changhai
 * @time: 2020/7/5 18:44
 */
@Component
public class ReturnCallbackService implements RabbitTemplate.ReturnCallback {

    private static final Logger log = LoggerFactory.getLogger(ReturnCallbackService.class);

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("returnedMessage ===> replyCode={} ,replyText={} ,exchange={} ,routingKey={}", replyCode, replyText, exchange, routingKey);
    }
}
