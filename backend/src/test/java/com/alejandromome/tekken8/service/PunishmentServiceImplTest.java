package com.alejandromome.tekken8.service;
import com.alejandromome.tekken8.*;
import com.alejandromome.tekken8.domain.entities.Character;
import com.alejandromome.tekken8.domain.entities.Move;
import com.alejandromome.tekken8.dtos.MovesAnswer;
import com.alejandromome.tekken8.mappers.MoveMapper;
import com.alejandromome.tekken8.repositories.CharacterRepository;
import com.alejandromome.tekken8.repositories.MoveRepository;
import com.alejandromome.tekken8.service.impl.PunishmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PunishmentServiceImplTest {
    @Mock
    private MoveRepository moveRepository;
    @Mock
    private CharacterRepository characterRepository;
    @Mock
    private MoveMapper moveMapper;
    @InjectMocks
    private PunishmentServiceImpl punishmentServiceImpl;

    @Test
    void frameTrapBlock() {
        Move attackingMove = new Move();
        attackingMove.setCleanBlockFrame(10);
        Move defendingMove = new Move();
        defendingMove.setCleanStartUp(10);
        Character defender = new Character();
        ArrayList<Move> mockList = new ArrayList<>();
        mockList.add(defendingMove);
        defender.setMoves(mockList);
        when(moveRepository.findById(12L)).thenReturn(Optional.of(attackingMove));
        when(characterRepository.findById(9L)).thenReturn(Optional.of(defender));

        List<MovesAnswer> result = punishmentServiceImpl.getBestMoves(9L, 12L);
        assertTrue(result.isEmpty());


    }

    @Test
    void punishmentExactFrames() {
        Move attackingMove = new Move();
        attackingMove.setCleanBlockFrame(-10);
        Move defendingMove = new Move();
        defendingMove.setCleanStartUp(10);
        Character defender = new Character();
        ArrayList<Move> mockList = new ArrayList<>();
        mockList.add(defendingMove);
        defender.setMoves(mockList);
        MovesAnswer movesAnswer = new MovesAnswer();

        when(moveRepository.findById(12L)).thenReturn(Optional.of(attackingMove));
        when(characterRepository.findById(9L)).thenReturn(Optional.of(defender));
        when(moveMapper.transformToAnswer(defendingMove)).thenReturn(movesAnswer);

        List<MovesAnswer> result = punishmentServiceImpl.getBestMoves(9L, 12L);
        assertEquals(1, result.size());
        assertNotNull(result.get(0));
        assertSame(movesAnswer, result.get(0));
    }

    @Test
    void slowerPunishmentMoves() {

        Move attackingMove = new Move();
        attackingMove.setCleanBlockFrame(-10);
        Move defendingMove = new Move();
        defendingMove.setCleanStartUp(12);
        Character defender = new Character();
        ArrayList<Move> mockList = new ArrayList<>();
        mockList.add(defendingMove);
        defender.setMoves(mockList);

        when(moveRepository.findById(12L)).thenReturn(Optional.of(attackingMove));
        when(characterRepository.findById(9L)).thenReturn(Optional.of(defender));

        List<MovesAnswer> result = punishmentServiceImpl.getBestMoves(9L, 12L);
        assertTrue(result.isEmpty());

    }

    @Test
    void correctSelectedMoves() {

        Move attackingMove = new Move();
        attackingMove.setCleanBlockFrame(-10);

        Move slowerMove = new Move();
        slowerMove.setCleanStartUp(12);

        Move fasterMove = new Move();
        fasterMove.setCleanStartUp(9);

        Move sameMove = new Move();
        sameMove.setCleanStartUp(10);

        Character defender = new Character();
        ArrayList<Move> mockList = new ArrayList<>();
        mockList.add(slowerMove);
        mockList.add(fasterMove);
        mockList.add(sameMove);
        defender.setMoves(mockList);
        MovesAnswer sameMoveAnswer = new MovesAnswer();
        MovesAnswer fasterMoveAnswer = new MovesAnswer();

        when(moveRepository.findById(12L)).thenReturn(Optional.of(attackingMove));
        when(characterRepository.findById(9L)).thenReturn(Optional.of(defender));
        when(moveMapper.transformToAnswer(sameMove)).thenReturn(sameMoveAnswer);
        when(moveMapper.transformToAnswer(fasterMove)).thenReturn(fasterMoveAnswer);
        List<MovesAnswer> result = punishmentServiceImpl.getBestMoves(9L, 12L);


        assertTrue(fasterMoveAnswer.equals(result.get(0)));
        assertTrue(sameMoveAnswer.equals(result.get(1)));

    }

}
