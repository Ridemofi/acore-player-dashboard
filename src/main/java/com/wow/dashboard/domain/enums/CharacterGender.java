package com.wow.dashboard.domain.enums;

import lombok.Getter;

@Getter
public enum CharacterGender {
    MALE(0, "Masculino"),
    FEMALE(1, "Femenino");

    private final int id;
    private final String label;

    CharacterGender(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public static CharacterGender fromId(int id) {
        for (CharacterGender value : values()) {
            if (value.id == id) {
                return value;
            }
        }
        return null;
    }

    public static String getLabelSafe(int id) {
        CharacterGender gender = fromId(id);
        return (gender != null) ? gender.getLabel() : "Desconocido";
    }
}

