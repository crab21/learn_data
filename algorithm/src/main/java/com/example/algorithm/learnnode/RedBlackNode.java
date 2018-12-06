package com.example.algorithm.learnnode;

/**
 * @author pywang
 * @version 1.0
 */
public class RedBlackNode {
    int value;
    Color color;
    RedBlackNode left;
    RedBlackNode right;
    RedBlackNode parent;

    public RedBlackNode(int value, RedBlackNode left, RedBlackNode right, Color color) {
        this.value = value;
        this.color = color;
        this.left = left;
        this.right = right;
    }

    public RedBlackNode(int value, Color color) {
        this.value = value;
        this.color = color;
    }

    public RedBlackNode(Color color) {
        this.color = color;
    }

    enum Color {Black, Red;}


}
