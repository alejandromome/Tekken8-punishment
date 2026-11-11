package com.alejandromome.tekken8.mappers.impl;
import com.alejandromome.tekken8.domain.entities.Move;
import com.alejandromome.tekken8.dtos.CharacterDTO;
import com.alejandromome.tekken8.dtos.MoveDTO;
import com.alejandromome.tekken8.dtos.MovesAnswer;
import com.alejandromome.tekken8.mappers.CharacterMapper;
import com.alejandromome.tekken8.mappers.MoveMapper;
import org.springframework.stereotype.Component;
import com.alejandromome.tekken8.domain.entities.Character;

@Component
public class MoveMapperImpl implements MoveMapper {

    @Override
    public MoveDTO toDTO(Move move) {
        return MoveDTO.builder().id(move.getId()).command(move.getCommand()).build();
    }

    @Override //eliminate?
    public MovesAnswer toAnswer(MovesAnswer movesAnswer) {
        return MovesAnswer.builder().name(movesAnswer.getName())
                .command(movesAnswer.getCommand())
                .hitLevel(movesAnswer.getHitLevel())
                .damage(movesAnswer.getDamage())
                .startFrame(movesAnswer.getStartFrame())
                .blockFrame(movesAnswer.getBlockFrame())
                .notes(movesAnswer.getNotes())
                .build();
    }

    @Override
    public MovesAnswer transformToAnswer(Move move) {
        return MovesAnswer.builder().id(move.getId()).name(
               move.getName())
                .command(move.getCommand())
                .hitLevel(move.getHitLevel())
                .damage(move.getDamage())
                .startFrame(move.getStartFrame())
                .blockFrame(move.getBlockFrame())
                .notes(move.getNotes())
                .build();
    }
}
