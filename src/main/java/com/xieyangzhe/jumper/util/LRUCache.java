package com.xieyangzhe.jumper.util;

/**
 * @author Yangzhe Xie
 * @date 21/4/20
 */

import com.xieyangzhe.jumper.model.UrlModel;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {
    LinkedHashMap<K, V> cache = null;
    private int cacheSize;

    public LRUCache(int cacheSize) {
        this.cacheSize = (int) Math.ceil(cacheSize / 0.75f) + 1;
        cache = new LinkedHashMap<K, V>(this.cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > cacheSize;
            }
        };
    }

    public V get(K key) {
        return (V) cache.get(key);
    }

    public V put(K key, V value) {
        return cache.put(key, value);
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }
}
