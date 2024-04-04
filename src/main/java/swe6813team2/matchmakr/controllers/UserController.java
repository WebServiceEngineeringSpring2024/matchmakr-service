package swe6813team2.matchmakr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import swe6813team2.matchmakr.models.User;
import swe6813team2.matchmakr.models.UserCredentials;
import swe6813team2.matchmakr.models.UserPersonality;
import swe6813team2.matchmakr.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();

            if (users.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(users);
            }
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/register")
    public ResponseEntity<User> insertUser(@RequestBody User newUser){
        try{
        	// set online to 1
        	newUser.setOnline(1);
            User savedUser = userService.saveUser(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/name/{userName}")
    public ResponseEntity<User> getUserByName(@PathVariable String userName){
        try{
            Optional<User> optionalUsername = userService.getUserByUsername(userName);
            User user = optionalUsername.get();
            return ResponseEntity.ok(user);
        } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(new HttpHeaders()).body(null);
    }
    }
    
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<String> postLogin(@RequestBody UserCredentials userCredentials) {
        String email = userCredentials.getEmail();
        String password = userCredentials.getPassword();
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        Optional<User> authenticatedUser = userService.login(email, password);
        if (authenticatedUser.isPresent()) {
        	// get user by email, set online status
        	// note: this should work since login must be a success here
        	User user = userService.getUserByEmail(email).get();
        	user.setOnline(1);
        	// save user with status of 1 for online
        	userService.saveUser(user);
            // return back ID to be used in checking personality
            return ResponseEntity.ok("" + user.getId());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        try {
            Optional<User> optionalUser = userService.getUserByEmail(email);

            if (optionalUser.isPresent()) {
                User user = optionalUser.get();

                System.out.println("Found User for email: " + email);
                System.out.println("User Details: " + user);

                return ResponseEntity.ok(user);
            } else {
                System.out.println("User not found for email: " + email);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        try {
            Optional<User> optionalUser = userService.getUserById(id);

            if (optionalUser.isPresent()) {
                User user = optionalUser.get();

                System.out.println("Found User for ID: " + id);
                System.out.println("User Details: " + user);

                return ResponseEntity.ok(user);
            } else {
                System.out.println("User not found for ID: " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @PostMapping("/signout/email")
    public ResponseEntity<String> postSignOutByEmail(@RequestBody UserCredentials userCredentials) {
        try {
        	String email = userCredentials.getEmail();
            System.out.println("Signing out email: " + email);
            Optional<User> findUser = userService.getUserByEmail(email);
            User user = findUser.get();
            if (user.getOnline() != 0) {
            	user.setOnline(0);
                userService.saveUser(user);
                return ResponseEntity.ok("");
            }
            else {
            	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is already signed out");
            }
            
        } catch (Exception e) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error signing out");
        }
    	
    }
}
