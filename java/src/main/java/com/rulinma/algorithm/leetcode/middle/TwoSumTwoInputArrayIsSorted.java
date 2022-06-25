package com.rulinma.algorithm.leetcode.middle;

import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * <p>
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * <p>
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted
 *
 * @author 马如林
 * @Data 2022/6/25 09:04
 */
public class TwoSumTwoInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        // 1. 从第一个开始进行遍历
        // 2. target-cur 在numbers中寻找,
        int i = 0;
        while (i < numbers.length - 1) {
            int cur = numbers[i];
            int minus = target - cur;
            int searched = binarySearch(numbers, minus, i + 1);
            if (searched > 0) {
                return new int[]{i + 1, searched + 1};
            }
            i++;
        }

        return new int[]{-1, -1};
    }


    public int binarySearch(int[] numbers, int target, int left) {
        int low = left;
        int high = numbers.length - 1;
        while (low <= high) {
            int middle = (high - low) / 2 + low;
            if (numbers[middle] > target) {
                high = middle - 1;
            } else if (numbers[middle] < target) {
                low = middle + 1;
            }
            if (numbers[middle] == target) {
                return middle;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        TwoSumTwoInputArrayIsSorted twoSumTwoInputArrayIsSorted = new TwoSumTwoInputArrayIsSorted();
        int[] nums = new int[]{-1,0};
        int target = -1;
        int[] result = twoSumTwoInputArrayIsSorted.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

}
