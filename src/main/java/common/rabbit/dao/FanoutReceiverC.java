package common.rabbit.dao;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/4/3 15:22
 */
@Component
@RabbitListener(queues = "fanout.C")
public class FanoutReceiverC {
    @RabbitHandler
    public void process(String message){
        System.out.println("fanout ReceiverC:"+message);
    }
}
