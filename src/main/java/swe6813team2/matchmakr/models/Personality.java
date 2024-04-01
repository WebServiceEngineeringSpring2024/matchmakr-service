package swe6813team2.matchmakr.models;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personality")
public class Personality {

    public Personality() {
        this.created = new Date();
        this.updated = new Date();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(swe6813team2.matchmakr.models.Game.GameViews.BasicView.class)
    private Long id;

    @Column(name = "aggression")
    private Integer aggression;
    
    @Column(name = "kindness")
    private Integer kindness;
    
    @Column(name = "competitiveness")
    private Integer competitiveness;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, updatable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;

    public Personality() {
        this.created = new Date();
        this.updated = new Date();
    }

    public Personality(Integer aggression, Integer kindness, Integer competitiveness) {
    	this.aggression = aggression;
    	this.kindness = kindness;
    	this.competitiveness = competitiveness;
        this.created = new Date();
        this.updated = new Date();
    }
    
    
    public Integer getAggression() {
    	return aggression;
    }
    
    public Integer getKindness() {
    	return kindness;
    }
    
    public Integer getCompetitiveness() {
    	return competitiveness;
    }

    public Long getId() {
        return id;
    }

    public interface PersonalityViews {
        interface BasicView {}
        interface DetailedView extends swe6813team2.matchmakr.models.Personality.PersonalityViews.BasicView {}
    }
}

