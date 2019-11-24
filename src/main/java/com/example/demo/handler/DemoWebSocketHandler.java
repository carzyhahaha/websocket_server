package com.example.demo.handler;

import org.springframework.web.socket.*;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DemoWebSocketHandler implements WebSocketHandler {

    private static final ConcurrentHashMap<String, WebSocketSession> SESSIONS = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String username = validate(session);
        if (username != null) {
            SESSIONS.put(username, session);
            System.out.println(username + " 登入, 目前" + SESSIONS.size() + "个连接.");
        }

    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (validate(session) == null) {
            System.out.println(new TextMessage(message.getPayload().toString()));
        } else {
            throw new Exception("授权失败");
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
        if (session.isOpen()) {
            session.close();
        }
        String username = validate(session);
        System.out.println(username + "连接出错");
        SESSIONS.remove(username);
        System.out.println("当前" + SESSIONS.size() + "个连接");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        String username = validate(session);
        System.out.println(username + "连接关闭");
        SESSIONS.remove(username);
        System.out.println("当前" + SESSIONS.size() + "个连接");

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    private String validate(WebSocketSession session) {
        Map<String, Object> attributes = session.getAttributes();
        HttpSession httpSession = (HttpSession) attributes.get("currHttpSession");
        String username = (String) httpSession.getAttribute("username");
        return username;
    }

}
