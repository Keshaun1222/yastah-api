package com.yastah.api.service;

import java.util.List;

import com.yastah.api.dto.CharacterDto;
import com.yastah.api.entity.Character;

public interface CharacterService {
    Character saveCharacter(CharacterDto characterDto);
    List<Character> getAllCharacters();
    List<Character> getPlayerActiveCharacters(Long playerId);
    List<Character> getPlayerCharacters(Long playerId);
    List<Character> getActiveCharacters();
    List<Character> getInactiveCharacters();
    Character getCharacterById(Long id);
    Character updateCharacter(CharacterDto characterDto, Long id);
    Character removeCharacter(Long id);
}
