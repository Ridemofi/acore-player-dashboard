package com.wow.dashboard.domain.enums;

import lombok.Getter;

@Getter
public enum CharacterRace {
    HUMAN(1, "Humano"),
    ORC(2, "Orco"),
    DWARF(3, "Enano"),
    NIGHT_ELF(4, "Elfo de la Noche"),
    UNDEAD(5, "No-muerto"),
    TAUREN(6, "Tauren"),
    GNOME(7, "Gnomo"),
    TROLL(8, "Trol"),
    // El ID 9 es Goblin (No jugable en WotLK)
    BLOOD_ELF(10, "Elfo de Sangre"),
    DRAENEI(11, "Draenei");

    private final int id;
    private final String label;

    CharacterRace(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public static CharacterRace fromId(int id) {
        for (CharacterRace value : values()) {
            if (value.id == id) {
                return value;
            }
        }
        return null;
    }

    public static String getLabelSafe(int id) {
        CharacterRace characterRace = fromId(id);
        return (characterRace != null) ? characterRace.getLabel() : "Desconocido";
    }
}

