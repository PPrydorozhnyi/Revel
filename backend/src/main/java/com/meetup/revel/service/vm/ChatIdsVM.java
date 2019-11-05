package com.meetup.revel.service.vm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatIdsVM {
    private int privateChatId;
    private int publicChatId;
}
