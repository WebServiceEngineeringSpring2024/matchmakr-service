package swe6813team2.matchmakr.models;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(GameViews.BasicView.class)
    private Long id;

    @Column(name = "name")
    @JsonView(GameViews.BasicView.class)
    private String name;
    @Lob
    @Column(name = "image")
    private String image;

    @Lob
    @Column(name = "banner")
    private String banner;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "developer")
    private String developer;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "max_players")
    private int maxPlayers;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, updatable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;


    public Game() {
        this.created = new Date();
        this.updated = new Date();
    }

    private Long getId() {
        return id;
    }

    private String getName(){
        return name;
    }
    public interface GameViews {
        interface BasicView {}
        interface DetailedView extends BasicView {}
    }
}

