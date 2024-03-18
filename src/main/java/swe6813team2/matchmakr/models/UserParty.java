package swe6813team2.matchmakr.models;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_party")
public class UserParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user")
    @JsonView(swe6813team2.matchmakr.models.Game.GameViews.BasicView.class)
    private Long user;

    @Column(name = "party")
    @JsonView(swe6813team2.matchmakr.models.Game.GameViews.BasicView.class)
    private Long party;
}

