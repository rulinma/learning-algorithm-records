package com.rulinma.algorithm.leetcode.match.weekly;

/**
 * @author 马如林
 * @Data 2022/8/31 11:14
 */
public class Test200 {

    public int getWinner(int[] arr, int k) {
        // 算法
        // 1. 统计当前位置最大值
        // 2. 统计当前位置的后续连续位置比我小的值得个数
        // 2.1 当前值 + 后续值 == k 则返回，否则继续后移
        // 3. 第一遍没找到则必然是最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        int[] maxVal = new int[arr.length];
        int currentMax = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > currentMax) {
                currentMax = arr[i];
            }
            maxVal[i] = currentMax;
        }

        int i = 0;
        while (i < arr.length) {
            // 开始暴力破解
            if (arr[i] == maxVal[i]) {
                // 需要后续k-1个值小
                int c = 0;
                if (i != 0) {
                    c = 1;
                }
                if (c == k) {
                    // get it
                    return arr[i];
                }

                int j = 1;
                while (i + j < arr.length && arr[i + j] < arr[i]) {
                    c++;
                    if (c == k) {
                        // get it
                        return arr[i];
                    }
                    j++;
                }
                // skip
                i += j;
            } else {
                i++;
            }
        }

        return max;
    }

    /**
     * 1534. 统计好三元组
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int rs = 0;
        // 0 <= i < j < k < arr.length
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) > a) {
                    continue;
                }
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a &&
                            Math.abs(arr[j] - arr[k]) <= b &&
                            Math.abs(arr[i] - arr[k]) <= c
                    ) {
                        rs++;
                    }
                }
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3, 5, 4, 6, 7};
        int k = 2;
        int rs = new Test200().getWinner(arr, k);
        System.out.println(rs);
    }

}
