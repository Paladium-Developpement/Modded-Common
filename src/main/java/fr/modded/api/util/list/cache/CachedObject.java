package fr.modded.api.util.list.cache;

public class CachedObject<V> {
    private final V value;
    private final long expireTime;
    private long session;

    public CachedObject(V value, long expireTime) {
        this.value = value;
        this.expireTime = expireTime;
        refreshSession();
    }

    public V getValue() {
        return value;
    }

    public boolean isExpiredSession() {
        final long lastSession = this.session;
        final long mergeTime = lastSession + this.expireTime;
        return mergeTime < System.currentTimeMillis();
    }

    public void refreshSession() {
        this.session = System.currentTimeMillis();
    }
}
