package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonalityTest {

    private Personality personality;

    @BeforeEach
    public void init() {
        personality = new Personality();
    }

    @Test
    public void testId() {
        Long id = 1L;
        personality.setId(id);
        assertEquals(id, personality.getId());
    }

    @Test
    public void testAggression() {
        int aggression = 5;
        personality.setAggression(aggression);
        assertEquals(aggression, personality.getAggression());
    }

    @Test
    public void testKindness() {
        int kindness = 3;
        personality.setKindness(kindness);
        assertEquals(kindness, personality.getKindness());
    }

    @Test
    public void testCompetitiveness() {
        int competitiveness = 7;
        personality.setCompetitiveness(competitiveness);
        assertEquals(competitiveness, personality.getCompetitiveness());
    }

    @Test
    public void testCreated() {
        Date created = new Date();
        personality.setCreated(created);
        assertEquals(created, personality.getCreated());
    }

    @Test
    public void testUpdated() {
        Date updated = new Date();
        personality.setUpdated(updated);
        assertEquals(updated, personality.getUpdated());
    }
}