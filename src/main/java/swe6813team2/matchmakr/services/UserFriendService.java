package swe6813team2.matchmakr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swe6813team2.matchmakr.models.UserFriend.UserFriendView;
import swe6813team2.matchmakr.models.UserFriend;
import swe6813team2.matchmakr.repositories.UserFriendRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserFriendService {

	@Autowired
	private UserFriendRepository ufr;

	
	// create friend request
	public UserFriend createFriendRequest(Long senderId, Long receiverId) {
		// fill in fields
		UserFriend newfr = new UserFriend();
		newfr.setUser(senderId);
		newfr.setFriend(receiverId);
		newfr.setAccepted(false);
		newfr.setCreated(new Date());
		newfr.setUpdated(new Date());
		
		// create friend request in ufr
		ufr.addFriendRequest(senderId, receiverId);
		return newfr;
	}
	// get friend requests
	public List<UserFriendView> getFriendRequests(Long receiverId) {
		return ufr.getFriendRequests(receiverId);
	}
	// delete friend request
	public boolean deleteFriendRequest(Long senderId, Long receiverId) {
		// if friend request not found,
		int requestCount = ufr.checkIfFriendRequestExists(senderId, receiverId);
		if (requestCount == 0) {
			return false;
		}
		// otherwise, delete friend request 
		ufr.deleteFriendRequest(senderId, receiverId);
		return true;
	}
	// accept friend request
	public boolean acceptFriendRequest(Long senderId, Long receiverId) {
		// if friend request not found,
		int requestCount = ufr.checkIfFriendRequestExists(senderId, receiverId);
		if (requestCount == 0) {
			return false;
		}
		// otherwise, create a new userfriend
		ufr.insertAcceptFriend(senderId, receiverId);
		// and update the existing userfriend
		ufr.updateAcceptFriend(senderId, receiverId);
		return true;
	}
	// get friends
	public List<UserFriendView> getFriends(Long userId) {
		return ufr.getFriends(userId);
	}
	// remove a friend
	public boolean deleteFriend(Long senderId, Long receiverId) {
		ufr.deleteFriend(senderId, receiverId);
		return true;
	}
}
