package fr.modded.api.model.admin;

import fr.modded.api.server.ClientServer;
import fr.modded.api.server.IPlayerServer;

import java.util.List;
import java.util.UUID;

public class AdminPlayerServerGeneralInfoModel {
    private final ClientServer server;
    private final List<UUID> whitelist;
    private final String host;
    private final int port;

    public AdminPlayerServerGeneralInfoModel(ClientServer server, List<UUID> whitelist, String host, int port) {
        this.server = server;
        this.whitelist = whitelist;
        this.host = host;
        this.port = port;
    }

    public IPlayerServer getServer() {
        return server;
    }

    public List<UUID> getWhitelist() {
        return whitelist;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
