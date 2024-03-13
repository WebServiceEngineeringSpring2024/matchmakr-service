package swe6813team2.matchmakr.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "game_lobby_type")
public class GameLobbyType {

    @Embeddable
    public static class GameLobbyTypeId implements Serializable {
        //todo fix relationships foreign keys
        @Column(name = "game")
        private int game;

        @Column(name = "type")
        private int type;

    }

    @EmbeddedId
    private GameLobbyTypeId id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameLobbyType)) return false;
        GameLobbyType that = (GameLobbyType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
