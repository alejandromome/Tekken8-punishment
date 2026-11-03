package com.alejandromome.tekken8.service;

import com.alejandromome.tekken8.domain.entities.Move;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;


public interface MoveService {
    Move createMove(Move move);
    Move updateMove(Move move);
    void deleteMoveById(Long i);
    Optional<Move>  findById(Long id);
    Integer importMoves(InputStream stream, String characterName) throws IOException;
    List<Move> findAllMoves();
    List<Move> findAllMovesByCharacterId(Long id);

}
