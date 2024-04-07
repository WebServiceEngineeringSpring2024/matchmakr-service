package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LobbyTest {

    private Lobby lobby;

    @BeforeEach
    public void init() {
        lobby = new Lobby();
    }

    @Test
    void testGameDefaultValue() {
        assertEquals(0, lobby.getGame());
    }

    @Test
    void testMaxPlayersDefaultValue() {
        assertEquals(0, lobby.getMaxPlayers());
    }

    @Test
    void testCreatedNotNull() {
        assertNotNull(lobby.getCreated());
    }

    @Test
    void testUpdatedNotNull() {
        assertNotNull(lobby.getUpdated());
    }

    @Test
    void testCreatedBeforeUpdated() {
        assertTrue(lobby.getCreated().getTime() <= lobby.getUpdated().getTime());
    }
}
