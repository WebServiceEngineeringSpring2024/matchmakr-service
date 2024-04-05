package swe6813team2.matchmakr.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import swe6813team2.matchmakr.models.Party;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class PartyRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PartyRepository partyRepository;

    @Test
    void testFindPartyByName() {
        // Create a new party
        Party party = new Party();
        party.setName("Test Party");

        // Save the party to the repository
        entityManager.persist(party);

        // Find the party by name
        Optional<Party> foundParty = partyRepository.findPartyByName("Test Party");

        // Verify that the party is found
        assertTrue(foundParty.isPresent());
        assertEquals("Test Party", foundParty.get().getName());
    }

    @Test
    void testFindUsersByParty() {
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
