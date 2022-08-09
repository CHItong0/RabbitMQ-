package com.qf.zlp.rabbitmq01.comfig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

//创建消息队列
    //在spring 中 只需要将一个 Queue对象注册到spring 容器中 RabbitMQ 就会自动创建该队列
    @Bean
    Queue myQueue(){
        /**
         * 1.队列名字
         * 2.队列是否持久化：RabbitMQ 重启之后，队列是否存在
         * 3.队列排他性：这个给为true 则 只有创建这个队列的连接才能给这个队列发信息
         * 4.如果没有人消费这个队列，是否直接删除该队列
         *
         */


        return new Queue("hello-queue",true,false,false);
    }

}
