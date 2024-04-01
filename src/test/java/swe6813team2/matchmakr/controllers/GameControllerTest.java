package swe6813team2.matchmakr.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import swe6813team2.matchmakr.models.Game;
import swe6813team2.matchmakr.services.GameService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class GameControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GameService gameService;

    @InjectMocks
    private GameController gameController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(gameController).build();
    }

    @Test
    public void getAllGames_ShouldReturnGamesList() throws Exception {
        Game game1 = new Game(); // Set properties for game1
        Game game2 = new Game(); // Set properties for game2
        List<Game> games = Arrays.asList(game1, game2);

        given(gameService.getAllGames()).willReturn(games);

        mockMvc.perform(get("/games"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").isNotEmpty())
                .andExpect(jsonPath("$[1]").isNotEmpty());

        verify(gameService, times(1)).getAllGames();
    }

    @Test
    public void getGameById_ShouldReturnGame() throws Exception {
        Long gameId = 1L;
        Game game = new Game(); // Set properties for game
        given(gameService.getGameById(gameId)).willReturn(Optional.of(game));

        mockMvc.perform(get("/games/{id}", gameId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(gameId));

        verify(gameService, times(1)).getGameById(gameId);
    }

    // Additional tests can be added here for other scenarios like not found, server error, etc.
}
