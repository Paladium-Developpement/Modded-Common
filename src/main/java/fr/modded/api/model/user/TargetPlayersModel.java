package fr.modded.api.model.user;

import fr.modded.api.model.SessionModel;

public class TargetPlayersModel extends SessionModel {
    private final String[] targetPlayers;

    public TargetPlayersModel(String sessionId, String[] targetPlayers) {
        super(sessionId);
        this.targetPlayers = targetPlayers;
    }

    public String[] getTargetPlayers() {
        return targetPlayers;
    }
}
