package com.liqiang.hrm.handler;

import com.liqiang.hrm.config.RabbitmqConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveMsgHandler {

    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_EMAIL})
    public  void receiveEmailMsg(String msg, Message message, Channel channel){
        System.out.println("receiveEmailMsg:"+msg);
    }

    @RabbitListener(queues = {RabbitmqConfig.QUEUE_INFORM_SMS})
    public  void receiveSmsMsg(String msg, Message message, Channel channel){
        System.out.println("receiveSmsMsg:"+msg);
    }
}
