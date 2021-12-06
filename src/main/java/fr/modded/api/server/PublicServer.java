package fr.modded.api.server;

import fr.modded.api.util.gson.Exclude;
import fr.modded.api.util.list.LockList;

import java.net.InetSocketAddress;
import java.util.UUID;

public class PublicServer implements IServer {
    private final String serverId;

    private final ServerInfo serverInfo = new ServerInfo();

    @Exclude
    private InetSocketAddress address;
    private String host;
    private int port;

    public PublicServer(String serverId) {
        this.serverId = serverId;
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
    public UUID getOwner() {
        return null;
    }

    @Override
    public String getType() {
        return null;
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
    public LockList<UUID> getWhiteList() {
        return null;
    }

    @Override
    public void addWhiteList(UUID playerId) {
    }

    @Override
    public void removeWhiteList(UUID playerId) {
    }

    @Override
    public boolean isWhiteListed(UUID playerId) {
        return true;
    }

    @Override
    public LockList<String> getInvitationCodes() {
        return null;
    }

    @Override
    public int getCurrentInvitations() {
        return 0;
    }

    @Override
    public void setCurrentInvitations(int current) {
    }

    @Override
    public void incrementInvitations(int amount) {
    }

    @Override
    public void decrementInvitations(int amount) {
    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public void setExpired(boolean expired) {
    }

    @Override
    public long getExpire() {
        return 0;
    }

    @Override
    public void setExpire(long expire) {
    }

    @Override
    public String toString() {
        return this.serverId;
    }
}
