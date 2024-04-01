package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

@DataJpaTest
public class UserFriendTest {

    @Test
    public void testUserFriendCreation() {
        UserFriend userFriend = new UserFriend();
        assertNotNull(userFriend.getUser());
        assertNotNull(userFriend.getFriend());
        assertNotNull(userFriend.getAccepted());
        assertNotNull(userFriend.getCreated());
        assertNotNull(userFriend.getUpdated());
    }

    @Test
    public void testUserFriendCreationWithDefaultValues() {
        UserFriend userFriend = new UserFriend();
        assertEquals(new Date(), userFriend.getCreated());
        assertEquals(new Date(), userFriend.getUpdated());
    }
}