package fr.modded.api.model.admin;

public class AdminPlayerServerBuyModel extends AdminModel {
    private final String type;
    private final long expireTime;

    public AdminPlayerServerBuyModel(String token, String playerId, String type, long expireTime) {
        super(token, playerId);
        this.type = type;
        this.expireTime = expireTime;
    }

    public String getType() {
        return type;
    }

    public long getExpireTime() {
        return expireTime;
    }
}
