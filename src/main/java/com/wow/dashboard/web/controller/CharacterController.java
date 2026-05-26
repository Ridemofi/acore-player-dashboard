package com.wow.dashboard.web.controller;

import com.wow.dashboard.application.exception.ErrorNegocio;
import com.wow.dashboard.application.service.CharacterService;
import com.wow.dashboard.web.dto.character.response.CharacterListResponse;
import com.wow.dashboard.web.dto.character.response.CharacterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping
    public ResponseEntity<List<CharacterListResponse>> getCharacters(@AuthenticationPrincipal Long userId) {
        if (userId == null) {
            throw new ErrorNegocio("Usuario no autenticado");
        }
        return ResponseEntity.ok(characterService.getCharacters(userId));
    }

    @GetMapping("/{guid}")
    public ResponseEntity<CharacterResponse> getCharacter(@PathVariable Long guid) {
        return ResponseEntity.ok(characterService.getCharacter(guid));
    }
}
