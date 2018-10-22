package com.example.algorithm.LinkedList;

public class Nodes {
    public Object data;
    public Nodes next;

    public Nodes(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Nodes getNext() {
        return next;
    }

    public void setNext(Nodes next) {
        this.next = next;
    }
}
