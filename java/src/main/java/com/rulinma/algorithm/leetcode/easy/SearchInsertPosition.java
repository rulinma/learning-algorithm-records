package com.rulinma.algorithm.leetcode.easy;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 链接：https://leetcode.cn/problems/search-insert-position
 *
 * @author 马如林
 * @Data 2022/6/23 09:02
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        // 1. 查找到：返回索引
        // 2. 未找到：
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (high - low) / 2 + low;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            }
        }

        return low;
    }
}
