package com.rulinma.algorithm.leetcode.easy;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

/**
 * 1582. 二进制矩阵中的特殊位置
 * <p>
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 * <p>
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,0,0],
 *             [0,0,1],
 *             [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 * 示例 2：
 * <p>
 * 输入：mat = [[1,0,0],
 *             [0,1,0],
 *             [0,0,1]]
 * 输出：3
 * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 * 示例 3：
 * <p>
 * 输入：mat = [[0,0,0,1],
 *             [1,0,0,0],
 *             [0,1,1,0],
 *             [0,0,0,0]]
 * 输出：2
 * 示例 4：
 * <p>
 * 输入：mat = [[0,0,0,0,0],
 *             [1,0,0,0,0],
 *             [0,1,0,0,0],
 *             [0,0,1,0,0],
 *             [0,0,0,1,1]]
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] 是 0 或 1
 * <p>
 * https://leetcode.cn/problems/special-positions-in-a-binary-matrix
 *
 * @author 马如林
 * @Data 2022/9/4 08:16
 */
public class SpecialPositionsInABinaryMatrix {

    public int numSpecial(int[][] mat) {
        // 官方的这个比较简洁
        int m = mat.length, n = mat[0].length;
        int[] rowsSum = new int[m];
        int[] colsSum = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowsSum[i] += mat[i][j];
                colsSum[j] += mat[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rowsSum[i] == 1 && colsSum[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    public int numSpecial1(int[][] mat) {
        int ans = 0;
        // 行中只有1的元素，记录[i][j]
        // 列中只有1的元素，记录[i][j]
        Set<Pair<Integer, Integer>> set1 = new HashSet<>();
        Set<Pair<Integer, Integer>> set2 = new HashSet<>();
        for (int i = 0; i < mat.length; i++) {
            int countOne = 0;
            int col = -1;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    countOne++;
                    col = j;
                }
            }
            if (countOne == 1) {
                set1.add(new Pair<>(i, col));
            }
        }

        for (int j = 0; j < mat[0].length; j++) {
            int countOne = 0;
            int row = -1;
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][j] == 1) {
                    countOne++;
                    row = i;
                }
            }
            if (countOne == 1) {
                set2.add(new Pair<>(row, j));
            }
        }

        // 2个列表中的[i][j] 进行遍历，同时出现的，则为结果
        for (Pair<Integer, Integer> p : set1) {
            for (Pair<Integer, Integer> q : set2) {
                if (p.getKey().equals(q.getKey()) && p.getValue().equals(q.getValue())) {
                    ans++;
                }
            }
        }

        return ans;
    }


}
