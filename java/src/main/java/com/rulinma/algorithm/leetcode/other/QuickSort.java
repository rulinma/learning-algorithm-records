package com.rulinma.algorithm.leetcode.other;

import java.util.Arrays;

/**
 * 快速排序
 * <p>
 * https://leetcode.cn/problems/sort-an-array/
 *
 * @author 马如林
 * @Data 2022/7/11 13:25
 */
public class QuickSort {

    public void sort(int[] nums) {
        // 1. 分治
        quickSort(0, nums.length - 1, nums);
    }

    private void quickSort(int l, int h, int[] nums) {
        if (l < h) {
            int partion = partion(l, h, nums);
            quickSort(l, partion - 1, nums);
            quickSort(partion + 1, h, nums);
        }
    }

    private int partion(int l, int h, int[] nums) {
        // get partion
        int pivot = nums[l];
        // 3, 2, 4, 1, 5
        // 终止条件是l==h，从右边开始，再左边开始的大循环
        while (l < h) {
            // 从右边开始寻找位置，比pivot小的数据，放到空缺坑位
            // 为什么从右边开始寻找？因为pivot刚好是最左边的位置空缺出来，否则需要使用swap交换位置，有额外消耗，这里无需再swap。
            while (l < h && pivot < nums[h]) {
                h--;
            }
            // 小于时，才能存放数据，否则则是等于时需要存放pivot
            if (l < h) {
                nums[l] = nums[h];
                l++;
            }

            // 从左边边开始寻找位置，比pivot大的数据，放到空缺坑位
            while (l < h && nums[l] < pivot) {
                l++;
            }
            // 小于时，才能存放数据，否则则是等于时需要存放pivot
            if (l < h) {
                nums[h] = nums[l];
                h--;
            }
        }

        // 寻找到的最后空坑位，放入pivot数据
        nums[l] = pivot;

        return l;
    }


    public static void main(String[] args) {
//        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        int[] nums = new int[]{1, 2, 3, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));

//        输入：nums = [5,2,3,1]
//        输出：[1,2,3,5]
//
//        输入：nums = [5,1,1,2,0,0]
//        输出：[0,0,1,1,2,5]
    }
}
