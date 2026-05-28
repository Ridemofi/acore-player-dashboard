package com.wow.dashboard.application.mapper.impl;

import com.wow.dashboard.application.mapper.CharacterMapper;
import com.wow.dashboard.domain.enums.CharacterClass;
import com.wow.dashboard.domain.model.Character;
import com.wow.dashboard.web.dto.character.response.CharacterResponse;
import com.wow.dashboard.web.dto.character.response.CharacterListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CharacterMapperImpl implements CharacterMapper {

    @Override
    public CharacterResponse toDto(Character character) {
        return CharacterResponse.builder()
                .guid(character.getGuid())
                .account(character.getAccount())
                .name(character.getName())
                .race(character.getRace())
                .characterClass(character.getCharacterClass())
                .gender(character.getGender())
                .level(character.getLevel())
                .xp(character.getXp())
                .money(character.getMoney())
                .online(character.getOnline())
                .totalTime(character.getTotalTime())
                .logoutTime(character.getLogoutTime())
                .health(character.getHealth())
                .power1(character.getPower1())
                .power2(character.getPower2())
                .power3(character.getPower3())
                .power4(character.getPower4())
                .power5(character.getPower5())
                .power6(character.getPower6())
                .power7(character.getPower7())
                .createdDate(character.getCreatedDate())
                .map(character.getMap())
                .zone(character.getZone())
                .equipmentCache(character.getEquipmentCache())
                .totalKills(character.getTotalKills())
                .chosenTitle(character.getChosenTitle())
                .todayKills(character.getTodayKills())
                .arenaPoints(character.getArenaPoints())
                .talentGroupsCount(character.getTalentGroupsCount())
                .activeTalentGroup(character.getActiveTalentGroup())
                .build();
    }

    @Override
    public CharacterListResponse toListDto(Character character) {
        return CharacterListResponse.builder()
                .guid(character.getGuid())
                .account(character.getAccount())
                .name(character.getName())
                .race(character.getRace())
                .className(CharacterClass.fromId(Byte.toUnsignedInt(character.getCharacterClass())) != null
                        ? CharacterClass.fromId(Byte.toUnsignedInt(character.getCharacterClass())).getLabel()
                        : "Desconocido")
                .level(character.getLevel())
                .online(character.getOnline())
                .build();
    }
}
