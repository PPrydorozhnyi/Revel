package com.meetup.revel.service;

import com.meetup.revel.dao.ChatDao;
import com.meetup.revel.entity.MessageDTO;
import com.meetup.revel.service.vm.ChatIdsVM;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@PropertySource("classpath:strings.properties")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdvancedChatService {

    private final ChatDao chatDao;

    private Map<Integer, List<String>> userLogins = new HashMap<>();

    public ChatIdsVM addChats(int eventId) {
        log.debug("Trying to add chats for event with id '{}'", eventId);

        ChatIdsVM chatIdsVM = chatDao.createChatsByEventId(eventId);

        log.debug("Created chats '{}' by eventId '{}'", chatIdsVM, eventId);

        return chatIdsVM;
    }

    public ChatIdsVM getChatsIds(int eventId) {
        log.debug("Trying to get chats for event with id '{}'", eventId);

        ChatIdsVM chatIdsVM = chatDao.findChatsIdsByEventId(eventId);

        log.debug("Received chats '{}' by eventId '{}'", chatIdsVM, eventId);

        return chatIdsVM;
    }

    public void deleteChats(int eventId) {
        log.debug("Trying to delete chats for event with id '{}'", eventId);

        chatDao.deleteChatsByEventId(eventId);
    }

    public MessageDTO addMessage(MessageDTO messageDTO){
        log.debug("Trying to add message '{}'", messageDTO);

        MessageDTO addedMessageDTO = chatDao.insertMessage(messageDTO);

        log.debug("Message '{}' added successful", addedMessageDTO);

        return addedMessageDTO;
    }
}
