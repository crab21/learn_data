package com.example.algorithm.learn;

public class Sum {
    /**
     * [2,7,20]
     * >>>9
     * >>>>>>>[2,7]
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
