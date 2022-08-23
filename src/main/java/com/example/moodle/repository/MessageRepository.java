package com.example.moodle.repository;

import com.example.moodle.models.MessageModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<MessageModel, Long> {
    @Query("SELECT m FROM MessageModel m WHERE (m.recipientId = ?1 AND m.senderId = ?2) OR (m.recipientId = ?2 AND m.senderId = ?1)")
    public List<MessageModel> getMessageModelsBySenderIdAndRecipientId(String from, String to);
}
