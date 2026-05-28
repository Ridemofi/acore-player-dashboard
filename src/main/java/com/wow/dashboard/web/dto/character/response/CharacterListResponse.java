package com.wow.dashboard.web.dto.character.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CharacterListResponse {
    private Long guid;
    private Long account;
    private String name;
    private Byte race;
    private String className;
    private Byte level;
    private Byte online;
}

