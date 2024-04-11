package swe6813team2.matchmakr.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import swe6813team2.matchmakr.models.UserFriend;
import swe6813team2.matchmakr.models.UserFriend.UserFriendView;

import java.util.List;

@Repository
public interface UserFriendRepository extends JpaRepository<UserFriend, Long> {
	@Query(nativeQuery = true, value = "SELECT user.id as Id, username as Username, user.online as Online FROM user INNER JOIN (SELECT user FROM user_friend WHERE friend = :receiverId AND accepted = 0) AS senders ON user.id = senders.user")
	List<UserFriendView> getFriendRequests(@Param("receiverId") Long receiverId);
	
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM user_friend WHERE user = :userId AND friend = :friendId AND accepted = 0")
	int checkIfFriendRequestExists(@Param("userId") Long userId, @Param("friendId") Long friendId);
	
	@Query(nativeQuery = true, value = "SELECT user.id as Id, username as Username, user.online as Online FROM user INNER JOIN (SELECT friend FROM user_friend WHERE user = :userId and accepted = 1) AS friendsIDs ON user.id = friendsIDs.friend")
	List<UserFriendView> getFriends(@Param("userId") Long userId);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "DELETE FROM user_friend WHERE user = :userId AND friend = :friendId")
	void deleteFriendRequest(@Param("userId") Long userId, @Param("friendId") Long friendId);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "DELETE FROM user_friend WHERE (user = :userId AND friend = :friendId) OR (user = :friendId AND friend = :userId)")
	void deleteFriend(@Param("userId") Long userId, @Param("friendId") Long friendId);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "INSERT INTO user_friend (user_friend.user, friend, accepted, created, updated, id) VALUES (:userId, :friendId, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, :userId)")
	void addFriendRequest(@Param("userId") Long userId, @Param("friendId") Long friendId);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "UPDATE user_friend SET accepted = 1, updated = CURRENT_TIMESTAMP WHERE user_friend.user = :userId AND user_friend.friend = :friendId")
	void updateAcceptFriend(@Param("userId") Long userId, @Param("friendId") Long friendId);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "INSERT INTO user_friend (user_friend.user, friend, accepted, created, updated, id) VALUES (:friendId, :userId, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0)")
	void insertAcceptFriend(@Param("userId") Long userId, @Param("friendId") Long friendId);
}
