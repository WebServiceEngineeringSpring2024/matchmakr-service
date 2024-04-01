package swe6813team2.matchmakr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swe6813team2.matchmakr.models.Personality;
import swe6813team2.matchmakr.models.User;
import swe6813team2.matchmakr.repositories.PersonalityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalityService {

    @Autowired
    private PersonalityRepository personalityRepository;

    public List<Personality> getAllPersonalities() {
        return personalityRepository.findAll();
    }
    
    public Optional<Personality> getPersonalityById(Long id) {
        return personalityRepository.findById(id);
    }
    
    public Personality savePersonality(Personality personality){
        return personalityRepository.save(personality);
    }
}
