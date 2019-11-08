package com.meetup.revel.model.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum EventType {
    EVENT("event"),
    NOTE("note"),
    PRIVATE_EVENT("private_event");

    private final String keyName;

    EventType(String keyName) {
        this.keyName = keyName;
    }

    @JsonCreator
    public static EventType fromString(String value) {
        return Arrays.stream(EventType.values())
                .filter(type -> type.keyName.equalsIgnoreCase(value))
                .findAny().orElseThrow(IllegalArgumentException::new);
    }

    @JsonValue
    @Override
    public String toString() {
        return this.getKeyName();
    }
}
