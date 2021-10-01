package fr.modded.api.model.admin;

public class AdminPlayerServerRenewModel extends AdminModel {
    private final String serverId;
    private final long expireTime;

    public AdminPlayerServerRenewModel(String token, String playerId, String serverId, long expireTime) {
        super(token, playerId);
        this.serverId = serverId;
        this.expireTime = expireTime;
    }

    public String getServerId() {
        return serverId;
    }

    public long getExpireTime() {
        return expireTime;
    }
}
