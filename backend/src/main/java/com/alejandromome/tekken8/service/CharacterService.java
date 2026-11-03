package com.alejandromome.tekken8.service;
import com.alejandromome.tekken8.domain.entities.Character;

import java.util.List;

public interface CharacterService {
    List<Character> listCharacters();
    Character getCharacterById(Long id);
    Character createCharacter(Character character);
    Character updateCharacter(Character character);
    void deleteCharacter(Long id);
}
