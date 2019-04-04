package common.rabbit.dao;

import common.config.MyWebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/4/1 15:08
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
    private static Logger logger = LoggerFactory.getLogger(HelloReceiver.class);

    @Autowired
    private MyWebSocket myWebSocket;

    @RabbitHandler
    private void process(String message){
        System.out.println("Receiver:"+message);
        myWebSocket.onMessage(message);
    }
}
