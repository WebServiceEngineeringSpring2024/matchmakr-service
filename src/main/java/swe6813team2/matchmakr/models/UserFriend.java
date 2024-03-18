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
}
