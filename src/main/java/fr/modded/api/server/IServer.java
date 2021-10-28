package fr.modded.api.server;

import fr.modded.api.util.list.LockList;

import java.net.InetSocketAddress;
import java.util.UUID;

public interface IServer {
    String getId();

    InetSocketAddress getAddress();

    void setAddress(InetSocketAddress address);

    ServerState getState();

    void setState(ServerState state);

    ServerInfo getInfo();

    UUID getOwner();

    ServerType getType();

    void setType(ServerType type);

    NetworkType getNetworkType();

    void setNetworkType(NetworkType type);

    LockList<UUID> getWhiteList();

    void addWhitelist(final UUID playerId);

    void removeWhitelist(final UUID playerId);

    boolean isWhitelisted(final UUID playerId);

    LockList<String> getInvitationCodes();

    int getCurrentInvitations();

    void setCurrentInvitations(int current);

    void incrementInvitations(int amount);

    void decrementInvitations(int amount);

    boolean isExpired();

    void setExpired(boolean expired);

    long getExpire();

    void setExpire(long expire);

    enum ServerState {
        NOT_INIT, CLOSE, OPEN
    }
}
