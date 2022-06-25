package com.rulinma.algorithm.leetcode.easy;

/**
 * 26. 删除有序数组中的重复项
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * <p>
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 * <p>
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 * <p>
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * <p>
 * <p>
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 *
 * @author 马如林
 * @Data 2022/6/25 17:08
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        // 1. next==pre
        // 2. cur, right
        int cur = 0;

        if (nums.length <= 1) {
            return 1;
        }

        int right = 1;
        // 1,1,2
        while (right < nums.length) {
            if (nums[cur] == nums[right]) {
                // 删除right的值，保持cur不变
                right++;
            } else {
                cur++;
                nums[cur] = nums[right];
                right++;
            }
        }

        return cur + 1;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};

    }
}
