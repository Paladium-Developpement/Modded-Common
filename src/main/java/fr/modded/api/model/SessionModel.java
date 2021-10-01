package fr.modded.api.model;

public class SessionModel {
    private final String sessionId;

    public SessionModel(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
}
