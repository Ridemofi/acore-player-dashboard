package com.wow.dashboard.application.service;

import com.wow.dashboard.web.dto.character.response.CharacterListResponse;
import com.wow.dashboard.web.dto.character.response.CharacterResponse;

import java.util.List;

public interface CharacterService {
    CharacterResponse getCharacter(Long guid, Long userId);
    List<CharacterListResponse> getCharacters(Long userId);
}
