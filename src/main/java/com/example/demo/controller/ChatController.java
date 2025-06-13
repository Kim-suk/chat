package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.model.ChatMessage;
import com.example.demo.service.ChatService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChatController {

	   private final ChatService chatService;
	   
	   @MessageMapping("/chat.send")
	    @SendTo("/topic/public") // 모든 구독자에게 전송
	    public ChatMessage sendMessage(ChatMessage message) {
	        return chatService.save(message); // 저장하고 메시지 반환
	    }
	   
    @GetMapping("/chat")
    public String chatPage() {
        return "chat/chat2"; // templates/chat.html (Thymeleaf) 또는 /WEB-INF/views/chat.jsp (JSP)로 이동
    }
}
