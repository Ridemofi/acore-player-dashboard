package com.wow.dashboard.application.service.impl;

import com.wow.dashboard.application.exception.ErrorNegocio;
import com.wow.dashboard.application.mapper.CharacterMapper;
import com.wow.dashboard.application.service.CharacterService;
import com.wow.dashboard.domain.model.Character;
import com.wow.dashboard.domain.repository.CharacterRepository;
import com.wow.dashboard.web.dto.character.response.CharacterListResponse;
import com.wow.dashboard.web.dto.character.response.CharacterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CharacterServiceImpl implements CharacterService {
    private final CharacterMapper characterMapper;
    private final CharacterRepository characterRepository;

    @Override
    public CharacterResponse getCharacter(Long guid) {
        Character character = characterRepository.findByGuid(guid).orElseThrow(() -> new ErrorNegocio("Personaje No Encontrado"));
        return characterMapper.toDto(character);
    }

    @Override
    public List<CharacterListResponse> getCharacters(Long userId) {
        return characterRepository.findByAccount(userId)
                .stream()
                .map(characterMapper::toListDto)
                .toList();
    }
}
