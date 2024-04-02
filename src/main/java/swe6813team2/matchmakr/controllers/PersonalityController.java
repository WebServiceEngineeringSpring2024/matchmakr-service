package swe6813team2.matchmakr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import swe6813team2.matchmakr.models.Personality;
import swe6813team2.matchmakr.models.User;
import swe6813team2.matchmakr.services.PersonalityService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/personalities")
public class PersonalityController {

    @Autowired
    private PersonalityService personalityService;

    @GetMapping
    public ResponseEntity<List<Personality>> getAllPersonalities() {
        try {
            List<Personality> personalities = personalityService.getAllPersonalities();

            if (personalities.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personalities);
            }
            return ResponseEntity.ok(personalities);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    // edit this to insert a new personality every time
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/insertPersonality") // test this by post -> body -> fields to match MODEL variables
    public ResponseEntity<Personality> insertPersonality(@RequestBody Personality personality){
    	Optional<Personality> oldPersonality = personalityService.getPersonalityByScores(personality.getAggression(), personality.getKindness(), personality.getCompetitiveness());
    	// Check if personality with those scores already exists
    	if (oldPersonality == null) {
    		try{
                Personality savedPersonality = personalityService.savePersonality(personality);
                return ResponseEntity.status(HttpStatus.CREATED).body(savedPersonality);
            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
    	}
    	// return the id of the new personality
		return null;
    	
    }
}
