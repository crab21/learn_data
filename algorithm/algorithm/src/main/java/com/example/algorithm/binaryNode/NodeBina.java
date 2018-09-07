package com.example.algorithm.binaryNode;

/**
 * Created by k on 2018/8/14.
 */
public class NodeBina {
    private Object data;
    private NodeBina leftChild;
    private NodeBina rightChild;

    public NodeBina() {
    }

    public NodeBina(Object data, NodeBina leftChild, NodeBina rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public NodeBina(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public NodeBina getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeBina leftChild) {
        this.leftChild = leftChild;
    }

    public NodeBina getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeBina rightChild) {
        this.rightChild = rightChild;
    }
}
