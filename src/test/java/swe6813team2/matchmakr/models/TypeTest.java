package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TypeTest {

    @Test
    void testTypeCreation() {
        Type type = new Type();
        assertNotNull(type);
    }

    @Test
    void testTypeCreationWithDefaultValues() {
        Type type = new Type();
        assertEquals(new Date(), type.getCreated());
        assertEquals(new Date(), type.getUpdated());
    }
}
