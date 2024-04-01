package swe6813team2.matchmakr.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import swe6813team2.matchmakr.models.Game;
import swe6813team2.matchmakr.repositories.GameRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService gameService;

    private Game game1;
    private Game game2;
    private List<Game> gameList;

    @BeforeEach
    public void setUp() {
        game1 = new Game(); // Set properties for game1
        game2 = new Game(); // Set properties for game2
        gameList = Arrays.asList(game1, game2);

        when(gameRepository.findAll()).thenReturn(gameList);
        when(gameRepository.findById(1L)).thenReturn(Optional.of(game1));
        when(gameRepository.findById(2L)).thenReturn(Optional.of(game2));
    }

    @Test
    public void getAllGames_ShouldReturnAllGames() {
        List<Game> result = gameService.getAllGames();
        verify(gameRepository, times(1)).findAll();
        assertEquals(gameList, result, "The returned game list should match the expected list");
    }

    @Test
    public void getGameById_WhenGameExists_ShouldReturnGame() {
        Optional<Game> result = gameService.getGameById(1L);
        verify(gameRepository, times(1)).findById(1L);
        assertTrue(result.isPresent(), "The result should be present");
        assertEquals(game1, result.get(), "The returned game should match game1");
    }

    @Test
    public void getGameById_WhenGameDoesNotExist_ShouldReturnEmpty() {
        Optional<Game> result = gameService.getGameById(3L);
        verify(gameRepository, times(1)).findById(3L);
        assertTrue(result.isEmpty(), "The result should be empty");
    }

    // Additional tests can be added here for other scenarios
}
