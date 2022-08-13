package com.qf.zlp.producer01;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RappitConfig {

    //定义一个队列名的成员变量，方便调用
    public static final String MY_QUEUE_NAME ="hello-queue";

    @Bean
    Queue myQueue(){


        return new Queue(MY_QUEUE_NAME,true,false,false);
    }
}
