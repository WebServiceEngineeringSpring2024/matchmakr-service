package swe6813team2.matchmakr.models;

public class UserPersonality {
    private String email;
    private Integer aggression;
    private Integer kindness;
    private Integer competitiveness;
    
    public UserPersonality(String email, Integer aggression, Integer kindness, Integer competitiveness) {
    	this.email = email;
    	this.aggression = aggression;
    	this.kindness = kindness;
    	this.competitiveness = competitiveness;
    }
    
    public String getEmail() {
        return email;
    }

    public Integer getAgression() {
        return aggression;
    }
    
    public Integer getKindness() {
        return kindness;
    }
    
    public Integer getCompetitiveness() {
        return competitiveness;
    }
}

