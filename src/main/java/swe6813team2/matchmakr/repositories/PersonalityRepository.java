package swe6813team2.matchmakr.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import swe6813team2.matchmakr.models.Personality;

import java.util.Optional;

public interface PersonalityRepository extends JpaRepository<Personality, Long> {
	Optional<Personality> findById(Integer id);
}