package swe6813team2.matchmakr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swe6813team2.matchmakr.models.Party;
import swe6813team2.matchmakr.repositories.PartyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PartyService {

    @Autowired
    private PartyRepository partyRepository;

    public List<Party> getAllParties() {
        return partyRepository.findAll();
    }

    public Optional<Party> getPartyById(Long id) {
        return partyRepository.findById(id);
    }

    public Optional<Party> getPartyByName(String name) {
        return partyRepository.findPartyByName(name);
    }

    public Optional<Party> getUsernameByParty(Long id) {
        return partyRepository.findUsersByParty(id);
    }
}
