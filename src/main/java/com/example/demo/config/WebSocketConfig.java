package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // WebSocket 메시지 브로커 사용 선언
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 클라이언트가 WebSocket 연결할 엔드포인트 정의
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*") // CORS 허용
                .withSockJS(); // SockJS 사용
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 클라이언트가 서버로 메시지를 보낼 때 prefix
        registry.setApplicationDestinationPrefixes("/app"); // 예: /app/chat.send

        // 서버가 클라이언트한테 메시지를 보낼 때 prefix (브로커)
        registry.enableSimpleBroker("/topic", "/queue"); // topic: 브로드캐스트, queue: 개인
    }
}
