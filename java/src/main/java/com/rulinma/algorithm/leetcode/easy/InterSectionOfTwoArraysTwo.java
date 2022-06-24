package com.rulinma.algorithm.leetcode.easy;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * <p>
 * https://leetcode.cn/problems/intersection-of-two-arrays-ii
 *
 * @author 马如林
 * @Data 2022/6/24 12:03
 */
public class InterSectionOfTwoArraysTwo {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 前面的短，后面的长
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        int l1 = 0;
        int l2 = 0;
        List<Integer> result = new ArrayList<>();

        while (l1 < nums1.length && l2 < nums2.length) {
            // 比较头指针
            if (nums1[l1] == nums2[l2]) {
                result.add(nums1[l1]);
                l1++;
                l2++;
            } else if (nums1[l1] > nums2[l2]) {
                l2++;
            } else if (nums1[l1] < nums2[l2]) {
                l1++;
            }
        }

        int[] arr = new int[result.size()];
        int i = 0;
        for (Integer x : result) {
            arr[i++] = x;
        }

        return arr;
    }

    public static void main(String[] args) {
        InterSectionOfTwoArraysTwo interSectionOfTwoArraysTwo = new InterSectionOfTwoArraysTwo();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] result = interSectionOfTwoArraysTwo.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
