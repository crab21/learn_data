package com.example.algorithm.collections_package;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class LearnQueue {
    /**
     * <pre>
     * offer add
     * poll remove
     * peek element
     *
     * note 前者方法操作不会出现异常
     * note 后者方法操作会报异常
     * @return
     * </pre>
     */
    public static Queue createQueue() {
        Queue<String> queue = new ArrayDeque(10);
        queue.add("0");
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");
        queue.add("6");
        queue.add("7");
        queue.add("8");
        queue.add("9");
        queue.add("10");
        queue.add("11");
        queue.add("12");
        queue.add("13");
        //note foreach方式迭代，完了之后不会移除元素
        for (String name :
                queue) {
            System.out.println(name + "----");
        }
        System.out.println(queue.size() + "-----");


        //note 队列方式遍历 元素被逐个移除

        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }

        System.out.println(queue.size() + "---" + queue.poll());
        return null;
    }

    /**
     * ArrayBlockingQueue队列.
     * note 大小固定  不可被改变
     */
    public static void arryaBlockingQueueCreate() {
        //note 构造函数需要指定容量、公平参数<按照等待时间的长短>
        //note 基于数组的阻塞循环队列 FIFO(先进先出原则)
        Queue<String> queue = new ArrayBlockingQueue<>(3, true);
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.offer("4");
        System.out.println(queue.size());
        queue.clear();
        System.out.println(queue.size());

    }

    public static void main(String[] args) {
//        createQueue();
        arryaBlockingQueueCreate();
    }
}
