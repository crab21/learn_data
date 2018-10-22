package com.example.algorithm.learn;

import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;

public class LearnString {
    public static void nullEstimate() {
        @NotNull String name = null;
        System.out.println(name);
        System.out.println(MoreObjects.toStringHelper("wang").add("li", 1).toString());
    }

    /**
     * Guava包的使用.
     */
    public static void CollectTest() {
        HashSet<Object> objects = Sets.newHashSet();

        Maps.newHashMap();
        int result = ComparisonChain.start().compare(1, 1).compare(3, 3).compare(2, 2).result();
        System.out.println(result);
        List list = Lists.newArrayList();
        list.add("wa");
        list.add("pe");
        list.add("yu");
        list.add("an");
        String join = Joiner.on(".").join(list);

        System.out.println(join);
    }

    private String result = "";

    public void stringTest() {
        //s必须声明为final  下面的内部类才能使用
        final String s = Strings.nullToEmpty("wang");
        System.out.println(s);
        class innerClass {
            void pri() {
                System.out.println(s);
                ;
                result = "";
            }
        }
    }

    public static void main(String[] args) {
        String name = "   ";
        if (StringUtils.isEmpty(name.trim())) {
            System.out.println("ok");
        }
    }
}
