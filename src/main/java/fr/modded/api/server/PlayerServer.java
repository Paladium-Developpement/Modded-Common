package fr.modded.api.server;

import fr.modded.api.util.gson.Exclude;
import fr.modded.api.util.list.LockList;

import java.util.UUID;

public class PlayerServer extends Server {
    @Exclude
    private final LockList<UUID> whitelist = new LockList<>();
    @Exclude
    private final LockList<String> invitationCodes = new LockList<>();

    private UUID playerOwner;
    private ServerType type;
    private NetworkType networkType;

    private int maxPlayers;
    private int maxInvitations;
    private int currentInvitations;

    private boolean expired;
    private long expire;

    public PlayerServer() {
    }

    public PlayerServer(String serverId) {
        super(serverId);
    }

    public PlayerServer(String serverId, UUID playerOwner, ServerType type) {
        super(serverId);
        this.playerOwner = playerOwner;
        setType(type);
    }

    public UUID getPlayerOwner() {
        return playerOwner;
    }

    public void setPlayerOwner(UUID playerOwner) {
        this.playerOwner = playerOwner;
    }

    public LockList<UUID> getWhitelist() {
        return whitelist;
    }

    public void addWhitelistPlayer(final UUID playerId) {
        this.whitelist.add(playerId);
    }

    public void removeWhitelist(final UUID playerId) {
        this.whitelist.remove(playerId);
    }

    public boolean isWhitelisted(final UUID playerId) {
        return this.whitelist.contains(playerId);
    }

    public ServerType getType() {
        return type;
    }

    public void setType(ServerType type) {
        this.type = type;
        this.maxPlayers = type.getMaxPlayers();
        this.maxInvitations = type.getMaxInvitations();
    }

    public NetworkType getNetworkType() {
        return networkType;
    }

    public void setNetworkType(NetworkType networkType) {
        this.networkType = networkType;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMaxInvitations() {
        return maxInvitations;
    }

    public int getCurrentInvitations() {
        return currentInvitations;
    }

    public void setCurrentInvitations(int currentInvitations) {
        this.currentInvitations = currentInvitations;
    }

    public void incrementInvitations(int amount) {
        if (this.currentInvitations + amount > this.maxInvitations)
            return;
        this.currentInvitations += amount;
    }

    public void decrementInvitations(int amount) {
        if (this.currentInvitations - amount <= 0)
            this.currentInvitations = 0;
        this.currentInvitations -= amount;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public LockList<String> getInvitationCodes() {
        return invitationCodes;
    }

    @Override
    public String toString() {
        return this.serverId;
    }
}
