package swe6813team2.matchmakr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swe6813team2.matchmakr.services.UserFriendService;
import swe6813team2.matchmakr.models.User;
import swe6813team2.matchmakr.models.UserFriend;
import swe6813team2.matchmakr.models.UserFriend.UserFriendView;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/friends")
public class UserFriendController {

	@Autowired
	private UserFriendService ufs;
	
	// get friends
	@GetMapping("/{userId}")
	public ResponseEntity<List<UserFriendView>> getFriends(@PathVariable String userId) {
		try {
			List<UserFriendView> friends = ufs.getFriends(Long.parseLong(userId));
			if (friends.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(friends);
			}
			return ResponseEntity.ok(friends);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(new HttpHeaders()).body(null);      
		}
	}
	// create friend request
	@PostMapping("/request")
	public ResponseEntity<UserFriend> postFriendRequest(@RequestBody UserFriend partial) {
		try {
			UserFriend complete = ufs.createFriendRequest(partial.getUser(), partial.getFriend());
			if (complete.getUser() == partial.getUser()) {
				return ResponseEntity.ok(complete);
			}
			else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(new HttpHeaders()).body(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(new HttpHeaders()).body(null);      
		}
	}
	// get friend requests
	@GetMapping("/incoming/{userId}")
	public ResponseEntity<List<UserFriendView>> getFriendRequests(@PathVariable String userId) {
		
		
		try {
			List<UserFriendView> incomingFRs = ufs.getFriendRequests(Long.parseLong(userId));
			if (incomingFRs.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(incomingFRs);
			}
			return ResponseEntity.ok(incomingFRs);
		} catch (Exception e) { 
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(new HttpHeaders()).body(null);
		}
	}
	// delete friend request (a delete request apparently can't contain a body so this is the alternative)
	@DeleteMapping("/reject/{senderId}/{receiverId}")
	public ResponseEntity<String> deleteFriendRequest(@PathVariable String senderId, @PathVariable String receiverId) {
		try {
			boolean result = ufs.deleteFriendRequest(Long.parseLong(senderId), Long.parseLong(receiverId));
			if (result) {
				return ResponseEntity.ok("");
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No friend request to delete");
			}
		} 
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting friend request");
		}
	}
	// accept friend request
	@PutMapping("/accept")
	public ResponseEntity<String> acceptFriendRequest(@RequestBody UserFriend accept) {
		try {
			boolean result = ufs.acceptFriendRequest(accept.getUser(), accept.getFriend());
			if (result) {
				return ResponseEntity.ok("");
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No friend request to accept");
			}
		} 
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error accepting friend request");
		}
	}
	// remove a friend
	@DeleteMapping("/remove/{senderId}/{receiverId}")
	public ResponseEntity<String> deleteFriend(@PathVariable String senderId, @PathVariable String receiverId) {
		try {
			boolean result = ufs.deleteFriend(Long.parseLong(senderId), Long.parseLong(receiverId));
			if (result) {
				return ResponseEntity.ok("");
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is missing or is not friends");
			}
		} 
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error removing friend");
		}
	}
}
