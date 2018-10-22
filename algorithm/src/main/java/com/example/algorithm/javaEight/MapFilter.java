package com.example.algorithm.javaEight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapFilter {
    public static void main(String[] args) {
        toStreamMapBefore();
        toStreamMapAfter1();
    }


    /**
     * java8之前
     */
    public static void toStreamMapBefore() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "linode.com");
        map.put(2, "heroku.com");
        map.put(3, "digitalocean.com");
        map.put(4, "aws.amazon.com");
        String result = "";
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if ("aws.amazon.com".equals(entry.getValue())) {
                result = entry.getValue();
            }
        }

        System.out.println(result);
    }


    /**
     * java之后
     */
    public static void toStreamMapAfter1() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "linode.com");
        map.put(2, "heroku.com");
        map.put(3, "digitalocean.com");
        map.put(4, "aws.amazon.com");

        String result = map.entrySet().stream()
                .filter(m -> "aws.amazon.com".equals(m.getValue()))
                .map(m -> m.getValue())
                .collect(Collectors.joining());
        System.out.println(result);


        /** 多个条件比较结果
         */

        String resultTwo = map.entrySet().stream()
                .filter(x -> {
                    if (!x.getValue().contains("amazon") && x.getValue().contains("digital")) {
                        return true;
                    }
                    return false;
                })
                .map(m -> m.getValue())
                .collect(Collectors.joining(","));

        List<String> collect = map.entrySet().stream().map(m -> m.getValue()).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }
}
