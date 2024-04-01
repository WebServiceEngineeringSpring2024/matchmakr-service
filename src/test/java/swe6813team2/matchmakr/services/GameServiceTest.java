package swe6813team2.matchmakr.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import swe6813team2.matchmakr.models.Game;
import swe6813team2.matchmakr.repositories.GameRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameServiceTest {

    private GameService gameService;

    @Mock
    private GameRepository gameRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        gameService = new GameService(gameRepository);
    }

    @Test
    public void testGetAllGames() {
        // Arrange
        List<Game> games = new ArrayList<>();
        games.add(new Game(1L, "Game 1"));
        games.add(new Game(2L, "Game 2"));
        when(gameRepository.findAll()).thenReturn(games);

        // Act
        List<Game> result = gameService.getAllGames();

        // Assert
        assertEquals(games, result);
        verify(gameRepository, times(1)).findAll();
    }

    @Test
    public void testGetGameById() {
        // Arrange
        Long gameId = 1L;
        Game game = new Game(gameId, "Game 1");
        when(gameRepository.findById(gameId)).thenReturn(Optional.of(game));

        // Act
        Optional<Game> result = gameService.getGameById(gameId);

        // Assert
        assertEquals(Optional.of(game), result);
        verify(gameRepository, times(1)).findById(gameId);
    }
}