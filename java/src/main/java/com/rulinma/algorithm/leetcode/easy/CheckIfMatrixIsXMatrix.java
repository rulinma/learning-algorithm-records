package com.rulinma.algorithm.leetcode.easy;

/**
 * 2319. 判断矩阵是否是一个 X 矩阵
 * 如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ：
 * <p>
 * 矩阵对角线上的所有元素都 不是 0
 * 矩阵中所有其他元素都是 0
 * 给你一个大小为 n x n 的二维整数数组 grid ，表示一个正方形矩阵。如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[2,0,0,1],[0,3,1,0],[0,5,2,0],[4,0,0,2]]
 * 输出：true
 * 解释：矩阵如上图所示。
 * X 矩阵应该满足：绿色元素（对角线上）都不是 0 ，红色元素都是 0 。
 * 因此，grid 是一个 X 矩阵。
 * <p>
 * https://leetcode.cn/problems/check-if-matrix-is-x-matrix
 *
 * @author 马如林
 * @Data 2022/7/2 08:30
 */
public class CheckIfMatrixIsXMatrix {

    public boolean checkXMatrix(int[][] grid) {
        boolean result = true;

        int n = grid.length;

        // [n,n]
        // [i,n-i]
//        for (int i = 0; i < n; i++) {
//            if (grid[i][i] != 0 || (grid[i][n - i - 1] != 0)) {
//                return false;
//            }
//        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || j == n - i - 1) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CheckIfMatrixIsXMatrix checkIfMatrixIsXMatrix = new CheckIfMatrixIsXMatrix();
        int[][] grid = new int[][]{{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}};
        boolean result = checkIfMatrixIsXMatrix.checkXMatrix(grid);
        System.out.println(result);
    }

}
