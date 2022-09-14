package com.rulinma.algorithm.leetcode.middle;

import java.util.LinkedHashMap;

/**
 * @author 马如林
 * @Data 2022/9/14 11:17
 */
public class LRU {

    int capacity;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        makeRecently(key);

        return cache.get(key);
    }

    private void makeRecently(int key) {
        int v = cache.get(key);
        cache.remove(key);
        cache.put(key, v);
    }

    public void put(int key, int val) {
        // 1 存在
        if (cache.containsKey(key)) {
            cache.put(key, val);
            makeRecently(key);
            return;
        }

        if (cache.size() >= capacity) {
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }

        cache.put(key, val);
    }

}
