package fr.modded.api.model.admin;

public class AdminPlayerBanModel extends AdminModel {
    private final long time;

    public AdminPlayerBanModel(String token, String playerId, long time) {
        super(token, playerId);
        this.time = time;
    }

    public long getTime() {
        return time;
    }
}
