package com.rulinma.algorithm.leetcode.middle;

import lombok.extern.slf4j.Slf4j;

/**
 * 912. 排序数组
 * <p>
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * @author 马如林
 * @Data 2022/6/18 18:19
 */
@Slf4j
public class SortAnArray {

    /**
     * 冒泡排序原理：
     * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2. 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 3. 针对所有的元素重复以上的步骤，除了最后一个。
     * 4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */

    public int[] sortArrayByFlagBubbleOptimize(int[] nums) {
        // 1. 每次最近的2个进行判断，大的放到后面，最终此次排序的一个放到最后
        // 2. 添加标记位，如果本次排序没有进行过交换，则排序结束
        if (nums.length < 2) {
            return nums;
        }

        // 执行次数
        for (int round = 0; round < nums.length - 1; round++) {
            // 其中一次
            // 有交换记录则说明还需要继续，没有则可以退出。
            boolean hasSwap = false;
            // 重置
            // round 是已经确定了个数，无需继续排序，提高效率而已，最大位置必须是长度-2，所以是<len-1
            // i 是开始比较的下标，需要比较的次数是 nums.length - roud - 1
            for (int i = 0; i < nums.length - round - 1; i++) {
                // 选择大的放到最后，这里是不正确的，则进行交换
                if (nums[i] > nums[i + 1]) {
                    int t = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = t;
                    hasSwap = true;
                }
            }

            if (!hasSwap) {
                return nums;
            }
        }

        return nums;
    }

    public int[] sortArrayByFlagBubble(int[] nums) {
        // 1. 每次最近的2个进行判断，大的放到后面，最终此次排序的一个放到最后
        // 2. 添加标记位，如果本次排序没有进行过交换，则排序结束
        if (nums.length < 2) {
            return nums;
        }

        // 执行次数
        for (int i = 0; i < nums.length - 1; i++) {
            // 其中一次
            // 有交换记录则说明还需要继续，没有则可以退出。
            boolean flag = false;
            {
                // 重置
                // i 是已经确定了个数，无需继续排序，提高效率而已，最大位置必须是长度-2，所以是<len-1
                for (int j = 0; j < nums.length - i - 1; j++) {
                    // 选择大的放到最后，这里是不正确的，则进行交换
                    if (nums[j] > nums[j + 1]) {
                        int t = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = t;
                        flag = true;
                    }
                }
            }

            if (!flag) {
                return nums;
            }
        }

        return nums;
    }

    public int[] sortArrayBySimpleBubble(int[] nums) {
        // 1. 每次最近的2个进行判断，大的放到后面，最终此次排序的一个放到最后
        // 2.

        if (nums.length < 2) {
            return nums;
        }

        // 执行次数
        for (int i = 0; i < nums.length - 1; i++) {
            // 其中一次
            // i 是已经确定了个数，无需继续排序，提高效率而已，最大位置必须是长度-2，所以是<len-1
            for (int j = 0; j < nums.length - i - 1; j++) {
                // 选择大的放到最后，这里是不正确的，则进行交换
                if (nums[j] > nums[j + 1]) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }

        return nums;
    }

    /**
     * 选择排序原理：
     * 1. 每次从数组中选择最小的那个放到当前位置
     * 2. 遍历currentIndex
     * 3. 遍历后面的数组，获取最小值，如果该值小于currentIndex，则交换2个数
     */
    public int[] sortArrayBySelect(int[] nums) {
        // 1. 进行n-1次选择
        // 2. 每次选择最小的一个放入当前位置
        for (int round = 0; round < nums.length - 1; round++) {
            int min = getMinIndex(nums, round);
            if (round != min) {
                // swap
                int tmp = nums[min];
                nums[min] = nums[round];
                nums[round] = tmp;
            }
        }

        return nums;
    }

    public int getMinIndex(int[] nums, int cuurent) {
        int min = nums[cuurent];
        int minIndex = cuurent;

        for (int i = cuurent + 1; i <= nums.length - 1; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

}
