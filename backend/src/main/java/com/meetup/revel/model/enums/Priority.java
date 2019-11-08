package com.meetup.revel.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Priority {
    URGENT("urgent"),
    NORMAL("normal"),
    LOW("low");

    private final String keyName;

    Priority(String keyName) {
        this.keyName = keyName;
    }

    @JsonCreator
    public static Priority fromString(String value) {
        return Arrays.stream(Priority.values())
                .filter(type -> type.keyName.equalsIgnoreCase(value))
                .findAny().orElseThrow(IllegalArgumentException::new);
    }

    @JsonValue
    @Override
    public String toString() {
        return this.getKeyName();
    }
}
