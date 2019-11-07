package com.meetup.revel.model.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Role {

    OWNER("owner"),
    PARTICIPANT("participant"),
    NULL("null");

    private final String keyName;

    Role(String keyName) {
        this.keyName = keyName;
    }

    @JsonCreator
    public static Role fromString(String value) {
        return Arrays.stream(Role.values())
                .filter(type -> type.keyName.equalsIgnoreCase(value))
                .findAny().orElseThrow(IllegalArgumentException::new);
    }

    @JsonValue
    @Override
    public String toString() {
        return this.getKeyName();
    }
}
