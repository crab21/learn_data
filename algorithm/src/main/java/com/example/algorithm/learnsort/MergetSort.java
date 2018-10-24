package com.example.algorithm.learnsort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergetSort {
    public static void main(String[] args) {
        int[] number = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50,23};
        mergeSort(number, 0, number.length - 1);
        System.out.println(Arrays.toString(number));
        System.out.println(count);
    }

    private static void mergeSort(int[] number, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            count++;
            mergeSort(number, low, mid);
            mergeSort(number, mid + 1, high);
            merge(number, low, mid, high);

        }
    }

    private static int count = 0;

    private static void merge(int[] number, int low, int mid, int high) {

        int[] tmp = new int[high - low + 1];
        // 左边界
        int left = low;
        // 右边界
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= high)
            tmp[k++] = number[left] <= number[right] ? number[left++] : number[right++];
        // 把左边剩余的移入数组中
        while (left <= mid)
            tmp[k++] = number[left++];
        // 把右边剩余的移入数组中
        while (right <= high)
            tmp[k++] = number[right++];
        // 覆盖之前的数组
        for (int k2 = 0; k2 < tmp.length; k2++) {
            number[k2 + low] = tmp[k2];
        }

    }
}
