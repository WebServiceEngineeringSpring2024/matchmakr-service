package swe6813team2.matchmakr.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import swe6813team2.matchmakr.models.Party;

import java.util.Optional;

public interface PartyRepository extends JpaRepository<Party, Long> {
    Optional<Party> findPartyByname(String name);
    @Query(value = "SELECT p.user FROM party p WHERE p.party = :id", nativeQuery = true)
    Optional<Party> findUsersByParty(Long id);
}