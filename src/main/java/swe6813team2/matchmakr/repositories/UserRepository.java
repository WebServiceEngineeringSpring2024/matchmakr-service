package swe6813team2.matchmakr.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import swe6813team2.matchmakr.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);

    Optional<User> findByEmail(String email);//custom method for finding by a specific variable/column name, the name of function must match model variable!
	
	@Query(
			nativeQuery = true,
			value = "SELECT u.* FROM user u " +
					"JOIN user me ON me.email = :uEmail " +
					"JOIN personality mp ON mp.id = me.personality " +
					"JOIN personality p ON p.id = u.personality " +
					"WHERE " +
					"u.online = 1 " +
					"AND p.aggression BETWEEN mp.aggression - 2 AND mp.aggression + 2 " +
					"AND p.kindness BETWEEN mp.kindness - 2 AND mp.kindness + 2 " +
					"AND p.competitiveness BETWEEN mp.competitiveness - 2 AND mp.competitiveness + 2 " +
					"AND u.id <> me.id " +
					"ORDER BY (ABS(mp.aggression - p.aggression) + ABS(mp.kindness - p.kindness) + ABS(mp.competitiveness - p.competitiveness)) / 3 " +
					"LIMIT 10;")
	List<User> findMatchingUsers(
			@Param("uEmail") String userEmail);

}