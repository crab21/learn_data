package com.example.algorithm.learnsort;

import java.util.*;

public class QucikSort {

    public static void main(String[] args) {
        int[] a;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 999999; ++i) {
            list.add(i);
        }
        a = list.stream().mapToInt(Integer::intValue).toArray();
        long time = new Date().getTime();
        System.out.println("开始排序");
        System.out.println(time);

//      quickSort(a, 0, a.length - 1);
        nonRecrutSort(a);
        System.out.println(new Date().getTime() - time);
        //        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] number, int low, int high) {
        if (low < high) {
            int pivot = partition(number, low, high);
            quickSort(number, low, pivot - 1);
            quickSort(number, pivot + 1, high);
        }
    }

    private static int partition(int[] number, int low, int high) {
        int pivot = (number[low] + number[high]) / 2;
        while (low < high) {
            while (low < high && number[high] >= pivot) high--;

            number[low] = number[high];

            while (low < high && number[low] <= pivot) low++;

            number[high] = number[low];
        }
        number[low] = pivot;
        return low;
    }


    /**
     * 非递归排序
     */
    public static void nonRecrutSort(int[] a) {//非递归快排，两个栈
        //设置两个栈，一个用于保存
        if (a == null || a.length < 0) return;
        Stack<Integer> startStack = new Stack<Integer>();//保存当前划分的最高位
        Stack<Integer> endStack = new Stack<Integer>();//保存当前划分的最低位
        int start = 0;
        int end = a.length - 1;

        int pivotPos;
        startStack.push(start);
        endStack.push(end);

        while (!startStack.isEmpty()) {
            start = startStack.pop();
            end = endStack.pop();
            pivotPos = partition(a, start, end);
            if (start < pivotPos - 1) {
                startStack.push(start);
                endStack.push(pivotPos - 1);
            }
            if (end > pivotPos + 1) {
                startStack.push(pivotPos + 1);
                endStack.push(end);
            }
        }
    }

    /*public void nonRecrutQuickSort(int a[]) {
        if (a == null || a.length <= 0) return;
        Stack<Integer> index = new Stack<Integer>();
        int start = 0;
        int end = a.length - 1;

        int pivotPos;

        index.push(start);
        index.push(end);

        while (!index.isEmpty()) {
            end = index.pop();
            start = index.pop();

            pivotPos = partition(a, start, end);
            if (start < pivotPos - 1) {
                index.push(start);
                index.push(pivotPos - 1);
            }
            if (end > pivotPos + 1) {
                index.push(pivotPos + 1);
                index.push(end);
            }
        }
    }*/
}
