package fr.modded.api.util.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockList<V> {
    private final List<V> list = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public List<V> getList() {
        return list;
    }

    public ReadWriteLock getLock() {
        return lock;
    }

    public void add(V value) {
        this.lock.writeLock().lock();
        try {
            this.list.add(value);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public void addAll(final Collection<? extends V> list) {
        this.lock.writeLock().lock();
        try {
            this.list.addAll(list);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public void remove(V value) {
        this.lock.writeLock().lock();
        try {
            this.list.remove(value);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public boolean contains(V value) {
        if (value == null)
            return false;
        boolean ret;
        this.lock.readLock().lock();
        try {
            ret = this.list.contains(value);
        } finally {
            this.lock.readLock().unlock();
        }
        return ret;
    }

    public List<V> toList() {
        final List<V> list = new ArrayList<>();
        this.lock.readLock().lock();
        try {
            list.addAll(this.list);
        } finally {
            this.lock.readLock().unlock();
        }
        return list;
    }

    public void clear() {
        this.lock.writeLock().lock();
        try {
            this.list.clear();
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public int size() {
        int ret;
        this.lock.readLock().lock();
        try {
            ret = this.list.size();
        } finally {
            this.lock.readLock().unlock();
        }
        return ret;
    }
}
