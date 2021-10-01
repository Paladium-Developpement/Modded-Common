package fr.modded.api.util.list.cache;

public interface ExpiredCache<V> {
    void onExpire(V value);
}
