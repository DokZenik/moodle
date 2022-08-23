package com.example.moodle.services;

import com.example.moodle.models.MessageModel;
import com.example.moodle.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    public void add(MessageModel message){
        messageRepository.save(message);
    }

    public List<MessageModel> getMessages( String from, String to){
        return messageRepository.getMessageModelsBySenderIdAndRecipientId(from, to);
    }
}
