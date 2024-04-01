package swe6813team2.matchmakr.models;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personality")
public class Personality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(swe6813team2.matchmakr.models.Game.GameViews.BasicView.class)
    private Long id;

    @Column(name = "aggression")
    private Integer aggression;
    
    @Column(name = "kindness")
    private Integer kidness;
    
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

    private Long getId() {
        return id;
    }

    public interface PersonalityViews {
        interface BasicView {}
        interface DetailedView extends swe6813team2.matchmakr.models.Personality.PersonalityViews.BasicView {}
    }
}

