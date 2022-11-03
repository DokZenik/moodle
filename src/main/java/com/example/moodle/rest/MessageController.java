package com.example.moodle.rest;

import com.example.moodle.models.MessageModel;
import com.example.moodle.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MessageController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/chat/{to}")
    public ResponseEntity<Void> sendMessage(MessageModel message){
        System.out.println("message: " + message + " to: " + message.getRecipientId());
        messageService.add(message);
        simpMessagingTemplate.convertAndSend("/topic/messages/" + message.getRecipientId(), message);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllMessages")
    public List<MessageModel> getAllMessages(@RequestParam String from, @RequestParam String to){
        return messageService.getMessages(from, to);
    }
}
