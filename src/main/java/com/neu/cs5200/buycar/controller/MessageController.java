package com.neu.cs5200.buycar.controller;

import com.neu.cs5200.buycar.domain.Message;
import com.neu.cs5200.buycar.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageRepository messageRepository;

    @PostMapping("/api/message")
    public Message createMessage(@RequestBody Message message) {
        return messageRepository.save(message);
    }

    @PutMapping("/api/message/{msgId}")
    public Message updateMessage(
            @PathVariable("msgId") int id,
            @RequestBody Message newMessage) {
        Message message = messageRepository.findMessageById(id);
        if(newMessage.getText() != null){
            message.setText(newMessage.getText());
        }
        return messageRepository.save(message);
    }

    @GetMapping("/api/message")
    public List<Message> findAllMessages(){
        return messageRepository.findAllMessages();
    }

    @GetMapping("/api/message/{mid}")
    public Message findMessageById(@PathVariable("mid") Integer mid){
        return messageRepository.findMessageById(mid);
    }

    @DeleteMapping("/api/message")
    public void deleteAllMessages(){
        messageRepository.deleteAllMessages();
    }

    @DeleteMapping("/api/message/{mid}")
    public void deleteMessageById(@PathVariable("mid") Integer mid){
        messageRepository.deleteMessageById(mid);
    }
}
