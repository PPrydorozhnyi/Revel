package com.meetup.revel.service;

import com.meetup.revel.model.entity.Message;
import com.meetup.revel.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageService {

    private final MessageRepository messageRepository;

    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> getMessagesByChatId(int chatId){
        log.debug("Trying to get messages by chat id '{}'", chatId);

        List<Message> messages = messageRepository.findMessagesByChatId(chatId);

        log.debug("Messages was received");

        return messages;
    }

}
