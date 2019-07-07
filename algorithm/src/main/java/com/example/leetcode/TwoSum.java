package com.example.leetcode;

import gnu.trove.map.TIntIntMap;
import gnu.trove.map.hash.TIntIntHashMap;

import java.util.Arrays;

/**
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    private int[] twoSumOfFirst(int[] param, int result) {
        TIntIntMap map = new TIntIntHashMap(10);
        for (int i = 0; i < param.length; ++i) {
            map.put(param[i], i);
        }

        for (int i = 0; i < param.length; ++i) {
            int completement = result - param[i];
            if (map.containsKey(completement) && map.get(completement) != i) {
                return new int[]{param[i],completement};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] param = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] ints = new TwoSum().twoSumOfFirst(param, 9);
        System.out.println(Arrays.toString(ints));


    }
}
