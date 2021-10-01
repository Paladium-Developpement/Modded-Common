package fr.modded.api.model;

public class AuthModel {
    private final String accessToken;
    private final String clientToken;

    public AuthModel(String accessToken, String clientToken) {
        this.accessToken = accessToken;
        this.clientToken = clientToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getClientToken() {
        return clientToken;
    }
}
