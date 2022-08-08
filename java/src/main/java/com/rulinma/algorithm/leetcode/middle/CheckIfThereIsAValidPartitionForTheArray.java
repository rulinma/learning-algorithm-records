package com.rulinma.algorithm.leetcode.middle;

/**
 * 6137. 检查数组是否存在有效划分
 * <p>
 * 你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。
 * <p>
 * 如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分：
 * <p>
 * 子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。
 * 子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。
 * 子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。
 * 如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,4,4,5,6]
 * 输出：true
 * 解释：数组可以划分成子数组 [4,4] 和 [4,5,6] 。
 * 这是一种有效划分，所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,2]
 * 输出：false
 * 解释：该数组不存在有效划分。
 * <p>
 * https://leetcode.cn/problems/check-if-there-is-a-valid-partition-for-the-array
 *
 * @author 马如林
 * @Data 2022/8/8 14:19
 */
public class CheckIfThereIsAValidPartitionForTheArray {

    public boolean validPartition(int[] nums) {
        // 1. 2个或3个相等的元素
        // 3个连续递增元素
        int len = nums.length;
        // dp[i]表示第i位结尾是否可行
        boolean[] dp = new boolean[len];
        dp[0] = false;
        dp[1] = (nums[1] == nums[0]);

        for (int i = 2; i < len; i++) {
            // 按第一种分法
            if (nums[i] == nums[i - 1] && dp[i - 2]) {
                dp[i] = true;
            }
            // 按第二种分法
            if (nums[i] == nums[i - 2] && nums[i - 2] == nums[i - 1] && (i == 2 || dp[i - 3])) {
                dp[i] = true;
            }
            // 按第三种分法
            if (nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2 && (i == 2 || dp[i - 3])) {
                dp[i] = true;
            }
        }

        return dp[len - 1];
    }

    public boolean validPartition1(int[] nums) {
        // 1. 2个或3个相等的元素
        // 3个连续递增元素
        // 递归出口

        boolean rs = valid(nums, 0);

        // 递归调用

        return rs;
    }

    public boolean valid(int nums[], int start) {
        // 递归出口
        if (nums.length - start == 2 && nums[start] == nums[start + 1]) {
            return true;
        }
        if (nums.length - start == 3 && nums[start] == nums[start + 1] && nums[start + 1] == nums[start + 2]) {
            return true;
        }
        if (nums.length - start == 3 && nums[start] == nums[start + 1] - 1 && nums[start + 1] == nums[start + 2] - 1) {
            return true;
        }

        // 2 相同
        // 3 相同
        // 3 递增
        boolean same2 = false;
        // 3 递增
        boolean same3 = false;
        // 3 递增
        boolean inc3 = false;

        if (start + 1 < nums.length) {
            if (nums[start] == nums[start + 1]) {
                //  从2开始
                int x = start + 2;
                same2 = valid(nums, x);
            }
        }

        if (start + 2 < nums.length) {
            if (nums[start] == nums[start + 1] && nums[start + 1] == nums[start + 2]) {
                int x = start + 3;
                same3 = valid(nums, x);
            } else if (nums[start] == nums[start + 1] - 1 && nums[start + 1] == nums[start + 2] - 1) {
                int x = start + 3;
                inc3 = valid(nums, x);
            }
        }

        return false || same2 || same3 || inc3;
    }

    public static void main(String[] args) {

        CheckIfThereIsAValidPartitionForTheArray checkIfThereIsAValidPartitionForTheArray = new CheckIfThereIsAValidPartitionForTheArray();

//        int[] nums = {4, 4, 4, 5, 6};
//        System.out.println(checkIfThereIsAValidPartitionForTheArray.validPartition(nums));
//
//        int[] nums1 = {1, 1, 1, 2};
//        System.out.println(checkIfThereIsAValidPartitionForTheArray.validPartition(nums1));
//
//        int[] nums2 = {803201, 803201, 803201, 803201, 803202, 803203};
//        System.out.println(checkIfThereIsAValidPartitionForTheArray.validPartition(nums2));

        int[] nums3 = {1, 1};
        System.out.println(checkIfThereIsAValidPartitionForTheArray.validPartition(nums3));

    }

}
