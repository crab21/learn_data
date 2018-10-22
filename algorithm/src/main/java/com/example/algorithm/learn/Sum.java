package com.example.algorithm.learn;

import java.util.HashMap;
import java.util.Map;

public class Sum {
    /**
     * [22,22222,231321,32132132,2,7,20]
     * >>>9
     * >>>>>>>[2,7]
     * <p>
     * <p>
     * time complexity: O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
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


    /**
     * 复习上面的写法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoB(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        //todo 抛出异常
        //...
        return null;
    }

    /**
     * time complexity: O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] three(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; ++i) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        return null;
    }


    /**
     * 最优算法
     * time complexity: O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] fourTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    final String a = "100";

    public void test(int param) {
        String str = "hello world";
        class Inner {
            public void sout() {

                System.out.println(str);
                System.out.println(a);
                System.out.println(param);
            }
        }
        new Inner().sout();
        System.out.println(a);
    }

    public static void main(String[] args) {
        /*int[] nums = {2, 7, 15, 20};
        int target = 0;
        int[] two = new Sum().two(nums, target);
        for (int flag : two) {
            System.out.println(nums[flag]);
        }*/
        new Sum().test(1);
    }
}
