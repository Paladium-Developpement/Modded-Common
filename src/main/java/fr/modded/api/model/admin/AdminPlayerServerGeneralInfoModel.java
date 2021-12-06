package fr.modded.api.model.admin;

import fr.modded.api.server.ClientServer;
import fr.modded.api.server.IPlayerServer;

import java.util.List;
import java.util.UUID;

public class AdminPlayerServerGeneralInfoModel {
    private final ClientServer server;
    private final List<UUID> whitelist;

    public AdminPlayerServerGeneralInfoModel(ClientServer server, List<UUID> whitelist) {
        this.server = server;
        this.whitelist = whitelist;
    }

    public IPlayerServer getServer() {
        return server;
    }

    public List<UUID> getWhitelist() {
        return whitelist;
    }
}
