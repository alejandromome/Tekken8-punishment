package com.alejandromome.tekken8.service.impl;

import com.alejandromome.tekken8.repositories.CharacterRepository;
import com.alejandromome.tekken8.service.CharacterService;
import com.alejandromome.tekken8.domain.entities.Character;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;
    @Override
    public List<Character> listCharacters() {
        return characterRepository.findAll();
    }

}
