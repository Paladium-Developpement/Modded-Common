package fr.modded.api.server;

public interface IServer {
    String getId();

    ServerState getState();

    void setState(ServerState state);

    ServerInfo getInfo();

    void setType(String type);

    NetworkType getNetworkType();

    void setNetworkType(NetworkType type);

    enum ServerState {
        NOT_INIT, CLOSE, OPEN
    }
}
