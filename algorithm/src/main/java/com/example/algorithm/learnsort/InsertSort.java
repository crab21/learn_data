package com.example.algorithm.learnsort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] number = {3, 5, 1, 2, 6, 4, 7, 11, 23, 44, 3, 34};
        Integer[] numberInt;
        numberInt = (Integer[]) Arrays.stream(number).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.stream(numberInt).mapToInt(Integer::intValue).toArray());

        //        getInsertSort(number);
     /*   Arrays.sort(number, (o1, o2) -> {

            int temp = Integer.compare(o2, o1);
            return temp;

        });
     */
        System.out.println(Arrays.toString(number));
    }

    private static void getInsertSort(int[] number) {
        if (number == null || number.length == 0) {
            return;
        }
        int len = number.length;
        int temp, j;
        for (int i = 1; i < len; ++i) {
            temp = number[i];
            for (j = i - 1; j >= 0 && number[j] > temp; --j) {
                number[j + 1] = number[j];
            }
            number[j + 1] = temp;
        }
    }
}
