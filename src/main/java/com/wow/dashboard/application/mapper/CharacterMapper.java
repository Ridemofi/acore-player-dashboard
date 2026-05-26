package com.wow.dashboard.application.mapper;

import com.wow.dashboard.domain.model.Character;
import com.wow.dashboard.web.dto.character.response.CharacterResponse;
import com.wow.dashboard.web.dto.character.response.CharacterListResponse;

public interface CharacterMapper {
    CharacterResponse toDto(Character character); //DETALLE COMPLETO INDIVIDUAL
    CharacterListResponse toListDto(Character character);
}
