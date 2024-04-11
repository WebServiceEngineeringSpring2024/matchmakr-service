package swe6813team2.matchmakr.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import swe6813team2.matchmakr.models.UserFriend;
import swe6813team2.matchmakr.models.UserFriend.UserFriendView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class UserFriendRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserFriendRepository ufr;
    
    @Test
    void testNewUserFriend() {
    	UserFriend p = new UserFriend();
    	p.setUser(420l);
    	p.setFriend(69l);
    	p.setAccepted(false);
    	UserFriend q = ufr.save(p);
    	assertEquals(p.getUser(), q.getUser());
    	assertEquals(p.getFriend(), q.getFriend());
    	assertEquals(p.getAccepted(), q.getAccepted());
    }
}
