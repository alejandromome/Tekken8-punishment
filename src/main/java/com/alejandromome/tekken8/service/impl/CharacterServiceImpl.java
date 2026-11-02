package com.alejandromome.tekken8.service.impl;

import com.alejandromome.tekken8.repositories.CharacterRepository;
import com.alejandromome.tekken8.service.CharacterService;
import com.alejandromome.tekken8.domain.entities.Character;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;
    @Override
    public Character getCharacterById(final Long id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Character not found with id: " + id));
    }
    @Override
    public Character createCharacter(Character character) {return characterRepository.save(character);}
    @Override
    public Character updateCharacter(Character character) {return characterRepository.save(character);}

    @Override
    public void deleteCharacter(final Long id) {
        characterRepository.deleteById(id);
    }

}
