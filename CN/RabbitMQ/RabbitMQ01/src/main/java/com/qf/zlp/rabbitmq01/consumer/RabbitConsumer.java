package com.qf.zlp.rabbitmq01.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;



@Component
public class RabbitConsumer {


    private static final Logger logger =  LoggerFactory.getLogger(RabbitConsumer.class);

    /**
     * @RabbitListener 这个注解 指定需要监听的消息队列，注解中的参数就是要监听的消息队列名称
     * @param msg
     */
    @RabbitListener(queues = "hello-queue",concurrency = "10")
    public void handleMsg1(String msg){

        logger.info("handleMsg1接收了{}"+"\\",msg+"\\");
    }

    @RabbitListener(queues = "hello-queue")
    public void handleMsg2(String msg){

        logger.info("handleMsg2接收了{}"+"\\",msg+"\\");
    }
}
