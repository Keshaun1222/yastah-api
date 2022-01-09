package com.yastah.api.enumeration;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DM {
    NA("Player"),
    JUNIOR("Junior Dungeon Master"),
    DM("Dungeon Master"),
    HEAD("Head Dungeon Master"),
    MASTER("Master Dungeon Master");
    
    private String title;

    DM(String title) {
        this.title = title;
    }

    @JsonCreator
    public static DM decode(final String title) {
        return Stream.of(values()).filter(targetEnum -> targetEnum.title.equals(title)).findFirst().orElse(null);
	}

    @JsonValue
    public String getTitle() {
        return title;
    }
}
