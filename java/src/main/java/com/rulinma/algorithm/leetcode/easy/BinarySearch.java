package com.rulinma.algorithm.leetcode.easy;

/**
 * 704. 二分查找
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * https://leetcode.cn/problems/binary-search/
 *
 * @author 马如林
 * @Data 2022/6/19 19:11
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        // 1. low high
        // 2. 折半查找，如果target>[middle], low=middle+1, 否则 high=middle -1
        // 3. while(low<=high)

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
//            int middle = (low + high) / 2;
            int middle = (high - low) / 2 + low;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }

        }

        return -1;
    }
}
