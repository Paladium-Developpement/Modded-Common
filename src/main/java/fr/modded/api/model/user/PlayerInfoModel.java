package fr.modded.api.model.user;

import java.util.UUID;

public class PlayerInfoModel {
    private final UUID playerId;
    private final String rank;

    public PlayerInfoModel(UUID playerId, String rank) {
        this.playerId = playerId;
        this.rank = rank;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public String getRank() {
        return rank;
    }
}
