package com.example.rpc_server.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * client 发送消息，发到 RPC_MSG_QUEUE 队列 server监听这个队列，就可以收到client 发来的消息，
 * 然后 server 对消息进行处理，处理完成后， 将响应的内容发到 RPC_REPLY_QUEUE 队列上，
 * client监听 RPC_REPLY_QUEUE 队列就可以收到server 返回的信息了
 */
@Configuration
public class  RpcConfig {

    //client 发送消息的时候，发到这个队列上（server监听这个队列）
    public static final String RPC_MSG_QUEUE="rpc_msg_queue";
    //server发送消息的时候，发到这个队列上（client 监听这个队列）
    public static final String RPC_REPLY_QUEUE="rpc_reply_queue";
    public static final String RPC_EXCHANGE_NAME="rpc_exchange_name";
    @Bean
    Queue rpcQueue01(){return new Queue(RPC_MSG_QUEUE,true,false,false);}
    @Bean
    Queue rpcQueue02(){return  new Queue(RPC_REPLY_QUEUE,true,false,false);}
    @Bean
    TopicExchange rpcTopicExchange(){return new TopicExchange(RPC_EXCHANGE_NAME,true,false);}
    //请求队列和交换机绑定
    @Bean
    Binding rpcBinding01(){return BindingBuilder.bind(rpcQueue01()).to(rpcTopicExchange()).with(RPC_MSG_QUEUE);}
    //响应队列和交换机绑定
    @Bean
    Binding rpcBinding(){return  BindingBuilder.bind(rpcQueue02()).to(rpcTopicExchange()).with(RPC_REPLY_QUEUE);}
}
