package com.rulinma.algorithm.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * https://leetcode.cn/problems/two-sum
 *
 * @author 马如林
 * @Data 2022/6/18 17:31
 */
@Slf4j
public class TwoSum {

    public int[] twoSumSimple(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int n : nums) {
            if (map.containsKey(target - n)) {
                return new int[]{map.get(target - n), index};
            }

            map.put(n, index++);
        }

        return new int[]{-1, -1};
    }


    /**
     * 1. 暴力破解
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumSimple1(int[] nums, int target) {
        log.info("simple");
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }

        // 1. 从第一位开始，到倒数第2位结束，遍历后面的数据是否能满足条件
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

}
