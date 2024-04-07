package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class GameLobbyTypeTest {

    private GameLobbyType.GameLobbyTypeId id;
    private GameLobbyType gameLobbyType1;
    private GameLobbyType gameLobbyType2;

    @BeforeEach
    public void init() {
        id = new GameLobbyType.GameLobbyTypeId();

        gameLobbyType1 = new GameLobbyType();
        gameLobbyType1.setId(id);

        gameLobbyType2 = new GameLobbyType();
        gameLobbyType2.setId(id);
    }

    @Test
    void testEquals() {
        assertEquals(gameLobbyType1, gameLobbyType2);
    }

    @Test
    void testNotEquals() {
        GameLobbyType.GameLobbyTypeId differentId = new GameLobbyType.GameLobbyTypeId();

        GameLobbyType differentGameLobbyType = new GameLobbyType();
        differentGameLobbyType.setId(differentId);

        assertNotEquals(gameLobbyType1, differentGameLobbyType);
    }

    @Test
    void testHashCode() {
        assertEquals(Objects.hash(id), gameLobbyType1.hashCode());
    }
}
