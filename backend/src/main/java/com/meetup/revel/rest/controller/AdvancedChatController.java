package com.meetup.revel.rest.controller;

import com.meetup.revel.entity.MessageDTO;
import com.meetup.revel.model.entity.Message;
import com.meetup.revel.service.AdvancedChatService;
import com.meetup.revel.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/api/users/{userId}/chats")
public class AdvancedChatController {

    private final AdvancedChatService chatService;

    private final MessageService messageService;

    private final ConversionService conversionService;

    private final ModelMapper mapper;


    @PostMapping("/message")
    @PreAuthorize("@chatAuthorization.checkByChatId(#userId, #messageDTO.chatId)")
    public ResponseEntity<MessageDTO> addMessage(@PathVariable int userId, @RequestBody MessageDTO messageDTO) {
        log.debug("Trying to add message for chat with id '{}'", messageDTO.getChatId());

        Message convertedMessage = conversionService.convert(messageDTO, Message.class);

        Message result = messageService.addMessage(convertedMessage);

        log.debug("Send response body message '{}' and status CREATED", result.getId());

        return new ResponseEntity(mapper.map(result, MessageDTO.class), HttpStatus.CREATED);
    }

}
