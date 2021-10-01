package fr.modded.api.model.user;

import fr.modded.api.model.SessionModel;

public class FriendOpenModel extends SessionModel {
    private final boolean openRequest;

    public FriendOpenModel(String sessionId, boolean openRequest) {
        super(sessionId);
        this.openRequest = openRequest;
    }

    public boolean isOpenRequest() {
        return openRequest;
    }
}
