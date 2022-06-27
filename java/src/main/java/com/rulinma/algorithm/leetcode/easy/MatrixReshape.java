package com.rulinma.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 566. 重塑矩阵
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * <p>
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * <p>
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * <p>
 * https://leetcode.cn/problems/reshape-the-matrix
 *
 * @author 马如林
 * @Data 2022/6/27 12:05
 */
public class MatrixReshape {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int x = mat[0].length;
        int y = mat.length;

        if (x * y != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < x * y; i++) {
            result[i / c][i % c] = mat[i / x][i % x];
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2}, {3, 4}};

        MatrixReshape matrixReshape = new MatrixReshape();
        int[][] result = matrixReshape.matrixReshape(mat, 1, 4);
        System.out.println("row: " + result.length);
        System.out.println("col: " + result[0].length);
        System.out.println(Arrays.toString(result));
    }

}
