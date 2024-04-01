package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LobbyTest {

    private Lobby lobby;

    @BeforeEach
    public void init() {
        lobby = new Lobby();
    }

    @Test
    public void testIdNotNull() {
        assertNotNull(lobby.getId());
    }

    @Test
    public void testGameDefaultValue() {
        assertEquals(0, lobby.getGame());
    }

    @Test
    public void testMaxPlayersDefaultValue() {
        assertEquals(0, lobby.getMaxPlayers());
    }

    @Test
    public void testCreatedNotNull() {
        assertNotNull(lobby.getCreated());
    }

    @Test
    public void testUpdatedNotNull() {
        assertNotNull(lobby.getUpdated());
    }

    @Test
    public void testCreatedBeforeUpdated() {
        assertTrue(lobby.getCreated().before(lobby.getUpdated()));
    }
}