package com.rulinma.algorithm.leetcode.match.weekly.doubleweek;

/**
 * @author 马如林
 * @Data 2022/9/19 17:24
 */
public class Test299 {

    public int countHousePlacements(int n) {
        int MOD = (int) 1e9 + 7;
        int MX = (int) 1e4 + 1;
        int[] f = new int[n + 1];
        if (n == 1) {
            return 4;
        }
        if (n == 2) {
            return 9;
        }
        // 定义 f[i] 表示前 i 个地块的放置方案数
        // 放1，不放
        f[1] = 2;
        // 放1，放2，都不放
        f[2] = 3;
        for (int i = 3; i <= n; ++i) {
            f[i] = (f[i - 1] + f[i - 2]) % MOD;
        }

        return (int) ((long) f[n] * f[n] % MOD);
    }


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
