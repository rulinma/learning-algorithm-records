package com.rulinma.algorithm.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 1539. 第 k 个缺失的正整数
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * <p>
 * 请你找到这个数组里第 k 个缺失的正整数。
 * <p>
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * <p>
 * https://leetcode.cn/problems/kth-missing-positive-number/
 *
 * @author 马如林
 * @Data 2022/6/24 16:57
 */
public class FindKthPositive {

    public int findKthPositive(int[] arr, int k) {
        // 顺序遍历1-n，缺失就+1，到k则返回
        // 逆向操作，从1开始累加count，
        // 停止条件
        int totalLen = arr.length + k;
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }

        int count = 0;
        for (int i = 1; i <= totalLen; i++) {
            if (!set.contains(i)) {
                count++;
            }
            if (count == k) {
                return i;
            }
        }

        return -1;
    }

    public int findKthPositive1(int[] arr, int k) {
        // 顺序遍历1-n，缺失就+1，到k则返回
        // 逆向操作，从1开始累加count，
        // 停止条件
        int totalLen = arr.length + k;
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }

        int count = 0;
        for (int i = 1; i <= totalLen; i++) {
            if (!set.contains(i)) {
                count++;
            }
            if (count == k) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
