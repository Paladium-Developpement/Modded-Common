package fr.modded.api.model.admin;

import fr.modded.api.server.PlayerServer;

import java.util.List;
import java.util.UUID;

public class AdminPlayerServerGeneralInfoModel {
    private final PlayerServer server;
    private final List<UUID> whitelist;

    public AdminPlayerServerGeneralInfoModel(PlayerServer server, List<UUID> whitelist) {
        this.server = server;
        this.whitelist = whitelist;
    }

    public PlayerServer getServer() {
        return server;
    }

    public List<UUID> getWhitelist() {
        return whitelist;
    }
}
