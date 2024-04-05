package swe6813team2.matchmakr.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lobby")
public class Lobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "game")
    private int game;

    @Column(name = "max_players")
    private int maxPlayers;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, updatable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;


    public Lobby() {
        this.created = new Date();
        this.updated = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGame() {
        return game;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
