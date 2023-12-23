package com.anonymousmessaging.messaging;

import com.anonymousmessaging.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

//@Controller
//public class MessageController {
//    private final SimpMessagingTemplate messagingTemplate;
//private final UserService userService;
//    @Autowired
//    public MessageController(SimpMessagingTemplate messagingTemplate,  UserService userService) {
//        this.messagingTemplate = messagingTemplate;
//        this.userService = userService;
//    }

//    @MessageMapping("/chat.sendMessage")
//    @SendToUser("/app/private")
//    public void sendMessage(@Payload Message chatMessage) {
//        String friendUsername = userService.findUsernameById();
//        String response = "Message sent successfully!";
//        messagingTemplate.convertAndSendToUser(chatMessage.getSentToUserId(), "/app/private", chatMessage);
//        return response;
//    }

//    }
