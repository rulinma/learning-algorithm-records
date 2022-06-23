package com.rulinma.algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 645. 错误的集合
 *
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * https://leetcode.cn/problems/set-mismatch
 *
 * @author 马如林
 * @Data 2022/6/23 18:51
 */
public class FindErrorNums {

    public static int[] findErrorNums(int[] nums) {
        // 1 获取那个元素重复
        // 2 获取重复元素位置
        Arrays.sort(nums);

        Set<Integer> set = new HashSet<Integer>();
        int pos = 0;
        int num = nums[0];
        for (int x : nums) {
            if (set.contains(x)) {
                // 重复元素
                num = x;
                break;
            }
            set.add(x);
            pos++;
        }

        // 丢失的元素
        for (int x : nums) {
            set.add(x);
        }
        int count = 1;
        while (count <= nums.length) {
            if (!set.contains(count)) {
                break;
            }
            count++;
        }


        return new int[]{num, count};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 3, 2, 2, 7, 6, 4, 8, 9};
        int[] result = findErrorNums(nums);
        System.out.println(result);
    }
}
