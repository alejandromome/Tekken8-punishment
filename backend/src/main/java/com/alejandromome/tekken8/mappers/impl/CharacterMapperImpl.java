package com.alejandromome.tekken8.mappers.impl;

import com.alejandromome.tekken8.dtos.CharacterDTO;
import com.alejandromome.tekken8.mappers.CharacterMapper;
import org.springframework.stereotype.Component;
import com.alejandromome.tekken8.domain.entities.Character;

@Component
public class CharacterMapperImpl implements CharacterMapper {
    @Override
    public CharacterDTO toDTO(Character character) {
        return CharacterDTO.builder().id(character.getId()).name(character.getName()).build();

    }
    @Override
    public Character toEntity(CharacterDTO characterDTO) {
        return null;
    }
}
