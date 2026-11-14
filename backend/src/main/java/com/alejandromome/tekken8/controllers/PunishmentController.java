package com.alejandromome.tekken8.controllers;

import com.alejandromome.tekken8.dtos.MovesAnswer;
import com.alejandromome.tekken8.mappers.CharacterMapper;
import com.alejandromome.tekken8.service.CharacterService;
import com.alejandromome.tekken8.service.PunishmentService;
import com.alejandromome.tekken8.mappers.MoveMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/punishments")
@RequiredArgsConstructor
public class PunishmentController {
    private final PunishmentService punishmentService;
    @GetMapping
    ResponseEntity <List<MovesAnswer>> getBestMoves(@RequestParam Long characterId, @RequestParam Long moveId)
    {
        List<MovesAnswer> bestMoves = punishmentService.getBestMoves(characterId, moveId).stream().toList();

        return ResponseEntity.ok(bestMoves);
    }

}
