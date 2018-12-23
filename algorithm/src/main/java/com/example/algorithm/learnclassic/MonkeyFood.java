package com.example.algorithm.learnclassic;

/**
 * 题目：猴子第一天摘了若干个桃子，当即吃了一半，还不解馋，又多吃了一个；第二天，吃剩下的桃子的一半，还不过瘾，又多吃了一个；以后每天都
 * 吃前一天剩下的一半多一个，到第10天想再吃时，只剩下一个桃子了。问第一天共摘了多少个桃子？
 *
 * 逆向思维：
 * s10 = 1
 * s9 = (s10+1)*2
 * s8 = (s9+1)*2
 * .....
 * ...
 * ..
 * .
 * Sn = (S(n+1)+1)*2
 */
public class MonkeyFood {
    /**
     * 递归
     * @param day
     * @return
     */
    public int sumPeach(int day) {
        if (day == 10) {
            return 1;
        }
        return 2 * sumPeach(day + 1) + 2;
    }

    public int sumPeachWhile(int day) {
        int d = 9, x1 = 0, x2 = 1;
        while (d > 0) {
            x1 = (x2 + 1) * 2;
            x2 = x1;
            d--;
        }
        return x1;
    }

    public static void main(String[] args) {
        MonkeyFood monkeyFood = new MonkeyFood();

        int sum = monkeyFood.sumPeach(1);
        System.out.println(sum);


        int i = monkeyFood.sumPeachWhile(0);
        System.out.println(i);


    }
}
