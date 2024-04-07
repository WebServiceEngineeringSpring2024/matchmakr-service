package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserCredentialsTest {

    @Test
    public void testGetEmail() {
        UserCredentials credentials = new UserCredentials();
        credentials.setEmail("test@example.com");
        assertEquals("test@example.com", credentials.getEmail());
    }

    @Test
    public void testGetPassword() {
        UserCredentials credentials = new UserCredentials();
        credentials.setPassword("password123");
        assertEquals("password123", credentials.getPassword());
    }
}