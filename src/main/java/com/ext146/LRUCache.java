package com.ext146;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author andyXu xu9529@gmail.com
 * @date 2019/10/14
 */
public class LRUCache {

    private LinkedHashMap<Integer,Integer> cache;

    private int MAX_ENTRIES;

    public LRUCache(int capacity) {
        this.MAX_ENTRIES=capacity;
        // accessOrder 为 true 按照访问顺序，false 按照插入顺序
        cache=new LinkedHashMap<Integer,Integer>(capacity, 0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                // 需要重写该方法，
                return size()>MAX_ENTRIES;
            }
        };


    }

    public int get(int key) {
        return cache.getOrDefault(key,-1);

    }

    public void put(int key, int value) {
        cache.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end
