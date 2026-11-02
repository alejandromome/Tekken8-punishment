package com.alejandromome.tekken8.mappers;

import com.alejandromome.tekken8.dtos.CharacterDTO;

public interface CharacterMapper {
    CharacterDTO  toDTO(Character character);
    Character  toEntity(CharacterDTO characterDTO);
}
