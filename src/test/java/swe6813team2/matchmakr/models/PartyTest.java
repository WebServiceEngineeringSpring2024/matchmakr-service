package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartyTest {

    private Party party;

    @BeforeEach
    public void init() {
        party = new Party();
    }

    @Test
    public void testId() {
        Long id = 1L;
        party.setId(id);
        assertEquals(id, party.getId());
    }

    @Test
    public void testName() {
        String name = "Test Party";
        party.setName(name);
        assertEquals(name, party.getName());
    }

    @Test
    public void testLobby() {
        Integer lobby = 5;
        party.setLobby(lobby);
        assertEquals(lobby, party.getLobby());
    }

    @Test
    public void testCreated() {
        Date created = new Date();
        party.setCreated(created);
        assertEquals(created, party.getCreated());
    }

    @Test
    public void testUpdated() {
        Date updated = new Date();
        party.setUpdated(updated);
        assertEquals(updated, party.getUpdated());
    }
}