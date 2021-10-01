package fr.modded.api.server;

public class InvitationCode {
    private final String code;
    private final String serverId;
    private final long expireTime;
    private final int maxUsages;
    private int currentUsages = 0;
    private long currentTime;

    public InvitationCode(String code, String serverId, long expireTime, int maxUsages) {
        this.code = code;
        this.serverId = serverId;
        this.expireTime = expireTime;
        this.maxUsages = maxUsages;
    }

    public String getCode() {
        return code;
    }

    public String getServerId() {
        return serverId;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public int getMaxUsages() {
        return maxUsages;
    }

    public int getCurrentUsages() {
        return currentUsages;
    }

    public void incrementUsages() {
        currentUsages++;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }
}
