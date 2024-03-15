package swe6813team2.matchmakr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swe6813team2.matchmakr.models.Party;
import swe6813team2.matchmakr.services.PartyService;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://our front end url goes here")
@RequestMapping("/party")
public class PartyController {

    @Autowired
    private PartyService partyService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Party>> getAllUsersInAParty(@PathVariable Long id) {
        try {
            Optional<Party> party = partyService.getUsernameByParty(id);

            if (party.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(party);
            }
            return ResponseEntity.ok(party);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
