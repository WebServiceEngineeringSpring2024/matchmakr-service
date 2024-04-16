package swe6813team2.matchmakr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import swe6813team2.matchmakr.models.User;
import swe6813team2.matchmakr.services.LobbyService;


import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/lobbies")

public class LobbyController {


    @Autowired
    private LobbyService lobbyService;

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/matchUser/{userEmail}")
    public ResponseEntity<List<User>> getMatchingUsers(@PathVariable String userEmail) {
        try {
            List<User> users = lobbyService.getMatchingUsers(userEmail);
            if (users.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(users);
            }
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
