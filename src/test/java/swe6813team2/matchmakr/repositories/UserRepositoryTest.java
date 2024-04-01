package swe6813team2.matchmakr.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import swe6813team2.matchmakr.models.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUserName() {
        // Create a new user
        User user = new User();
        user.setUserName("testuser");
        user.setEmail("testuser@example.com");

        // Save the user to the repository
        entityManager.persist(user);

        // Find the user by username
        Optional<User> foundUser = userRepository.findByUserName("testuser");

        // Verify that the user is found
        assertTrue(foundUser.isPresent());
        assertEquals(user, foundUser.get());
    }

    @Test
    public void testFindByEmail() {
        // Create a new user
        User user = new User();
        user.setUserName("testuser");
        user.setEmail("testuser@example.com");

        // Save the user to the repository
        entityManager.persist(user);

        // Find the user by email
        Optional<User> foundUser = userRepository.findByEmail("testuser@example.com");

        // Verify that the user is found
        assertTrue(foundUser.isPresent());
        assertEquals(user, foundUser.get());
    }
}