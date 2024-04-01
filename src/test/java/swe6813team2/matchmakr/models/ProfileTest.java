package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTest {

    private Profile profile;

    @BeforeEach
    public void init() {
        profile = new Profile();
    }

    @Test
    public void testGetUserID() {
        long userID = 123456;
        assertEquals(userID, profile.getUserID());
    }

    @Test
    public void testSetUserID() {
        long userID = 7890;
        profile.setUserID(userID);
        assertEquals(userID, profile.getUserID());
    }
}