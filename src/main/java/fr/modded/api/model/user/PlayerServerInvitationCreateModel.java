package fr.modded.api.model.user;

import fr.modded.api.model.SessionModel;

public class PlayerServerInvitationCreateModel extends SessionModel {
    private final String serverId;
    private final long expireTime;
    private final int maxUsages;

    public PlayerServerInvitationCreateModel(String sessionId, String serverId, long expireTime, int maxUsages) {
        super(sessionId);
        this.serverId = serverId;
        this.expireTime = expireTime;
        this.maxUsages = maxUsages;
    }

    public String getServerId() {
        return serverId;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public int getMaxUsages() {
        return maxUsages;
    }
}
