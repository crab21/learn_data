package com.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class LearnReflection {
    private String name;

    public LearnReflection() {
    }

    public LearnReflection(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println("on now time is ......");
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        LearnReflection learnReflection = new LearnReflection();
        String name = learnReflection.getClass().getPackage().getName();
        System.out.println(name);
        System.out.println(learnReflection.getClass().getName());
        Class<?> result = null;
        try {
            result = (Class<?>) Class.forName("com.example.reflection.LearnReflection");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String simpleName = result.getSimpleName();
        System.out.println(simpleName);

        Constructor<?>[] constructors = result.getConstructors();
        System.out.println(Arrays.toString(constructors));

        LearnReflection o = (LearnReflection)constructors[0].newInstance();
        o.name  = "fsdfasd";
        System.out.println(o.name);

        System.out.println(result.getClassLoader().getClass().getName());

        try {
            Method print = result.getDeclaredMethod("print");
            print.invoke(result.newInstance());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
