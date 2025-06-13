package com.example.demo.repository.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "chatmessage2")
@Getter @Setter
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String roomId;

    private String sender;
    private String message;
    private String type; // TALK, ENTER, READ
    private LocalDateTime sendTime;
}

