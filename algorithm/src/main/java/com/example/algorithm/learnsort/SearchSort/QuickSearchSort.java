package com.example.algorithm.learnsort.SearchSort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 查找k元素
 */
public class QuickSearchSort {


    /**
     * 排序找出第k小的元素
     *
     * @param number
     * @param k
     * @return
     */
    public static int selectMinKth(int[] number, int k) {
        k--;
        int low = 0, high = number.length - 1;
        while (true) {
            int j = partition(number, low, high);
            if (j < k) {
                low = j + 1;
            } else if (j > k) {
                high = high - 1;
            } else {
                return number[k];
            }
        }

    }

    private static int partition(int[] number, int low, int high) {
        int i = low, j = high + 1;
        while (true) {
            while (true) {
                i++;
                if (i == high || number[i] > number[low]) {
                    break;
                }
            }
            while (true) {
                j--;
                if (j == low || number[j] < number[low]) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(number, i, j);
        }
        swap(number, low, high);
        return j;
    }

    private static void swap(int[] number, int i, int j) {
        int t = number[i];
        number[i] = number[j];
        number[j] = t;
    }

    public static void main(String[] args) {

       /* int[] a = {9, 0, 6, 5, 8, 2, 1, 7, 4, 3};
        int result = selectMinKth(a, 3);
        System.out.println(result);*/
//        Queue<String> result = new LinkedList<>();
//        result.offer(null);
        stringToBytes("111111");

    }

    public  static void stringToBytes(String str) {
        if (str == null) {
            return;
        }
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
    }


}
