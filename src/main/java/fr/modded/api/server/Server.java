package fr.modded.api.server;

import fr.modded.api.util.gson.Exclude;
import fr.modded.api.util.list.LockList;

import java.net.InetSocketAddress;
import java.util.UUID;

public class Server implements IServer {
    private final String serverId;
    private final UUID playerOwner;

    private final ServerInfo serverInfo = new ServerInfo();

    @Exclude
    private final LockList<UUID> whitelist = new LockList<>();
    @Exclude
    private final LockList<String> invitationCodes = new LockList<>();

    @Exclude
    private InetSocketAddress address;
    private String host;
    private int port;

    private String serverType;
    private NetworkType networkType;
    private ServerState state;

    private int maxPlayers;
    private int maxInvitations;
    private int currentInvitations;

    private boolean expired;
    private long expire;

    public Server(String id, UUID owner, ServerType type) {
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
    public InetSocketAddress getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(InetSocketAddress address) {
        this.address = address;
        this.host = address.getHostName();
        this.port = address.getPort();
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
    public UUID getOwner() {
        return this.playerOwner;
    }

    @Override
    public String getType() {
        return this.serverType;
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
    public LockList<UUID> getWhiteList() {
        return this.whitelist;
    }

    @Override
    public void addWhiteList(UUID playerId) {
        this.whitelist.add(playerId);
    }

    @Override
    public void removeWhiteList(UUID playerId) {
        this.whitelist.remove(playerId);
    }

    @Override
    public boolean isWhiteListed(UUID playerId) {
        return this.whitelist.contains(playerId);
    }

    @Override
    public LockList<String> getInvitationCodes() {
        return this.invitationCodes;
    }

    @Override
    public int getCurrentInvitations() {
        return this.currentInvitations;
    }

    @Override
    public void setCurrentInvitations(int current) {
        this.currentInvitations = current;
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
    public boolean isExpired() {
        return this.expired;
    }

    @Override
    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    @Override
    public long getExpire() {
        return this.expire;
    }

    @Override
    public void setExpire(long expire) {
        this.expire = expire;
    }

    @Override
    public String toString() {
        return this.serverId;
    }
}
