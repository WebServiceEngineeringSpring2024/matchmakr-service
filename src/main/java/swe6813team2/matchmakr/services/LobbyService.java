package swe6813team2.matchmakr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import swe6813team2.matchmakr.models.Lobby;
import swe6813team2.matchmakr.models.User;
import swe6813team2.matchmakr.repositories.LobbyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LobbyService {

	@Autowired
	private LobbyRepository lobbyRepository;

	public List<Lobby> getAllLobbies() {
		return lobbyRepository.findAll();
	}

	public Optional<Lobby> getLobbyById(Integer id) {
		return lobbyRepository.findById(id);
	}

	public Lobby saveLobby(Lobby lobby) {
		return lobbyRepository.save(lobby);
	}
	
	@Query("SELECT *u FROM user U WHERE u.online = 1")
	public List<User> getUsersWithMatchingPersonalities(Long userId) {
		// https://www.baeldung.com/spring-data-jpa-query

	}
}
