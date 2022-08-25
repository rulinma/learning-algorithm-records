package com.rulinma.algorithm.leetcode.easy;

/**
 * 2373. 矩阵中的局部最大值
 * <p>
 * 给你一个大小为 n x n 的整数矩阵 grid 。
 * <p>
 * 生成一个大小为 (n - 2) x (n - 2) 的整数矩阵  maxLocal ，并满足：
 * <p>
 * maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
 * 换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。
 * <p>
 * 返回生成的矩阵。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
 * 输出：[[9,9],[8,6]]
 * 解释：原矩阵和生成的矩阵如上图所示。
 * 注意，生成的矩阵中，每个值都对应 grid 中一个相接的 3 x 3 矩阵的最大值。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
 * 输出：[[2,2,2],[2,2,2],[2,2,2]]
 * 解释：注意，2 包含在 grid 中每个 3 x 3 的矩阵中。
 *  
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 3 <= n <= 100
 * 1 <= grid[i][j] <= 100
 * <p>
 * https://leetcode.cn/problems/largest-local-values-in-a-matrix
 *
 * @author 马如林
 * @Data 2022/8/25 14:02
 */
public class LargestLocalValuesInAMatrix {

    public int[][] largestLocal(int[][] grid) {
        int len = grid.length;
        int[][] ans = new int[len - 2][len - 2];

        // 填充每个位置
        int l = len - 2;
        for (int i = 0; i < l; i++) {
            // row i
            for (int j = 0; j < l; j++) {
                // row c
                ans[i][j] = getMax(grid, i, j);
            }
        }

        return ans;
    }

    public int getMax(int[][] grid, int i, int j) {
        // i 和 j的9宫格范围内最大值
        int max = grid[i][j];
        for (int m = i; m < i + 3; m++) {
            for (int n = j; n < j + 3; n++) {
                max = Math.max(max, grid[m][n]);
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}
        };

        LargestLocalValuesInAMatrix largestLocalValuesInAMatrix = new LargestLocalValuesInAMatrix();
        int[][] rs = largestLocalValuesInAMatrix.largestLocal(grid);
        System.out.println(rs);
    }
}
