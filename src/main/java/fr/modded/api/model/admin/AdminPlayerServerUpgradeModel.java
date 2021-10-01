package fr.modded.api.model.admin;

public class AdminPlayerServerUpgradeModel extends AdminModel {
    private final String serverId;
    private final String type;
    private final long expireTime;

    public AdminPlayerServerUpgradeModel(String token, String playerId, String serverId, String type, long expireTime) {
        super(token, playerId);
        this.serverId = serverId;
        this.type = type;
        this.expireTime = expireTime;
    }

    public String getServerId() {
        return serverId;
    }

    public String getType() {
        return type;
    }

    public long getExpireTime() {
        return expireTime;
    }
}
