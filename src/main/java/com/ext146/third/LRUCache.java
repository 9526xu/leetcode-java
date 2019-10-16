package com.ext146.third;

import java.util.HashMap;
import java.util.Map;

/**
 * @author andyXu xu9529@gmail.com
 * @date 2019/10/15
 */
public class LRUCache {

    Entry head, tail;
    int capacity;
    int size;
    Map<Integer, Entry> cache;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        initLinkedList();
        size = 0;
        cache = new HashMap<>(capacity + 2);
    }

    private void initLinkedList() {
        head = new Entry();
        tail = new Entry();

        head.next = tail;
        tail.pre = head;

    }

    public int get(int key) {
        Entry node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 存在移动节点
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(Entry node) {
        // 首先删除原来节点的关系
        deleteNode(node);
        addNode(node);
    }

    private void addNode(Entry node) {
        head.next.pre = node;
        node.next = head.next;

        node.pre = head;
        head.next = node;
    }

    private void deleteNode(Entry node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        Entry node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }
        // 不存在。先加进去，再移除尾结点
        // 此时容量已满 删除尾结点
        if (size == capacity) {
            Entry lastNode=tail.pre;
            deleteNode(lastNode);
            cache.remove(lastNode.key);
            size--;
        }
        // 加入头结点

        Entry newNode = new Entry();
        newNode.key = key;
        newNode.value = value;
        addNode(newNode);
        cache.put(key, newNode);
        size++;

    }


    public static class Entry {
        public Entry pre;
        public Entry next;
        public int key;
        public int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Entry() {
        }
    }

    public static void main(String[] args) {

        LRUCache cache=new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));

    }
}