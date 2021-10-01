package fr.modded.api.model.user;

import fr.modded.api.model.SessionModel;

public class PlayerServerInvitationModel extends SessionModel {
    private final String code;

    public PlayerServerInvitationModel(String sessionId, String code) {
        super(sessionId);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
