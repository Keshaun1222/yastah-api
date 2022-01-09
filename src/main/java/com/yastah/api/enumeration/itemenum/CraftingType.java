package com.yastah.api.enumeration.itemenum;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CraftingType {
    ARMOR("Armor and Shield Crafting"),
    WEAPON("Weapon Crafting"),
    GEAR("Adventuring Gear Crafting"),
    POTION("Potion and Poison Crafting"),
    GUNSLINGER("Freehanded Weapon"),
    AAT("Exotic Melee Weapon");

    private String name;

    CraftingType(String name) {
        this.name = name;
    }

    @JsonCreator
    public static CraftingType decode(final String name) {
        return Stream.of(values()).filter(targetEnum -> targetEnum.name.equals(name)).findFirst().orElse(null);
	}

    @JsonValue
    public String getName() {
        return name;
    }
}
