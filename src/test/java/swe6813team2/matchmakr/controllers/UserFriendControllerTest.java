package swe6813team2.matchmakr.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import swe6813team2.matchmakr.models.UserFriend;
import swe6813team2.matchmakr.services.UserFriendService;
import swe6813team2.matchmakr.models.UserFriend.UserFriendView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserFriendControllerTest {

    @Mock
    private UserFriendService ufs;

    @InjectMocks
    private UserFriendController ufc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetFriendRequestsFound() {
        // Arrange
    	List<UserFriendView> tmp = new ArrayList<UserFriendView>();
    	tmp.add(null);
    	tmp.add(null);
    	when(ufs.getFriendRequests(20l)).thenReturn(tmp);

        // Act
        ResponseEntity<List<UserFriendView>> response = ufc.getFriendRequests("20");
        
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
 
    @Test
    public void testGetFriendRequestsNoneFound() {
        // Arrange
    	List<UserFriendView> tmp = new ArrayList<UserFriendView>();
    	when(ufs.getFriendRequests(20l)).thenReturn(tmp);
    	
        // Act
        ResponseEntity<List<UserFriendView>> response = ufc.getFriendRequests("-1");
        
        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    public void testGetFriendsFound() {
        // Arrange
    	List<UserFriendView> tmp = new ArrayList<UserFriendView>();
    	tmp.add(null);
    	tmp.add(null);
    	when(ufs.getFriends(20l)).thenReturn(tmp);

        // Act
        ResponseEntity<List<UserFriendView>> response = ufc.getFriends("20");
        
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    public void testGetFriendsNotFound() {
        // Arrange
    	List<UserFriendView> tmp = new ArrayList<UserFriendView>();
    	when(ufs.getFriends(20l)).thenReturn(tmp);
    	
        // Act
        ResponseEntity<List<UserFriendView>> response = ufc.getFriends("-1");
        
        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
    
    @Test
    public void testDeleteFriendRequestFound() {
        // Arrange
    	when(ufs.deleteFriendRequest(5l, 2l)).thenReturn(true);
        // Act
        ResponseEntity<String> response = ufc.deleteFriendRequest("5", "2");
        
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    public void testDeleteFriendRequestNotFound() {
        // Arrange
    	when(ufs.deleteFriendRequest(-1l, -2l)).thenReturn(false);
    	
        // Act
        ResponseEntity<String> response = ufc.deleteFriendRequest("-1", "-2");
        
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
    
    @Test
    public void testAcceptFriendRequestFound() {
        // Arrange
    	UserFriend tmp = new UserFriend();
    	tmp.setUser(20l);
    	tmp.setFriend(21l);
    	when(ufs.acceptFriendRequest(tmp.getUser(), tmp.getFriend())).thenReturn(true);

        // Act
        ResponseEntity<String> response = ufc.acceptFriendRequest(tmp);
        
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    public void testAcceptFriendRequestNotFound() {
    	// Arrange
    	UserFriend tmp = new UserFriend();
    	tmp.setUser(-1l);
    	tmp.setFriend(-2l);
    	when(ufs.acceptFriendRequest(tmp.getUser(), tmp.getFriend())).thenReturn(false);

        // Act
        ResponseEntity<String> response = ufc.acceptFriendRequest(tmp);
        
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
    
    @Test
    public void testDeleteFriendFound() {
        // Arrange
    	when(ufs.deleteFriend(-1l, -2l)).thenReturn(true);

        // Act
        ResponseEntity<String> response = ufc.deleteFriend("-1", "-2");
        
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    public void testDeleteFriendNotFound() {
    	// Arrange
    	when(ufs.deleteFriend(-1l, -2l)).thenReturn(false);

        // Act
    	ResponseEntity<String> response = ufc.deleteFriend("-1", "-2");
        
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}