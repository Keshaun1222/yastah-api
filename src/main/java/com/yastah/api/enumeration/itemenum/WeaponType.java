package com.yastah.api.enumeration.itemenum;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum WeaponType {
    S_M("Simple Melee Weapon"),
    S_R("Simple Ranged Weapon"),
    M_M("Martial Melee Weapon"),
    M_R("Martial Ranged Weapon"),
    F_H("Freehanded Weapon"),
    E_M("Exotic Melee Weapon"),
    E_R("Exotic Ranged Weapon");

    private String name;

    WeaponType(String name) {
        this.name = name;
    }

    @JsonCreator
    public static WeaponType decode(final String name) {
        return Stream.of(values()).filter(targetEnum -> targetEnum.name.equals(name)).findFirst().orElse(null);
	}

    @JsonValue
    public String getName() {
        return name;
    }
}
