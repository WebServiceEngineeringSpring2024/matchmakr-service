package swe6813team2.matchmakr.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import swe6813team2.matchmakr.models.Lobby;
import swe6813team2.matchmakr.models.User;

import java.util.List;
import java.util.Optional;

public interface LobbyRepository extends JpaRepository<Lobby, Long> {
	Optional<Lobby> findById(Integer id);
	
	
	
	
	/*value = "SELECT * FROM user u "
	+ "INNER JOIN personality p ON u.personality = p.id "
	+ "WHERE u.online = 1 "
	+ "and p.aggression = 1 "
	+ "and p.kindness = 2"
	+ "and p.competitiveness = 3;")*/
	//+ "u.personality=:personalityId")
}