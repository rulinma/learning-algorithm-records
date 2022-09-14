package com.rulinma.algorithm.leetcode.other;

/**
 * @author 马如林
 * @Data 2022/9/1 07:54
 */
public class BinarySearch {

    /**
     * 二叉查找的蓝绿框架
     */
    public int binarySearch(int[] num, int target) {
        int l = -1;
        int r = num.length;
        while (l + 1 != r) {
            int m = (l + r) / 2;
            if (isBlue(num[m], target)) {
                l = m;
            } else {
                r = m;
            }
        }

        return l;
    }

    private boolean isBlue(int i, int target) {
        return i <= target;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 22, 45, 66, 88};

        int index = new BinarySearch().binarySearch(nums, 88);
        System.out.println(index);
    }
}
