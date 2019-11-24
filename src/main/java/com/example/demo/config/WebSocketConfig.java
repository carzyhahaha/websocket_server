package com.example.demo.config;

import com.example.demo.handler.DemoWebSocketHandler;
import com.example.demo.interceptor.websocket.DemoHandShakeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new DemoWebSocketHandler(), "/wss").addInterceptors(new DemoHandShakeInterceptor()).setAllowedOrigins("*");
//        registry.addHandler(new DemoWebSocketHandler(), "/wss/sockjs").addInterceptors(new DemoHandShakeInterceptor()).setAllowedOrigins("*");
    }
}
