package swe6813team2.matchmakr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swe6813team2.matchmakr.models.Personality;
import swe6813team2.matchmakr.models.User;
import swe6813team2.matchmakr.repositories.PersonalityRepository;
import swe6813team2.matchmakr.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PersonalityRepository personalityRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> login(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
    
    public Optional<User> updateUserPersonality(Long userId, Integer personalityId) {
    	Optional<User> user = userRepository.findById(userId);
    	Optional<Personality> myPersonality = personalityRepository.findById(personalityId);
    	if (user.isPresent() && myPersonality.isPresent()) {
    		user.orElseThrow().setPersonality(personalityId); //orElseThrow gets the instance of the optional class (aka the user)
    		return user;
    	}
    	return Optional.empty();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String userName){

        return userRepository.findByuserName(userName);
    }
    
    public Optional<User> getUserByEmail(String email){

        return userRepository.findByEmail(email);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
