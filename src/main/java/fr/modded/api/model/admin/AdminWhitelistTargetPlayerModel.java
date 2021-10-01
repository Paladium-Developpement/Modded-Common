package fr.modded.api.model.admin;

public class AdminWhitelistTargetPlayerModel extends AdminModel {
    private final String targetServerId;
    private final String targetPlayerId;

    public AdminWhitelistTargetPlayerModel(String token, String targetServerId, String targetPlayerId) {
        super(token);
        this.targetServerId = targetServerId;
        this.targetPlayerId = targetPlayerId;
    }

    public String getTargetServerId() {
        return targetServerId;
    }

    public String getTargetPlayerId() {
        return targetPlayerId;
    }
}
