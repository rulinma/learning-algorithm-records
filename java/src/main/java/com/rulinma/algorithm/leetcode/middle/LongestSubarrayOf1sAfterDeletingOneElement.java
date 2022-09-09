package com.rulinma.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 马如林
 * @Data 2022/9/9 11:38
 */
public class LongestSubarrayOf1sAfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int max = 0;
        int left = 0;
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
                left++;
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
