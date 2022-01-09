package com.yastah.api.enumeration;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Side {
    BRINMORE("Brinmore"),
    DIRMUS("Dirmus");

    private String name;

    Side(String name) {
        this.name = name;
    }

    @JsonCreator
    public static Side decode(final String name) {
        return Stream.of(values()).filter(targetEnum -> targetEnum.name.equals(name)).findFirst().orElse(null);
	}

    @JsonValue
    public String getName() {
        return name;
    }
}
