package fr.modded.api.model.user;

import fr.modded.api.model.SessionModel;

public class WhitelistTargetPlayersModel extends SessionModel {
    private final String serverId;
    private final String[] targetPlayers;

    public WhitelistTargetPlayersModel(String sessionId, String serverId, String[] targetPlayers) {
        super(sessionId);
        this.serverId = serverId;
        this.targetPlayers = targetPlayers;
    }

    public String getServerId() {
        return serverId;
    }

    public String[] getTargetPlayers() {
        return targetPlayers;
    }
}
