package fr.modded.api.model.user;

import fr.modded.api.model.SessionModel;
import fr.modded.api.server.ServerInfo;

public class PlayerServerInfoEditModel extends SessionModel {
    private final String serverId;
    private final ServerInfo serverInfo;
    private final String networkType;

    public PlayerServerInfoEditModel(String sessionId, String serverId, ServerInfo serverInfo, String networkType) {
        super(sessionId);
        this.serverId = serverId;
        this.serverInfo = serverInfo;
        this.networkType = networkType;
    }

    public String getServerId() {
        return serverId;
    }

    public ServerInfo getServerInfo() {
        return serverInfo;
    }

    public String getNetworkType() {
        return networkType;
    }
}
