package com.rulinma.algorithm.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author 马如林
 * @Data 2022/6/24 09:57
 */
@Slf4j
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        // 1. 选择最左边的元素
        // 2. 选择最右边的元素
        int leftIndex = getLeftIndex(nums, target);

        int rightIndex = getRightIndex(nums, target);

        return new int[]{leftIndex, rightIndex};
    }

    private int getRightIndex(int[] nums, int target) {
        int rightIndex = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (high - low) / 2 + low;
            if (nums[middle] == target) {
                // get it
                rightIndex = middle;
                low = middle + 1;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            }
        }
        return rightIndex;
    }

    private static int getLeftIndex(int[] nums, int target) {
        int leftIndex = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (high - low) / 2 + low;
            if (nums[middle] == target) {
                // get it
                leftIndex = middle;
                high = middle - 1;
            } else if (nums[middle] < target) {
                low = middle + 1;
            } else if (nums[middle] > target) {
                high = middle - 1;
            }
        }
        return leftIndex;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray();
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
//        int target = 8;

//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
//        int target = 6;

        int[] nums = new int[]{};
        int target = 0;

        int[] result = findFirstAndLastPositionOfElementInSortedArray.searchRange(nums, target);
        System.out.println(Arrays.toString(result));

    }
}
