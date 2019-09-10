package com.liqiang.hrm;

import com.liqiang.hrm.config.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMQ_9007_Application.class)
public class SendMsgTest {
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Test
    public void testSendMsg()throws Exception{
        String msg = "send a massage to email!";
        //把字符串转换为Message对象再发送
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_DIRECT_INFORM,"email",msg);
    }
}

