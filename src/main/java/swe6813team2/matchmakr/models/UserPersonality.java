package swe6813team2.matchmakr.models;

public class UserPersonality {
    private Long userId;
    private Long personalityId;
    
    public UserPersonality(Long userId, Long personalityId) {
    	this.userId = userId;
    	this.personalityId = personalityId;
    }
    
    public Long getUserId() {
        return userId;
    }

    public Long getPersonalityId() {
        return personalityId;
    }
}

