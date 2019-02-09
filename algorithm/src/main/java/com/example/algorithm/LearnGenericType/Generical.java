package com.example.algorithm.LearnGenericType;

public class Generical<T> {
    T name;

    public Generical(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }
}
