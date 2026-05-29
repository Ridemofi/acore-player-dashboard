package com.wow.dashboard.domain.enums;

import lombok.Getter;

@Getter
public enum CharacterClass {
    WARRIOR(1, "Guerrero"),
    PALADIN(2, "Paladín"),
    HUNTER(3, "Cazador"),
    ROGUE(4, "Pícaro"),
    PRIEST(5, "Sacerdote"),
    DEATH_KNIGHT(6, "Caballero de la Muerte"),
    SHAMAN(7, "Chamán"),
    MAGE(8, "Mago"),
    WARLOCK(9, "Brujo"),
    DRUID(11, "Druida");

    private final int id;
    private final String label;

    CharacterClass(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public static CharacterClass fromId(int id) {
        for (CharacterClass value : values()) {
            if (value.id == id) {
                return value;
            }
        }
        return null;
    }

    public static String getLabelSafe(int id) {
        CharacterClass characterClass = fromId(id);
        return characterClass != null ? characterClass.getLabel() : "Desconocido";
    }
}
