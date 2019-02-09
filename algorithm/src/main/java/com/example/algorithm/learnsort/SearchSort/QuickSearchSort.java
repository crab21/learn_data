package com.example.algorithm.learnsort.SearchSort;

import org.springframework.batch.core.configuration.support.AbstractApplicationContextFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

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
//        stringToBytes("111111");
        int[] num = {10, 100, 9, 8, 4,4,4, 32};
//        _sort(num, 0, num.length - 1);
//        System.out.println(Arrays.toString(num));

        insertSort(num);
        System.out.println(Arrays.toString(num));
    }


    public  static void stringToBytes(String str) {
        if (str == null) {
            return;
        }
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
    }


    public static void _sort(int[] num, int low, int high) {
        if (low < high) {
            int mid = getMiddle(num, low, high);
            _sort(num, low, mid-1);
            _sort(num, mid + 1, high);
        }
    }

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private static int getMiddle(int[] num, int low, int high) {
        int tmp = num[low];

        while (low < high) {
            while (low < high && tmp <= num[high]) {
                high--;
            }
            atomicInteger.addAndGet(1);
            num[low] = num[high];
            while (low < high && tmp >= num[low]) {
                low++;
            }
            atomicInteger.addAndGet(1);
            num[high] = num[low];
        }
        num[low] = tmp;
        return low;
    }


    private static void insertSort(int[] num) {
        int i, j;
        for (i = 1; i < num.length; ++i) {
            if (num[i - 1] > num[i]) {
                int tmp = num[i];
                for (j = i - 1; j >= 0 && num[j] >tmp; --j) {
                    num[j + 1] = num[j];
                }
                num[j + 1] = tmp;
            }
        }
    }

}
