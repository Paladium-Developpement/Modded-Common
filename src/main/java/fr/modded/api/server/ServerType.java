package fr.modded.api.server;

public class ServerType {
    final String name;
    final int ordinal;
    final int maxPlayers;
    final int maxInvitations;
    final long lastBackupExpireTime;

    final int memory;
    final int disk;

    public ServerType(Builder builder) {
        this.name = builder.name;
        this.ordinal = builder.ordinal;
        this.maxPlayers = builder.maxPlayers;
        this.maxInvitations = builder.maxInvitations;
        this.lastBackupExpireTime = builder.lastBackupExpireTime;
        this.memory = builder.memory;
        this.disk = builder.disk;
    }

    public String getName() {
        return name;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMaxInvitations() {
        return maxInvitations;
    }

    public long getLastBackupExpireTime() {
        return lastBackupExpireTime;
    }

    public int getMemory() {
        return memory;
    }

    public int getDisk() {
        return disk;
    }

    public static class Builder {
        String name;
        int ordinal;
        int maxPlayers;
        int maxInvitations;
        long lastBackupExpireTime;

        int memory;
        int disk;

        public ServerType create(String name, int ordinal, int maxPlayers, int maxInvitations, long lastBackupExpireTime, int memory, int disk) {
            this.name = name;
            this.ordinal = ordinal;
            this.maxPlayers = maxPlayers;
            this.maxInvitations = maxInvitations;
            this.lastBackupExpireTime = lastBackupExpireTime;
            this.memory = memory;
            this.disk = disk;
            return new ServerType(this);
        }
    }
}
