package fr.modded.api.server;

public class ClientGlobalServer implements IServer {
    private final String serverId;

    private final ServerInfo serverInfo = new ServerInfo();

    public ClientGlobalServer(String serverId) {
        this.serverId = serverId;
    }

    @Override
    public String getId() {
        return this.serverId;
    }

    @Override
    public ServerState getState() {
        return ServerState.OPEN;
    }

    @Override
    public void setState(ServerState state) {
    }

    @Override
    public ServerInfo getInfo() {
        return this.serverInfo;
    }

    @Override
    public void setType(String type) {
    }

    @Override
    public NetworkType getNetworkType() {
        return null;
    }

    @Override
    public void setNetworkType(NetworkType type) {
    }

    @Override
    public String toString() {
        return this.serverId;
    }
}
