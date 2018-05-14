package com.example.algorithm.learn;

public class Sum {
    public int[] two(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        try {
            throw new IllegalAccessException("no tow sum solution");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 15, 20};
        int target = 0;
        int[] two = new Sum().two(nums, target);
        for (int flag : two) {
            System.out.println(nums[flag]);
        }
    }
}
