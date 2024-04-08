package swe6813team2.matchmakr.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import swe6813team2.matchmakr.models.Party;
import swe6813team2.matchmakr.services.PartyService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PartyControllerTest {

    @Mock
    private PartyService partyService;

    @InjectMocks
    private PartyController partyController;

    public PartyControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsersInAParty_WithExistingPartyId_ReturnsParty() {
        // Arrange
        Long partyId = 1L;
        Party party = new Party();
        when(partyService.getUsernameByParty(partyId)).thenReturn(Optional.of(party));

        // Act
        ResponseEntity<Optional<Party>> response = partyController.getAllUsersInAParty(partyId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Optional.of(party), response.getBody());
        verify(partyService, times(1)).getUsernameByParty(partyId);
    }

    @Test
    public void testGetAllUsersInAParty_WithNonExistingPartyId_ReturnsNoContent() {
        // Arrange
        Long partyId = 2L;
        when(partyService.getUsernameByParty(partyId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Optional<Party>> response = partyController.getAllUsersInAParty(partyId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(Optional.empty(), response.getBody());
        verify(partyService, times(1)).getUsernameByParty(partyId);
    }

    @Test
    public void testGetAllUsersInAParty_WithException_ReturnsNotFound() {
        // Arrange
        Long partyId = 3L;
        when(partyService.getUsernameByParty(partyId)).thenThrow(new RuntimeException());

        // Act
        ResponseEntity<Optional<Party>> response = partyController.getAllUsersInAParty(partyId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
        verify(partyService, times(1)).getUsernameByParty(partyId);
    }
}