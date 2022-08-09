package com.qf.zlp.rabbitmq01.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Component
public class RabbitConsumer {


    private static final Logger logger =  LoggerFactory.getLogger(RabbitConsumer.class);


    @RabbitListener(queues = "hello-queue")
    public void handleMsg(String msg){

        logger.info("msg{}",msg);
    }
}
