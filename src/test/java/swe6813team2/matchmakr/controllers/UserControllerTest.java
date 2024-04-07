package swe6813team2.matchmakr.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import swe6813team2.matchmakr.models.User;
import swe6813team2.matchmakr.services.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        // Arrange
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());

        when(userService.getAllUsers()).thenReturn(users);

        // Act
        ResponseEntity<List<User>> response = userController.getAllUsers();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(users, response.getBody());
    }

    @Test
    public void testGetAllUsers_NoContent() {
        // Arrange
        List<User> users = new ArrayList<>();

        when(userService.getAllUsers()).thenReturn(users);

        // Act
        ResponseEntity<List<User>> response = userController.getAllUsers();

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals(users, response.getBody());
    }

    // Add more test methods for other controller methods

    // ...

}