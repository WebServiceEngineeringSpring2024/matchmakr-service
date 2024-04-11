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
    
    @Test
    void testUser() {
    	UserFriend userFriend = new UserFriend();
    	Long val = 10000l;
    	userFriend.setUser(val);
    	assertEquals(val, userFriend.getUser());
    }
    @Test
    void testFriend() {
    	UserFriend userFriend = new UserFriend();
    	Long val = 10000l;
    	userFriend.setFriend(val);
    	assertEquals(val, userFriend.getFriend());
    }
    @Test
    void testAccepted() {
    	UserFriend userFriend = new UserFriend();
    	userFriend.setAccepted(true);
    	assertEquals(true, userFriend.getAccepted());
    }
    @Test
    void testCreated() {
    	UserFriend userFriend = new UserFriend();
    	Date val = new Date();
    	userFriend.setCreated(val);
    	assertEquals(val, userFriend.getCreated());
    }
    @Test
    void testUpdated() {
    	UserFriend userFriend = new UserFriend();
    	Date val = new Date();
    	userFriend.setUpdated(val);
    	assertEquals(val, userFriend.getUpdated());
    }
}
