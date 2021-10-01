package fr.modded.api.model;

public class ServerModel {
    private final String serverId;

    public ServerModel(String serverId) {
        this.serverId = serverId;
    }

    public String getServerId() {
        return serverId;
    }
}
