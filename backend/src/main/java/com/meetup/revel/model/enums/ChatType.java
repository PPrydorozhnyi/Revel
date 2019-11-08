package com.meetup.revel.model.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ChatType {
    WITH_OWNER("with_owner"),
    without_owner("without_owner");

    private final String keyName;

    ChatType(String keyName) {
        this.keyName = keyName;
    }

    @JsonCreator
    public static ChatType fromString(String value) {
        return Arrays.stream(ChatType.values())
                .filter(type -> type.keyName.equalsIgnoreCase(value))
                .findAny().orElseThrow(IllegalArgumentException::new);
    }

    @JsonValue
    @Override
    public String toString() {
        return this.getKeyName();
    }
}
