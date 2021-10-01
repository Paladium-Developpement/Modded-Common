package fr.modded.api.server;

public class Server {
    protected String serverId;
    protected final ServerInfo serverInfo = new ServerInfo();
    protected ServerState state;
    protected String host;
    protected int port;

    public Server() {
    }

    public Server(String serverId) {
        this.serverId = serverId;
    }

    public String getServerId() {
        return serverId;
    }

    public ServerInfo getServerInfo() {
        return serverInfo;
    }

    public ServerState getState() {
        return state;
    }

    public void setState(ServerState state) {
        this.state = state;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return this.serverId;
    }

    public enum ServerState {
        NOT_INIT, CLOSE, OPEN
    }
}
