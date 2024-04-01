package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UserGameTest {

    @Test
    public void testUserGameCreation() {
        UserGame userGame = new UserGame();
        assertNotNull(userGame.getUser());
        assertNotNull(userGame.getGame());
    }

    @Test
    public void testUserGameSettersAndGetters() {
        UserGame userGame = new UserGame();
        Long userId = 1L;
        Long gameId = 2L;

        userGame.setUser(userId);
        userGame.setGame(gameId);

        assertEquals(userId, userGame.getUser());
        assertEquals(gameId, userGame.getGame());
    }
}