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
    
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/savePersonality")
    public ResponseEntity<Personality> insertPersonality(@RequestBody Personality newPersonality){
        try{
            Personality savedPersonality = personalityService.savePersonality(newPersonality);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPersonality);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
