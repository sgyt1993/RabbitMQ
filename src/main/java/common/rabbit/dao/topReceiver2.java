package common.rabbit.dao;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/4/3 14:27
 */
@Component
@RabbitListener(queues = "topic.messages")
public class topReceiver2 {
    @RabbitHandler
    public void message(String message){
        System.out.println("Topic Receiver2 :" +message);
    }
}
