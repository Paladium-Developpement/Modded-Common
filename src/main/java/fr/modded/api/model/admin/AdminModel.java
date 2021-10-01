package fr.modded.api.model.admin;

public class AdminModel {
    private final String token;
    private final String playerId;

    public AdminModel(String token) {
        this.token = token;
        this.playerId = null;
    }

    public AdminModel(String token, String playerId) {
        this.token = token;
        this.playerId = playerId;
    }

    public String getToken() {
        return token;
    }

    public String getPlayerId() {
        return playerId;
    }
}
