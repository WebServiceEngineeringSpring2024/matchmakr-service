package swe6813team2.matchmakr.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import swe6813team2.matchmakr.models.UserFriend;
import swe6813team2.matchmakr.models.UserFriend.UserFriendView;
import swe6813team2.matchmakr.repositories.UserFriendRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserFriendServiceTest {

    @Mock
    private UserFriendRepository ufr;

    @InjectMocks
    private UserFriendService us;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateFriendRequest() {
        // Arrange
        Long senderId = 1L;
        Long receiverId = 2L;

        // Act
        UserFriend result = us.createFriendRequest(senderId, receiverId);

        // Assert
        assertNotNull(result);
        assertEquals(senderId, result.getUser());
        assertEquals(receiverId, result.getFriend());
        assertNotNull(result.getCreated());
        assertNotNull(result.getUpdated());
        verify(ufr).addFriendRequest(senderId, receiverId);
    }//*/
    @Test
    public void testDeleteFriendRequest() {
        // Arrange
        Long senderId = 1L;
        Long receiverId = 2L;
        when(ufr.checkIfFriendRequestExists(senderId, receiverId)).thenReturn(1);

        // Act
        boolean result = us.deleteFriendRequest(senderId, receiverId);

        // Assert
        assertTrue(result);
        verify(ufr).deleteFriendRequest(senderId, receiverId);
    }//*/
    
    @Test
    public void testAcceptFriendRequest() {
        // Arrange
        Long senderId = 1L;
        Long receiverId = 2L;
        when(ufr.checkIfFriendRequestExists(senderId, receiverId)).thenReturn(1);

        // Act
        boolean result = us.acceptFriendRequest(senderId, receiverId);

        // Assert
        assertTrue(result);
        verify(ufr).insertAcceptFriend(senderId, receiverId);
        verify(ufr).updateAcceptFriend(senderId, receiverId);
    }
}