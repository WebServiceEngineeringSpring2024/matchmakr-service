package swe6813team2.matchmakr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import swe6813team2.matchmakr.models.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	
}
