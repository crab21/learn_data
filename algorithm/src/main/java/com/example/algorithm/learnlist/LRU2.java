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

    /**
     * 构造函数  设置LRU数量
     * @param size
     */
    public LRU2(int size) {
        this.MAX_CACHE_SIZE = size;
        cacheMap = new HashMap<>();
    }

    public v get(k key) {
        //获取当前key中的值
        Entry<k, v> kvEntry = cacheMap.get(key);
        //当前key值为null  则直接返回
        if(kvEntry == null) return null;

        //移动当前获取的key对应的值 到链表头部
        movetoHead(kvEntry);
        //返回值
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
        //当前为head节点 则无需移动
        if (entry == head) {
            return;
        }

        //前一个节点不为空，则将当前节点的下一个元素  给当前节点的前一个->下一个
        // 类似于跳过当前元素 把当前元素的下一个元素恰当处理
        // ***处理当前节点的后节点关系
        if (entry.pre != null) {
            entry.pre.next = entry.next;
        }

        //类似于前一个判断   ***处理当前节点的前节点关系
        if (entry.next != null) {
            entry.next.pre = entry.pre;
        }

        //判断当前元素是否为尾部节点
        if (entry == tail) {
            //获取当前节点的前节点
            Entry<k, v> prev = entry.pre;
            //前节点有值，则把前一个节点当做尾节点
            //类似删除尾节点
            if (prev != null) {
                tail.pre = null;
                tail = prev;
                tail.next = null;
            }
        }
        //没有元素  双向变一
        if (head == null || tail == null) {
            head = tail = entry;
            return;
        }
        //把当前节点放在head节点之前
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
