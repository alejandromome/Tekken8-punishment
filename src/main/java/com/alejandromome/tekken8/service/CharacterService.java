package com.alejandromome.tekken8.service;
import com.alejandromome.tekken8.domain.entities.Character;

public interface CharacterService {
    Character getCharacterById(Long id);
    Character createCharacter(Character character);
    Character updateCharacter(Character character);
    void deleteCharacter(Long id);
}
