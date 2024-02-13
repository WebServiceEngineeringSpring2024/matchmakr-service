package swe6813team2.matchmakr.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Profile model

@Entity
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long UserID;
	// TODO: Insert fields for model here

	// Constructors
	public Profile() {
		super();
		UserID = 123456;
	}
	public Profile(long userID) {
		super();
		UserID = userID;
	}
	
	// Getters/setters
	public long getUserID() {
		return UserID;
	}

	public void setUserID(long userID) {
		UserID = userID;
	}

	
	
}
