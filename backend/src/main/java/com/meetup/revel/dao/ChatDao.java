package com.meetup.revel.dao;

import com.meetup.revel.entity.MessageDTO;
import com.meetup.revel.service.vm.ChatCheckEntity;
import com.meetup.revel.service.vm.ChatIdsVM;

import java.util.List;

public interface ChatDao {

    //Chats

    ChatIdsVM createChatsByEventId(int eventId);

    void deleteChatsByEventId(int eventId);

    ChatIdsVM findChatsIdsByEventId(int eventId);

    //Messages

    MessageDTO insertMessage(MessageDTO messageDTO);

    List<MessageDTO> findMessagesByChatId(int chatId);

    //Permissions

    ChatCheckEntity canJoinChat(int userId, int chatId);
}
