package com.alejandromome.tekken8.controllers;

import com.alejandromome.tekken8.dtos.CharacterDTO;
import com.alejandromome.tekken8.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alejandromome.tekken8.mappers.CharacterMapper;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/characters")
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService characterService;
    private final CharacterMapper characterMapper;
    @GetMapping
    public ResponseEntity <List<CharacterDTO>> getAllCharacters()
    {List<CharacterDTO> characters = characterService.listCharacters().stream().map(characterMapper::toDTO).toList();
    return ResponseEntity.ok(characters);}

}
