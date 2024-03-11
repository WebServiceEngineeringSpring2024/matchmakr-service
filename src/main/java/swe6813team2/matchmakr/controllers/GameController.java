package swe6813team2.matchmakr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swe6813team2.matchmakr.models.Game;
import swe6813team2.matchmakr.services.GameService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        try {
            List<Game> games = gameService.getAllGames();

            if (games.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(games);
            }

            return ResponseEntity.ok(games);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        try {
            Optional<Game> optionalGame = gameService.getGameById(id);

            if (optionalGame.isPresent()) {
                Game game = optionalGame.get();

                // Log the content of the Game object
                System.out.println("Found Game for ID: " + id);
                System.out.println("Game Details: " + game);

                return ResponseEntity.ok(game);
            } else {
                System.out.println("Game not found for ID: " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Test endpoint for connectivity
    @GetMapping("/test")
    public String testEndpoint() {
        return "GameController is reachable. Your application is connected!";
    }
}
