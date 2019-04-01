package common.rabbit.dao;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/4/1 15:08
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    private void process(String hello){
        System.out.println("Receiver:"+hello);
    }
}
