package com.rulinma.algorithm.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 马如林
 * @Data 2022/6/18 17:31
 */
@Slf4j
public class TwoSum {

//    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//
//    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
//    你可以按任意顺序返回答案。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode.cn/problems/two-sum
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /**
     * 1. 暴力破解
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumSimple(int[] nums, int target) {
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
