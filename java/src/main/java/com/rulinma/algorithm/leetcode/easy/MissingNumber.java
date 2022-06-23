package com.rulinma.algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 268. 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * <p>
 * https://leetcode.cn/problems/missing-number
 *
 * @author 马如林
 * @Data 2022/6/23 19:36
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int len = nums.length;

        // 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        while (len >= 0) {
            if (!set.contains(len)) {
                return len;
            }
            len--;
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 1};
        System.out.println(missingNumber(nums));
    }
}
