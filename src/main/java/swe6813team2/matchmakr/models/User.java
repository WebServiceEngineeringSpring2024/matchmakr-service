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
    private Long personality;
    
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPersonality() {
        return personality;
    }

    public void setPersonality(Long personality) {
        this.personality = personality;
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

    public interface UserViews {
        interface BasicView {}
        interface DetailedView extends swe6813team2.matchmakr.models.User.UserViews.BasicView {}
    }
}
