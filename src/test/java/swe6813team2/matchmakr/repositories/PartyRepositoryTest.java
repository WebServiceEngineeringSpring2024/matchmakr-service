package swe6813team2.matchmakr.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import swe6813team2.matchmakr.models.Party;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ActiveProfiles("test")
public class PartyRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PartyRepository partyRepository;

    @Test
    public void testFindPartyByName() {
        // Create a new party
        Party party = new Party();
        party.setName("Test Party");

        // Save the party to the repository
        entityManager.persist(party);

        // Find the party by name
        Optional<Party> foundParty = partyRepository.findPartyByname("Test Party");

        // Verify that the party is found
        assertTrue(foundParty.isPresent());
        assertEquals("Test Party", foundParty.get().getName());
    }

    @Test
    public void testFindUsersByParty() {
        // Create a new party
        Party party = new Party();
        party.setName("Test Party");

        // Save the party to the repository
        entityManager.persist(party);

        // Find the users by party
        Optional<Party> foundUsers = partyRepository.findUsersByParty(party.getId());

        // Verify that the users are found
        assertTrue(foundUsers.isPresent());
        assertEquals(party.getId(), foundUsers.get().getId());
    }
}