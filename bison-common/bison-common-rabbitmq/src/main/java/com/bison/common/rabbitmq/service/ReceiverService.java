package com.bison.common.rabbitmq.service;

import com.rabbitmq.client.Channel;
import com.bison.common.rabbitmq.callback.ConfirmCallbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @description:
 * @author: Changhai
 * @time: 2020/7/5 19:17
 */
@Component
@RabbitListener(queues = "confirm_test_queue")
public class ReceiverService {

    private static final Logger log = LoggerFactory.getLogger(ConfirmCallbackService.class);

    @RabbitHandler
    public void processHandler(CorrelationData correlationData, String msg, Channel channel, Message message) throws IOException {

        try {
            log.info("消费者 2 号收到：{}", msg);

            String correlationId = (String) message.getMessageProperties().getHeaders().get("spring_returned_message_correlation");

            System.out.println(correlationId);

            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        } catch (Exception e) {

        }
    }
}
