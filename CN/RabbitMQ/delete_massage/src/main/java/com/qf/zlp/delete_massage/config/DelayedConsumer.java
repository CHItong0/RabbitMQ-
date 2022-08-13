package com.qf.zlp.delete_massage.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DelayedConsumer {

  public static final   Logger logger= LoggerFactory.getLogger(DelayedConsumer.class);


  //监听队列
  @RabbitListener(queues = DelayedMassageConfig.DELAYED_MSG_QUEUE_NAME)
  public void handMsg(byte[] msg){

      logger.info("{}",new String(msg,0,msg.length));


  }


}
