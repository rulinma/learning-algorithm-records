package com.rulinma.algorithm.leetcode.middle;

/**
 * @author 马如林
 * @Data 2022/9/22 20:52
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        // 1. arr[m][n]
        // 2. f[0][0] = 1 f[m][n]
        // 3. 第一行和第一列处理
        // f[0][0] = 1 f[0][j] = 1
        // f[0][0] = 1 f[i][0] = 1
        // f[m][n] = f[m][n-1] + f[m-1][n]
        int[][] f = new int[m][n];

        // init
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        // iterator

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i][j - 1] + f[i - 1][j];
            }
        }

        return f[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7));
    }

}
