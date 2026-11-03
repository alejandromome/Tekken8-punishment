package com.alejandromome.tekken8.mappers;

import com.alejandromome.tekken8.domain.entities.Move;
import com.alejandromome.tekken8.dtos.MoveDTO;
import com.alejandromome.tekken8.dtos.MovesAnswer;

public interface MoveMapper {
    MoveDTO toDTO(Move move);
    MovesAnswer toAnswer(MovesAnswer movesAnswer);
    MovesAnswer transformToAnswer(Move move);
}
