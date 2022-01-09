package com.yastah.api.enumeration.itemenum;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum GearType {
    AMMO("Ammunition"),
    ARCANE("Arcane Focus"),
    DRUIDIC("Druidic Focus"),
    HOLY("Holy Symbol"),
    PACK("Pack"),
    ARTISAN("Artisan's Tool"),
    KIT("Kit"),
    MUSIC("Musical Instrument"),
    GAMING("Gaming Set"),
    CLOTHES("Clothing Set"),
    CONTAINER("Basic Container"),
    BASIC("Basic Gear");


    private String name;

    GearType(String name) {
        this.name = name;
    }

    @JsonCreator
    public static GearType decode(final String name) {
        return Stream.of(values()).filter(targetEnum -> targetEnum.name.equals(name)).findFirst().orElse(null);
	}

    @JsonValue
    public String getName() {
        return name;
    }
    
}
