package com.bison.common.rabbitmq.service;

import com.bison.common.rabbitmq.callback.ConfirmCallbackService;
import com.bison.common.rabbitmq.callback.ReturnCallbackService;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @description:
 * @author: Changhai
 * @time: 2020/7/5 19:12
 */
@Component
public class SendService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ConfirmCallbackService confirmCallbackService;
    @Autowired
    private ReturnCallbackService returnCallbackService;

    /**
     * @description:
     * @param exchange   交换机
     * @param routingKey 队列
     * @param msg        消息体
     * @return:
     * @author: Changhai
     * @createDate:
     */  
    public void sendMessage(String exchange, String routingKey, Object msg) {

        /**
         * 确保消息发送失败后可以重新返回到队列中
         * 注意：yml需要配置 publisher-returns: true
         */
        rabbitTemplate.setMandatory(true);

        /**
         * 消费者确认收到消息后，手动ack回执回调处理
         */
        rabbitTemplate.setConfirmCallback(confirmCallbackService);

        /**
         * 消息投递到队列失败回调处理
         */
        rabbitTemplate.setReturnCallback(returnCallbackService);

        /**
         * 发送消息
         */
        rabbitTemplate.convertAndSend(exchange, routingKey, msg,
                message -> {
                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    return message;
                },
                new CorrelationData(UUID.randomUUID().toString()));
    }
}