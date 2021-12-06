package fr.modded.api.server;

import fr.modded.api.util.list.LockList;

import java.util.UUID;

public class ClientServer implements IPlayerServer {
    private final String serverId;
    private final UUID playerOwner;

    private final ServerInfo serverInfo = new ServerInfo();

    private String serverType;
    private NetworkType networkType;
    private ServerState state;

    private int maxPlayers;
    private int maxInvitations;
    private int currentInvitations;

    private boolean expired;
    private long expire;

    public ClientServer(String id, UUID owner, ServerType type) {
        this.serverId = id;
        this.playerOwner = owner;
        this.serverType = type.getName();
        this.maxPlayers = type.maxPlayers;
        this.maxInvitations = type.maxInvitations;
    }

    @Override
    public String getId() {
        return this.serverId;
    }

    @Override
    public ServerState getState() {
        return this.state;
    }

    @Override
    public void setState(ServerState state) {
        this.state = state;
    }

    @Override
    public ServerInfo getInfo() {
        return this.serverInfo;
    }

    @Override
    public void setType(String type) {
        this.serverType = type;
    }

    @Override
    public NetworkType getNetworkType() {
        return this.networkType;
    }

    @Override
    public void setNetworkType(NetworkType type) {
        this.networkType = type;
    }

    @Override
    public UUID getOwner() {
        return playerOwner;
    }

    @Override
    public String getType() {
        return serverType;
    }

    @Override
    public boolean isExpired() {
        return expired;
    }

    @Override
    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    @Override
    public long getExpireTime() {
        return expire;
    }

    @Override
    public void setExpireTime(long expireTime) {
        this.expire = expireTime;
    }

    @Override
    public LockList<String> getInvitationCodes() {
        return null;
    }

    @Override
    public int getCurrentInvitations() {
        return currentInvitations;
    }

    @Override
    public void setCurrentInvitations(int value) {
        this.currentInvitations = value;
    }

    @Override
    public void incrementInvitations(int amount) {
        this.currentInvitations += amount;
    }

    @Override
    public void decrementInvitations(int amount) {
        if (this.currentInvitations - amount <= 0)
            this.currentInvitations = 0;
        this.currentInvitations -= amount;
    }

    @Override
    public String toString() {
        return this.serverId;
    }
}
