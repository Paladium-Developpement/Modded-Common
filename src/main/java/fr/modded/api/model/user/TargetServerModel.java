package fr.modded.api.model.user;

import fr.modded.api.model.SessionModel;

public class TargetServerModel extends SessionModel {
    private final String serverId;

    public TargetServerModel(String sessionId, String serverId) {
        super(sessionId);
        this.serverId = serverId;
    }

    public TargetServerModel(String serverId) {
        super(null);
        this.serverId = serverId;
    }

    public String getServerId() {
        return serverId;
    }
}
