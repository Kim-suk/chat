package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.interfaces.ChatRepository;
import com.example.demo.repository.model.ChatMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatMessage save(ChatMessage message) {
        message.setSendTime(LocalDateTime.now());
        return chatRepository.save(message);
    }

    public List<ChatMessage> getChatMessages(String roomId) {
        return chatRepository.findByRoomIdOrderBySendTimeAsc(roomId);
    }
}


