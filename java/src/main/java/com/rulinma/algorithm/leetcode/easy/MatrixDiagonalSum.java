package com.rulinma.algorithm.leetcode.easy;

/**
 * 1572. 矩阵对角线元素的和
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * <p>
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * <p>
 *  
 * <p>
 * 示例  1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],
 *             [4,5,6],
 *             [7,8,9]]
 * <p>
 * https://leetcode.cn/problems/matrix-diagonal-sum
 *
 * @author 马如林
 * @Data 2022/7/4 10:51
 */
public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        // 奇数列，中间元素会被重复1次，最后扣除
        // [i,i]
        // [i, len-i-1]
        int sum = 0;
        int len = mat.length;
        for (int i = 0; i < len; i++) {
            sum += mat[i][i];
            sum += mat[i][len - i - 1];
        }

        if (len % 2 == 1) {
            sum = sum - mat[len / 2][len / 2];
        }

        return sum;
    }
}
