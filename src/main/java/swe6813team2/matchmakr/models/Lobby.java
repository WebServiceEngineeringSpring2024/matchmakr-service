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
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;


    public Lobby() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
}
