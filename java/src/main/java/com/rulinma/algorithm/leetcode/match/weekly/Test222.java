package com.rulinma.algorithm.leetcode.match.weekly;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 马如林
 * @Data 2022/9/26 11:22
 */
public class Test222 {

    /**
     * 1710. 卡车上的最大单元数
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int max = 0;
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return ((Integer) o2[1]).compareTo(o1[1]);
            }
        });

        int remain = truckSize;
        for (int[] b : boxTypes) {
            if (remain > 0) {
                if (remain - b[0] > 0) {
                    remain = remain - b[0];
                    max += b[0] * b[1];
                } else if (remain - b[0] == 0) {
                    remain = remain - b[0];
                    max += b[0] * b[1];
                    break;
                } else {
                    max += remain * b[1];
                    break;
                }
            } else if (remain == 0) {
                break;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{{1, 3}, { 2, 2 }, {3, 1}};

        Test222 test222 = new Test222();
//        int rs = test222.maximumUnits(boxTypes, 4);
//        System.out.println(rs);



    }

}
