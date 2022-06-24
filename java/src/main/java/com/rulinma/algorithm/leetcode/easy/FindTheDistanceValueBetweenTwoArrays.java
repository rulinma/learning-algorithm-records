package com.rulinma.algorithm.leetcode.easy;

/**
 * 1385. 两个数组间的距离值
 * <p>
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * <p>
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 * <p>
 * 链接：https://leetcode.cn/problems/find-the-distance-value-between-two-arrays
 *
 * @author 马如林
 * @Data 2022/6/24 18:44
 */
public class FindTheDistanceValueBetweenTwoArrays {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int x : arr1) {
            boolean ok = true;
            for (int y : arr2) {
                if (Math.abs(x - y) <= d) {
                    ok = false;
                }
            }
            count = ok ? count + 1 : count;
        }

        return count;
    }
}
