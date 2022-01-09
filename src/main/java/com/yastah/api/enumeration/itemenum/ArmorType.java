package com.yastah.api.enumeration.itemenum;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ArmorType {
    LIGHT("Light Armor"),
    MEDIUM("Medium Armor"),
    HEAVY("Heavy Armor"),
    SHIELD("Shield");

    private String name;

    ArmorType(String name) {
        this.name = name;
    }

    @JsonCreator
    public static ArmorType decode(final String name) {
        return Stream.of(values()).filter(targetEnum -> targetEnum.name.equals(name)).findFirst().orElse(null);
	}

    @JsonValue
    public String getName() {
        return name;
    }
}
