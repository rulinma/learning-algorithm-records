package com.rulinma.algorithm.leetcode.middle;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 马如林
 * @Data 2022/6/18 18:19
 */
@Slf4j
public class SortAnArray {
    // 912. 排序数组
    // 给你一个整数数组 nums，请你将该数组升序排列。

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
            {
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


}
