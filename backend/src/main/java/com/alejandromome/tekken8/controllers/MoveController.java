package com.alejandromome.tekken8.controllers;

import com.alejandromome.tekken8.domain.entities.Move;
import com.alejandromome.tekken8.dtos.CharacterDTO;
import com.alejandromome.tekken8.dtos.MoveDTO;
import com.alejandromome.tekken8.dtos.MovesAnswer;
import com.alejandromome.tekken8.mappers.MoveMapper;
import com.alejandromome.tekken8.repositories.CharacterRepository;
import com.alejandromome.tekken8.repositories.MoveRepository;
import com.alejandromome.tekken8.service.MoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alejandromome.tekken8.mappers.MoveMapper;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/characters/{characterId}/moves")
@RequiredArgsConstructor
public class MoveController {
    private final MoveService moveService;
    private final MoveMapper moveMapper;

    @GetMapping
    public ResponseEntity <List<MoveDTO>> getAllMoves(@PathVariable Long characterId){
        List<MoveDTO> moves = moveService.findAllMovesByCharacterId(characterId).stream().map(moveMapper::toDTO).toList();
        return ResponseEntity.ok(moves);
    }

}
