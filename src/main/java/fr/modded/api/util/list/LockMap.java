package fr.modded.api.util.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockMap<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public Map<K, V> getMap() {
        return map;
    }

    public ReadWriteLock getLock() {
        return lock;
    }

    public V get(K key) {
        final V value;
        this.lock.readLock().lock();
        try {
            value = this.map.get(key);
        } finally {
            this.lock.readLock().unlock();
        }
        return value;
    }

    public void put(K key, V value) {
        this.lock.writeLock().lock();
        try {
            this.map.put(key, value);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public void remove(K key) {
        this.lock.writeLock().lock();
        try {
            this.map.remove(key);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public boolean containsKey(K key) {
        if (key == null)
            return false;
        boolean isContained;
        this.lock.readLock().lock();
        try {
            isContained = this.map.containsKey(key);
        } finally {
            this.lock.readLock().unlock();
        }
        return isContained;
    }

    public List<V> toList() {
        final List<V> list = new ArrayList<>();
        this.lock.readLock().lock();
        try {
            list.addAll(this.map.values());
        } finally {
            this.lock.readLock().unlock();
        }
        return list;
    }

    public void clear() {
        this.lock.writeLock().lock();
        try {
            this.map.clear();
        } finally {
            this.lock.writeLock().unlock();
        }
    }
}
