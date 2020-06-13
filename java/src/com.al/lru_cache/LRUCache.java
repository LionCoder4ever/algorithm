package com.al.lru_cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class LRUCache {
    class LRUCacheHelper<K, V> extends LinkedHashMap<K, V> {
        private int max;

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > max;
        }

        LRUCacheHelper(int max) {
            super(max, 0.75f, true);
            this.max = max;
        }
    }
    private LRUCacheHelper lruh;
    LRUCache(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity error");
        lruh = new LRUCacheHelper(capacity);
    }

    int get(int key) {
        if (lruh == null)
            return -1;
        return (int) lruh.getOrDefault(key, -1);
    }

    void put(int key, int value) {
        if (lruh != null){
            lruh.put(key,value);
        }
    }

    Set keys() throws Exception {
        if (lruh == null){
            throw new Exception("lrucache need init");
        }
    return lruh.keySet();
}
}