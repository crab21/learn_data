package com.example.algorithm.binaryNode;

import org.springframework.scheduling.concurrent.ScheduledExecutorTask;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by k on 2018/8/14.
 */
public class NodeMain {
    private static NodeTree nodeTree = new NodeBinaImpl();

    public static void main(String[] args) {
        NodeBina nodeBina = new NodeBina(6);
        nodeTree.insert(nodeBina, 4);
        nodeTree.insert(nodeBina, 5);
        nodeTree.insert(nodeBina, 20);
        nodeTree.insert(nodeBina, 11);
        nodeTree.insert(nodeBina, 30);
        nodeTree.insert(nodeBina, 9);
        nodeTree.insert(nodeBina, 25);

        nodeTree.preOrder(nodeBina);

        int a = 234;
        System.out.println((byte) a);

        NodeBina node = new NodeBinaImpl().findNode(nodeBina, 20);
        System.out.println(node.getData());
        System.out.println(node.getLeftChild().getData());
    }
}
