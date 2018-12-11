package com.example.algorithm.learnThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SendOrder {
    public static void main(String[] args) {
        sendAllTo();
        sendAll();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static AtomicInteger aa = new AtomicInteger(0);
    private static AtomicBoolean bb = new AtomicBoolean(true);
    private static Lock lock = new ReentrantLock(true);


    private static Condition condition = lock.newCondition();
    private static Condition conditionAll = lock.newCondition();

    public static void sendAll() {
        System.out.println("sendall");
        for (int i = 0; i < 2; ++i) {
            new Thread(() -> {
                System.out.println("start send");
                aa.addAndGet(1);
                sendMsg(2);

            }).start();
        }
    }

    public static void sendMsg(int size) {
        for (int i = 0; i < 100; ++i) {
            int finalI = i;

            new Thread(() -> {
                lock.lock();
                try {
                    System.out.println("准备好了" + finalI);
                    if (aa.get() == 2 && finalI == 99) {
                        sendTmp();
                    }
                    condition.await();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(finalI);
                lock.unlock();
            }).start();


        }
    }

    public static void sendTmp() {
        new Thread(() -> {
            try {
                lock.tryLock(10,TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("通知发送全部");
            conditionAll.signalAll();
            System.out.println("send end.......");
            lock.unlock();
        }).start();
    }

    public static void sendAllTo() {
        System.out.println("sss");

        new Thread(() -> {
            try {
                lock.tryLock(10,TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("----------");
                conditionAll.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("已经通知完成了.....");
            condition.signalAll();
            lock.unlock();
        }).start();
    }
}
