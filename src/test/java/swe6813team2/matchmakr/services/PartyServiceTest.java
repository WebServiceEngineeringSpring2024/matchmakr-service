package swe6813team2.matchmakr.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import swe6813team2.matchmakr.models.Party;
import swe6813team2.matchmakr.repositories.PartyRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PartyServiceTest {

    @Mock
    private PartyRepository partyRepository;

    @InjectMocks
    private PartyService partyService;

    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllParties() {
        // Arrange
        List<Party> expectedParties = Arrays.asList(new Party(), new Party());
        when(partyRepository.findAll()).thenReturn(expectedParties);

        // Act
        List<Party> actualParties = partyService.getAllParties();

        // Assert
        assertEquals(expectedParties, actualParties);
        verify(partyRepository, times(1)).findAll();
    }

    @Test
    public void testGetPartyById() {
        // Arrange
        Long partyId = 1L;
        Party expectedParty = new Party();
        when(partyRepository.findById(partyId)).thenReturn(Optional.of(expectedParty));

        // Act
        Optional<Party> actualParty = partyService.getPartyById(partyId);

        // Assert
        assertEquals(Optional.of(expectedParty), actualParty);
        verify(partyRepository, times(1)).findById(partyId);
    }

    @Test
    public void testGetPartyByName() {
        // Arrange
        String partyName = "Party1";
        Party expectedParty = new Party();
        when(partyRepository.findPartyByname(partyName)).thenReturn(Optional.of(expectedParty));

        // Act
        Optional<Party> actualParty = partyService.getPartyByname(partyName);

        // Assert
        assertEquals(Optional.of(expectedParty), actualParty);
        verify(partyRepository, times(1)).findPartyByname(partyName);
    }

    @Test
    public void testGetUsernameByParty() {
        // Arrange
        Long partyId = 1L;
        Party expectedParty = new Party();
        when(partyRepository.findUsersByParty(partyId)).thenReturn(Optional.of(expectedParty));

        // Act
        Optional<Party> actualParty = partyService.getUsernameByParty(partyId);

        // Assert
        assertEquals(Optional.of(expectedParty), actualParty);
        verify(partyRepository, times(1)).findUsersByParty(partyId);
    }
}