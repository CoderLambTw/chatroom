package com.coderlambtw.chatroom.model;

import com.coderlambtw.chatroom.constant.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
  private String sender;
  private String content;
  private String time;
  private Status type;
}
