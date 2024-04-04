package swe6813team2.matchmakr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import swe6813team2.matchmakr.models.Personality;
import swe6813team2.matchmakr.models.User;

import swe6813team2.matchmakr.models.UserPersonality;
import swe6813team2.matchmakr.services.PersonalityService;
import swe6813team2.matchmakr.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/personalities")
public class PersonalityController {

    @Autowired
    private PersonalityService personalityService;
    
    @Autowired
    private UserService userService;
    
    // Creates a new personality, inserts it into Personality table, and links its id to a user
    @PostMapping("/insert")
    public ResponseEntity<User> insertPersonality(@RequestBody  UserPersonality userPersonality){
        // attempt to update the user table and link personality id to it
        try{
        	// Save personality to personality table
        	Personality newPersonality = new Personality(userPersonality.getAgression(), userPersonality.getKindness(), userPersonality.getCompetitiveness());
    		Personality savedPersonality = personalityService.savePersonality(newPersonality);
    		// link personalityId with user table
        	Long userId = userService.getUserByEmail(userPersonality.getEmail()).get().getId();
        	Long personalityId = savedPersonality.getId();
        	if (userId != null && personalityId != null) {
        		User user = userService.updateUserPersonalityById(userId, personalityId);
        		User savedUser = userService.saveUser(user);
        		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        	}
        	else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Personality> getPersonalityByUserId(@PathVariable Long id) {
    	try {
    		// get user with id,
    		Optional<User> optionalUser = userService.getUserById(id);
    		if (!optionalUser.isPresent()) {
    			System.out.println("User not found for ID: " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    		}
    		// get personalityID from user,
    		Long personality = optionalUser.get().getPersonality();
    		if (personality == null || personality == 0) {
    			System.out.println("User found but has no personality: " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    		}
    		// get personality with this personalityID,
    		Optional<Personality> optionalP = personalityService.getPersonalityById(personality);
    		if (!optionalP.isPresent()) {
    			System.out.println("User found, but personality not found: " + personality);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    		}
    		
    		// return personality
    		Personality result = optionalP.get();
    		return ResponseEntity.ok(result);
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    	}
    }
}
