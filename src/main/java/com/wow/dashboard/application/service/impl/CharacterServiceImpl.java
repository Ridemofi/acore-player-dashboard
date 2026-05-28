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
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class CharacterServiceImpl implements CharacterService {
    private final CharacterMapper characterMapper;
    private final CharacterRepository characterRepository;

    @Override
    public CharacterResponse getCharacter(Long guid, Long userId) {
        if (userId == null) {
            throw new ErrorNegocio("Usuario no autenticado");
        }
        Character character = characterRepository.findByGuid(guid).orElseThrow(() -> new ErrorNegocio("Personaje No Encontrado"));
        if(!Objects.equals(character.getAccount(), userId)) {
            throw new ErrorNegocio("No tienes permiso para ver este personaje");
        }
        return characterMapper.toDto(character);
    }

    @Override
    public List<CharacterListResponse> getCharacters(Long userId) {
        if (userId == null) {
            throw new ErrorNegocio("Usuario no autenticado");
        }
        return characterRepository.findByAccount(userId)
                .stream()
                .map(characterMapper::toListDto)
                .toList();
    }
}
