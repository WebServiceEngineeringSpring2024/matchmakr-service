package swe6813team2.matchmakr.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import swe6813team2.matchmakr.models.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}