package com.ext146.second;

import java.util.HashMap;
import java.util.Map;

/**
 * @author andyXu xu9529@gmail.com
 * @date 2019/10/14
 */
public class LRUCache {

    private Map<Integer, Integer> cache;

    private Entry head;
    private Entry tail;
    private int MAX_ENTRIES;
    private int size;

    LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        MAX_ENTRIES = capacity;
        head = new Entry(0);
        tail = new Entry(0);

        head.next = tail;
        tail.pre = head;

    }

    int get(int key) {
        int value = cache.getOrDefault(key, -1);
        if (value != -1) {
            moveToHead(key);
        }
        return value;
    }

    void put(int key, int value) {

        if (cache.containsKey(key)) {
            // 存在
            moveToHead(key);
            cache.put(key, value);

        } else {
            // 不存在
            moveToHead(key);
            cache.put(key, value);
            size++;
            if (size > MAX_ENTRIES) {
                removeTailNode();
                size--;

            }


        }


    }

    private void moveToHead(int key) {
        Entry node = new Entry(key);
        deleteNode(node.key);
        // 直接放到头结点
        node.next = head.next;
        head.next.pre = node;

        head.next = node;
        node.pre = head;

    }

    private void deleteNode(int key) {
        Entry node = head.next;

        while (node != tail) {
            if (node.key == key) {
                break;
            } else {
                node = node.next;
            }
        }
        if (node == tail) {
            return;
        }

        node.pre.next = node.next;
        node.next.pre = node.pre;

    }

    private void removeTailNode() {
        Entry node = head;
        if (node.next == tail) {
            return;
        }

        while (node.next != tail) {
            node = node.next;
        }
        cache.remove(node.key);

        node.pre.next = node.next;
        node.next.pre = node.pre;


    }


    public static class Entry {
        int key;
        Entry pre;
        Entry next;

        public Entry(int key) {
            this.key = key;
        }

        public Entry getPre() {
            return pre;
        }

        public void setPre(Entry pre) {
            this.pre = pre;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        //[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

        LRUCache cache = new LRUCache(2);
//        cache.get(2);
//        cache.put(2, 6);
//        cache.get(1);
//        cache.put(1, 5);
//        cache.put(1, 2);
//        cache.get(1);
//        cache.get(2);


        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
    }
}

