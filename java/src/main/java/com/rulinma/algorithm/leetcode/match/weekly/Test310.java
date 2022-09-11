package com.rulinma.algorithm.leetcode.match.weekly;

import com.rulinma.algorithm.leetcode.other.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 马如林
 * @Data 2022/9/11 10:29
 */
public class Test310 {

    public int mostFrequentEven(int[] nums) {
        int max = -1;
        int ans = -1;
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (i % 2 == 0) {
                int c = map.getOrDefault(i, 0);
                map.put(i, c + 1);
                int cv = map.get(i);
                if (cv > max) {
                    max = cv;
                    ans = i;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 2, 2, 4, 4, 1};
        System.out.println(new Test310().mostFrequentEven(nums));


        int[] nums1 = new int[]{4, 4, 4, 9, 2, 4};
        System.out.println(new Test310().mostFrequentEven(nums1));

        int[] nums2 = new int[]{29, 47, 21, 41, 13, 37, 25, 7};
        System.out.println(new Test310().mostFrequentEven(nums2));

        int[] nums3 = new int[]{0, 0, 0, 0};
        System.out.println(new Test310().mostFrequentEven(nums3));
    }
}
