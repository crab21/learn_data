package com.example.algorithm.learn_string;

/**
 * Created by k on 2018/6/9.
 */
public class LearnSplit {
    public static void main(String[] args) {
        String split = "-wang--";
        String[] split1 = split.split("-");
        System.out.println(split1.length);
        for (String name :
                split1) {
            System.out.println(name+"---");
        }
/*        char ch = '-';
        String regex = "4";
        int i = "12356".indexOf(ch = regex.charAt(0));
        System.out.println(i);*/
/*        int i1 = (ch - 'a') | ('z' - ch);
        System.out.println(i1);*/
    }
}
