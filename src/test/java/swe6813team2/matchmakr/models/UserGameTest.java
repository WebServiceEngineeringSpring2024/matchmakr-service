package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserGameTest {

    @Test
    void testUserGameCreation() {
        UserGame userGame = new UserGame();
        assertNotNull(userGame);
    }

    @Test
    void testUserGameSettersAndGetters() {
        UserGame userGame = new UserGame();
        Long userId = 1L;
        Long gameId = 2L;

        userGame.setUser(userId);
        userGame.setGame(gameId);

        assertEquals(userId, userGame.getUser());
        assertEquals(gameId, userGame.getGame());
    }
}
