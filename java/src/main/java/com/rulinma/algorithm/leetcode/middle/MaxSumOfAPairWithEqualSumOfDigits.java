package com.rulinma.algorithm.leetcode.middle;

import java.util.*;

/**
 * 2342. 数位和相等数对的最大和
 * 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。
 * <p>
 * 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [18,43,36,13,7]
 * 输出：54
 * 解释：满足条件的数对 (i, j) 为：
 * - (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
 * - (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
 * 所以可以获得的最大和是 54 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,12,19,14]
 * 输出：-1
 * 解释：不存在满足条件的数对，返回 -1 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * <p>
 * https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits
 *
 * @author 马如林
 * @Data 2022/8/26 14:48
 */
public class MaxSumOfAPairWithEqualSumOfDigits {

    public int maximumSum(int[] nums) {
        int max = -1;
        int len = nums.length;
        Arrays.sort(nums);
        int[] ns = new int[len];
        int[] nsc = new int[len];
        // 逆序
        int j = len;
        for (int n : nums) {
            ns[--j] = n;
        }

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            // 统计数位和
            nsc[i] = calCount(ns[i]);
            // 相同值的只需要计算最前面2个
            int v = map.getOrDefault(nsc[i], -1);
            if (v != -1 && !set.contains(v)) {
                // 第2次遇到
                int vv = ns[v] + ns[i];
                max = Math.max(max, vv);
                set.add(v);
            } else {
                map.put(nsc[i], i);
            }
        }


        return max;
    }

    public int calCount(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
