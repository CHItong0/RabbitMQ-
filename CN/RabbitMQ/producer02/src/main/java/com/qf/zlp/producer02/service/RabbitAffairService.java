package com.qf.zlp.producer02.service;

import com.qf.zlp.producer02.config.DirectConfig;
import com.qf.zlp.producer02.config.RabbitAffairConfig;
import com.qf.zlp.producer02.config.RabbitMqConfig;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


@Service
public class RabbitAffairService {
    //消息模板
    @Autowired
    RabbitTemplate rabbitTemplate;

  // @Transactional
    public void hello(){
        // 设置通信通道开启事务模式
        rabbitTemplate.setChannelTransacted(true);
        //发生消息
        rabbitTemplate.convertAndSend(RabbitAffairConfig.AFFAIR_QUEUE_NAME,"hello");
        //手动模拟个异常
        int i = 1 / 0;

    }


    public void Hello2(){

        rabbitTemplate.convertAndSend(DirectConfig.DIRECT_EXCHANGE_NAME,
                DirectConfig.DIRECT_QUEUE_NAME, (Object) "hello",new CorrelationData("99"));


    }

    //手动消费
    public void Hello3(){

        for (int i = 0; i < 10; i++) {

        rabbitTemplate.convertAndSend(RabbitMqConfig.MY_QUEUE_NAME_02,"heool"+i);
        }


    }



}
