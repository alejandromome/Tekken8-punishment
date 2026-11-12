package com.alejandromome.tekken8.service;
import com.alejandromome.tekken8.*;
import com.alejandromome.tekken8.domain.entities.Character;
import com.alejandromome.tekken8.domain.entities.Move;
import com.alejandromome.tekken8.mappers.MoveMapper;
import com.alejandromome.tekken8.repositories.CharacterRepository;
import com.alejandromome.tekken8.repositories.MoveRepository;
import com.alejandromome.tekken8.service.impl.MoveServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MoveServiceImplTest {
    @Mock
    private MoveRepository moveRepository;
    @Mock
    private CharacterRepository characterRepository;
    @Mock
    private MoveMapper moveMapper;
    @InjectMocks
    private MoveServiceImpl moveServiceImpl;

    @Test
    void correctParse() throws IOException {
        Character character = new Character();
        character.setName("Yoshimitsu");
        Integer rows = 0;
        String mockCSV="Name,Command,Hit level,Damage,Start up frame,Block frame,Hit frame,Notes\n" +
                "Test Move,\"df+1, 1+2\",High,20,12,-10,+5,\n"+
                "Test Move 2,df+2,Mid,25,15,,+6,";
        InputStream inputStream = new ByteArrayInputStream(mockCSV.getBytes(StandardCharsets.UTF_8));
        when(characterRepository.findByName("Yoshimitsu")).thenReturn(Optional.of(character));
        rows=moveServiceImpl.importMoves(inputStream, "Yoshimitsu");
        assertEquals(2, rows);
        ArgumentCaptor<Move> argumentCaptor = ArgumentCaptor.forClass(Move.class);
        verify(moveRepository, times(2)).save(argumentCaptor.capture());
        List<Move> savedMove = argumentCaptor.getAllValues();
        assertEquals("df+1, 1+2", savedMove.get(0).getCommand());
        assertEquals(-10, savedMove.get(0).getCleanBlockFrame());


        assertEquals("df+2", savedMove.get(1).getCommand());
        assertNull(savedMove.get(1).getCleanBlockFrame());
    }


}
