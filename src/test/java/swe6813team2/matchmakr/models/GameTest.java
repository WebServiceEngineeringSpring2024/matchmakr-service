package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private Game game;

    @BeforeEach
    public void init() {
        game = new Game();
    }

    @Test
    public void testId() {
        Long id = 1L;
        game.setId(id);
        assertEquals(id, game.getId());
    }

    @Test
    public void testName() {
        String name = "Test Game";
        game.setName(name);
        assertEquals(name, game.getName());
    }

    @Test
    public void testImage() {
        String image = "Test Image";
        game.setImage(image);
        assertEquals(image, game.getImage());
    }

    @Test
    public void testBanner() {
        String banner = "Test Banner";
        game.setBanner(banner);
        assertEquals(banner, game.getBanner());
    }

    @Test
    public void testDescription() {
        String description = "Test Description";
        game.setDescription(description);
        assertEquals(description, game.getDescription());
    }

    @Test
    public void testDeveloper() {
        String developer = "Test Developer";
        game.setDeveloper(developer);
        assertEquals(developer, game.getDeveloper());
    }

    @Test
    public void testPublisher() {
        String publisher = "Test Publisher";
        game.setPublisher(publisher);
        assertEquals(publisher, game.getPublisher());
    }

    @Test
    public void testMaxPlayers() {
        int maxPlayers = 4;
        game.setMaxPlayers(maxPlayers);
        assertEquals(maxPlayers, game.getMaxPlayers());
    }

    @Test
    public void testCreated() {
        Date created = new Date();
        game.setCreated(created);
        assertEquals(created, game.getCreated());
    }

    @Test
    public void testUpdated() {
        Date updated = new Date();
        game.setUpdated(updated);
        assertEquals(updated, game.getUpdated());
    }
}