package swe6813team2.matchmakr.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import swe6813team2.matchmakr.models.Party;

import java.util.Optional;

public interface PartyRepository extends JpaRepository<Party, Long> {
    Optional<Party> findPartyByName(String name);

    @Query(value = "SELECT p.user FROM party p WHERE p.party = :id", nativeQuery = true)
    // TODO: @Query(value = "SELECT up.user FROM userParty up WHERE up.party = :id", nativeQuery = true)
    // TODO: once someone figures out that party doesn't have a user field and fixes this query, enable the test in PartyRepositoryTest.java
    Optional<Party> findUsersByParty(Long id);
}
