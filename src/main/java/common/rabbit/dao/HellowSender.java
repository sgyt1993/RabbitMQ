package common.rabbit.dao;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author:sgyt
 * @Description:生产者
 * @Date:2019/4/1 14:58
 */
@Component
public class HellowSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        String content = "Hello"+new Date();
        System.out.println("Sender:"+content);
        rabbitTemplate.convertAndSend("hello",content);
    }
}
