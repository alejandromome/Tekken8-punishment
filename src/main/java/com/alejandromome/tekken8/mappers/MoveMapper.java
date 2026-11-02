package com.alejandromome.tekken8.mappers;

import com.alejandromome.tekken8.domain.entities.Move;
import com.alejandromome.tekken8.dtos.MoveDTO;

public interface MoveMapper {
    MoveDTO toDTO(Move move);
    Move toEntity(MoveDTO moveDTO);
}
