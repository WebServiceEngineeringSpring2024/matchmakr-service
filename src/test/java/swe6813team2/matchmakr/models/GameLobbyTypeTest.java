package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class GameLobbyTypeTest {

    private GameLobbyType.GameLobbyTypeId id;
    private GameLobbyType gameLobbyType1;
    private GameLobbyType gameLobbyType2;

    @BeforeEach
    public void init() {
        id = new GameLobbyType.GameLobbyTypeId();
        id.setGame(1);
        id.setType(2);

        gameLobbyType1 = new GameLobbyType();
        gameLobbyType1.setId(id);

        gameLobbyType2 = new GameLobbyType();
        gameLobbyType2.setId(id);
    }

    @Test
    public void testEquals() {
        assertEquals(gameLobbyType1, gameLobbyType2);
    }

    @Test
    public void testNotEquals() {
        GameLobbyType.GameLobbyTypeId differentId = new GameLobbyType.GameLobbyTypeId();
        differentId.setGame(3);
        differentId.setType(4);

        GameLobbyType differentGameLobbyType = new GameLobbyType();
        differentGameLobbyType.setId(differentId);

        assertNotEquals(gameLobbyType1, differentGameLobbyType);
    }

    @Test
    public void testHashCode() {
        assertEquals(Objects.hash(id), gameLobbyType1.hashCode());
    }
}