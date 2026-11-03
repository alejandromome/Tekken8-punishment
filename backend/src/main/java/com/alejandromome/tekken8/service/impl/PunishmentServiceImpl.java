package com.alejandromome.tekken8.service.impl;

import com.alejandromome.tekken8.domain.entities.Move;
import com.alejandromome.tekken8.dtos.MovesAnswer;
import com.alejandromome.tekken8.mappers.MoveMapper;
import com.alejandromome.tekken8.repositories.CharacterRepository;
import com.alejandromome.tekken8.repositories.MoveRepository;
import com.alejandromome.tekken8.service.MoveService;
import com.alejandromome.tekken8.service.PunishmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PunishmentServiceImpl implements PunishmentService {

    private final MoveRepository moveRepository;
    private final CharacterRepository characterRepository;
    private final MoveMapper moveMapper;

    @Override
    public List<MovesAnswer> getBestMoves(Long characterId, Long moveId) {
        Move chosedMove = moveRepository.findById(moveId).orElseThrow(() -> new RuntimeException("Move not found"));
        List<Move> moves = characterRepository.findById(characterId).get().getMoves();

        return movesAnswerlist(moves, chosedMove);
    }

    private List<MovesAnswer> movesAnswerlist(List<Move> moves, Move chosedMove) {

        return moves.stream().filter(move -> move.getCleanStartUp() != null
                && move.getCleanStartUp() <= Math.abs(chosedMove.getCleanBlockFrame())).map(moveMapper::transformToAnswer).toList();
    }
}
