package com.coderlambtw.chatroom.controller;

import com.coderlambtw.chatroom.constant.Status;
import com.coderlambtw.chatroom.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketEventListener {

  private final SimpMessageSendingOperations sendingOperations;

  @EventListener
  public void handleWebSocketConnectListener(SessionConnectedEvent event) {
    LocalDateTime connectedTime = LocalDateTime.now();
    log.info("New user Connected at {}", connectedTime);
  }

  @EventListener
  public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

    String username = (String) headerAccessor.getSessionAttributes().get("username");

    ChatMessage chatMessage =
        ChatMessage.builder().type(Status.DISCONNECT).sender(username).build();

    log.info("{} has left the chat room", username);
    sendingOperations.convertAndSend("/topic/public", chatMessage);
  }
}
