package com.alejandromome.tekken8.controllers;

import com.alejandromome.tekken8.dtos.MovesAnswer;
import com.alejandromome.tekken8.mappers.MoveMapper;
import com.alejandromome.tekken8.service.MoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/characters/{characterId}/moves")
@RequiredArgsConstructor
public class MoveController {
    private final MoveService moveService;
    private final MoveMapper moveMapper;

    @GetMapping
    public ResponseEntity <List<MovesAnswer>> getAllMoves(@PathVariable Long characterId){
        List<MovesAnswer> moves = moveService.findAllMovesByCharacterId(characterId).stream().map(moveMapper::transformToAnswer).toList();
        return ResponseEntity.ok(moves);
    }

}
