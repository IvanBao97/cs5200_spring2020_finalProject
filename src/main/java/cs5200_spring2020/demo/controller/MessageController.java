package cs5200_spring2020.demo.controller;

import cs5200_spring2020.demo.domain.Message;
import cs5200_spring2020.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageRepository messageRepository;

    @GetMapping("/message")
    public List<Message> findAllMessages(){
        return messageRepository.findAllMessages();
    }

    @GetMapping("/message/{mid}")
    public Message findMessageById(@PathVariable("mid") Integer mid){
        return messageRepository.findMessageById(mid);
    }

    @GetMapping("/message/delete")
    public void deleteAllMessages(){
        messageRepository.deleteAllMessages();
    }

    @GetMapping("/message/delete/{mid}")
    public void deleteMessageById(@PathVariable("mid") Integer mid){
        messageRepository.deleteMessageById(mid);
    }
}
