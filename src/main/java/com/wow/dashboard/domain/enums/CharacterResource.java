package com.wow.dashboard.domain.enums;

import com.wow.dashboard.domain.model.Character;
import lombok.Getter;

@Getter
public enum CharacterResource {
    MANA("Mana", "power1"),
    RAGE("Ira", "power2"),
    ENERGY("Energia", "power4"),
    RUNIC_POWER("Poder runico", "power7");

    private final String label;
    private final String powerField;

    CharacterResource(String label, String powerField) {
        this.label = label;
        this.powerField = powerField;
    }

    public static CharacterResource fromClassId(int classId) {
        return switch (classId) {
            case 1 -> RAGE; // Guerrero
            case 4 -> ENERGY; // Picaro
            case 6 -> RUNIC_POWER; // Caballero de la Muerte
            case 2, 3, 5, 7, 8, 9, 11 -> MANA; // Paladin, Cazador, Sacerdote, Chaman, Mago, Brujo, Druida
            default -> null;
        };
    }

    public static String getLabelSafe(int classId) {
        CharacterResource resource = fromClassId(classId);
        return (resource != null) ? resource.getLabel() : "Desconocido";
    }

    public static Long getResourceValue(Character character) {
        int classId = Byte.toUnsignedInt(character.getCharacterClass());

        return switch (classId) {
            case 1 -> character.getPower2();
            case 4 -> character.getPower4();
            case 6 -> character.getPower7();
            default -> character.getPower1();
        };
    }
}
