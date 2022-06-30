package com.rulinma.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * <p>

 * https://leetcode.cn/problems/set-matrix-zeroes
 *
 * @author 马如林
 * @Data 2022/6/30 16:46
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // set
        for (int x : rows) {
            // set matrix 的 rows行为 0
            for (int j = 0; j < col; j++) {
                matrix[x][j] = 0;
            }
        }

        for (int y : cols) {
            // set matrix 的 rows行为 0
            for (int i = 0; i < row; i++) {
                matrix[i][y] = 0;
            }
        }

        System.out.println("end");
    }

    public static void main(String[] args) {
        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
//        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setMatrixZeroes.setZeroes(matrix);
    }
}
