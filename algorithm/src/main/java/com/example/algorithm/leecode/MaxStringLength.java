package com.example.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;

public class MaxStringLength {
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < length; ++j) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }

        return ans;
    }

    public static int lengthOfLengthString(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; ++j) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        map.forEach((k, v) -> System.out.print(k));
        return ans;
    }

    public static void main(String[] args) {
        int result = lengthOfLengthString("tabcadfeab");
        System.out.println(result);
    }
}
