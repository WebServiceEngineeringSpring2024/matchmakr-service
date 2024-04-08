package swe6813team2.matchmakr.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import swe6813team2.matchmakr.models.Game;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class GameRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GameRepository gameRepository;

    @Test
    void testSaveGame() {
        // Create a new game
        Game game = new Game();
        game.setName("Test Game");
        game.setDescription("This is a test game");

        // Save the game to the repository
        Game savedGame = gameRepository.save(game);

        // Verify that the game is saved with an ID
        assertTrue(savedGame.getId() > 0);

        // Retrieve the game from the repository
        Game retrievedGame = entityManager.find(Game.class, savedGame.getId());

        // Verify that the retrieved game matches the saved game
        assertEquals(savedGame, retrievedGame);
    }

    @Test
    void testFindAllGames() {
        // Create some test games
        Game game1 = new Game();
        game1.setName("Game 1");
        game1.setDescription("This is game 1");

        Game game2 = new Game();
        game2.setName("Game 2");
        game2.setDescription("This is game 2");

        // Save the games to the repository
        entityManager.persist(game1);
        entityManager.persist(game2);

        // Retrieve all games from the repository
        List<Game> games = gameRepository.findAll();

        // Verify that the correct number of games are retrieved
        assertEquals(2, games.size());

        // Verify that the retrieved games match the saved games
        assertTrue(games.contains(game1));
        assertTrue(games.contains(game2));
    }

    @Test
    void testFindById() {
        // Create a test game
        Game game = new Game();
        game.setName("Test Game");
        game.setDescription("This is a test game");

        // Save the game to the repository
        Game savedGame = entityManager.persist(game);

        // Retrieve the game by ID
        Game retrievedGame = gameRepository.findById(savedGame.getId()).orElse(null);

        // Verify that the retrieved game is not null
        assertNotNull(retrievedGame);

        // Verify that the retrieved game matches the saved game
        assertEquals(savedGame, retrievedGame);
    }

    @Test
    void testDeleteGame() {
        // Create a test game
        Game game = new Game();
        game.setName("Test Game");
        game.setDescription("This is a test game");

        // Save the game to the repository
        Game savedGame = entityManager.persist(game);

        // Delete the game from the repository
        gameRepository.delete(savedGame);

        // Verify that the game is no longer in the repository
        assertFalse(gameRepository.existsById(savedGame.getId()));
    }
}