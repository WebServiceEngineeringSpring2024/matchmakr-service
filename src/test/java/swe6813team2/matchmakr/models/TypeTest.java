package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class TypeTest {

    @Test
    public void testTypeCreation() {
        Type type = new Type();
        assertNotNull(type.getId());
        assertNotNull(type.getName());
        assertNotNull(type.getCreated());
        assertNotNull(type.getUpdated());
    }

    @Test
    public void testTypeCreationWithDefaultValues() {
        Type type = new Type();
        assertEquals(new Date(), type.getCreated());
        assertEquals(new Date(), type.getUpdated());
    }
}