package com.example.demo.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;
import com.example.demo.repository.model.ChatMessage;



public interface ChatRepository extends JpaRepository<ChatMessage, UUID> {

	List<ChatMessage> findByRoomIdOrderBySendTimeAsc(String roomId);
}
