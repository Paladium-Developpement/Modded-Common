package fr.modded.api.model.admin;

import fr.modded.api.server.Server;

import java.util.List;
import java.util.UUID;

public class AdminPlayerServerGeneralInfoModel {
    private final Server server;
    private final List<UUID> whitelist;

    public AdminPlayerServerGeneralInfoModel(Server server, List<UUID> whitelist) {
        this.server = server;
        this.whitelist = whitelist;
    }

    public Server getServer() {
        return server;
    }

    public List<UUID> getWhitelist() {
        return whitelist;
    }
}
