package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testGameConstructor() {
        Game game = new Game();
        assertNotNull(game.getCreated(), "Created date should be initialized");
        assertNotNull(game.getUpdated(), "Updated date should be initialized");
        assertEquals(game.getCreated(), game.getUpdated(), "Created and updated dates should be the same upon initialization");
    }

    // Additional tests can be added here for any public methods that you create in the Game class.
}
