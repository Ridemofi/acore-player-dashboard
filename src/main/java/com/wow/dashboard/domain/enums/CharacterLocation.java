package com.wow.dashboard.domain.enums;

import lombok.Getter;

@Getter
public enum CharacterLocation {
    EASTERN_KINGDOMS(0, "Reinos del Este"),
    KALIMDOR(1, "Kalimdor"),
    OUTLAND(530, "Terrallende"),
    NORTHREND(571, "Rasganorte");

    private final int id;
    private final String label;

    CharacterLocation(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public static CharacterLocation fromId(int id) {
        for (CharacterLocation value : values()) {
            if (value.id == id) {
                return value;
            }
        }
        return null;
    }

    public static String getLabelSafe(int id) {
        CharacterLocation location = fromId(id);
        return (location != null) ? location.getLabel() : "Instancia";
    }
}

