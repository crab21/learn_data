package com.example.algorithm.LearnGenericType;

/**
 *
 */
public class GenericTestMain {


    public static void t1() {
        Generical<Integer> gInteger = new Generical<Integer>(123);
        Generical<Number> gNumber = new Generical<Number>(456);
        showKeyValue1(gNumber);

    }

    public static void main(String[] args) {
        t1();
    }
    public static  void showKeyValue1(Generical<Number> obj){
        System.err.println(("泛型测试"+"key value is " + obj.getName()));
    }

}
