package com.rulinma.algorithm.leetcode.middle;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * <p>
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * <p>
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * <p>
 * 如果不存在这样的子数组，请返回 0 。
 * <p>
 *  
 * <p>
 * 提示 1：
 * <p>
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 要么是 0 要么是 1 。
 * <p>
 * https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element
 *
 * @author 马如林
 * @Data 2022/9/9 11:38
 */
public class LongestSubarrayOf1sAfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int max = 0;
        int right = 0;
        int countNotOne = 0;
        Deque<Integer> list = new LinkedList<>();
        boolean rmFlag = false;
        while (right < nums.length) {
            if (nums[right] != 1) {
                countNotOne++;
            }
            list.add(nums[right]);
            right++;

            // 统计其中1的个数，如果>=1，则缩减窗口到1个
            while (countNotOne > 1) {
                Integer x = list.removeFirst();
                if (x != 1) {
                    countNotOne--;
                }
                rmFlag = true;
            }

            if (countNotOne == 1) {
                rmFlag = true;
                max = Math.max(max, list.size() - 1);
            } else {
                max = Math.max(max, list.size());
            }
        }

        if (!rmFlag) {
            max = max - 1;
        }

        return max;
    }

    public int countNotOne(Deque<Integer> list) {
        int c = 0;

        for (int i : list) {
            if (i != 1) {
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        LongestSubarrayOf1sAfterDeletingOneElement longestSubarrayOf1sAfterDeletingOneElement = new LongestSubarrayOf1sAfterDeletingOneElement();

        int[] nums = new int[]{1, 1, 0, 1};
        int rs = longestSubarrayOf1sAfterDeletingOneElement.longestSubarray(nums);
        System.out.println(rs);

        // 5
        int[] nums1 = new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
        int rs1 = longestSubarrayOf1sAfterDeletingOneElement.longestSubarray(nums1);
        System.out.println(rs1);

        // 2
        int[] nums2 = new int[]{1, 1, 1};
        int rs2 = longestSubarrayOf1sAfterDeletingOneElement.longestSubarray(nums2);
        System.out.println(rs2);
    }
}
