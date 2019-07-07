package com.example.algorithm.learnlist;

import java.util.Objects;

public class UserObject {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("要死了要死了要死了!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserObject)) return false;
        UserObject that = (UserObject) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAge(), that.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
}

