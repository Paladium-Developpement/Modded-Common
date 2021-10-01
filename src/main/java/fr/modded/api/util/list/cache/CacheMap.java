package fr.modded.api.util.list.cache;

import fr.modded.api.util.list.LockMap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

public class CacheMap<K, V> {
    private final LockMap<K, CachedObject<V>> cache = new LockMap<>();
    private final Timer tasks = new Timer();
    private ExpiredCache<V> handler;

    public LockMap<K, CachedObject<V>> getCache() {
        return cache;
    }

    public V get(K key) {
        final CachedObject<V> value = this.cache.get(key);
        if (value != null) {
            if (!value.isExpiredSession()) {
                value.refreshSession();
                return value.getValue();
            }
            expire(value.getValue());
        }
        return null;
    }

    public void put(K key, V value, long expireTime) {
        this.cache.put(key, new CachedObject<>(value, expireTime));
    }

    public void remove(K key) {
        this.cache.remove(key);
    }

    public boolean containsKey(K key) {
        return this.cache.containsKey(key);
    }

    public void checkExpiredObjects() {
        final Queue<K> toRemove = new LinkedList<>();
        this.cache.getLock().readLock().lock();
        try {
            this.cache.getMap().forEach((key, value) -> {
                if (value.isExpiredSession()) {
                    expire(value.getValue());
                    toRemove.add(key);
                }
            });
        } finally {
            this.cache.getLock().readLock().unlock();
        }

        while (toRemove.peek() != null)
            remove(toRemove.poll());
    }

    public void onExpired(final ExpiredCache<V> handler) {
        this.handler = handler;
    }

    private void expire(final V value) {
        if (this.handler != null)
            this.handler.onExpire(value);
    }

    public void startTask(final long time) {
        this.tasks.purge();
        this.tasks.schedule(new TimerTask() {
            @Override
            public void run() {
                checkExpiredObjects();
            }
        }, 0, time);
    }

    public void stopTask() {
        this.tasks.cancel();
        this.tasks.purge();
    }

    public void clear() {
        this.cache.clear();
    }
}
