package com.rulinma.algorithm.leetcode.match.weekly.doubleweek;

/**
 * @author 马如林
 * @Data 2022/9/19 17:24
 */
public class Test299 {

    public boolean checkXMatrix(int[][] grid) {
        boolean ans = true;
        int len = grid.length;
        // 对角线

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                // 坐标是对角线需要不是0
                if ((i == j || i + j == (len - 1))) {
                    if (grid[i][j] == 0) {
                        System.out.println("1: " + i + " " + j);
                        return false;
                    }
                } else if (grid[i][j] != 0) {
                    // 非对角线是0
                    System.out.println("3: " + i + " " + j);
                    return false;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
