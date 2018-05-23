package com.example.algorithm.learn;

import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {
    public static void main(String[] args) {
        listLearn();
    }

    public static void listLearn() {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; ++i) {
            copyOnWriteArrayList.add(new Integer(23 + i));
        }
        for (Integer in :
                copyOnWriteArrayList) {
            System.out.println(in);
        }
    }
}
