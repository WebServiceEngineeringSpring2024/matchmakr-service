package swe6813team2.matchmakr.models;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "party")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(swe6813team2.matchmakr.models.Game.GameViews.BasicView.class)
    private Long id;

    @Column(name = "name")
    @JsonView(swe6813team2.matchmakr.models.Game.GameViews.BasicView.class)
    private String name;

    @Column(name = "lobby")
    @JsonView(swe6813team2.matchmakr.models.Game.GameViews.BasicView.class)
    private Integer lobby;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, updatable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;

    public Party() {
        this.created = new Date();
        this.updated = new Date();
    }
}
