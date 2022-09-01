package com.rulinma.algorithm.leetcode.match.weekly;

/**
 * @author 马如林
 * @Data 2022/9/1 15:32
 */
public class Test85 {

    /**
     * 836. 矩形重叠
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int x3 = rec2[0];
        int y3 = rec2[1];
        int x4 = rec2[2];
        int y4 = rec2[3];

        return !(x4 < x1 || y3 > y2 || x3 > x2 || y4 < y1);
    }

    public static void main(String[] args) {

    }

}
