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
    @JsonView(Game.GameViews.BasicView.class)
    private Long id;

    @Column(name = "aggression")
    private int aggression;

    @Column(name = "kindness")
    private int kindness;

    @Column(name = "competitiveness")
    private int competitiveness;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, updatable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;
}
