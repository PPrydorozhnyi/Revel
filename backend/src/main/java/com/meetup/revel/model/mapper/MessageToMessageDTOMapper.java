package com.meetup.revel.model.mapper;

import com.meetup.revel.entity.MessageDTO;
import com.meetup.revel.model.entity.Message;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageToMessageDTOMapper {

    private final ModelMapper modelMapper;

    @PostConstruct
    public void init() {
        instanceToDtoSetup();
    }

    private void instanceToDtoSetup() {
        modelMapper.createTypeMap(Message.class, MessageDTO.class).setConverter(context -> {
                    MessageDTO messageDTO = new MessageDTO();

                    Message message = context.getSource();
                    if (Objects.isNull(message)) {
                        return null;
                    }

                    messageDTO.setChatId(message.getChat().getId());
                    messageDTO.setMessageDate(modelMapper.map(message.getCreatedWhen(), String.class));
                    messageDTO.setMessageId(message.getId());
                    messageDTO.setSenderId(message.getUser().getId());
                    messageDTO.setSenderLogin(message.getUser().getLogin());

                    return messageDTO;
                }

        );
    }

}
