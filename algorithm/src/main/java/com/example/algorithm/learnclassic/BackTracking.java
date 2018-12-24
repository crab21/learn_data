package com.example.algorithm.learnclassic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法问题
 */
public class BackTracking {

    /**
     * 自由组合算法  一共有多少种问题
     * 1，2，3，4
     * 随机组合，全排列的总数
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        int[] flag = new int[nums.length];
        List<Integer> innerLS = new ArrayList<>(nums.length);
        helper(nums, flag, nums.length, innerLS, result);

        return result;
    }

    void helper(int[] nums, int[] flag, int leftCnt, List<Integer> innerLS, List<List<Integer>> outerLS){
        if(0 == leftCnt){
            outerLS.add(innerLS);
            return;
        }

        for(int index = 0; index < nums.length; index++){
            if(0 == flag[index]){
                int[] f = Arrays.copyOf(flag, flag.length);
                List<Integer> i = new ArrayList<>(innerLS);
                int left = leftCnt;
                f[index] = 1;
                i.add(nums[index]);
                helper(nums, f, --left, i, outerLS);
            }
        }
    }

    public static void main(String[] args) {
        int[]a = {1,2,3,4};
        List<List<Integer>> permute = new BackTracking().permute(a);
//        permute.stream().forEach(k->{
//            k.stream().forEach(l->{
//                System.out.print(l);
//            });
//            System.out.println();
//        });
        System.out.println(permute.size());
    }
}
