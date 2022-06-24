package com.rulinma.algorithm.leetcode.easy;

import java.util.*;

/**
 * 217. 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * <p>
 * https://leetcode.cn/problems/contains-duplicate
 *
 * @author 马如林
 * @Data 2022/6/24 16:35
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        // 1. 排序后检查是否有相等值，有返回true
        Arrays.sort(nums);

        int i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        // 1. 使用set统计即可
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            } else {
                set.add(n);
            }
        }
        return false;
    }

}
