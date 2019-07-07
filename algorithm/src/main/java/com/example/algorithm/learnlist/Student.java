package com.example.algorithm.learnlist;

import java.util.Objects;

public class Student {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    public static void main(String[] args) {
        Student student = new Student(10,"20");
        Student student1 = new Student(10, "20");
        Object ob = new Object();
        boolean equals = ob.equals(ob);

        if (Objects.equals(student,student1)) {
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
