package com.wow.dashboard.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "characters", catalog = "acore_characters")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Character {

    @Id
    @Column(name = "guid", columnDefinition = "int unsigned")
    private Long guid;

    @Column(name = "account", columnDefinition = "int unsigned")
    private Long account;

    @Column(name = "name")
    private String name;

    @Column(name = "race", columnDefinition = "tinyint unsigned")
    private Byte race;

    @Column(name = "`class`", columnDefinition = "tinyint unsigned")
    private Byte characterClass;

    @Column(name = "gender", columnDefinition = "tinyint unsigned")
    private Byte gender;

    @Column(name = "level", columnDefinition = "tinyint unsigned")
    private Byte level;

    @Column(name = "xp", columnDefinition = "int unsigned")
    private Long xp;

    @Column(name = "money", columnDefinition = "int unsigned")
    private Long money;

    @Column(name = "online", columnDefinition = "tinyint unsigned")
    private Byte online;

    @Column(name = "totaltime", columnDefinition = "int unsigned")
    private Long totalTime;

    @Column(name = "logout_time", columnDefinition = "int unsigned")
    private Long logoutTime;

    @Column(name = "health", columnDefinition = "int unsigned")
    private Long health;

    @Column(name = "power1", columnDefinition = "int unsigned")
    private Long power1;

    @Column(name = "power2", columnDefinition = "int unsigned")
    private Long power2;

    @Column(name = "power3", columnDefinition = "int unsigned")
    private Long power3;

    @Column(name = "power4", columnDefinition = "int unsigned")
    private Long power4;

    @Column(name = "power5", columnDefinition = "int unsigned")
    private Long power5;

    @Column(name = "power6", columnDefinition = "int unsigned")
    private Long power6;

    @Column(name = "power7", columnDefinition = "int unsigned")
    private Long power7;

    @Column(name = "creation_date", columnDefinition = "timestamp")
    private LocalDateTime createdDate;

    @Column(name = "map", columnDefinition = "smallint unsigned")
    private Short map;

    @Column(name = "zone", columnDefinition = "smallint unsigned")
    private Short zone;

    @Column(name = "equipmentCache", columnDefinition = "longtext")
    private String equipmentCache;

    @Column(name = "totalKills", columnDefinition = "int unsigned")
    private Long totalKills;

    @Column(name = "chosenTitle", columnDefinition = "int unsigned")
    private Long chosenTitle;

    @Column(name = "todayKills", columnDefinition = "smallint unsigned")
    private Short todayKills;

    @Column(name = "arenaPoints", columnDefinition = "int unsigned")
    private Long arenaPoints;

    @Column(name = "talentGroupsCount", columnDefinition = "tinyint unsigned")
    private Byte talentGroupsCount;

    @Column(name = "activeTalentGroup", columnDefinition = "tinyint unsigned")
    private Byte activeTalentGroup;
}