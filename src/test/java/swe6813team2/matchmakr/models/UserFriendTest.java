package swe6813team2.matchmakr.models;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserFriendTest {

    @Test
    void testUserFriendCreation() {
        UserFriend userFriend = new UserFriend();
        assertNotNull(userFriend.getCreated());
        assertNotNull(userFriend.getUpdated());
    }

    @Test
    void testUserFriendCreationWithDefaultValues() {
        UserFriend userFriend = new UserFriend();
        assertEquals(new Date(), userFriend.getCreated());
        assertEquals(new Date(), userFriend.getUpdated());
    }
}
