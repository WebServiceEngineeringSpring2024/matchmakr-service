package swe6813team2.matchmakr.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_friend")
public class UserFriend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user")
    private Long user;

    @Column(name = "friend")
    private Long friend;
    
    @Column(name = "accepted")
    private Boolean accepted;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, updatable = false)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;


    public UserFriend() {
        this.created = new Date();
        this.updated = new Date();
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getFriend() {
        return friend;
    }

    public void setFriend(Long friend) {
        this.friend = friend;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
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
