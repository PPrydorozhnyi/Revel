package com.meetup.revel.service.vm;

import com.meetup.revel.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatCheckEntity {
    private Role role;
    private int chatTypeId;
}
