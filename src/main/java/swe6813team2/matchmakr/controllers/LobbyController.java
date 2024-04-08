package swe6813team2.matchmakr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import swe6813team2.matchmakr.models.Lobby;
import swe6813team2.matchmakr.models.Personality;
import swe6813team2.matchmakr.models.User;
import swe6813team2.matchmakr.models.UserCredentials;
import swe6813team2.matchmakr.models.UserPersonality;
import swe6813team2.matchmakr.services.LobbyService;
import swe6813team2.matchmakr.services.PersonalityService;
import swe6813team2.matchmakr.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lobbies")

public class LobbyController {


    @Autowired
    private LobbyService lobbyService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private PersonalityService personalityService;

    @GetMapping("/matchUser/{userId}")
    public ResponseEntity<List<User>> getMatchingUsers(@PathVariable Long userId) {
    	try {
    		// Get user
    		Optional<User> optionalUser = userService.getUserById(userId);
    		User user = optionalUser.get();
    		// Get personality
    		Long userPersonalityId = user.getPersonality();
    		Optional<Personality> optionalPersonality = personalityService.getPersonalityById(userPersonalityId);
    		Personality personality = optionalPersonality.get();
    		// Get personality scores
    		Integer aScore = personality.getAggression();
    		Integer kScore = personality.getKindness();
    		Integer cScore = personality.getCompetitiveness();
    		
    		Integer range = 3; // how far to look above and below score for a match
    		Integer aScoreMin = aScore - range;
    		Integer aScoreMax = aScore + range;
    		Integer kScoreMin = kScore - range;
    		Integer kScoreMax = kScore + range;
    		Integer cScoreMin = cScore - range;
    		Integer cScoreMax = cScore + range;
    		
            List<User> users = lobbyService.getMatchingUsers(aScoreMin, aScoreMax, kScoreMin, kScoreMax, cScoreMin, cScoreMax);
            if (users.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(users);
            }
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
