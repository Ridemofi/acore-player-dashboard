package com.wow.dashboard.web.dto.character.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CharacterResponse {
    // Identidad
    private Long guid;
    private Long account;
    private String name;

    // Raza / Clase / Genero
    private Byte race;
    private String raceName;
    private Byte characterClass;
    private String className;
    private Byte gender;
    private String genderName;

    // Progreso y estado
    private Byte level;
    private Long xp;
    private Long money;
    private Byte online;
    private Long totalTime;
    private Long logoutTime;
    private Long health;

    // Recursos(mana,furia,etc)
    private String resourceName;
    private Long resourceValue;

    // Ubicacion y metadata
    private LocalDateTime createdDate;
    private Short map;
    private String mapName;
    private Short zone; // sin uso frontend(posible uso backend)
    private String equipmentCache;

    // PvE / PvP
    private Long totalKills;
    private Short todayKills;
    private Long arenaPoints;

    // Talentos
    private Byte talentGroupsCount;
    private Byte activeTalentGroup;
}
