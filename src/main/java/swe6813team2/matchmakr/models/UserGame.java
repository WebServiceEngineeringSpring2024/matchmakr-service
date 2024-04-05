package swe6813team2.matchmakr.models;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

@Entity
@Table(name = "user_game")
public class UserGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user")
    @JsonView(swe6813team2.matchmakr.models.Game.GameViews.BasicView.class)
    private Long user;

    @Column(name = "game")
    @JsonView(swe6813team2.matchmakr.models.Game.GameViews.BasicView.class)
    private Long game;

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getGame() {
        return game;
    }

    public void setGame(Long game) {
        this.game = game;
    }
}
