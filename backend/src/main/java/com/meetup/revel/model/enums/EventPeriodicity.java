package com.meetup.revel.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum EventPeriodicity {
    ONCE("once"),
    HOUR("hour"),
    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    YEAR("year");

    private final String keyName;

    EventPeriodicity(String keyName) {
        this.keyName = keyName;
    }

    @JsonCreator
    public static EventPeriodicity fromString(String value) {
        return Arrays.stream(EventPeriodicity.values())
                .filter(type -> type.keyName.equalsIgnoreCase(value))
                .findAny().orElseThrow(IllegalArgumentException::new);
    }

    @JsonValue
    @Override
    public String toString() {
        return this.getKeyName();
    }
}
