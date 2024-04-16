package swe6813team2.matchmakr.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import swe6813team2.matchmakr.models.Lobby;

import java.util.Optional;

public interface LobbyRepository extends JpaRepository<Lobby, Long> {
	Optional<Lobby> findById(Integer id);
}