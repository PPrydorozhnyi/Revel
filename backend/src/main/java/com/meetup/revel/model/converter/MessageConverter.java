package com.meetup.revel.model.converter;

import com.meetup.revel.entity.MessageDTO;
import com.meetup.revel.model.entity.Message;
import com.meetup.revel.repository.ChatRepository;
import com.meetup.revel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageConverter implements Converter<MessageDTO, com.meetup.revel.model.entity.Message> {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public Message convert(MessageDTO messageDTO) {

        Message convertedMessage = new Message();

        convertedMessage.setText(messageDTO.getText());
        convertedMessage.setChat(chatRepository.getOne(messageDTO.getChatId()));
        convertedMessage.setCreatedWhen(modelMapper.map(messageDTO.getMessageDate(), Date.class));
        convertedMessage.setUser(userRepository.getOne(messageDTO.getSenderId()));

        return convertedMessage;
    }
}
