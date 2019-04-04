package common.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/4/4 15:42
 */
@ServerEndpoint(value = "/websocket")
@Component
public class MyWebSocket {
    private static Logger log = LogManager.getLogger(MyWebSocket.class);

    //使用静态变量，来记录当前在线链接数，设计为线程安全的

//    与某个客户端链接回话，需要通过它来给客户端发送数据
    private Session session;

//    同步线程容器
    private static CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<>();

    private static AtomicInteger onlineCount = new AtomicInteger();

//    存放每个客户端对应的myWebSocket对象，若要实现服务端与单一客户端通信的话，用map存放
    private static CopyOnWriteArraySet<MyWebSocket> myWebSockets = new CopyOnWriteArraySet<>();

    /***
     * 链接建立成功调用的方法
     * @param session
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        sessions.add(session);
        myWebSockets.add(this);
        onlineCount.incrementAndGet();
        log.info("有新链接加入！当前在线人数为:"+onlineCount);
    }

    /**
     * 链接关闭的方法
     */
    @OnClose
    public void onClose(){
        myWebSockets.remove(this);
        sessions.remove(session);
        onlineCount.decrementAndGet();
        log.info("有一个链接关闭！当前人数为："+onlineCount);
    }

    /***
     * 收到客户端消息后调用的方法
     * @param message
     *
     */
    @OnMessage
    public void onMessage(String message){
        log.info("来自客户端的消息"+message);
        for(MyWebSocket item:myWebSockets){
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    /***
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session,Throwable error){
        log.error("发生错误");
        error.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        if(sessions.size() != 0 ){
            for(Session s:sessions){
                if(s != null){
                    s.getBasicRemote().sendText(message);
                }
            }
        }
        log.info("[x]推送消息"+message);
    }


}

