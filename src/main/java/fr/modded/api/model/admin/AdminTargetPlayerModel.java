package fr.modded.api.model.admin;

public class AdminTargetPlayerModel extends AdminModel {
    private final String targetPlayerId;

    public AdminTargetPlayerModel(String token, String targetPlayerId) {
        super(token);
        this.targetPlayerId = targetPlayerId;
    }

    public String getTargetPlayerId() {
        return targetPlayerId;
    }
}
