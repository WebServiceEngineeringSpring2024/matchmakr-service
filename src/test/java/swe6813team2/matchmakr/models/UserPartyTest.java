package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserPartyTest {

    @Test
    public void testGetUser() {
        UserParty userParty = new UserParty();
        userParty.setUser(1L);

        assertEquals(1L, userParty.getUser());
    }

    @Test
    public void testGetParty() {
        UserParty userParty = new UserParty();
        userParty.setParty(2L);

        assertEquals(2L, userParty.getParty());
    }
}