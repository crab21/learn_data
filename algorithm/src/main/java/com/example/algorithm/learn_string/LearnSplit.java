package com.example.algorithm.learn_string;

/**
 * Created by k on 2018/6/9.
 */
public class LearnSplit {
/*
    public static void main(String[] args) {

//        ts3();
//        ts2();
        ts1();
*/
/*        char ch = '-';
        String regex = "4";
        int i = "12356".indexOf(ch = regex.charAt(0));
        System.out.println(i);*//*

     */
/*        int i1 = (ch - 'a') | ('z' - ch);
        System.out.println(i1);*//*


//        int dayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//        System.out.println(dayOfMonth);


        String tmp = "74834955BB7434924701A00000055BB6438437B0000000055BB7549375397407N00000000055BB";
        StringBuilder stringBuilder = new StringBuilder(tmp);
        StringBuilder stringBuilder1 = recursiveString(stringBuilder, new StringBuilder());
        System.out.println(stringBuilder1.toString());

    }
*/


    static String flag = "55BB";

    /**
     * 递归截取字符串
     * <p>
     * <p>
     * 思想：  逐步分解  递归取出其中结果  按照所需分类   保证线程安全切同步
     * <p>
     * <p>
     * <p>
     * 最好采用链表方式取出   按照顺序
     */
    private static StringBuilder recursiveString(StringBuilder str, StringBuilder result) {
        if (str.indexOf(flag) == -1) {
            return result;
        }

        //第一次出现标志地方
        int i = str.indexOf(flag);
        if (i > 0) {
            //多余的字符串  拼接上一次字符串做处理
            String superfluous = str.substring(0, i);

        }

        int j = str.indexOf(flag, i + flag.length());

        if (i == str.length() - flag.length()) {
            //剩下字符串中包含所截取的字符串


            return result;
        }
        if (j == -1) {
            result.append(str.substring(i));
            return result;
        } else {
            result.append(str.substring(i, j));
            recursiveString(new StringBuilder(str.substring(j)), result);
        }
        return result;
    }


    /**
     * 前面的分隔符会保留空格分隔
     * size=3
     */
    public static void ts1() {
        String splitOne = "--wang--";
        String[] split = splitOne.split("-");
        for (String result :
                split) {
            System.out.println(result + ">>>");
        }
    }

    /**
     * 后面的分隔符会被判定是为连续空格
     * size=2
     */
    public static void ts2() {
        String splitTwo = "-wang--";
        String[] split = splitTwo.split("-");
        for (String result :
                split) {
            System.out.println(result + "<<<<");
        }
    }

    /**
     * 分隔符 处理前面的  后面的若为空  则不截取后面的
     */
    public static void ts3() {
        String splitThree = "-wang-";
        String[] split = splitThree.split("-");
        System.out.println(split.length);
        for (String result :
                split) {
            System.out.println(result + ">>>");
        }
    }


    /**
     * 字符串问题进一步理解
     */

    private static void stringUnderstand() {
        final String s = "hello world";
        String ss = "hello world.";
        String n = "hello"+s.substring(5);

        String n1 = s + ".";
        System.out.println(n1);
        System.out.println(n1.hashCode());
        System.out.println(ss.hashCode());
        if (n1 != ss) {
            System.out.println("=====");
        }
    }


    public static void main(String[] args) {
        stringUnderstand();
    }
}
