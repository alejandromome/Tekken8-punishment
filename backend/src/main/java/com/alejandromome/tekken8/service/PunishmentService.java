package com.alejandromome.tekken8.service;

import com.alejandromome.tekken8.domain.entities.Move;
import com.alejandromome.tekken8.dtos.MovesAnswer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PunishmentService {
    List<MovesAnswer> getBestMoves(Long characterId, Long moveId);
}
