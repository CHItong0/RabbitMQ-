package com.qf.zlp.consumer01.rabbitmqconfig;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 直连交换机
 */
@Configuration
public class RabbitMqConfig {

    //队列名
    public static final String MY_QUEUE_NAME_02 ="my_queue_name02";
    //队列名
    public static final String MY_QUEUE_NAME_03="my_queue_name03";

    //交换机名
    public static final String DIRECT_EXCHANGE_NAME="direct_exchange_name";


    //两个队列
    @Bean
    Queue myQueue02(){
        return new Queue(MY_QUEUE_NAME_02,true,false,false);
    }

    @Bean
    Queue myQueue03(){
        return new Queue(MY_QUEUE_NAME_03,true,false,false);
    }


    //交换机
    @Bean
    DirectExchange directExchange(){

        // 交换机名
        //交换机是否持久化
        // 没有队列的时候，交换机是否自动删除
        return new DirectExchange(DIRECT_EXCHANGE_NAME,true,false);
    }



    //交换机绑定队列
    @Bean
    Binding bindingMyQueue02(){

        //将 MyQueue02 队列和交换机绑定起来
        return BindingBuilder.bind(myQueue02())
                //绑定该交换机
                .to(directExchange())
                //为这个binding 设置一个 routingKey 将来发消息的是很好，会携带一个 routingKey
                //这个消息到达交换机后，会自动将这个消息路由到与之同名滴。
                .with(MY_QUEUE_NAME_02);

    }

    @Bean
    Binding bindingMyQueue03(){
        //将 MyQueue03 队列和交换机绑定起来
        return BindingBuilder.bind(myQueue03())

                .to(directExchange())
                // .with(bbb);
                //发送消息是，如果设置 routingKey 为 bbbb，则消息会被转发到 queue03 上
                //发送消息是，如果设置 routingKey 为 aaaa，则消息会被转发到 queue02 上
                //不建议随便起名字
                .with(MY_QUEUE_NAME_03);

    }
}
