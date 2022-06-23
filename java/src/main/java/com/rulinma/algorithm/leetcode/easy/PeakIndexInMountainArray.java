package com.rulinma.algorithm.leetcode.easy;

/**
 * 852. 山脉数组的峰顶索引
 *
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * <p>
 * 链接：https://leetcode.cn/problems/peak-index-in-a-mountain-array
 *
 * @author 马如林
 * @Data 2022/6/23 13:14
 */
public class PeakIndexInMountainArray {

//    大于后一个元素时，既可能为顶峰，也可能为顶峰后的元素，右指针为中间索引 -1
//    小于时，说明在顶峰之前，左指针为中间索引 +1
//    大于后一个元素并且大于前一个元素时，即是顶峰

    public int peakIndexInMountainArray(int[] arr) {
        int low = 1;
        int high = arr.length - 2;
        int ans = 0;
        while (low <= high) {
            int middle = (high - low) / 2 + low;
            if (arr[middle] >= arr[middle + 1]) {
                ans = middle;
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return ans;
    }

    public int peakIndexInMountainArray1(int[] arr) {
        // 1. simple
        int max = arr[0];
        int i = 1;
        int maxIndex = 0;
        while (i < arr.length) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
            i++;
        }

        return maxIndex;
    }

}
