package com.ruoyi.common.websocket.server;

import com.ruoyi.common.websocket.util.WebSocketUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: Changhai
 * @time: 2020/7/8 1:21
 */
@ServerEndpoint(value = "/websocket")
@Component
public class ZydWebsocketServer {

    private static final Logger log = LoggerFactory.getLogger(WebSocketUtil.class);

    /**
     * 线程安全的socket集合
     */
    private static CopyOnWriteArraySet<Session> webSocketSet = new CopyOnWriteArraySet<>();
    /**
     * 初始在线人数
     */
    private static AtomicInteger onlineCount = new AtomicInteger(0);

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        webSocketSet.add(session);
        int count = onlineCount.incrementAndGet();
        log.info("[Socket] 有链接加入，当前在线人数为: {}", count);

        WebSocketUtil.sendOnlineMsg(Integer.toString(count), webSocketSet);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        int count = onlineCount.decrementAndGet();
        log.info("[Socket] 有链接关闭,当前在线人数为: {}", count);
        WebSocketUtil.sendOnlineMsg(Integer.toString(count), webSocketSet);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message
     *         客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("[Socket] {}来自客户端的消息:{}", session.getId(), message);
    }

    /**
     * 获取在线用户数量
     *
     * @return
     */
    public int getOnlineUserCount() {
        return onlineCount.get();
    }

    /**
     * 获取在线用户的会话信息
     *
     * @return
     */
    public CopyOnWriteArraySet<Session> getOnlineUsers() {
        return webSocketSet;
    }
}
