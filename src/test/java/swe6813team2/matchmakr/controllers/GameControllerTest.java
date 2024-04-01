package swe6813team2.matchmakr.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import swe6813team2.matchmakr.models.Game;
import swe6813team2.matchmakr.services.GameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GameControllerTest {

    @Mock
    private GameService gameService;

    @InjectMocks
    private GameController gameController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllGames() {
        // Arrange
        List<Game> games = new ArrayList<>();
        games.add(new Game());
        games.add(new Game());

        when(gameService.getAllGames()).thenReturn(games);

        // Act
        ResponseEntity<List<Game>> response = gameController.getAllGames();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(games, response.getBody());
    }

    @Test
    public void testGetAllGames_NoContent() {
        // Arrange
        List<Game> games = new ArrayList<>();

        when(gameService.getAllGames()).thenReturn(games);

        // Act
        ResponseEntity<List<Game>> response = gameController.getAllGames();

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(games, response.getBody());
    }

    @Test
    public void testGetAllGames_Exception() {
        // Arrange
        when(gameService.getAllGames()).thenThrow(new RuntimeException());

        // Act
        ResponseEntity<List<Game>> response = gameController.getAllGames();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    public void testGetGameById() {
        // Arrange
        Long gameId = 1L;
        Game game = new Game();

        when(gameService.getGameById(gameId)).thenReturn(Optional.of(game));

        // Act
        ResponseEntity<Game> response = gameController.getGameById(gameId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(game, response.getBody());
    }

    @Test
    public void testGetGameById_NotFound() {
        // Arrange
        Long gameId = 1L;

        when(gameService.getGameById(gameId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Game> response = gameController.getGameById(gameId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    public void testGetGameById_Exception() {
        // Arrange
        Long gameId = 1L;

        when(gameService.getGameById(gameId)).thenThrow(new RuntimeException());

        // Act
        ResponseEntity<Game> response = gameController.getGameById(gameId);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
}