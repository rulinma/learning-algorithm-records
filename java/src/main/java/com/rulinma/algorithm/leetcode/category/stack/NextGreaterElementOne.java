package com.rulinma.algorithm.leetcode.category.stack;

import java.util.*;

/**
 * @author 马如林
 * @Data 2022/9/1 09:25
 */
public class NextGreaterElementOne {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int[] rs = new int[nums2.length];
        Deque<Integer> deque = new LinkedList<>();
        // 1. nums2的单调栈获取每个位置的下一个更大值，不存在设置为-1
        for (int i = 0; i < nums2.length; i++) {
            while (!deque.isEmpty() && nums2[deque.peek()] < nums2[i]) {
                // 当前位置的下一个最大值是nums2[i]
                rs[deque.pop()] = nums2[i];
            }
            deque.push(i);
        }
        while (!deque.isEmpty()) {
            rs[deque.pop()] = -1;
        }

        // nums2的key和index map方便nums1查找
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = rs[map.get(nums1[i])];
        }

        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElementOne nextGreaterElementOne = new NextGreaterElementOne();
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};

        int[] rs = new NextGreaterElementOne().nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(rs));
    }
}
