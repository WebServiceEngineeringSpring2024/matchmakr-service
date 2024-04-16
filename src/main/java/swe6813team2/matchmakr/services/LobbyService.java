package swe6813team2.matchmakr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swe6813team2.matchmakr.models.Lobby;
import swe6813team2.matchmakr.models.User;
import swe6813team2.matchmakr.repositories.LobbyRepository;
import swe6813team2.matchmakr.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LobbyService {

	@Autowired
	private LobbyRepository lobbyRepository;
	
	@Autowired
	private UserRepository userRepository;

	public List<Lobby> getAllLobbies() {
		return lobbyRepository.findAll();
	}

	public Optional<Lobby> getLobbyById(Integer id) {
		return lobbyRepository.findById(id);
	}

	public Lobby saveLobby(Lobby lobby) {
		return lobbyRepository.save(lobby);
	}
	
	public List<User> getMatchingUsers(String userEmail) {
		return userRepository.findMatchingUsers(userEmail);
	}
}
