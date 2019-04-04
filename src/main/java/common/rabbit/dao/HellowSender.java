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

    public void send1(){
        String context = "hi,i am message all";
        System.out.println("Sender:"+context);
        rabbitTemplate.convertAndSend("topicExchange","topic.1",context);
    }

    public void send2(){
        String context = "hi,i am message 1";
        System.out.println("Sender:"+context);
        rabbitTemplate.convertAndSend("topicExchange","topic.message",context);
    }

    public void send3(){
        String context = "hi,i am message 2";
        System.out.println("Sender:"+context);
        rabbitTemplate.convertAndSend("topicExchange","topic.messages",context);
    }


    public void sendFanout(){
        String context = "h1,fanout msg";
        System.out.println("Sender :"+context);
        rabbitTemplate.convertAndSend("fanoutExchange","",context);
    }
}
