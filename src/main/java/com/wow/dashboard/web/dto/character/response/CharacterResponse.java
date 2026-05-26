package com.wow.dashboard.web.dto.character.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CharacterResponse {
    private Long guid;
    private Long account;
    private String name;
    private Byte race;
    private Byte characterClass;
    private Byte gender;
    private Byte level;
    private Long xp;
    private Long money;
    private Byte online;
    private Long totalTime;
    private Long logoutTime;
    private Long health;
    private Long power1;
    private Long power2;
    private Long power3;
    private Long power4;
    private Long power5;
    private Long power6;
    private Long power7;
    private LocalDateTime createdDate;
    private Short map;
    private Short zone;
    private String equipmentCache;
    private Long totalKills;
    private Long chosenTitle;
    private Short todayKills;
    private Long arenaPoints;
    private Byte talentGroupsCount;
    private Byte activeTalentGroup;
}
