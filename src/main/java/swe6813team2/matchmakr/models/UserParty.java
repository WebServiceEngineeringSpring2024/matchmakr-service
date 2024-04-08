package swe6813team2.matchmakr.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

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

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getParty() {
        return party;
    }

    public void setParty(Long party) {
        this.party = party;
    }
}
