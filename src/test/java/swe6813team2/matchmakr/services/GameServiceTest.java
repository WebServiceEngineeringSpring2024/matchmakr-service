package swe6813team2.matchmakr.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import swe6813team2.matchmakr.models.Game;
import swe6813team2.matchmakr.repositories.GameRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GameServiceTest {

    @InjectMocks
    private GameService gameService;

    @Mock
    private GameRepository gameRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllGames() {
        // Arrange
        List<Game> games = new ArrayList<>();
        games.add(new Game());
        games.add(new Game());
        when(gameRepository.findAll()).thenReturn(games);

        // Act
        List<Game> result = gameService.getAllGames();

        // Assert
        assertEquals(games, result);
        verify(gameRepository, times(1)).findAll();
    }

    @Test
    void testGetGameById() {
        // Arrange
        Long gameId = 1L;
        Game game = new Game();
        game.setId(gameId);
        when(gameRepository.findById(gameId)).thenReturn(Optional.of(game));

        // Act
        Optional<Game> result = gameService.getGameById(gameId);

        // Assert
        assertEquals(Optional.of(game), result);
        verify(gameRepository, times(1)).findById(gameId);
    }
}
