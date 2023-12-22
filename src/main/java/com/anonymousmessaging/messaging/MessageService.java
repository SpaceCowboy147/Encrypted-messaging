package com.anonymousmessaging.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class MessageService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void sendMessageToUser(String username, String message) {
        String destination = "/user/" + username + "/send-message/private";
        messagingTemplate.convertAndSend(destination, message);
    }
}
