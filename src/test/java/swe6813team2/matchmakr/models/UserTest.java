package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    private User user;

    @BeforeEach
    public void init() {
        user = new User();
    }

    @Test
    public void testId() {
        Long id = 1L;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    public void testUserName() {
        String userName = "TestUser";
        user.setUserName(userName);
        assertEquals(userName, user.getUserName());
    }

    @Test
    public void testPassword() {
        String password = "TestPassword";
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }

    @Test
    public void testEmail() {
        String email = "test@example.com";
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }

    @Test
    public void testOnline() {
        int online = 1;
        user.setOnline(online);
        assertEquals(online, user.getOnline());
    }

    @Test
    public void testLanguage() {
        String language = "English";
        user.setLanguage(language);
        assertEquals(language, user.getLanguage());
    }

    @Test
    public void testCity() {
        String city = "TestCity";
        user.setCity(city);
        assertEquals(city, user.getCity());
    }

    @Test
    public void testState() {
        String state = "TestState";
        user.setState(state);
        assertEquals(state, user.getState());
    }

    @Test
    public void testCountry() {
        String country = "TestCountry";
        user.setCountry(country);
        assertEquals(country, user.getCountry());
    }

    @Test
    public void testPersonality() {
        Integer personality = 5;
        user.setPersonality(personality);
        assertEquals(personality, user.getPersonality());
    }

    @Test
    public void testCreated() {
        Date created = new Date();
        user.setCreated(created);
        assertEquals(created, user.getCreated());
    }

    @Test
    public void testUpdated() {
        Date updated = new Date();
        user.setUpdated(updated);
        assertEquals(updated, user.getUpdated());
    }
}