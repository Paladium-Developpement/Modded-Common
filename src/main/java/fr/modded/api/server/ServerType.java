package fr.modded.api.server;

import java.util.concurrent.TimeUnit;

public enum ServerType {
    STARTER(2, 1, TimeUnit.DAYS.toMillis(31)),
    EXPERT(4, 3, TimeUnit.DAYS.toMillis(31 * 3)),
    PRO(8, 6, TimeUnit.DAYS.toMillis(31 * 12));

    private final int maxPlayers;
    private final int maxInvitations;
    private final long backupExpireTime;

    public static final ServerType MAX = PRO;

    ServerType(int maxPlayers, int maxInvitations, long backupExpireTime) {
        this.maxPlayers = maxPlayers;
        this.maxInvitations = maxInvitations;
        this.backupExpireTime = backupExpireTime;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMaxInvitations() {
        return maxInvitations;
    }

    public long getBackupExpireTime() {
        return backupExpireTime;
    }
}
