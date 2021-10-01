package fr.modded.api.model.user;

import fr.modded.api.server.ServerType;

import java.util.UUID;

public class PlayerInfoModel {
    private final UUID playerId;
    private final ServerType rank;

    public PlayerInfoModel(UUID playerId, ServerType rank) {
        this.playerId = playerId;
        this.rank = rank;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public ServerType getRank() {
        return rank;
    }
}
