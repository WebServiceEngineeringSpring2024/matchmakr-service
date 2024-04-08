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
		value = "SELECT u.* FROM user u "
		+ "INNER JOIN personality p ON u.personality = p.id "
		+ "WHERE u.online = 1 "
		+ "and p.aggression BETWEEN :aScoreMin AND :aScoreMax "
		+ "and p.kindness BETWEEN :kScoreMin AND :kScoreMax "
		+ "and p.competitiveness BETWEEN :cScoreMin AND :cScoreMax ")
	List<User> findMatchingUsers(
		@Param("aScoreMin") Integer aScoreMin,
		@Param("aScoreMax") Integer aScoreMax,
		@Param("kScoreMin") Integer kScoreMin,
		@Param("kScoreMax") Integer kScoreMax,
		@Param("cScoreMin") Integer cScoreMin,
		@Param("cScoreMax") Integer cScoreMax);
	
}