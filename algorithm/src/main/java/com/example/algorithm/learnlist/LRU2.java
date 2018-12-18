package com.example.algorithm.learnlist;

import java.util.HashMap;
import java.util.Map;

public class LRU2<k, v> {
    private final int MAX_CACHE_SIZE;

    class Entry<K,V>{
        Entry pre;
        Entry next;
        K key;
        V value;
        public Entry() {
        }
    }
    private Entry<k, v> head;
    private Entry<k, v> tail;

    private Map<k, Entry<k, v>> cacheMap;

    public LRU2(int size) {
        this.MAX_CACHE_SIZE = size;
        cacheMap = new HashMap<>();
    }

    public v get(k key) {
        Entry<k, v> kvEntry = cacheMap.get(key);
        if(kvEntry == null) return null;

        movetoHead(kvEntry);
        return kvEntry.value;
    }

    public void put(k key, v value) {
        Entry<k, v> entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            movetoHead(entry);
        }else{
            if (cacheMap.size() >= MAX_CACHE_SIZE) {
                cacheMap.remove(key);
                removeTail();
            }
            entry = new Entry<>();
            entry.key = key;
            entry.value = value;
            movetoHead(entry);
            cacheMap.put(key, entry);
        }
    }

    private void removeTail() {
        if (tail == null) {
            Entry<k, v> prev = tail.pre;
            if (prev == null) {
                head = null;
                tail = null;
            }else{
                tail.pre = null;
                tail = prev;
                tail.next = null;
            }
        }
    }
    private void movetoHead(Entry<k, v> entry) {
        if (entry == head) {
            return;
        }

        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }

        if (entry.next != null) {
            entry.pre.pre = entry.pre;
        }

        if (entry == tail) {
            Entry<k, v> prev = entry.pre;
            if (prev != null) {
                tail.pre = null;
                tail = prev;
                tail.next = null;
            }
        }
        if (head == null || tail == null) {
            head = tail = entry;
            return;
        }
        entry.next = head;
        head.pre = entry;
        entry.pre = null;
        head = entry;
    }

    public void remove(k key) {
        Entry<k, v> entry = getEntry(key);
        if (entry != null) {
            if (entry == head) {
                Entry next = head.next;
                head.next = null;
                head = next;
                head.pre = null;
            } else if (entry == tail) {
                Entry pre = head.pre;
                tail.pre = null;
                tail = pre;
                tail.next = null;
            }else{
                entry.pre.next = entry.next;
                entry.next.pre = entry.pre;
            }

        }
    }

    private Entry<k, v> getEntry(k key) {
        return cacheMap.get(key);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Entry<k, v> entry = head;
        while (entry != null) {
            stringBuilder.append(String.format("%s:%s ", entry.key, entry.value));
            entry = entry.next;
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        LRU2<Integer, Integer> lru2 = new LRU2<>(5);
        lru2.put(1, 1);
        System.out.println(lru2);
        lru2.put(2, 2);
        System.out.println(lru2);
        lru2.put(3, 3);
        System.out.println(lru2);
        lru2.get(1);
        System.out.println(lru2);
        lru2.put(4, 4);
        lru2.put(5, 5);
        lru2.put(6, 6);
        System.out.println(lru2);
        lru2.get(1);
        System.out.println(lru2);
        lru2.put(7, 7);
        System.out.println(lru2);
        lru2.get(2);
        System.out.println(lru2);
    }

}
