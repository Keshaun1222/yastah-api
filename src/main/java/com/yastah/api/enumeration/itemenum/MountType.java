package com.yastah.api.enumeration.itemenum;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MountType {
    MOUNT("Mount"),
    STABLE("Stabling Costs"),
    EQUIPMENT("Equipment for Mounts");

    private String name;

    MountType(String name) {
        this.name = name;
    }

    @JsonCreator
    public static MountType decode(final String name) {
        return Stream.of(values()).filter(targetEnum -> targetEnum.name.equals(name)).findFirst().orElse(null);
	}

    @JsonValue
    public String getName() {
        return name;
    }
}
