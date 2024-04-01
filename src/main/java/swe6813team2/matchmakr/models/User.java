package swe6813team2.matchmakr.models;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(swe6813team2.matchmakr.models.Game.GameViews.BasicView.class)
    private Long id;

    @Column(name = "username")
    @JsonView(swe6813team2.matchmakr.models.Game.GameViews.BasicView.class)
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    @JsonView(swe6813team2.matchmakr.models.Game.GameViews.BasicView.class)
    private String email;
    @Lob
    @Column(name = "online")
    @JsonView(swe6813team2.matchmakr.models.Game.GameViews.BasicView.class)
    private int online;
    @Column(name = "language")
    private String language;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "personality")
    private Integer personality;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, updatable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;

    public User() {
        this.created = new Date();
        this.updated = new Date();
    }

    private Long getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    
    public void setPersonality(Integer personalityId) {
    	this.personality = personalityId;
    }

    private String getUserName(){
        return userName;
    }
    public interface UserViews {
        interface BasicView {}
        interface DetailedView extends swe6813team2.matchmakr.models.User.UserViews.BasicView {}
    }
}

