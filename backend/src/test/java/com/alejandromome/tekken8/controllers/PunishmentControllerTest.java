package com.alejandromome.tekken8.controllers;
import com.alejandromome.tekken8.*;
import com.alejandromome.tekken8.dtos.MovesAnswer;
import com.alejandromome.tekken8.mappers.CharacterMapper;
import com.alejandromome.tekken8.mappers.MoveMapper;
import com.alejandromome.tekken8.service.CharacterService;
import com.alejandromome.tekken8.service.PunishmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PunishmentController.class)
public class PunishmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PunishmentService punishmentService;

    @MockitoBean
    private CharacterService characterService;

    @MockitoBean
    private CharacterMapper characterMapper;

    @MockitoBean
    private MoveMapper moveMapper;

    @Test
    void getBestMovesTest() throws Exception {
        List<MovesAnswer> movesAnswers = new java.util.ArrayList<>(List.of());
        MovesAnswer mockAnswer = new MovesAnswer();
        movesAnswers.add(mockAnswer);
        when(punishmentService.getBestMoves(10L, 20L)).thenReturn(movesAnswers);
        mockMvc.perform(get("/api/v1/punishments").param("characterId", "10").param("moveId", "20")).andExpect(status().isOk());
        verify(punishmentService, times(1)).getBestMoves(10L, 20L);

    }
}
