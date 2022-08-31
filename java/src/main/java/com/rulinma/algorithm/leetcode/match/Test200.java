package com.rulinma.algorithm.leetcode.match;

/**
 * @author 马如林
 * @Data 2022/8/31 11:14
 */
public class Test200 {

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

    }

}
