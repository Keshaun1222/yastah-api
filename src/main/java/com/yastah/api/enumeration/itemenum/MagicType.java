package com.yastah.api.enumeration.itemenum;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MagicType {
    ARM_ENCHANT("Armor Enchantment"),
    S_ENCHANT("Shield Enchantment"),
    W_ENCHANT("Weapon Enchantment"),
    AMMO_ENCHANT("Ammunition Enchantment"),
    ARMOR("Special Armor"),
    WEAPON("Special Weapon"),
    ROD("Special Rod"),
    SHARD("Special Shard"),
    STAFF("Special Staff"),
    WAND("Special Wand"),
    NECKLACE("Magical Necklace"),
    RING("Magical Ring"),
    TATTOO("Magical Tattoo"),
    ARMS("Magical Armwear"),
    BELT("Magical Belt"),
    CHEST("Magical Chestpiece"),
    CLOAK("Magical Cloak"),
    EYES("Magical Eyewear"),
    FEET("Magical Footwear"),
    HANDS("Magical Handwear"),
    HEAD("Magical Headwear"),
    RANDOM("Random Special Item");

    private String name;

    MagicType(String name) {
        this.name = name;
    }

    @JsonCreator
    public static MagicType decode(final String name) {
        return Stream.of(values()).filter(targetEnum -> targetEnum.name.equals(name)).findFirst().orElse(null);
	}

    @JsonValue
    public String getName() {
        return name;
    }
}
