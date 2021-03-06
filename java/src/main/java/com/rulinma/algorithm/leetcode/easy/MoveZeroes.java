package com.rulinma.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * https://leetcode.cn/problems/move-zeroes
 *
 * @author 马如林
 * @Data 2022/6/26 14:44
 */
public class MoveZeroes {

    /**
     * 只是移动所有0道末尾了
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // 当前已经排好的非0数组末尾
        int left = 0;
        // 非0的数
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
                left++;
            }
            right++;
        }
    }


    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = new int[]{3, 0, 1};
        moveZeroes.moveZeroes(nums);
    }

}
