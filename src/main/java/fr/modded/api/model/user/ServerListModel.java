package fr.modded.api.model.user;

import java.util.List;

public class ServerListModel {
    private final List<String> servers;

    public ServerListModel(List<String> servers) {
        this.servers = servers;
    }

    public List<String> getServers() {
        return servers;
    }
}
