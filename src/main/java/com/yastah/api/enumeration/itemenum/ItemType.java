package com.yastah.api.enumeration.itemenum;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ItemType {
    ARMOR("Armor"),
    WEAPON("Weapon"),
    ADVENTURE("Adventuring Gear"),
    MAGIC("Magic Item"),
    POTION("Potion or Poison"),
    MOUNT("Mount"),
    CRAFTING("Crafting Materials"),
    REPAIR("Item Repair");

    private String name;

    ItemType(String name) {
        this.name = name;
    }

    @JsonCreator
    public static ItemType decode(final String name) {
        return Stream.of(values()).filter(targetEnum -> targetEnum.name.equals(name)).findFirst().orElse(null);
	}

    @JsonValue
    public String getName() {
        return name;
    }
}
