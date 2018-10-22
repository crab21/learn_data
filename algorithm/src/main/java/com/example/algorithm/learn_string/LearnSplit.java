package com.example.algorithm.learn_string;

/**
 * Created by k on 2018/6/9.
 */
public class LearnSplit {
    public static void main(String[] args) {

        ts3();
/*        char ch = '-';
        String regex = "4";
        int i = "12356".indexOf(ch = regex.charAt(0));
        System.out.println(i);*/
/*        int i1 = (ch - 'a') | ('z' - ch);
        System.out.println(i1);*/

//        int dayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//        System.out.println(dayOfMonth);
    }


    /**
     * 前面的分隔符会保留空格分隔
     * size=3
     */
    public static void ts1() {
        String splitOne = "--wang-";
        String[] split = splitOne.split("-");
        for (String result :
                split) {
            System.out.println(result + ">>>");
        }
    }

    /**
     * 后面的分隔符会被判定是否为连续空格
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
}
