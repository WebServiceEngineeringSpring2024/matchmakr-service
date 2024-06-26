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

    public User updateUserPersonalityById(Long userId, Long personalityId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Personality> optionalPersonality = personalityRepository.findById(personalityId);
        if (optionalUser.isPresent() && optionalPersonality.isPresent()) {
            User user = optionalUser.get();
            user.setPersonality(personalityId);
            return user;
        }
        return null;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String userName){

        return userRepository.findByUserName(userName);
    }
    
    public Optional<User> getUserByEmail(String email){

        return userRepository.findByEmail(email);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
